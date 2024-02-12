package com.example.albatross.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.albatross.domain.vo.UserVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class UserMapperTests {
	
	@Autowired
	private UserMapper userMapper;
	/*
	@Test
	public void testRead() {
		UserVO vo = userMapper.read("hansamkang@naver.com");
		
	}
	*/
	/*
	@Test
	public void insertTest() {
		UserVO user = new UserVO();
		user.setMail("mapperTest2@naver.com");
		user.setPassword("123123");
		user.setNickname("mapper테스터2");
		user.setIntro("삭제할거임~");
		userMapper.insert(user);
	}
	*/
	/*
	@Test
	public void selectTest() {
		log.info(userMapper.select(3L));
	}
	*/
	/*
	@Test
	public void deleteTest() {
		log.info(userMapper.delete(27L));
	}
	*/
	
	@Test
	public void updateTest() {
		UserVO user = userMapper.select(28L);
		user.setIntro("인트로 바꿔 보자잉~~~");
		user.setEnabled(false);
		
		log.info("==============================================");
		log.info(user == null ? "없는 유저입니다" : userMapper.update(user)+"인 유저 수정되었습니다."); 
		log.info("==============================================");
	
	}
	
}
