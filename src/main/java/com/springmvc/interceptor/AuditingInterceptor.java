package com.springmvc.interceptor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuditingInterceptor extends HandlerInterceptorAdapter{
	
	public Logger log = LoggerFactory.getLogger(this.getClass());
	
	private String user;
	private String bookId;

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		
		if(!(req.getRequestURI().endsWith("logout"))) {
			
			if(req.getRequestURI().endsWith("books/add") && req.getMethod().equals("POST")) {
				user = req.getRemoteUser();
				bookId = req.getParameter("bookId");
			}
			
		}

		
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest req, HttpServletResponse resp, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("afterCompletion 입장했습니다.");
		if(req.getRequestURI().endsWith("books/add")) {
			log.warn(String.format("신규등록 도서 ID : %s, 접근자 : %s, 접근시각 : %s", bookId, user, getCurrentTime()));
		}
		
	}
	
	
	private String getCurrentTime() {
		// TODO Auto-generated method stub
		System.out.println("getCurrentTime() 입장");
		DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		
		return formatter.format(calendar.getTime());
	}
	
	
}
