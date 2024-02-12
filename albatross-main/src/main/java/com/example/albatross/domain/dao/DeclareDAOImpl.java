package com.example.albatross.domain.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.albatross.domain.vo.DeclareVO;
import com.example.albatross.domain.vo.TweetVO;
import com.example.albatross.mapper.DeclareMapper;

@Repository
public class DeclareDAOImpl implements DeclareDAO{

	@Autowired
	DeclareMapper declareMapper;
	
	@Override
	public TweetVO read(Long tid) {
		return declareMapper.read(tid);
	}

	@Override
	public List<DeclareVO> getGroupCount() {
		return declareMapper.getGroupCount();
	}

	@Override
	public boolean delete(Long tid) {
		return declareMapper.delete(tid) != 0;
	}
	
	@Override
	public boolean tweetDelete(Long tid) {
		return declareMapper.tweetDelete(tid) != 0;
	}

	@Override
	public void declare(DeclareVO declareVO) {
		declareMapper.declare(declareVO);
	}

	

	
	
}
