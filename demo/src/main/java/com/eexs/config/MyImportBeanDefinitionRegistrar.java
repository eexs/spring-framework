package com.eexs.config;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		BeanDefinition demoBeanDb = registry.getBeanDefinition("demoBean");
//		demoBeanDb.getConstructorArgumentValues().addGenericArgumentValue(ImportBean.class.getName());
		demoBeanDb.getConstructorArgumentValues().addGenericArgumentValue(registry.getBeanDefinition(ImportBean.class.getName()));
	}

}
