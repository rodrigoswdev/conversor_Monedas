package com.example.contadorMonedas.service;

import com.example.contadorMonedas.model.DTOCambio;
import com.example.contadorMonedas.repository.cambioRepository;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class cambioServicio implements cambioRepository {

    private String API_KEY = "878bb01f1284721e4604fb8b";
    private String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    @Override
    public DTOCambio obtenerTasas(String baseCurrency) {
        try {
            String url = BASE_URL + API_KEY + "/latest/" + baseCurrency;

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            Gson gson = new Gson();
            return gson.fromJson(response.body(), DTOCambio.class);

        } catch (Exception e) {
            throw new RuntimeException("Error al obtener tasas de cambio: " + e.getMessage());
        }
    }

    public double convertir(String desde, String cambio, double cantidad) {
        DTOCambio exchangeResponse = obtenerTasas(desde);

        if (exchangeResponse.conversion_rates().containsKey(cambio)) {
            double tasa = exchangeResponse.conversion_rates().get(cambio);
            return cantidad * tasa;
        } else {
            throw new RuntimeException("No se encontró la tasa de conversión de " + desde + " a " + cambio);
        }
    }
}
