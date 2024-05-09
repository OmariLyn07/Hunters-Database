package com.company.services.controller;

import com.company.services.model.Hunter;
import com.company.services.model.HunterDetails;
import com.company.services.services.HunterService;
import jakarta.websocket.server.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hunters")
public class HunterController {
    private final HunterService hunterService;

    @Autowired
    public HunterController(HunterService hunterService) {
        this.hunterService = hunterService;
    }

    @PostMapping
    public ResponseEntity<Hunter> insertNewHunterRecord(@RequestBody Hunter hunter) {
        Hunter savedHunter = hunterService.insertNewHunterRecord(hunter);
        return ResponseEntity.ok(savedHunter);
    }

    @DeleteMapping
    public ResponseEntity<Hunter> deleteHunterRecord(@RequestBody Hunter hunter) {
        Hunter deletedHunter = hunterService.deleteHunterRecord(hunter);
        return ResponseEntity.ok(deletedHunter);
    }

    @GetMapping
    public ResponseEntity<List<Hunter>> getAllHunters() {
        List<Hunter> hunters = hunterService.getAllHunters();
        return ResponseEntity.ok(hunters);
    }

    @GetMapping("/with-locales")
    public ResponseEntity<List<HunterDetails>> getAllHuntersWithLocales() {
        return ResponseEntity.ok(hunterService.getAllHuntersWithLocales());
    }

    @GetMapping("/with-rating")
    public ResponseEntity<List<Hunter>> getAllHuntersWithMaxRating() {
        List<Hunter> hunter = hunterService.getMaxRating();
        if(hunter != null) {
            return ResponseEntity.ok(hunter);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/with-rank")
    public ResponseEntity<List<Hunter>> getAllHuntersWithHighestRank() {
        List<Hunter> hunter = hunterService.getHighestRank();
        if(hunter != null) {
            return ResponseEntity.ok(hunter);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    public ResponseEntity<Hunter> updateHunter(@RequestBody Hunter hunter) {
        Hunter updatedHunter = hunterService.updateHunter(hunter);
        return ResponseEntity.ok(updatedHunter);
    }
}
