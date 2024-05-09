package com.company.services.repository;

import com.company.services.model.Hunter;
import com.company.services.model.HunterDetails;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HunterRepository extends CrudRepository<Hunter, Long> {
    @Query("SELECT h FROM Hunter h")
    public List<Hunter> getAllHunters();

    @Query("SELECT new com.company.services.model.HunterDetails(h.huntingID, h.name, h.rank, h.rating, h.target, l) FROM Hunter h JOIN h.locale l")
    List<HunterDetails> findAllWithLocales();

    @Query("SELECT DISTINCT h FROM Hunter h WHERE h.rating = (SELECT MAX( rating ) FROM Hunter)")
    public List<Hunter> findHunterWithMaxRating();

    @Query("SELECT DISTINCT h FROM Hunter h WHERE h.rank = (SELECT MAX( rank ) FROM Hunter)")
    public List<Hunter> findHunterWithHighestRank();

}
