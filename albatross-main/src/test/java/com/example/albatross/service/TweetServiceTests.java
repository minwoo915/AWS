package com.example.albatross.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.albatross.domain.vo.PageInfo;
import com.example.albatross.domain.vo.TweetVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class TweetServiceTests {
	@Autowired
	TweetService tweetService;
	
	/*
	@Test
	public void getTest() {
		log.info(tweetService.get(26L));
	}
	*/
	/*
	@Test
	public void addTest() {
		TweetVO tweet = new TweetVO();
		tweet.setUuid(1L);
		tweet.setContent("Service 테스트에서 작성한 내용입니다.3");
		log.info(tweetService.add(tweet));
	}
	*/
	/*
	@Test
	public void delTest() {
		log.info(tweetService.remove(14L));
	}
	*/
	/*
	@Test
	public void updateTest() {
		TweetVO tweet = tweetService.get(13L);
		tweet.setContent("Service에서 수정" );
		log.info(tweetService.modify(tweet));
	}
	*/
	
	@Test
	public void getListTest() {
		tweetService.getList(new PageInfo(1,10,"TC", "nomal", null, "테스트", null));
	}
	
}
