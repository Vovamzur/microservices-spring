package com.example.client.controller;

import com.example.client.entity.Country;
import com.example.client.exception.ResourceNotFoundException;
import com.example.client.exception.ValidationException;
import com.example.client.repository.CountryRepository;
import com.example.client.response.CountriesAndServiceName;
import com.example.client.response.CountryAndServiceName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

    @Value("${eureka.instance.instance-id}")
    private String serviceInstanceId;

    @Autowired
    private CountryRepository countryRepository;

    private List<String> checkForUnique(Country country) {
        List<String> errors = new ArrayList<>();
        if (countryRepository.findByCapital(country.getCapital()).isPresent()) {
            errors.add("country with " + country.getCapital() + " capital is already exists");
        }
        if (countryRepository.findByName((country.getName())).isPresent()) {
            errors.add("country with " + country.getName() + " name is already exists");
        }
        return errors;
    }

    @GetMapping("")
    @ResponseBody
    public CountriesAndServiceName getCountries() {
        List<Country> countries = countryRepository.findAll();
        return new CountriesAndServiceName(countries, serviceInstanceId);
    }

    @GetMapping("/{countryId}")
    @ResponseBody
    public CountryAndServiceName getCountryById(@PathVariable("countryId") Long countryId) {
        Country country = countryRepository.findById(countryId).orElseThrow(
                () -> new ResourceNotFoundException("Country with such id " + countryId + " does not exist")
        );

        return new CountryAndServiceName(country, serviceInstanceId);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Country saveNewCountry(
            @Valid @RequestBody Country country, BindingResult bindingResult
    ) throws ValidationException {
        if (bindingResult.hasErrors()) {
            List<String> errors = bindingResult
                    .getAllErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
            throw new ValidationException(errors);
        }
        List uniqueErrors = this.checkForUnique(country);

        if (uniqueErrors.size() > 0) {
            throw new ValidationException(uniqueErrors);
        }
        return this.countryRepository.save(country);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Country updateCountry(
            @Valid @RequestBody Country country, BindingResult bindingResult
    ) throws ValidationException, ResourceNotFoundException {
        if (bindingResult.hasErrors()) {
            List<String> errors = bindingResult
                    .getAllErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
            throw new ValidationException(errors);
        }
        Optional<Country> bdCountry = this.countryRepository.findById(country.getId());

        if (!bdCountry.isPresent()) {
            throw new ResourceNotFoundException("Country with such id " + country.getId() + " does not exist");
        }

        List uniqueErrors = this.checkForUnique(country);
        if (uniqueErrors.size() > 0) {
            throw new ValidationException(uniqueErrors);
        }

        return this.countryRepository.save(country);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteCountryById(@PathVariable(name = "id") Long id) {
        Optional<Country> bdCountry = this.countryRepository.findById(id);

        if (!bdCountry.isPresent()) {
            throw new ResourceNotFoundException("There is  no country with such id " + id);
        }
        this.countryRepository.deleteById(id);
        return "Successfully deleted";
    }
}
