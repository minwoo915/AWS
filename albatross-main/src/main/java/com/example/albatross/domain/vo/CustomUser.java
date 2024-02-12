package com.example.albatross.domain.vo;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;

@Getter
public class CustomUser extends User{
	private static final long serialVersionUID =1L;
	
	private UserVO user;
	
	public CustomUser(String mail, String password, Collection<? extends GrantedAuthority> authorities) {
		super(mail, password, authorities);
	}
	
	public CustomUser(UserVO vo) {
		super(vo.getMail(), vo.getPassword(), Stream.of(vo.getAuthority())
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList()) );
		
		this.user = vo;
	}
}
