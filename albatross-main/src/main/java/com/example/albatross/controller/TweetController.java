package com.example.albatross.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.albatross.domain.vo.PageInfo;
import com.example.albatross.domain.vo.TweetDTO;
import com.example.albatross.domain.vo.TweetVO;
import com.example.albatross.service.TweetService;
import com.example.albatross.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tweet/*")
@Log4j
public class TweetController {
	private final TweetService tweetService;
	private final UserService userService;
	
	@GetMapping("/test")
    public String test() {
		log.info("GET 요청이 잘 되었습니다.");
		log.info(tweetService);
		log.info(userService);
        return "Get 요청이 잘 처리되었습니다.";
    }
	
	//트윗 작성
	@PostMapping(value ="/new" , consumes ="application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> addTweet(@RequestBody TweetVO tweet) {
		log.info("new Tweet........" + tweet);
		
		return tweetService.add(tweet) ? new ResponseEntity<>("success", HttpStatus.OK) :
			new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//트윗 전체 조회
	@GetMapping(value = "/list", 
				produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<List<TweetDTO>> getList(PageInfo pageinfo) {
		log.info("getTweetList........");
		return new ResponseEntity<>(tweetService.getList(pageinfo), HttpStatus.OK);
	}
	
	
	//트윗 하나 조회
	@GetMapping(value = "/{tid}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public TweetDTO getTweet(@PathVariable("tid")Long tid) {
		log.info("(getTweet........" + tid);
		
		return tweetService.get(tid);
	}
		
	//트윗 삭제
	@DeleteMapping(value="/{tid}", produces= {MediaType.TEXT_PLAIN_VALUE})
	public String remove(@PathVariable("tid") Long tid) {
		log.info("removeTweet........" + tid);
		return tweetService.remove(tid) ? "success" : "fail" ;
	}
		
	//트윗 수정 (실무에선 걍 post쓴데)
	@PostMapping(value="/modify/{tid}", consumes ="application/json", produces= {MediaType.TEXT_PLAIN_VALUE})
	public String modify(@PathVariable Long tid, @RequestBody TweetVO tweet) {
		log.info("modifyTweet........" + tid);
		
		tweet.setTid(tid);
		return tweetService.modify(tweet) ? "success" : "fail";
	}
	
}
