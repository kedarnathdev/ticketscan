package com.ticketscan.ticketscan.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Train {
    @JsonProperty("train_number")
    private String trainNumber;
    @JsonProperty("train_name")
    private String trainName;
    @JsonProperty("from_std")
    private String journeyStartTime;
    @JsonProperty("to_std")
    private String journeyEndTime;
}
