package com.eexs.config;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;
import java.util.List;

@Configuration
@ComponentScan("com.eexs")
@EnableWebMvc
public class SpringApplication implements WebMvcConfigurer {

	@Bean
	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
		return new MappingJackson2HttpMessageConverter();
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(mappingJackson2HttpMessageConverter());
		System.out.println(converters);
	}

	public static void run() {
		AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
		applicationContext.register(SpringApplication.class);
		/**
		 * EnableWebMvc注解 与 applicationContext#refresh 同时使用会报错
		 */
//		applicationContext.refresh();

		File baseFile = new File(System.getProperty("java.io.tmpdir"));

		Tomcat tomcat = new Tomcat();
		tomcat.setPort(9090);

		/**
		 * 根据SPI会调用 ServletContainerInitializer	（WEB项目初始化、回去解析jsp等等）
		 * tomcat.addWebapp()
		 * 不会调用 ServletContainerInitializer		（非WEB项目初始化）
		 * tomcat.addContext()
		 */
		Context rootContext = tomcat.addContext("/", baseFile.getAbsolutePath());

		DispatcherServlet dispatcherServlet = new DispatcherServlet(applicationContext);
		//调用HttpServletBean#init方法初始化
		Tomcat.addServlet(rootContext, "dispatcherServlet", dispatcherServlet).setLoadOnStartup(1);
		rootContext.addServletMapping("/", "dispatcherServlet");

		try {
			tomcat.start();
			tomcat.getServer().await();
		} catch (LifecycleException e) {
			e.printStackTrace();
		}

	}
	

}
