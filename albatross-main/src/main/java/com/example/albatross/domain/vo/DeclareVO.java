package com.example.albatross.domain.vo;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class DeclareVO {
	private Long did;
	private Long tid;
	private int uuid;
	private int count;

}
