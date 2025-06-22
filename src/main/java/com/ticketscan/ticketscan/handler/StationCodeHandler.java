package com.ticketscan.ticketscan.handler;

import com.ticketscan.ticketscan.dto.Result;
import com.ticketscan.ticketscan.dto.Station;
import com.ticketscan.ticketscan.dto.StationCodeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StationCodeHandler {

    private final WebClient webClient;

    public StationCodeHandler(WebClient webClient) {
        this.webClient = webClient;
    }

    @Autowired
    private Environment env;

    public Mono<StationCodeResponse> getStationCode(String stationName) {
        String stationCodeApiUrl = env.getProperty("railway.station.code.api.url", "");
        stationCodeApiUrl = stationCodeApiUrl.replace("{stationName}", stationName);
        return callExternalApi(stationCodeApiUrl);
    }

    public Mono<StationCodeResponse> callExternalApi(String apiUrl) {

        return webClient
                .get()
                .uri(apiUrl)
                .retrieve()
                .bodyToMono(StationCodeResponse.class);
    }

}
