package com.example.albatross.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.albatross.domain.dao.DeclareDAO;
import com.example.albatross.domain.vo.DeclareVO;
import com.example.albatross.domain.vo.TweetVO;

@Service
public class DeclareServiceImpl implements DeclareService {
	
	@Autowired
	DeclareDAO declareDAO;

	public TweetVO read(Long did) {
		return declareDAO.read(did);
	}

	@Override
	public List<DeclareVO> getGroupCount() {
		return declareDAO.getGroupCount();
	}

	@Override
	public boolean delete(Long tid) {
		return declareDAO.delete(tid);
	}
	
	@Override
	public boolean tweetDelete(Long tid) {
		return declareDAO.tweetDelete(tid);
	}

	@Override
	public void declare(DeclareVO declareVO) {
		declareDAO.declare(declareVO);
	}
	
	
}
