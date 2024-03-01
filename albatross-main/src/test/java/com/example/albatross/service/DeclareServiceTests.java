package com.example.albatross.service;
// package - 클래스와 인터페이스의 집합

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.albatross.domain.vo.DeclareVO;
import com.example.albatross.domain.vo.TweetVO;

import lombok.extern.log4j.Log4j;
// import - 자바의 라이브러리 패키지의 클래스를 사용하거나 
//			사용자의 다른 패키지 안의 클래스를 사용할 때 사용하는 명령어

// @ - 어노테이션, 클래스와 메서드에 추가하여 다양한 기능을 부여하는 역할

@RunWith(SpringJUnit4ClassRunner.class)
// @RunWith - 말 그대로 SpringJUnit4ClassRunner.class를 실행, 
//			  JUnit 프레임워크의 테스트 실행 방법을 확장할 때 사용하는 애노테이션
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
// @ContextConfiguration - 자동으로 만들어줄 애플리케이션 컨텍스트의 설정파일 위치를 지정
@Log4j
// @Log4j - 선택적으로 로그를 남기거나 특정파일에 로그를 생성

public class DeclareServiceTests {
	@Autowired
	//@Autowired - 의존관계 주입(DI)을 할 때 사용하는 어노테이션이며,
	//			   의존 객체의 타입에 해당하는 Bean을 찾아 주입하는 역할
	private DeclareService declareService;
	
//	@Test - Spring 프레임워크를 사용하여 개발된 애플리케이션을 테스트하기 위한 코드
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







