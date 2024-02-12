package com.example.albatross.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.albatross.domain.dao.TweetDAO;
import com.example.albatross.domain.vo.PageInfo;
import com.example.albatross.domain.vo.TweetDTO;
import com.example.albatross.domain.vo.TweetVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TweetServiceImpl implements TweetService {
	
	private final TweetDAO tweetDAO;
	
	@Override
	public List<TweetDTO> getList(PageInfo info) {
		return tweetDAO.getList(info);
	}

	@Override
	public boolean add(TweetVO tweet) {
		return tweetDAO.add(tweet);
	}

	@Override
	public TweetDTO get(Long tid) {
		return tweetDAO.get(tid);
	}

	@Override
	public boolean remove(Long tid) {
		return tweetDAO.remove(tid);
	}

	@Override
	public boolean modify(TweetVO tweet) {
		return tweetDAO.update(tweet);
	}

}
