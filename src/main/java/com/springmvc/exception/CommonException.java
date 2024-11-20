package com.springmvc.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CommonException {
	
	@ExceptionHandler(RuntimeException.class)
	private ModelAndView handleErrorCommon(Exception e) {
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("exception", e);
		mav.setViewName("errorCommon"); //돌아갈 뷰 페이지 이름
		System.out.println("에러 페이지로 넘어갑니다.");
		return mav;

	}
}
