package com.styledin.styledin.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmploymentHistory {
    private UUID id;
    private String title;
    private String companyName;
    // this is supposed to be like a range of dates such as February 2020 - October 2023
    private String datesEmployed;
    private String jobDescription;
}
