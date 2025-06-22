package com.ticketscan.ticketscan.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {
	
	JsonResult result;
	
	public class JsonResult {
		private Boolean success;
		
		@JsonProperty("seat_availibility")
		private List<SeatAvailability> seatAvailability;
		
	}

}
