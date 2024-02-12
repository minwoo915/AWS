package com.example.albatross.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.example.albatross.domain.vo.PageInfo;
import com.example.albatross.domain.vo.TweetDTO;
import com.example.albatross.domain.vo.TweetVO;
import com.example.albatross.service.FollowService;
import com.example.albatross.service.TweetService;
import com.example.albatross.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@RequiredArgsConstructor
@RequestMapping("/follow/*")
@Log4j
public class FollowController {
	
	@Autowired
	FollowService followService;
	
	@GetMapping("/test")
    public String test() {
		log.info("GET 요청이 잘 되었습니다.");
        return "Get 요청이 잘 처리되었습니다.";
    }
	
	// 팔로우
	@PostMapping(value ="/new" , consumes ="application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> addFollow(@RequestBody FollowVO follow) {
		log.info("new follow........" + follow);
			
		return followService.add(follow) ? new ResponseEntity<>("success", HttpStatus.OK) :
			new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	// 팔로우 해제
	@DeleteMapping(value="/{fid}", produces= {MediaType.TEXT_PLAIN_VALUE})
	public String remove(@PathVariable("fid") Long fid) {
		log.info("removeFollow........" + fid);
		return followService.remove(fid) ? "success" : "fail" ;
	}
	
	//팔로우 전체 조회
	@GetMapping(value = "list/{uuid}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<List<FollowVO>> getList(@PathVariable("uuid")Long uuid) {
		log.info("getFollowList........");
		return new ResponseEntity<>(followService.getList(uuid), HttpStatus.OK);
	}
	
	// 팔로우
	@GetMapping(value = "/exists", 
			produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<Boolean> exists(FollowVO follow) {
		log.info("exists follow........" + follow);
			
		return new ResponseEntity<>(followService.exists(follow), HttpStatus.OK);
	}
	
	//fid 가져오기
	@GetMapping(value = "/get", 
				produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<Integer> getFid(FollowVO follow) {
		log.info("getFid........");
		return new ResponseEntity<>(followService.getFid(follow), HttpStatus.OK);
	}
	
}
