package com.example.albatross.domain.dao;

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
public class TweetDaoTests {
	@Autowired
	TweetDAO tweetDAO;
	
	/*
	@Test
	public void daoTest() {
		log.info(tweetDAO);
	}
	*/
	
	@Test
	public void getTest() {
		log.info(tweetDAO.get(4L));
	}
	
	/*
	@Test
	public void addTest() {
		TweetVO tweet = new TweetVO();
		tweet.setContent("DAO에서 추가한 글");
		tweet.setUuid(1L);
		//tweet.setT_type("reply");
		//tweet.setRef_tid(9L);
		//tweet.setImage_link("none");
		log.info(tweetDAO.add(tweet));
	}
	*/
	/*
	@Test
	public void removeTest() {
		log.info(tweetDAO.remove(4L));
	}
	*/
	
	/*
	@Test
	public void updateTest() {
		TweetVO tweet = tweetDAO.get(8L);

		if(tweet == null) {log.info("NO BOARD"); return;}
		
		tweet.setContent("DAO에서 수정함");
		
		log.info("UPDATE : " + tweetDAO.update(tweet));
	}
	*/
	/*
	@Test
	public void getListTest() {
		tweetDAO.getList(new PageInfo(1, 10)).forEach(log::info);
	}
	*/
}
