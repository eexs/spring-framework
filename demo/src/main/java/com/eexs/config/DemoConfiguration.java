package com.eexs.config;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.eexs")
@Import({MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
//@Import(MyImportSelector.class)
public class DemoConfiguration {


//	@Bean
//	@Primary
//	public DemoBean demoBean() {
//		return new DemoBean();
//	}
//
//	@Bean
//	public DemoBean demoBean1() {
//		return demoBean();
//	}

	@Bean
	public MyImportSelector myImportSelector() {
		return new MyImportSelector();
	}

	@Bean
	public MyImportBeanDefinitionRegistrar myImportBeanDefinitionRegistrar() {
		return new MyImportBeanDefinitionRegistrar();
	}

}
