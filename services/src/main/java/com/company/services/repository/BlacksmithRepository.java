package com.company.services.repository;

import com.company.services.model.Blacksmith;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlacksmithRepository extends CrudRepository<Blacksmith, String> {
    @Query("SELECT b FROM Blacksmith b")
    public List<Blacksmith> getAllBlacksmiths();
}
