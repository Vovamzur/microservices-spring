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

    @GetMapping("")
    @ResponseBody
    public CountriesAndServiceName getCountries () {
        List<Country> countries = countryRepository.findAll();
        return new CountriesAndServiceName(countries, serviceInstanceId);
    }

    @GetMapping("/{countryId}")
    @ResponseBody
    public CountryAndServiceName getCountryById (@PathVariable("countryId") Long countryId) {
        Country country = countryRepository.findById(countryId).orElseThrow(
                () -> new ResourceNotFoundException("Country with such id " + countryId + " does not exist")
        );

        return new CountryAndServiceName(country, serviceInstanceId);
    }

    @PostMapping("/create")
    public ResponseEntity saveNewCountry (@Valid @RequestBody Country country, BindingResult bindingResult) throws  ValidationException {
        if (bindingResult.hasErrors()) {
            List<String> errors = bindingResult
                    .getAllErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
            throw new ValidationException(errors);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(this.countryRepository.save(country));
    }

    @PutMapping("/update")
    public ResponseEntity<Country> updateCountry (@Valid @RequestBody Country country, BindingResult bindingResult) throws  ValidationException {
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
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        Country newCountry = this.countryRepository.save(country);

        return ResponseEntity.status(HttpStatus.OK).body(newCountry);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCountryById (@PathVariable(name="id") Long id) {
        Optional<Country> bdCountry = this.countryRepository.findById(id);

        if (!bdCountry.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("There is  no country with such id " +  id);
        }

        try {
            this.countryRepository.deleteById(id);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body( "Something went wrong!. Try again");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Successfully deleted");
    }
}
