package com.styledin.styledin.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Salon {
    private UUID id;
    private String name;
    private String address;
    private String ownerName;
    private String phoneNumber;
    private String email;
    private List<Job> openJobs;
}
