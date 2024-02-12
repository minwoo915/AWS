package com.example.albatross.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.albatross.domain.vo.PageInfo;
import com.example.albatross.domain.vo.TweetDTO;
import com.example.albatross.domain.vo.TweetVO;

@Service
public interface TweetService {
	// 리스트 가져오기
		public List<TweetDTO> getList(PageInfo info);
		
		// 삽입
		public boolean add(TweetVO tweet);
			
		// 글 하나 가져오기
		public TweetDTO get(Long tid);
			
		// 삭제
		public boolean remove(Long tid);
			
		// 업데이트
		public boolean modify(TweetVO tweet);
}
