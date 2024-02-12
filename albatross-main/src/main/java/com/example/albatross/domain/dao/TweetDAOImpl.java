package com.example.albatross.domain.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.albatross.domain.vo.PageInfo;
import com.example.albatross.domain.vo.TweetDTO;
import com.example.albatross.domain.vo.TweetVO;
import com.example.albatross.mapper.TweetMapper;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class TweetDAOImpl implements TweetDAO {
	private final TweetMapper tweetMapper;
	
	@Override
	public List<TweetDTO> getList(PageInfo info) {
		return tweetMapper.selectList(info);
	}

	@Override
	public boolean add(TweetVO tweet) {
		return tweetMapper.insert(tweet) != 0;
	}

	@Override
	public TweetDTO get(Long tid) {
		return tweetMapper.select(tid);
	}

	@Override
	public boolean remove(Long tid) {
		return tweetMapper.delete(tid) != 0 ; 
	}

	@Override
	public boolean update(TweetVO tweet) {	
		return tweetMapper.update(tweet) != 0;
	}

}
