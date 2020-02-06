package com.eexs.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//BeanNameUrlHandlerMapping、SimpleControllerHandlerAdapter。处理实现Controller接口方式的Controller
@Component("/test2")
public class TestController2 implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("execute Controller handleRequest");
		return null;
	}

}
