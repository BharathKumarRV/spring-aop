package com.example.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SecurityAspect {

    @Before("execution(* com.example.aop.service.DepartmentService.processDepartment(..))")
    public void checkSecurity() {
        System.out.println("Security check before processing department");
    }
}