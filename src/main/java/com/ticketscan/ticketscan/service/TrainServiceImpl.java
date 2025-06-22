package com.ticketscan.ticketscan.service;

import com.ticketscan.ticketscan.dto.*;
import com.ticketscan.ticketscan.handler.SeatAvailabilityHandler;
import com.ticketscan.ticketscan.handler.StationCodeHandler;
import com.ticketscan.ticketscan.handler.TrainsBetweenStationsHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class TrainServiceImpl {

    @Autowired
    private SeatAvailabilityHandler seatAvailabilityHandler;

    @Autowired
    private StationCodeHandler stationCodeHandler;

    @Autowired
    private TrainsBetweenStationsHandler trainsBetweenStationsHandler;

    public Mono<Result> getSeatAvailabilityStatus(SeatAvailabilityRequest seatAvailabilityRequest) {
        return seatAvailabilityHandler.getSeatAvailabilityStatus(seatAvailabilityRequest);
    }

    public Mono<StationCodeResponse> getStationCode(String stationName) {
        return stationCodeHandler.getStationCode(stationName);
    }

    public Mono<TrainsBetweenStationsResponse> getTrainsBetweenStations(TrainsBetweenStationsRequest request) {
        return trainsBetweenStationsHandler.getTrainsBetweenStations(request);
    }

}
