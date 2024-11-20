package com.springmvc.interceptor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MonitoringInterceptor implements HandlerInterceptor{

	ThreadLocal<StopWatch> stopWatchLocal = new ThreadLocal<StopWatch>();
	
	public Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		System.out.println("preHandle()입장");
		
		StopWatch stopWatch = new StopWatch(handler.toString());
		stopWatch.start(handler.toString());
		stopWatchLocal.set(stopWatch);
		
		log.info("접근한 URL 경로 : " + getURLPath(request) );
		log.info("요청 처리 시작 시간 : " + getCurrentTime());
		
		return true;
	}

	private String getCurrentTime() {
		// TODO Auto-generated method stub
		System.out.println("getCurrentTime() 입장");
		DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		
		return formatter.format(calendar.getTime());
	}

	private String getURLPath(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		System.out.println("getURLPath() 입장");
		String currentPath = request.getRequestURI();
		String queryString = request.getQueryString();
		queryString = queryString == null ? "" : "?" + queryString;
		
		return currentPath+queryString;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		log.info("요청 처리 종료 시각 : " + getCurrentTime());
		
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		StopWatch stopWatch = stopWatchLocal.get();
		
		log.info("요청 처리 소요 시간 : " + stopWatch.getTotalTimeMillis() + "ms" );
		stopWatchLocal.set(null);
		log.info("=======================================");
		
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
	
	
	
	
}
