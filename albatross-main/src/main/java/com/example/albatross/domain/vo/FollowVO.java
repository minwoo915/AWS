package com.example.albatross.domain.vo;

import lombok.Data;

@Data
public class FollowVO {
	private Long fid;
	private Long from_uid;
	private Long to_uid;
	private String followdate;
}
