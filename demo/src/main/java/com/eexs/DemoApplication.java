package com.eexs;

import com.eexs.config.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class DemoApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfiguration.class);
		DemoBean demoBean = context.getBean(DemoBean.class);
		System.out.println(demoBean);
		ImportBean importBean = context.getBean(ImportBean.class);
		System.out.println(demoBean.getImportBean() == importBean);

		MyDemoA myDemoA = context.getBean(MyDemoA.class);
		System.out.println(myDemoA);

	}

}
