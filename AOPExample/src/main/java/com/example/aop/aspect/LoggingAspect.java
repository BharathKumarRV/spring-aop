package com.example.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	@Pointcut("execution(* com.example.aop.service.DepartmentService.*(..))")
	private void serviceMethods() {
	}

	@Before("serviceMethods()")
	public void logBefore(JoinPoint joinPoint) {
		System.out.println("Logging before method: " + joinPoint.getSignature().getName());
	}

	/*
	 * @After("serviceMethods()") public void logAfter(JoinPoint joinPoint) {
	 * System.out.println("Logging after method: " +
	 * joinPoint.getSignature().getName()); }
	 */

	/*
	 * @AfterReturning(pointcut = "serviceMethods()", returning = "result") public
	 * void logAfterReturning(JoinPoint joinPoint, Object result) {
	 * System.out.println("Logging after returning method: " +
	 * joinPoint.getSignature().getName() + ", returned value: " + result); }
	 */

	/*
	 * @AfterThrowing(pointcut = "serviceMethods()", throwing = "error") public void
	 * logAfterThrowing(JoinPoint joinPoint, Throwable error) { System.out
	 * .println("Logging after throwing method: " +
	 * joinPoint.getSignature().getName() + ", error: " + error); }
	 */

	@Around("serviceMethods()")
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("Logging around method: " + joinPoint.getSignature().getName());
		Object result = joinPoint.proceed();
		System.out.println("Logging around after method: " + joinPoint.getSignature().getName());
		return result;
	}

}