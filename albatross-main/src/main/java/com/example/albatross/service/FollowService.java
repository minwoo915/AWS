package com.example.albatross.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.albatross.domain.vo.FollowVO;

@Service
public interface FollowService {
	public List<FollowVO> getList(long from_uid);
	public boolean add(FollowVO fvo);
	public boolean remove(long fid);
	public boolean exists(FollowVO followVO);
	public int getFid(FollowVO followVO);
}
