package com.company.services.services;

import com.company.services.model.testEmployee;
import com.company.services.repository.testRepository;
import com.company.services.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;


public class testService {
    private final testRepository testRepository;

    @Autowired
    public testService(testRepository testRepository){
        this.testRepository = testRepository;
    }

    public testEmployee getEmployeeWithMaxSalary(){
        return EmployeeRepository.findEmployeeWithMaxSalary().orElse(null);
    }

    public testEmployee test(Integer id){
        return testRepository.findById(id).orElse(null);
    }
}
