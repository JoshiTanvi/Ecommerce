package com.project.ecommerce.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@After(value = "execution(* com.project.ecommerce.service.*.*(..))")
    public void after(JoinPoint joinPoint) {
        //logger.info("after execution of {}", joinPoint);
		System.out.println("after execution of {}" + joinPoint);
    }
	
	@Before(value = "execution(* com.project.ecommerce.service.*.*(..))")
    public void before(JoinPoint joinPoint) {
        //logger.info("after execution of {}", joinPoint);
    }
}
