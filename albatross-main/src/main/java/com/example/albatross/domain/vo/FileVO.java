package com.example.albatross.domain.vo;

import lombok.Data;

@Data
public class FileVO {
	String uuid;
	String uploadPath;
	String fileName;
	boolean fileType;
}
