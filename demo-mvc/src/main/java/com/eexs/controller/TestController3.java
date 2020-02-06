package com.eexs.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//BeanNameUrlHandlerMapping、HttpRequestHandlerAdapter。处理实现HttpRequestHandler接口方式的Controller
@Component("/test3")
public class TestController3 implements HttpRequestHandler {

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("execute HttpRequestHandler handleRequest");
	}

}
