package com.ticketscan.ticketscan.handler;

import com.ticketscan.ticketscan.dto.TrainsBetweenStationsRequest;
import com.ticketscan.ticketscan.dto.TrainsBetweenStationsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class TrainsBetweenStationsHandler {

    private final WebClient webClient;

    public TrainsBetweenStationsHandler(WebClient webClient) {
        this.webClient = webClient;
    }

    @Autowired
    private Environment env;

    public Mono<TrainsBetweenStationsResponse> getTrainsBetweenStations(TrainsBetweenStationsRequest request) {
        String trainsBetweenStationsApiUrl = env.getProperty("trains.between.stations.api.url", "");

        trainsBetweenStationsApiUrl = trainsBetweenStationsApiUrl.replace("{fromStationCode}", request.getFromStationCode())
                .replace("{toStationCode}", request.getToStationCode())
                .replace("{journeyDate}", request.getJourneyDate());

        return callExternalApi(trainsBetweenStationsApiUrl);
    }

    public Mono<TrainsBetweenStationsResponse> callExternalApi(String apiUrl) {
        return webClient
                .get()
                .uri(apiUrl)
                .retrieve()
                .bodyToMono(TrainsBetweenStationsResponse.class);
    }
}
