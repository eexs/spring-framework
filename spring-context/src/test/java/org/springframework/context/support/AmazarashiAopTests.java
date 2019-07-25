package org.springframework.context.support;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.junit.Test;

import java.util.Arrays;

public class AmazarashiAopTests {

	private static final String PATH = "/org/springframework/context/support/";
	private static final String AMAZARASHI_CONTEXT = PATH + "AmazarashiAopTests.xml";

	@Test
	public void testSingleConfigLocation() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(AMAZARASHI_CONTEXT);
		Hello hello = ctx.getBean(Hello.class);
		hello.hello("hello");
		ctx.close();
	}


//	@Aspect
//	@Component
//	@EnableAspectJAutoProxy
	static class LogAcpect {

//		@Pointcut("execution(public * org.springframework.context.support..*.*(..))")
		public void log(){}

//		@Before("log()")
		public void doBefore(JoinPoint joinPoint) throws Throwable {
			System.out.println(Arrays.toString(joinPoint.getArgs()));
			System.out.println("doBefore");
		}

//		@AfterReturning(returning = "ret",pointcut = "log()")
		public void doAfterReturning(JoinPoint joinPoint, Object ret) throws Throwable {
			System.out.println(Arrays.toString(joinPoint.getArgs()));
			System.out.println(ret);
			System.out.println("doAfterReturning");
		}

	}

	static interface Hello {
		public String hello(String hello);
	}

//	@Component
	static class HelloImpl implements Hello {
		@Override
		public String hello(String hello) {
			return hello + "world";
		}
	}

}
