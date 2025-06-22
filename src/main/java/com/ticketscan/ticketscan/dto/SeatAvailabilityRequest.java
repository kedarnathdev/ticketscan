package com.ticketscan.ticketscan.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SeatAvailabilityRequest {
    @JsonProperty("trainNumber")
    private String trainNumber;
    @JsonProperty("journeyClass")
    private String journeyClass;
    @JsonProperty("fromStationCode")
    private String fromStationCode;
    @JsonProperty("toStationCode")
    private String toStationCode;
    @JsonProperty("journeyDate")
    private String journeyDate;
    @JsonProperty("journeyQuota")
    private String journeyQuota;
    @JsonProperty("boardingFromStationCode")
    private String boardingFromStationCode;
    @JsonProperty("boardingToStationCode")
    private String boardingToStationCode;
}
