package com.ticketscan.ticketscan.handler;

import com.ticketscan.ticketscan.dto.SeatAvailabilityRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.ticketscan.ticketscan.dto.Result;

import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
public class SeatAvailabilityHandler {

	private final WebClient webClient;

    @Autowired
    private Environment env;

    public SeatAvailabilityHandler(WebClient webClient, Environment env) {
        this.webClient = webClient;
    }

    public Mono<Result> getSeatAvailabilityStatus(SeatAvailabilityRequest seatAvailabilityRequest) {

        String ticketAvailabilityApiUrl = env.getProperty("ticket.availability.api.url", "");

        SeatAvailabilityRequest request = Optional.ofNullable(seatAvailabilityRequest)
                .orElse(new SeatAvailabilityRequest());
        ticketAvailabilityApiUrl = ticketAvailabilityApiUrl.replace("{trainNumber}", request.getTrainNumber())
                .replace("{journeyClass}", request.getJourneyClass())
                .replace("{fromStationCode}", request.getFromStationCode())
                .replace("{toStationCode}", request.getToStationCode())
                .replace("{journeyDate}", request.getJourneyDate())
                .replace("{journeyQuota}", request.getJourneyQuota())
                .replace("{boardingFromStationCode}", request.getBoardingFromStationCode())
                .replace("{boardingToStationCode}", request.getBoardingToStationCode());
        return callExternalApi(ticketAvailabilityApiUrl);
    }
    
    public Mono<Result> callExternalApi(String apiUrl) {
        return webClient
                .get()
                .uri(apiUrl)
                .retrieve()
                .bodyToMono(Result.class);
    }
	
}
