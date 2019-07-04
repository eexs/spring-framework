package org.springframework.context.support;

import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.io.ClassPathResource;

import static junit.framework.TestCase.assertNotNull;

public class AmazarashiClassPathXmlApplicationContextTests {

	private static final String PATH = "/org/springframework/context/support/";
	private static final String AMAZARASHI_CONTEXT = PATH + "AmazarashiClassPathXmlApplicationContextTests.xml";

	@Test
	public void testSingleConfigLocation() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(AMAZARASHI_CONTEXT);
//		assertNotNull(ctx.getBean(Basket.class));
		assertNotNull(ctx.getBean(Apple.class));
		ctx.close();


//		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(AMAZARASHI_CONTEXT);
//		ctx.getBeanFactory().addBeanPostProcessor(new MyBeanPostProcessor());
//		assertNotNull(ctx.getBean(Basket.class));
//		assertNotNull(ctx.getBean(Apple.class));
//		ctx.close();


//		ClassPathResource resource = new ClassPathResource(AMAZARASHI_CONTEXT);
//		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
//		factory.addBeanPostProcessor(new MyBeanPostProcessor());
//		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
//		reader.loadBeanDefinitions(resource);
////		assertNotNull(factory.getBean(Basket.class));
//		assertNotNull(factory.getBean(Apple.class));


//		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(AMAZARASHI_CONTEXT);
//		DataSource dataSource = ctx.getBean(DataSource.class);
//		assertNotNull(dataSource);
//		ctx.close();

//		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(AMAZARASHI_CONTEXT);
//		Basket basket = ctx.getBean(Basket.class);
//		assertNotNull(basket);
//		ctx.close();

//		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(AMAZARASHI_CONTEXT);
//		ctx.getEnvironment().setActiveProfiles("production");
//		ctx.refresh();
//		Apple apple = ctx.getBean(Apple.class);
//		assertNotNull(apple);
//		ctx.close();

	}

	static class Basket {
		private Apple apple;
		public Apple getApple() {
			return apple;
		}
		public void setApple(Apple apple) {
			this.apple = apple;
		}
		@Override
		public String toString() {
			return "Basket{" +
					"apple=" + apple +
					'}';
		}
	}

	static class Apple {
		String colour;
		public String getColour() {
			return colour;
		}
		public void setColour(String colour) {
			this.colour = colour;
		}
		@Override
		public String toString() {
			return "Apple{" +
					"colour='" + colour + '\'' +
					'}';
		}
	}

	static class MyBeanPostProcessor implements BeanPostProcessor, InitializingBean {

		@Override
		public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
			System.out.println(bean.getClass().getSimpleName() + "->Before");
			return bean;
		}

		@Override
		public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
			System.out.println(bean.getClass().getSimpleName() + "->After");
			return bean;
		}

		@Override
		public void afterPropertiesSet() throws Exception {
			System.out.println(this.getClass().getSimpleName() + "->afterPropertiesSet");
		}

		public void initMethod() {
			System.out.println(this.getClass().getSimpleName() + "->initMethod");
		}

	}

	static class DataSource {
		private int test;

		public void setTest(int test) {
			this.test = test;
		}

		public int getTest() {
			return test;
		}

		private String driveClass;
		private String url;
		private String userName;
		private String password;
		public String getDriveClass() {
			return driveClass;
		}

		public String getUrl() {
			return url;
		}

		public String getUserName() {
			return userName;
		}

		public String getPassword() {
			return password;
		}

		public void setDriveClass(String driveClass) {
			this.driveClass = driveClass;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		@Override
		public String toString() {
			return "DataSource{" +
					"driveClass='" + driveClass + '\'' +
					", url='" + url + '\'' +
					", userName='" + userName + '\'' +
					", password='" + password + '\'' +
					'}';
		}
	}

	static class CustomConverterService implements Converter<String, Apple> {

		@Override
		public Apple convert(String source) {
			Apple apple = new Apple();
			apple.setColour(source);
			return apple;
		}
	}

}


