package com.example.aop.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TransactionAspect {

    @After("execution(* com.example.aop.service.DepartmentService.processDepartment(..))")
    public void handleTransaction() {
        System.out.println("Transaction handling after processing department");
    }
}