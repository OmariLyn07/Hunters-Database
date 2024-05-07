package com.company.services.services;

import com.company.services.model.Locale;
import com.company.services.repository.LocaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocaleService {
    private final LocaleRepository localeRepository;

    @Autowired
    public LocaleService(LocaleRepository localeRepository) {
        this.localeRepository = localeRepository;
    }

    public Locale insertLocale(Locale locale) {
        return localeRepository.save(locale);
    }

    public List<Locale> insertLocales(List<Locale> locales) {
        Iterable<Locale> savedLocales = localeRepository.saveAll(locales);
        return Streamable.of(savedLocales).toList();
    }

    public List<Locale> getAllLocales() {
        Iterable<Locale> locales = localeRepository.getAllLocales();
        return Streamable.of(locales).toList();
    }

    public Optional<Locale> getLocaleById(String id) {
        return localeRepository.findById(id);
    }
}
