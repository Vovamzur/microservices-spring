package com.example.getaway;

import com.example.getaway.response.CountriesAndServiceName;
import com.example.getaway.response.CountryAndServiceName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import javax.validation.Valid;

//@RestController
//@RequestMapping("/countries")
//public class Getaway {
//
//    @Autowired
//    private RestTemplate restTemplate;
//
//    @Autowired
//    private WebClient.Builder webClientBuilder;
//
//    @GetMapping("")
//    @ResponseBody
//    public CountriesAndServiceName getCountries () {
//        return restTemplate.getForObject("http://countries-service/api/countries", CountriesAndServiceName.class);
//    }
//
//    @GetMapping("/{countryId}")
//    @ResponseBody
//    public CountryAndServiceName getCountryById (@PathVariable("countryId") Long countryId) {
//        return restTemplate.getForObject("http://countries-service/api/countries/" + countryId, CountryAndServiceName.class);
//    }
//
//    @PostMapping("/create")
//    public ResponseEntity saveNewCountry (@Valid @RequestBody Country country) {
//        return restTemplate.postForEntity("http://countries-service/api/countries/create", country, ResponseEntity.class);
//    }
//
//    @PutMapping("/update")
//    public ResponseEntity updateCountry (@Valid @RequestBody Country country) {
//        restTemplate.put("http://countries-service/api/countries/update", country);
//        return restTemplate.getForObject("http://countries-service/api/countries/" + country.getId(), ResponseEntity.class);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<String> deleteCountryById (@PathVariable(name="id") Long id) {
//        restTemplate.delete("http://countries-service/api/countries/delete" + id);
//        CountryAndServiceName result = restTemplate.getForObject("http://countries-service/api/countries/" + id, CountryAndServiceName.class);
//        if (result != null) return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong!. Try again");
//        else return ResponseEntity.status(HttpStatus.OK).body("Successfully deleted");
//    }
//}
