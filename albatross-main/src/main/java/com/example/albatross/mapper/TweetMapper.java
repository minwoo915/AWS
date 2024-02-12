package com.example.albatross.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.albatross.domain.vo.PageInfo;
import com.example.albatross.domain.vo.TweetDTO;
import com.example.albatross.domain.vo.TweetVO;

@Mapper
public interface TweetMapper {
	// 리스트 가져오기
	public List<TweetDTO> selectList(PageInfo info);
	// 삽입
	public int insert(TweetVO tweet);
	// 글 하나 가져오기
	public TweetDTO select(Long tid);
	// 삭제
	public int delete(Long tid);
	// 업데이트
	public int update(TweetVO tweet);
}
