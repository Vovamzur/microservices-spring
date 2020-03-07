package com.example.getaway.response;

import com.example.getaway.Country;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CountriesAndServiceName {
    List<Country> data;
    String serviceInstanceId;
}
