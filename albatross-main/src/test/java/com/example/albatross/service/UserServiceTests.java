package com.example.albatross.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.albatross.domain.vo.PageInfo;
import com.example.albatross.domain.vo.UserVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class UserServiceTests {
	@Autowired
	UserService userService;
	
	
	@Test
	public void getTest() {
		log.info(userService.get(32L));
	}
	
	
	/*
	@Test
	public void addTest() {
		UserVO user = new UserVO();
		user.setMail("serviceTest@naver.com");
		user.setPassword("123123");
		user.setNickname("service테스터");
		log.info(userService.add(user));
	}
	*/
	
	/*
	@Test
	public void delTest() {
		log.info(userService.remove(14L));
	}
	*/
	/*
	@Test
	public void updateTest() {
		UserVO user = userService.get(30L);
		user.setIntro("가나다라마바사앙자차카파타하");
		user.setNickname("ACKKKKI");
		
		log.info("==============================================");
		log.info(user == null ? "없는 유저입니다" : userService.modify(user)+"인 유저 수정되었습니다."); 
		log.info("==============================================");
	}
	*/
	
	/*
	@Test
	public void checkEmailTest() {
		if(userService.checkMail("hansamkang@naver.com")) {
			log.info("중복임");
		}else {
			log.info("중복 아님");
		}
	}
	*/
	
}
