package com.example.albatross.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.albatross.domain.vo.HeartVO;

@Service
public interface HeartService {
	public boolean add(HeartVO heartVO);
	public boolean remove(Long hid);
	public boolean exists(HeartVO heartVO);
	public int getHid(HeartVO heartVO);
	public int getTotal(Long tid);	
}
