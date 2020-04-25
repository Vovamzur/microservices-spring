package com.example.getaway.controller;

import com.example.getaway.client.CountriesService;
import com.example.getaway.dto.CountriesAndServiceName;
import com.example.getaway.dto.Country;
import com.example.getaway.dto.CountryAndServiceName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/getaway/countries")
public class CountriesController {

    @Autowired
    private CountriesService countriesService;

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
