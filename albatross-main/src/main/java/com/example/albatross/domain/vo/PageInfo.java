package com.example.albatross.domain.vo;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Data;

// 글들을 List로 가지고 오기위한 페이지 정보를 전송하기 위한 DTO
@Data
public class PageInfo {
	// 페이지 번호 Default = 1;
	private int pageNum;
	// 한번에 가지고 올 페이지 량 Default = 20;
	private int amount;
	
	
	//검색구문 
	private String str;
	
	//keyword들
	private String t_type;
	private Long uuid;
	private String content;
	private Long ref_tid;
	
	
	// Default 
	public PageInfo() {
		this(1, 10);
	}
	
	public PageInfo(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	public PageInfo(int pageNum, int amount, String str, String t_type, Long uuid, String content, Long ref_tid) {
		this.pageNum = pageNum;
		this.amount = amount;
		this.str = str;
		this.t_type = t_type;
		this.uuid = uuid;
		this.content = content;
		this.ref_tid = ref_tid;
	}
	
	public String getParams() {
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
				.queryParam("pageNum", this.pageNum)
				.queryParam("str", this.str)
				.queryParam("t_type", this.t_type)
				.queryParam("uuid", this.uuid)
				.queryParam("content", this.content)
				.queryParam("ref_tid", this.ref_tid);
		return builder.toUriString();
	}
	
	public String[] getTypes() {
		//"ABC".split("") --> 3칸 배열 ([A][B][C])
		return str == null? new String[] {} : str.split("");
	}
	
}
