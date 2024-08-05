package com.example.aop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.aop.model.Department;
import com.example.aop.service.DepartmentService;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/department")
    public Department getDepartment(@RequestParam String name) {
        return departmentService.getDepartment(name);
    }

    @GetMapping("/process")
    public void processDepartment(@RequestParam String name) {
       // Department dept = departmentService.getDepartment(name);
        departmentService.processDepartment(name);
    }
}