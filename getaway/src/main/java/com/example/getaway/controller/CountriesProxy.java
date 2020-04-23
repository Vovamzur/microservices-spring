package com.example.getaway.controller;

import com.example.getaway.ProxyService;
import com.example.getaway.dto.CountriesAndServiceName;
import com.example.getaway.dto.Country;
import com.example.getaway.dto.CountryAndServiceName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/feign/countries")
public class CountriesProxy {
    @Autowired
    private ProxyService countriesService;

    @GetMapping("")
    @ResponseBody
    public CountriesAndServiceName getCountries() {
        return countriesService.getCountries();
    }

    @GetMapping("/{countryId}")
    @ResponseBody
    public CountryAndServiceName getCountryById(@PathVariable("countryId") Long countryId) {
        return this.countriesService.getCountryById(countryId);
    }

    @PostMapping("/create")
    public Country saveNewCountry(@RequestBody Country country) {
        return this.countriesService.saveNewCountry(country);
    }

    @PutMapping("/update")
    public Country updateCountry(@RequestBody Country country) {
        return this.countriesService.updateCountry(country);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCountryById(@PathVariable(name = "id") Long id) {
        return this.countriesService.deleteCountryById(id);
    }
}
