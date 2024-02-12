package com.example.albatross.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.albatross.domain.vo.UserVO;

@Mapper
public interface UserMapper {
	//mail로 VO 가져오기 Spring Security용 email check 
	public UserVO read(String mail);
	
	// 삽입
	public int insert(UserVO user);
	
	// 유저 정보 하나 가져오기
	public UserVO select(Long uuid);
	
	// 삭제, 근데 트윗 쓴거 있으면 안됨. 어짜피 안쓸거임
	public int delete(Long uuid);
	
	// 업데이트
	public int update(UserVO user);
	
}
