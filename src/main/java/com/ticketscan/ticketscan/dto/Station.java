package com.ticketscan.ticketscan.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Station {
    @JsonProperty("station_name")
    private String stationName;
    @JsonProperty("station_code")
    private String stationCode;
}
