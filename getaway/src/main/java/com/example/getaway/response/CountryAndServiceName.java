package com.example.getaway.response;

import com.example.getaway.Country;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CountryAndServiceName {
    Country data;
    String serviceInstanceId;
}
