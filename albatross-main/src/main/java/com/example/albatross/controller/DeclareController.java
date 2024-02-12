package com.example.albatross.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.albatross.domain.vo.DeclareVO;
import com.example.albatross.domain.vo.HeartVO;
import com.example.albatross.service.DeclareService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@RequiredArgsConstructor
@RequestMapping("/declare/*")
@Log4j
public class DeclareController {
	@Autowired
	DeclareService declareService;
	// 신고
	@PostMapping(value ="/new" , consumes ="application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
	public void addFollow(@RequestBody DeclareVO declare) {
		log.info("new declare........" + declare);
		declareService.declare(declare);
	}	

}




