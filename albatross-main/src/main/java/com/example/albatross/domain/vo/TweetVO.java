package com.example.albatross.domain.vo;

import lombok.Data;

// 트윗(글)의 VO
@Data
public class TweetVO {
	private Long tid;
	private Long uuid;	
	private String t_type;
	private Long ref_tid;	// type에 따라서 null 가능
	private String content;		
	private String image_link;	// image 존재 여부에 따라서 null 가능
	private String regdate;		//	spring에서 조작 불필요
	private String updatedate;	//	spring에서 조작 불필요
}
