package com.example.client.response;

import com.example.client.entity.Country;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CountriesAndServiceName {
    List<Country> data;
    String serviceInstanceId;
}
