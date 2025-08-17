package com.example.contadorMonedas.model;

import java.util.Map;

public record DTOCambio(
        String result,
        String base_code,
        Map<String, Double> conversion_rates
) {
}
