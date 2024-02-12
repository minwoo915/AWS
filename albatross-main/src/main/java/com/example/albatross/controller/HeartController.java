package com.example.albatross.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.albatross.domain.vo.FollowVO;
import com.example.albatross.domain.vo.HeartVO;
import com.example.albatross.service.HeartService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@RequiredArgsConstructor
@RequestMapping("/heart/*")
@Log4j
public class HeartController {
	
	private final HeartService heartService;
	
	@GetMapping("/test")
	public String test() {
		log.info("GET 요청 잘 됨");
		return "GET 요청이 잘 되었음";
	}
	
	// 좋아요
	@PostMapping(value ="/new" , consumes ="application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> addFollow(@RequestBody HeartVO heart) {
		log.info("new heart........" + heart);
			
		return heartService.add(heart) ? new ResponseEntity<>("success", HttpStatus.OK) :
			new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	// 좋아요 해제
	@DeleteMapping(value="/{hid}", produces= {MediaType.TEXT_PLAIN_VALUE})
	public String remove(@PathVariable("hid") Long hid) {
		log.info("remove heart........" + hid);
		return heartService.remove(hid) ? "success" : "fail" ;
	}
		
	// 좋아요 존재
	@GetMapping(value = "/exists", 
			produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<Boolean> exists(HeartVO heart) {
		log.info("exists heart........" + heart);
			
		return new ResponseEntity<>(heartService.exists(heart), HttpStatus.OK);
	}
	
	//hid 가져오기
	@GetMapping(value = "/get", 
				produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<Integer> getFid(HeartVO heart) {
		log.info("getHid........");
		return new ResponseEntity<>(heartService.getHid(heart), HttpStatus.OK);
	}
	
	//total 가져오기
	@GetMapping(value = "getTotal/{tid}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<Integer> getTotal(@PathVariable("tid") Long tid ) {
	log.info("getTotal........");
	return new ResponseEntity<>(heartService.getTotal(tid), HttpStatus.OK);
}
}
