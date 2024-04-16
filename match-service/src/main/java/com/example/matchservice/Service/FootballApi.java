package com.example.matchservice.Service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class FootballApi {
    @Value("${rapidapi.key}")
    private static String rapidApiKey;

    private final static String url = "https://v3.football.api-sports.io";
    private static final String today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

    public static JSONObject getBoardMatches(int league) {
        try {
            String fixtures = WebClient.builder()
                    .baseUrl(url)
                    .defaultHeader("x-rapidapi-host", "v3.football.api-sports.io")
                    .defaultHeader("x-rapidapi-key", rapidApiKey)
                    .build()
                    .post()
                    .uri("/fixtures")
                    .body(BodyInserters.fromValue("{\"league\": \"" + league + "\", \"season\": \"2023\", \"date\": \"" + today + "\"}"))
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            JSONObject data = new JSONObject(fixtures);
            return data.getJSONObject("response");
        } catch (Exception e) {
            return new JSONObject();
        }
    }

}
