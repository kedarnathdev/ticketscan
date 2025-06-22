package com.ticketscan.ticketscan.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TrainsBetweenStationsRequest {
    @JsonProperty("fromStationCode")
    private String fromStationCode;
    @JsonProperty("toStationCode")
    private String toStationCode;
    @JsonProperty("journeyDate")
    private String journeyDate;
}
