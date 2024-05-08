package com.company.services.controller;

import com.company.services.model.Locale;
import com.company.services.services.LocaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("locales")
public class LocaleController {
    private final LocaleService localeService;

    @Autowired
    public LocaleController(LocaleService localeService) {

        this.localeService = localeService;
    }

    // Endpoint to add a new Locale
    @PostMapping
    public ResponseEntity<Locale> createLocale(@RequestBody Locale locale) {
        Locale savedLocale  = localeService.insertLocale(locale);
        return ResponseEntity.ok(savedLocale);  // Return the saved Locale
    }

    // Endpoint to add multiple Locales
    @PostMapping("/batch")
    public ResponseEntity<List<Locale>> createLocales(@RequestBody List<Locale> locales) {
        List<Locale> savedLocales = localeService.insertLocales(locales);
        return ResponseEntity.ok(savedLocales);  // Return the saved Locale
    }

    @DeleteMapping
    public ResponseEntity<Locale> deleteLocale(@RequestBody Locale locale) {
        Locale deletedLocale = localeService.deleteLocale(locale);
        return ResponseEntity.ok(deletedLocale);
    }

    // Endpoint to retrieve all Locales
    @GetMapping
    public ResponseEntity<List<Locale>> getAllLocales() {
        List<Locale> locales = localeService.getAllLocales();
        return ResponseEntity.ok(locales);  // Return the list of Locale
    }

    // Endpoint to find a Locale by ID
    @GetMapping("/{id}")
    public ResponseEntity<Locale> getLocaleById(@PathVariable("id") String id) {
        Optional<Locale> locale = localeService.getLocaleById(id);
        return locale.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());  // Handle not found case
    }
}
