package com.company.services.controller;

import com.company.services.model.Blacksmith;
import com.company.services.services.BlacksmithService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("blacksmiths")
public class BlacksmithController {
    private final BlacksmithService blacksmithService;

    @Autowired
    public BlacksmithController(BlacksmithService blacksmithService) {
        this.blacksmithService = blacksmithService;
    }

    // Endpoint to add a new Blacksmith
    @PostMapping
    public ResponseEntity<Blacksmith> createBlacksmith(@RequestBody Blacksmith blacksmith) {
        Blacksmith savedBlacksmith  = blacksmithService.insertBlacksmith(blacksmith);
        return ResponseEntity.ok(savedBlacksmith);  // Return the saved Blacksmith
    }

    // Endpoint to add multiple Blacksmiths
    @PostMapping("/batch")
    public ResponseEntity<List<Blacksmith>> createBlacksmiths(@RequestBody List<Blacksmith> blacksmiths) {
        List<Blacksmith> savedBlacksmiths = blacksmithService.insertBlacksmiths(blacksmiths);
        return ResponseEntity.ok(savedBlacksmiths);  // Return the saved Blacksmith
    }

    // Endpoint to retrieve all Blacksmiths
    @GetMapping
    public ResponseEntity<List<Blacksmith>> getAllBlacksmiths() {
        List<Blacksmith> blacksmiths = blacksmithService.getAllBlacksmiths();
        return ResponseEntity.ok(blacksmiths);  // Return the list of Blacksmith
    }

    // Endpoint to find a Blacksmith by ID
    @GetMapping("/{id}")
    public ResponseEntity<Blacksmith> getBlacksmithById(@PathVariable("id") String id) {
        Optional<Blacksmith> blacksmith = blacksmithService.getBlacksmithById(id);
        return blacksmith.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());  // Handle not found case
    }
}
