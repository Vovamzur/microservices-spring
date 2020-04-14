package com.example.getaway.client;

import com.example.getaway.dto.CountriesAndServiceName;
import com.example.getaway.dto.Country;
import com.example.getaway.dto.CountryAndServiceName;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name="countries-service", configuration = CountrieServiceConfigurations.class)
public interface CountriesService {
    @GetMapping("/api/countries")
    @ResponseBody
    CountriesAndServiceName getCountries();

    @GetMapping("/api/countries/{countryId}")
    @ResponseBody
    CountryAndServiceName getCountryById (@PathVariable("countryId") Long countryId);

    @PostMapping("/api/countries/create")
    ResponseEntity saveNewCountry (@RequestBody Country country);

    @PutMapping("/api/countries/update")
    ResponseEntity<Country> updateCountry (@RequestBody Country country);

    @DeleteMapping("/api/countries/delete/{id}")
    ResponseEntity<String> deleteCountryById (@PathVariable(name="id") Long id);
}
