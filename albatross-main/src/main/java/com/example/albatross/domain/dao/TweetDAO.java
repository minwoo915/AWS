package com.example.albatross.domain.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.albatross.domain.vo.PageInfo;
import com.example.albatross.domain.vo.TweetDTO;
import com.example.albatross.domain.vo.TweetVO;

@Repository
public interface TweetDAO {
	// 리스트 가져오기
	public List<TweetDTO> getList(PageInfo info);
	
	// 삽입
	public boolean add(TweetVO tweet);
		
	// 글 하나 가져오기
	public TweetDTO get(Long tid);
		
	// 삭제
	public boolean remove(Long tid);
		
	// 업데이트
	public boolean update(TweetVO tweet);
}
