package com.example.albatross.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.albatross.domain.vo.FollowVO;

@Mapper
public interface FollowMapper {
	public List<FollowVO> selectList(long from_uid);
	public int insert(FollowVO followVO);
	public int delete(long fid);
	public boolean exists(FollowVO followVO);
	public int selectFid(FollowVO followVO);
}
