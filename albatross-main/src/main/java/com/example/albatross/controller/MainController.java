package com.example.albatross.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.albatross.domain.vo.DeclareVO;
import com.example.albatross.service.DeclareService;
import com.example.albatross.service.HeartService;
import com.example.albatross.service.TweetService;
import com.example.albatross.service.UserService;

import lombok.extern.log4j.Log4j;


@Controller	
@Log4j
@RequestMapping("/Albatross/*")
public class MainController {
	@Autowired
	private TweetService tweetService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private HeartService heartService;
	
	@Autowired
	private DeclareService declareService;
	
	//User 계정으로만 진입가능
	@GetMapping("/main")
	public void doMain() {
		log.info("MainController에서 /main 진입");
	}
	
	@GetMapping("/tweetDetail")
	public void tweetDetail(Long tid, Model model) {
		log.info("MainContorller = /tweetDetail에 들어왔음 ");
		model.addAttribute("TweetDTO", tweetService.get(tid));
	}
	
	@GetMapping("/userDetail")
	public void userDetail(Long uuid, Model model) {
		log.info("MainContorller = /userDetail에 들어왔음 ");
		log.info("MainContorller = /userDetail uuid = " + uuid.getClass().getName());
		model.addAttribute("UserVO", userService.get(uuid));
	}
	
	@GetMapping("/edit")
	public void userEdit(Long uuid, Model model) {
		log.info("MainContorller = /edit에 들어왔음 ");
		log.info("MainContorller = /edit uuid = " + uuid);
		model.addAttribute("UserVO", userService.get(uuid));
	}
	
	@GetMapping("/search")
	public void search(String str, Model model) {
		log.info("MainContorller = /search에 들어왔음 ");
		log.info("MainContorller = /search str = " + str);
		model.addAttribute("str", str);
	}
	
	@GetMapping("/follow")
	public void follow() {
		log.info("MainContorller = /follow에 들어왔음 ");
	}
	
	
	//계정 없이 진입 가능
	@GetMapping("/register")
	public void doAccountRegister() {
		log.info("MainController에서 /accountRegiste 진입");
	}
	
	//--------------------------------------------------------------------관리자
	
	@GetMapping("/admin")
	public void list(Long did, HttpServletRequest request, Model model) {
		
		log.info("list...");
		model.addAttribute("declarelist", declareService.getGroupCount());
	}
	
	@GetMapping("/adminRead")
	public void read(Long tid, HttpServletRequest request, Model model) {
		log.info("read...");
		String url = request.getRequestURI();
		log.info(url.substring(url.lastIndexOf("/")) + ": " + tid);
		model.addAttribute("declare", declareService.read(tid));
	}

	@GetMapping("/adminDelete")
	public String delete(Long tid, RedirectAttributes rttr) {
		log.info("/delete: " + tid);
		
		if(declareService.delete(tid) && declareService.tweetDelete(tid)) {
			rttr.addFlashAttribute("result", "success");
		}
		
		return "redirect:/Albatross/admin";
	}
	
	@PostMapping("/declare")
	public String declare(DeclareVO declareVO, RedirectAttributes rttr) {
		log.info("/declare: " + declareVO);
		declareService.declare(declareVO);
		
		rttr.addFlashAttribute("did", declareVO.getDid());
		return "redirect:/declare/list";
	} 

	
	
	
	
	//---------------------------------CommonController-------------------------------------
	@GetMapping("/error")
	public void accessDenied(Authentication auth, Model model){		
		log.info("access Denied : " + auth);
		
		model.addAttribute("msg", "Access Denined");

	}
	
	@GetMapping("/Login")
	public void loginInput(String error, String logout, Model model) {
		log.info("error: " + error);
		log.info("logout: " +logout);
		
		if(error != null) {
			model.addAttribute("error", "Login Error Check Your Acccount");
		}
		
		if(logout != null) {
			model.addAttribute("logout", "Logout!!");
		}
	}
	@GetMapping("/Logout")
	public void logoutGet() {
		log.info("loggout!!");
	}
}
