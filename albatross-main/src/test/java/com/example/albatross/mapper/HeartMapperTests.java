package com.example.albatross.mapper;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.albatross.domain.vo.HeartVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class HeartMapperTests {

	@Autowired
	HeartMapper heartMapper;

	
//	@Test // 
//	public void insertTest() {
//		HeartVO heart = new HeartVO();
//		heart.setUuid(3L);
//		heart.setTid(112L);
//		log.info("insertResult = " + heartMapper.insert(heart));
//	}
	
//	@Test // 
//	public void deleteTest() {
//
//	    log.info("deleteResult = " + heartMapper.delete(5L));
//	}
	
//	@Test // 
//	public void existsTest() {
//	    HeartVO heart = new HeartVO();
//	    heart.setUuid(3L);
//	    heart.setTid(112L);
//	    log.info("존재 함 : " + heartMapper.exists(heart));
//	}
		
//	@Test
//	public void selectHidTest() {
//		HeartVO heart = new HeartVO();
//		heart.setUuid(3L);
//		heart.setTid(114L);
//		if(heartMapper.exists(heart)) {
//			log.info("해당 Hid = " + heartMapper.selectHid(heart));
//		} else {
//			log.info("존재 안함");
//		}
//	}
	
	@Test
	public void selectTotalTest() {
		log.info(heartMapper.selectTotal(115L));
	}
	
	
	
}
