package com.example.albatross.mapper;

import java.util.List;

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
public class DeclareMapperTests {
	
	@Autowired
	private DeclareMapper declareMapper;
	
	@Test
	public void readTest() {
		TweetVO tweetVO = declareMapper.read(111L);
		log.info("SUCCESS: " + tweetVO);
	}
	
//	@Test
//	public void groupCountTest() {
//		List<DeclareVO> declareVO = declareMapper.getGroupCount();
//		//declareMapper.getGroupCount().forEach(log::info);
//		log.info(declareVO);
//	}
	
//	@Test
//	public void declareTest() {
//		DeclareVO declareVO = new DeclareVO();
//		declareVO.setTid(61L);
//		declareVO.setUuid(1);
//		
//		declareMapper.declare(declareVO);
//		
//		log.info(declareVO);
//	}
	
//	@Test
//	public void deleteTest() {
//		Long tid = 68L;
//		TweetVO tweetVO = declareMapper.read(tid);
//		
//		if(tweetVO != null) {
//			log.info("declare COUNT: " + declareMapper.delete(tweetVO.getTid()));
//			return;
//		}
//		log.info("NO declare");
//	}
	
//	@Test
//	public void tweetDeleteTest() {
//		Long tid = 68L;
//		TweetVO tweetVO = declareMapper.read(tid);
//		
//		if(tweetVO != null) {
//			log.info("declare COUNT: " + declareMapper.tweetDelete(tweetVO.getTid()));
//			return;
//		}
//		log.info("NO declare");
//	}
}





