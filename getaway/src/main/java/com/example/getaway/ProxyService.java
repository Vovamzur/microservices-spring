package com.example.getaway;

import com.example.getaway.client.CountriesService;
import com.example.getaway.dto.CountriesAndServiceName;
import com.example.getaway.dto.Country;
import com.example.getaway.dto.CountryAndServiceName;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;

@Component
public class ProxyService {
    private static final String BACKEND_A = "countries-service";

    @Autowired
    private CountriesService serviceClient;

    @CircuitBreaker(name = BACKEND_A, fallbackMethod = "allFallback")
    public CountriesAndServiceName getCountries() {
        return serviceClient.getCountries();
    }

    @CircuitBreaker(name = BACKEND_A, fallbackMethod = "oneFallback")
    public CountryAndServiceName getCountryById(@PathVariable(name="id") Long id) {
        return serviceClient.getCountryById(id);
    }

    @Retry(name = BACKEND_A)
    public Country saveNewCountry(Country country) {
        return serviceClient.saveNewCountry(country);
    }

    @Retry(name = BACKEND_A)
    public Country updateCountry(Country country) {
        return serviceClient.updateCountry(country);
    }

    @Retry(name=BACKEND_A)
    public String deleteCountryById(@PathVariable(name="id") Long id) {
        return this.serviceClient.deleteCountryById(id);
    }

    public CountryAndServiceName oneFallback(Throwable e) {
        return new CountryAndServiceName(null, "oneFallback");
    }

    public CountriesAndServiceName allFallback(Throwable e) {
        return new CountriesAndServiceName(new ArrayList<>(), "allFallback");
    }
}
