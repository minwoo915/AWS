package com.example.albatross.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.albatross.domain.vo.CustomUser;
import com.example.albatross.domain.vo.UserVO;
import com.example.albatross.mapper.UserMapper;

import lombok.extern.log4j.Log4j;

@Log4j
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
	log.warn("Load User By UserMail:" +mail);
	
	UserVO vo = userMapper.read(mail);
	log.warn("queried by member mapper:" +vo);
	
	return vo == null ? null :new CustomUser(vo);
}
}
