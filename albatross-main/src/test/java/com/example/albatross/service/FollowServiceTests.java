package com.example.albatross.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.albatross.domain.vo.FollowVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class FollowServiceTests {
	@Autowired
	FollowService followService;

//	@Test
//	public void addTest() {
//		FollowVO follow = new FollowVO();
//		follow.setFrom_uid(3L);
//		follow.setTo_uid(30L);
//		log.info(followService.add(follow));
//	}
	
//	@Test
//	public void delTest() {
//		log.info(followService.remove(7L));
//	}
	
//	@Test
//	public void selectListTest() {
//		followService.getList(3L).forEach(log::info);
//	}
	
//	@Test
//	public void existsTest() {
//		FollowVO follow = new FollowVO();
//		follow.setFrom_uid(3L);
//		follow.setTo_uid(30L);
//		
//		log.info("존재" +followService.exists(follow));
//	} 
	
	@Test
	public void selectFidTest() {
		FollowVO follow = new FollowVO();
		follow.setFrom_uid(3L);
		follow.setTo_uid(30L);
		
		log.info("FID =" + followService.getFid(follow));
	}
}
