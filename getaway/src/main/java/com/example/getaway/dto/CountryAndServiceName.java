package com.example.getaway.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountryAndServiceName {
    Country data;
    String serviceInstanceId;
}
