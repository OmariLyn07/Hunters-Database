package com.company.services.repository;

import com.company.services.model.Hunter;
import com.company.services.model.HunterDetails;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HunterRepository extends CrudRepository<Hunter, Long> {
    @Query("SELECT h FROM Hunter h")
    public List<Hunter> getAllHunters();

    @Query("SELECT new com.company.services.model.HunterDetails(h.huntingID, h.name, h.rank, h.rating, l) FROM Hunter h JOIN h.locale l")
    List<HunterDetails> findAllWithLocales();
}
