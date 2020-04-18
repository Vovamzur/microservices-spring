package com.example.getaway.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Country {
    Long id;
    long population;
    long budget;
    long gdp;
    String name;
    String currency;
    String capital;
    String phonePrefix;
    Set<String> languages;
}
