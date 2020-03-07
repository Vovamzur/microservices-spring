package com.example.getaway;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Country {
    private Long id;

    @NotBlank(message = "name is mandatory")
    private String name;

    @NotBlank(message = "currency is mandatory")
    private String currency;

    @Size(min=1, message = "should pass at least one language")
    private Set<@NotBlank String> languages = new HashSet<>();

    @NotBlank(message = "capital is mandatory")
    private String capital;

    @Min(value = 1, message = "Population should be unsigned number")
    @Digits(integer=10, fraction = 0, message = "Population should be unsigned long")
    @NotNull(message = "population can't be null")
    private long population;

    @NotBlank(message = "phonePrefix is mandatory")
    private String phonePrefix;

    @Min(value=1, message = "Budget should be bigger than 1")
    @Digits(integer=12, fraction = 0, message = "Budget should be unsigned long")
    @NotNull(message = "budget can't be null")
    private long budget;

    @Min(value=1, message = "GDP should be bigger than 1")
    @Digits(integer=15, fraction = 0, message = "GDP should be unsigned long")
    @NotNull(message = "gdp can't be null")
    private long gdp;
}

