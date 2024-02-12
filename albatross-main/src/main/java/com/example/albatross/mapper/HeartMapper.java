package com.example.albatross.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.albatross.domain.vo.HeartVO;

@Mapper
public interface HeartMapper {
	public int insert(HeartVO heartVO);
	public int delete(Long hid);
	public boolean exists(HeartVO heartVO);
	public int selectHid(HeartVO heartVO);
	public int selectTotal(Long tid);
}
