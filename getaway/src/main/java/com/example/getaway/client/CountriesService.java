package com.example.getaway.client;

import com.example.getaway.dto.CountriesAndServiceName;
import com.example.getaway.dto.Country;
import com.example.getaway.dto.CountryAndServiceName;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name="countries-service", configuration = CountrieServiceConfigurations.class)
public interface CountriesService {
    @RequestMapping(method = RequestMethod.GET, value = "/api/countries", consumes = "application/json")
    CountriesAndServiceName getCountries();

    @RequestMapping(method = RequestMethod.GET, value = "/api/countries/{countryId}", consumes = "application/json")
    CountryAndServiceName getCountryById (@PathVariable("countryId") Long countryId);

    @RequestMapping(method = RequestMethod.POST, value = "/api/countries/create", consumes = "application/json")
    Country saveNewCountry (@RequestBody Country country);

    @RequestMapping(method = RequestMethod.PUT, value = "/api/countries/update", consumes = "application/json")
    Country updateCountry (@RequestBody Country country);

    @RequestMapping(method = RequestMethod.DELETE, value = "/api/countries/delete/{id}")
    String deleteCountryById (@PathVariable(name="id") Long id);
}
