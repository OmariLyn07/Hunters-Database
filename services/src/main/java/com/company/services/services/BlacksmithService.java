package com.company.services.services;

import com.company.services.model.Blacksmith;
import com.company.services.repository.BlacksmithRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlacksmithService {
    private final BlacksmithRepository blacksmithRepository;

    @Autowired
    public BlacksmithService(BlacksmithRepository blacksmithRepository) {
        this.blacksmithRepository = blacksmithRepository;
    }

    public Blacksmith insertBlacksmith(Blacksmith blacksmith) {
        return blacksmithRepository.save(blacksmith);
    }

    public List<Blacksmith> insertBlacksmiths(List<Blacksmith> blacksmiths) {
        Iterable<Blacksmith> savedBlacksmiths = blacksmithRepository.saveAll(blacksmiths);
        return Streamable.of(savedBlacksmiths).toList();
    }

    public List<Blacksmith> getAllBlacksmiths() {
        Iterable<Blacksmith> blacksmiths = blacksmithRepository.getAllBlacksmiths();
        return Streamable.of(blacksmiths).toList();
    }

    public Optional<Blacksmith> getBlacksmithById(String id) {
        return blacksmithRepository.findById(id);
    }
}
