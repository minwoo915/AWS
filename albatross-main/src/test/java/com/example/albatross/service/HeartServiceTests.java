package com.example.albatross.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.albatross.domain.vo.HeartVO;
import com.example.albatross.mapper.HeartMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class HeartServiceTests {
	@Autowired
	HeartService heartService;

	
//	@Test // 
//	public void insertTest() {
//		HeartVO heart = new HeartVO();
//		heart.setUuid(3L);
//		heart.setTid(112L);
//		log.info("insertResult = " + heartService.add(heart));
//	}
	
//	@Test // 
//	public void deleteTest() {
//
//	    log.info("deleteResult = " + heartService.remove(6L));
//	}
	
//	@Test // 
//	public void existsTest() {
//	    HeartVO heart = new HeartVO();
//	    heart.setUuid(4L);
//	    heart.setTid(115L);
//	    log.info("존재 함 : " + heartService.exists(heart));
//	}
		
//	@Test
//	public void selectHidTest() {
//		HeartVO heart = new HeartVO();
//		heart.setUuid(3L);
//		heart.setTid(114L);
//		if(heartService.exists(heart)) {
//			log.info("해당 Hid = " + heartService.getHid(heart));
//		} else {
//			log.info("존재 안함");
//		}
//	}
	
	@Test
	public void selectTotalTest() {
		log.info(heartService.getTotal(115L));
	}
	
}
