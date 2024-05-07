package com.company.services.controller;

import com.company.services.model.Hunter;
import com.company.services.model.HunterDetails;
import com.company.services.services.HunterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<Hunter>> getAllHunters() {
        List<Hunter> hunters = hunterService.getAllHunters();
        return ResponseEntity.ok(hunters);
    }

    @GetMapping("/with-locales")
    public ResponseEntity<List<HunterDetails>> getAllHuntersWithLocales() {
        return ResponseEntity.ok(hunterService.getAllHuntersWithLocales());
    }
}
