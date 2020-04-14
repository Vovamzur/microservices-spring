package com.example.getaway.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountriesAndServiceName {
    List<Country> data;
    String serviceInstanceId;
}
