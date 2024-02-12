package com.example.albatross.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.albatross.domain.vo.HeartVO;
import com.example.albatross.mapper.HeartMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HeartServiceImpl implements HeartService {
	
	private final HeartMapper heartMapper;

	@Override
	public boolean add(HeartVO heartVO) {
		return heartMapper.insert(heartVO) != 0;
	}

	@Override
	public boolean remove(Long hid) {
		return heartMapper.delete(hid) != 0;
	}

	@Override
	public boolean exists(HeartVO heartVO) {
		return heartMapper.exists(heartVO);
	}

	@Override
	public int getHid(HeartVO heartVO) {
		return heartMapper.selectHid(heartVO);
	}

	@Override
	public int getTotal(Long tid) {
		return heartMapper.selectTotal(tid);
	}
	
}	
