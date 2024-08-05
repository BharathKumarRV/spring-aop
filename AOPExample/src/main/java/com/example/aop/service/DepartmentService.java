package com.example.aop.service;

import com.example.aop.model.Department;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
	public Department getDepartment(String name) {
		return new Department(name);
	}

	public void processDepartment(String department) {
		System.out.println("Processing department: " + department);
	}
}