package com.example.contadorMonedas.repository;

import com.example.contadorMonedas.model.DTOCambio;

public interface cambioRepository {
    DTOCambio obtenerTasas(String baseCurrency);
}
