/**
 * 
 */
package com.example.albatross.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.albatross.domain.vo.FollowVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class FollowMapperTests {
	
	@Autowired
	FollowMapper followMapper;
	
	
//	@Test
//	public void insertTest() {
//		FollowVO follow = new FollowVO();
//		follow.setFrom_uid(3L);
//		follow.setTo_uid(30L);
//		log.info("insertResult ="+followMapper.insert(follow));
//	}
	
	

//	@Test
//	public void deleteTest() {
//		log.info(followMapper.delete(4L));
//	}

//	@Test
//	public void existsTest() {
//		FollowVO follow = new FollowVO();
//		follow.setFrom_uid(3L);
//		follow.setTo_uid(31L);
//		
//		log.info("존재" +followMapper.exists(follow));
//	} 
	
//	@Test
//	public void selectListTest() {
//		followMapper.selectList(3L).forEach(log::info);
//	}
	@Test
	public void selcetFidTest() {
		FollowVO follow = new FollowVO();
		follow.setFrom_uid(3L);
		follow.setTo_uid(31L);
		if(followMapper.exists(follow)) {
			log.info("해당 fid = "+ followMapper.selectFid(follow));
		}else {
			log.info("해당 fid 없음 ");
		}
	}
	
}
