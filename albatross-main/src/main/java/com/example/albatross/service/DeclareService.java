package com.example.albatross.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.albatross.domain.vo.DeclareVO;
import com.example.albatross.domain.vo.TweetVO;

@Service
public interface DeclareService {
	// 특정 글 가져오기
	public TweetVO read(Long did);
	// 신고글 많은 순서대로 내림차순으로 출력 
	public List<DeclareVO> getGroupCount();
	// 신고글 삭제(DECLARE_TBL)
	public boolean delete(Long tid);
	// 신고글 삭제(ATT_TWEET)
	public boolean tweetDelete(Long tid);
	// 신고 기능
	public void declare(DeclareVO declareVO);
}
