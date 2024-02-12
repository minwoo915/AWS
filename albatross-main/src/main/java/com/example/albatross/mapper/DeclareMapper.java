package com.example.albatross.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.albatross.domain.vo.DeclareVO;
import com.example.albatross.domain.vo.TweetVO;


@Mapper
public interface DeclareMapper{
	public TweetVO read(Long tid);
	public List<DeclareVO> getGroupCount();
	public int delete(Long tid);
	public int tweetDelete(Long tid);
	public void declare(DeclareVO declareVO);
}
