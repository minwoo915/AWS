package com.example.albatross.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.albatross.domain.vo.FileVO;

import lombok.extern.log4j.Log4j;
import net.coobird.thumbnailator.Thumbnailator;

@Controller
@Log4j
public class FileController {
	
	@PostMapping(value= "/upload", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<FileVO> upload(@RequestParam("multipartFile")MultipartFile multipartFile){
	    log.info("upload Controller.........");
	    
	    FileVO fileVO = new FileVO();
	    String uploadDirectory = "C:\\upload";
	    String uploadDatePath = getDirectoryForm();
	    
	    File uploadPath = new File(uploadDirectory, uploadDatePath);
	    log.info("upload path : " + uploadPath);
	    
	    if(!uploadPath.exists()) {
	        uploadPath.mkdirs();
	    }
	    
	    log.info("----------------------------------");
	    log.info("Upload File Name: " + multipartFile.getOriginalFilename());
	    log.info("Upload File Size: " + multipartFile.getSize());
	    
	    String originalFileName = multipartFile.getOriginalFilename();
	    String fileName = null;
	    
	    UUID uuid = UUID.randomUUID();
	    fileName = uuid.toString() + "_" + originalFileName;
	    
	    fileVO.setUuid(uuid.toString());
	    fileVO.setFileName(originalFileName);
	    fileVO.setUploadPath(uploadDatePath);
	    
	    try {
	        File file = new File(uploadPath, fileName);
	        multipartFile.transferTo(file);
	        
	        InputStream in = new FileInputStream(file);
	        
	        //썸네일도 일단 생성
	        if(checkImageType(file)) {
	            fileVO.setFileType(true);
	            FileOutputStream out = new FileOutputStream(new File(uploadPath, "t_" + fileName));
	            Thumbnailator.createThumbnail(in, out, 100, 100);
	            in.close();
	            out.close();
	        }
	    } catch (IllegalStateException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	    
	    return new ResponseEntity<FileVO>(fileVO, HttpStatus.OK);
	}
	
	@GetMapping("/display")
	@ResponseBody
	public ResponseEntity<byte[]> display(String fileName){
		log.info("file name" + fileName);
		
		File file = new File("C:\\upload\\" + fileName);
		log.info("file: " + file);
		
		ResponseEntity<byte[]> result = null;
		HttpHeaders header = new HttpHeaders();
		
		try {
			header.add("Content-Type", Files.probeContentType(file.toPath()));
			result = new ResponseEntity<byte[]>(FileCopyUtils.copyToByteArray(file),header, HttpStatus.OK);
		}catch(IOException e){
			e.printStackTrace();			
		}
		
		return result;
	}
	
	private String getDirectoryForm() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy\\MM\\dd");
		Date today = new Date();
		return simpleDateFormat.format(today);
	}
	
	public boolean checkImageType(File file) throws IOException {
		String contentType = Files.probeContentType(file.toPath());
		return contentType.startsWith("image");
	}
	
}
