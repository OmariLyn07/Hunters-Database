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

    public List<HunterDetails> getAllHuntersWithLocales() {
        return Streamable.of(hunterRepository.findAllWithLocales()).toList();
    }
}
