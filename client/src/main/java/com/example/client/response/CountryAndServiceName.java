package com.example.client.response;

import com.example.client.entity.Country;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CountryAndServiceName {
    Country data;
    String serviceInstanceId;
}
