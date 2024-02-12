package com.example.albatross.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.albatross.domain.vo.UserVO;
import com.example.albatross.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user/*")
@Log4j
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/test")
    public String test() {
		log.info("USERCONTROLLER GET 요청이 잘 되었습니다.");
        return "USERCONTROLLER GET 요청이 잘 되었습니다..";
    }
	
	//유저 계정 생성
	@PostMapping(value ="/new" , consumes ="application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> addUser(@RequestBody UserVO user) {
		return userService.add(user) ? new ResponseEntity<>("success", HttpStatus.OK) :
			new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//유저 하나 조회
	@GetMapping(value = "/{uuid}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public UserVO getUser(@PathVariable("uuid")Long uuid) {
		log.info("getUser........" + uuid);
		
		return userService.get(uuid);
	}
	
	//유저 수정
	@PostMapping(value="/modify/{uuid}", consumes ="application/json", produces= {MediaType.TEXT_PLAIN_VALUE})
	public String modify(@PathVariable Long uuid, @RequestBody UserVO user) {
		log.info("modifyUser........" + uuid);
			
		return userService.modify(user) ? "success" : "fail";
	}
	
	//email 중복 체크
	@GetMapping(value="/check/{mail:.+}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public boolean checkMail(@PathVariable("mail") String mail) {
		String temp = mail.replace("\"", "");
		log.info("UserController - checkEmail  : " + temp);
		
		return userService.checkMail(temp);
	}
}
