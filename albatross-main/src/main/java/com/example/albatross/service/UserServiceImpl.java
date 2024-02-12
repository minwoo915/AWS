package com.example.albatross.service;

import org.springframework.stereotype.Service;

import com.example.albatross.domain.dao.TweetDAO;
import com.example.albatross.domain.vo.UserVO;
import com.example.albatross.mapper.UserMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@RequiredArgsConstructor
@Log4j
public class UserServiceImpl implements UserService {
	
	private final UserMapper userMapper;
	
	@Override
	public boolean add(UserVO user) {
		
		return userMapper.insert(user) != 0;
	}

	@Override
	public UserVO get(Long uuid) {
		return userMapper.select(uuid);
	}

	@Override
	public boolean remove(Long uuid) {
		return userMapper.delete(uuid) != 0;
	}

	@Override
	public boolean modify(UserVO user) {
		return userMapper.update(user) != 0;
	}

	@Override
	public boolean checkMail(String mail) {
		log.info("UserService에서 mail:" + mail);
		UserVO user = userMapper.read(mail);
		if(user == null) { return false; }
		return mail.equals(user.getMail());
	}

}
