package com.company.services.repository;

import com.company.services.model.testEmployee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface testRepository extends CrudRepository<testEmployee, Integer> {
    @Query
            ("SELECT * FROM Employee e WHERE e.salary = (SELECT MAX(salary) FROM Employee)")
    Optional<testEmployee> findEmployeeWithMaxSalary();
    Optional<testEmployee> findById(Integer id);
}
