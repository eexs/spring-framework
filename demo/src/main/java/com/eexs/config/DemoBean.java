package com.eexs.config;


import org.springframework.stereotype.Component;

@Component
public class DemoBean {

//	private Class aClass;
//
//	public DemoBean(Class aClass) {
//		this.aClass = aClass;
//	}

	private ImportBean importBean;

	public DemoBean(ImportBean importBean) {
		this.importBean = importBean;
	}

	public ImportBean getImportBean() {
		return importBean;
	}
}
