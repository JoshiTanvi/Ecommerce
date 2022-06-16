package com.project.ecommerce.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeTrackAspect {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Around("@annotation(com.project.ecommerce.aop.TimeTrack)")
	public void around(ProceedingJoinPoint joinPoint) throws Throwable {
		long startTime = System.currentTimeMillis();

		joinPoint.proceed();

		long timeTaken = System.currentTimeMillis() - startTime;
		logger.info("Time Taken by {} is {}", joinPoint, timeTaken);
		//System.out.println("Time Taken by {} is {}" + joinPoint + " ---- " + timeTaken);
	}
}
