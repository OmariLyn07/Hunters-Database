package com.company.services.services;

import com.company.services.model.Hunter;
import com.company.services.model.HunterDetails;
import com.company.services.repository.HunterRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HunterService {
    private final HunterRepository hunterRepository;

    @Autowired
    public HunterService(HunterRepository hunterRepository) {

        this.hunterRepository = hunterRepository;
    }

    public List<Hunter> getAllHunters(){

        return Streamable.of(hunterRepository.getAllHunters()).toList();
    }

    public Hunter insertNewHunterRecord(Hunter hunter){
        try{
            return hunterRepository.save(hunter);
        }
        catch(DataAccessException e){
            throw new ServiceException("Failed to insert Hunter record", e);
        }
    }

    public Hunter deleteHunterRecord(Hunter hunter){
        try{
            hunterRepository.delete(hunter);
        }catch(DataAccessException e){
            throw new ServiceException("Failed to delete Hunter record", e);
        }
        return hunter;
    }

    public List<HunterDetails> getAllHuntersWithLocales() {
        return Streamable.of(hunterRepository.findAllWithLocales()).toList();
    }

    public Hunter getMaxRating() {
        return hunterRepository.findHunterWithMaxRating();
    }

    public Hunter getHighestRank(){
        return hunterRepository.findHunterWithHighestRank();
    }

    public Optional<Hunter> getTarget(String target){
        return hunterRepository.findHunterByTarget(target);
    }
}
