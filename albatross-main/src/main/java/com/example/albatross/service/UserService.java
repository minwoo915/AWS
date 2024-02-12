package com.example.albatross.service;

import org.springframework.stereotype.Service;

import com.example.albatross.domain.vo.UserVO;

@Service
public interface UserService {
	
	// 삽입
	public boolean add(UserVO user);
				
	// 유저정보 하나 가져오기
	public UserVO get(Long uuid);
				
	// 삭제
	public boolean remove(Long uuid);
				
	// 업데이트
	public boolean modify(UserVO user);
	
	//email중복 확인 있으면 true, 없으면 false
	public boolean checkMail(String mail);
}
