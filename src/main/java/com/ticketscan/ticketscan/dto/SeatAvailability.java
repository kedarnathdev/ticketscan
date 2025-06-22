package com.ticketscan.ticketscan.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SeatAvailability {

	@JsonProperty("Date (DD-MM-YYYY)")
	private String dateDDMMYYYY;
	@JsonProperty("Class - SL")
	private String classSL;
	@JsonProperty("class_type")
	private String classType;
	@JsonProperty("cp_perc")
	private String cpPerc;

}
