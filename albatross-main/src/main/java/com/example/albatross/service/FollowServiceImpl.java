package com.example.albatross.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.albatross.domain.vo.FollowVO;
import com.example.albatross.mapper.FollowMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FollowServiceImpl implements FollowService {
	
	private final FollowMapper followMapper;
	
	@Override
	public List<FollowVO> getList(long from_uid) {
		return followMapper.selectList(from_uid);
	}

	@Override
	public boolean add(FollowVO fvo) {
		return followMapper.insert(fvo) != 0;
	}

	@Override
	public boolean remove(long fid) {
		// TODO Auto-generated method stub
		return followMapper.delete(fid) != 0;
	}

	@Override
	public boolean exists(FollowVO followVO) {
		return followMapper.exists(followVO);
	}

	@Override
	public int getFid(FollowVO followVO) {
		if(followMapper.exists(followVO))
		{
			return followMapper.selectFid(followVO);
		}
		else {
			return 0;
		}
	}

}
