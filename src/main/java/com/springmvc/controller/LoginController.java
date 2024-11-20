package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//왜 자꾸 이걸 까먹지?
@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String login(Model model) {
		System.out.println("로그인 페이지로 이동합니다.");
		// Boolean으로 추가 형변환 없이 그냥 받고싶다면 로그인이 성공했을 때도 값을 넣어줘야 한다.
		return "login";
		
	}
	
	@GetMapping("/loginfailed")
	public String loginerror(Model model) {
		System.out.println("로그인에 실패했습니다.");
		model.addAttribute("error", "true");
		// 이거 문자열로 담은거라서 Boolean으로 그냥 받게되면 에러 터짐
		// String으로 받아서 문제는 없지만 Boolean그대로 받고 싶다면 쌍따옴표 뺄 것
		// model.addAttribute("error", "true");
		return "login";
		
	}
	
	@GetMapping("/logout")
	public String logout(Model model) {
		System.out.println("로그아웃");
		return "login";
	}
}
