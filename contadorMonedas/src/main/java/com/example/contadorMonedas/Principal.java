package com.example.contadorMonedas;

import com.example.contadorMonedas.service.cambioServicio;

import java.util.Scanner;

public class Principal {

    private cambioServicio servicio = new cambioServicio();
    private Scanner teclado = new Scanner(System.in);

    public void mostrarMenu() {

        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    "**************************"
                    Sea bienvenido/a al Conversor de Monedas
                    1) Dólar =>> Peso argentino
                    2) Peso argentino =>> Dólar
                    3) Dólar =>> Real Brasileño
                    4) Real brasileño =>> Dólar
                    5) Dólar =>> Peso colombiano
                    6) Peso colombiano =>> Dólar
                    7) Salir
                    
                    Elija una opción válida:
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();
            switch (opcion) {
                case 1:
                    convertir("USD", "ARS");
                    break;
                case 2:
                    convertir("ARS", "USD");
                    break;
                case 3:
                    convertir("USD", "BRL");
                    break;
                case 4:
                    convertir("BRL", "USD");
                    break;
                case 5:
                    convertir("USD", "COP");
                    break;
                case 6:
                    convertir("COP", "USD");
                    break;
                case 7:
                    System.out.println("Gracias por usar el conversor!");
                    break;
                default:
                    System.out.println("Opción inválida, intente de nuevo.");
            }

        }
    }

    private void convertir(String desde, String cambio) {
        System.out.print("Ingresa el valor que desea convertir: ");
        double valor = teclado.nextDouble();

        double resultado = servicio.convertir(desde, cambio, valor);
        System.out.printf("El valor %.2f [%s] corresponde al valor final de =>>> %.4f [%s]%n",
                valor, desde, resultado, cambio);
    }
}
