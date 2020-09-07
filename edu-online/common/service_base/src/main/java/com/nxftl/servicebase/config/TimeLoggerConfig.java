package com.nxftl.servicebase.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author darkltl
 * @Date 2020/8/30 23:12
 */
@Component
@Aspect
public class TimeLoggerConfig {
	private static final Logger LOGGER = LoggerFactory.getLogger(TimeLoggerConfig.class);

	@Pointcut("execution(public * com.nxftl.eduservice.service.impl..*.*(..))")
	public void pointCut(){}

	@Before("pointCut()")
	public void before(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		LOGGER.info("Method Name : ["+methodName+"] ->>>> AOP after");
	}

	@AfterReturning(pointcut = "pointCut()",returning = "result")
	public void afterReturn(JoinPoint joinPoint,Object result){
		String methodName = joinPoint.getSignature().getName();
		LOGGER.info("Method Name : [" + methodName + "] ---> AOP after return ,and result is : " + result.toString());
	}

	@AfterThrowing(pointcut = "pointCut()",throwing = "throwable")
	public void afterThrowing(JoinPoint joinPoint,Throwable throwable){
		String methodName = joinPoint.getSignature().getName();
		LOGGER.info("Method Name : [" + methodName + "] ---> AOP after throwing ,and throwable message is : " + throwable.getMessage());
	}

	@Around("pointCut()")
	public Object around(ProceedingJoinPoint proceedingJoinPoint){
		String methodName = proceedingJoinPoint.getSignature().getName();
		try {
			LOGGER.info("Method Name : [" + methodName + "] ---> AOP around start");
			long startTimeMillis = System.currentTimeMillis();
			//调用 proceed() 方法才会真正的执行实际被代理的方法
			Object result = proceedingJoinPoint.proceed();
			long execTimeMillis = System.currentTimeMillis() - startTimeMillis;
			LOGGER.info("Method Name : [" + methodName + "] ---> AOP method exec time millis : " + execTimeMillis);
			LOGGER.info("Method Name : [" + methodName + "] ---> AOP around end , and result is : " + result.toString());
			return result;
		}catch (Throwable ex){
			LOGGER.error(ex.getMessage(),ex);
			throw new RuntimeException(ex.getMessage());
		}
	}
}
