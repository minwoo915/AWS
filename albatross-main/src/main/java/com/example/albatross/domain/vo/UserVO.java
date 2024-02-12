package com.example.albatross.domain.vo;

import lombok.Data;

@Data
public class UserVO {
	private Long uuid;
	private String mail;
	private String password;
	private String nickname;
	private String intro;
	private String authority;
	private String profile_link;
	private boolean enabled;
	
	private String joindate;
}
