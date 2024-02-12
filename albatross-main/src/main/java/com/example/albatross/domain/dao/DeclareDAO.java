package com.example.albatross.domain.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.albatross.domain.vo.DeclareVO;
import com.example.albatross.domain.vo.TweetVO;

@Repository
public interface DeclareDAO {
	public TweetVO read(Long tid);
	public List<DeclareVO> getGroupCount();
	public boolean delete(Long tid);
	public boolean tweetDelete(Long tid);
	public void declare(DeclareVO declareVO);
}
