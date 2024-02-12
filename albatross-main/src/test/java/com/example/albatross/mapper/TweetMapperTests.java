/**
 * 
 */
package com.example.albatross.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.albatross.domain.vo.PageInfo;
import com.example.albatross.domain.vo.TweetDTO;
import com.example.albatross.domain.vo.TweetVO;

import lombok.extern.log4j.Log4j;

/**
 * @author USER
 *
 */
@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class TweetMapperTests {
	@Autowired
	TweetMapper tweetMapper;

	/*
	@Test
	public void insertTest() {
		TweetVO tweet = new TweetVO();
		tweet.setUuid(2L);
		tweet.setT_type("nomal");
		tweet.setContent("mapper에서 생성: 언리드 테스트");
		tweet.setImage_link("https://images.unsplash.com/photo-1575936123452-b67c3203c357?q=80&w=1000&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8aW1hZ2V8ZW58MHx8MHx8fDA%3D");
		tweetMapper.insert(tweet);
		log.info(tweet);
	}
	*/
	/*
	@Test
	public void selectTest() {
		log.info(tweetMapper.select(24L));
	}
	*/
	/*
	@Test
	public void deleteTest() {
		log.info(tweetMapper.delete(3L));
	}
	*/
	/*
	@Test
	public void updateTest() {
		TweetVO tweet = tweetMapper.select(4L);
		if(tweet != null) {
			tweet.setContent("mapper Tests에서 수정 한 트윗");
		};
	
		log.info("==============================================");
		log.info(tweet == null ? "없는 댓글입니다" : tweetMapper.update(tweet)+"건 수정되었습니다."); 
		log.info("==============================================");
	
	}
	*/
	
//	@Test
//	public void selectListTest() {
//		tweetMapper.selectList(new PageInfo(1,10,"T","nomal",null,null,null)).forEach(log::info);
//	}
	
	
}
