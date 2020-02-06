package com.eexs.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

//RequestMappingHandlerMapping、RequestMappingHandlerAdapter。处理使用@Controller注解方式的Controller
@RestController
public class TestController {

	@RequestMapping("test")
	@ResponseBody
	public String test(){
		System.out.println("execute @RestController test");
		return "test";
	}

	@RequestMapping("json")
	@ResponseBody
	public Object json(){
		System.out.println("execute @RestController json");
		Map map = new HashMap<>();
		map.put("json", "ok");
		return map;
	}

}
