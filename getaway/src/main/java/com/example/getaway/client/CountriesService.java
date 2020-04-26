package com.example.getaway.client;

import com.example.getaway.dto.CountriesAndServiceName;
import com.example.getaway.dto.Country;
import com.example.getaway.dto.CountryAndServiceName;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(name = "countries-service", configuration = CountrieServiceConfigurations.class)
@RequestMapping("/api/countries")
public interface CountriesService {
    @GetMapping(value = "", consumes = "application/json")
    @ResponseBody
    CountriesAndServiceName getCountries();

    @GetMapping(value = "/{countryId}", consumes = "application/json")
    @ResponseBody
    CountryAndServiceName getCountryById(@PathVariable("countryId") Long countryId);

    @PostMapping(value = "/create", consumes = "application/json")
    @ResponseBody
    Country saveNewCountry(@RequestBody Country country);

    @PutMapping(value = "/update", consumes = "application/json")
    @ResponseBody
    Country updateCountry(@RequestBody Country country);

    @DeleteMapping(value = "/delete/{id}", consumes = "application/json")
    @ResponseBody
    Map<String, String> deleteCountryById(@PathVariable(name = "id") Long id);
}
