package com.ticketscan.ticketscan.controller;

import com.ticketscan.ticketscan.dto.*;
import com.ticketscan.ticketscan.service.TrainServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ticketscan.ticketscan.handler.SeatAvailabilityHandler;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/trains")
public class TrainController {

	@Autowired
	TrainServiceImpl trainServiceImpl;
	
	@PostMapping("/seat_availability")
	public Mono<Result> getSeatAvailabilityStatus(@RequestBody SeatAvailabilityRequest seatAvailabilityRequest) {
		return trainServiceImpl.getSeatAvailabilityStatus(seatAvailabilityRequest);
	}

	@GetMapping("/station_code")
	public Mono<StationCodeResponse> getStationCode(@RequestParam("query") String stationName) {
		return trainServiceImpl.getStationCode(stationName);
	}

	@PostMapping("/trains_between_stations")
	public Mono<TrainsBetweenStationsResponse> getTrainsBetweenStations(@RequestBody TrainsBetweenStationsRequest request) {
		return trainServiceImpl.getTrainsBetweenStations(request);
	}

}
