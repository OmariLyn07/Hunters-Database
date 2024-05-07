package com.company.services.repository;

import com.company.services.model.Locale;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocaleRepository extends CrudRepository<Locale, String> {
    @Query("SELECT l FROM Locale l")
    public List<Locale> getAllLocales();
}
