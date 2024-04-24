@RestController
@RequestMapping("/myapi")
package com.company.services.controller;

import com.company.services.model.testEmployee;
import com.company.services.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

public class testControllers {

    private final testService testService;

    @Autowired
    public testControllers(testService testService){
        this.testService = testService;
    }

    @GetMapping("/test")
    public testEmployee test(@RequestParam Integer id){
        return testService.test(id);
    }

    @GetMapping("/employees/max-salary")
    public testEmployee getEmployeeWithMaxSalary(){
        return EmployeeService.getEmployeeWithMaxSalary();
    }
}


