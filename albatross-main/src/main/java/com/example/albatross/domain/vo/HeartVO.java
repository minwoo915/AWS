package com.example.albatross.domain.vo;

import java.util.Date;

import lombok.Data;

@Data
public class HeartVO {
	private Long hid; // 좋아요 
	private Long uuid; // 좋아요를 누른 사람
	private Long tid; // 좋아요를 누른 게시글
	private String heartdate; // 좋아요 날짜
}
