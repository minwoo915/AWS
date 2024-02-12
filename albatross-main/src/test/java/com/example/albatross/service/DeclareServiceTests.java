package com.example.albatross.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.albatross.domain.vo.DeclareVO;
import com.example.albatross.domain.vo.TweetVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class DeclareServiceTests {
	@Autowired
	private DeclareService declareService;
	
//	@Test
//	public void serviceTest() {
//		log.info(declareService);
//	}
	
//	@Test
//	public void readTest() {
//		TweetVO tweetVO = declareService.read(67L);
//		if(tweetVO != null) {
//			log.info(tweetVO);
//			return;
//		}
//		log.info("NO DATA");
//	}
	
//	@Test
//	public void deleteTest() {
//		TweetVO tweetVO = declareService.read(42L);
//		if(tweetVO == null) {log.info("NO DATA"); return;}
//		
//		if(declareService.delete(tweetVO.getTid()) 
//				&& declareService.tweetDelete(tweetVO.getTid())) {
//			log.info("declare SUCCESS");
//			return;
//		}
//		log.info("declare FAIL");
//	}
	
//	@Test
//	public void getGroupCountTest() {
//		declareService.getGroupCount().forEach(log::info);
//	}
	
	@Test
	public void declareTest() {
		DeclareVO declareVO = new DeclareVO();
		declareVO.setTid(76L);
		declareVO.setUuid(21);
		
		declareService.declare(declareVO);
		
		log.info("생성된 번호: "+ declareVO);
	}
}







