package com.indigo.deepseekchat;

import java.io.*;

public class LimpiarCSV {
    public static void main(String[] args) {
        String rutaEntrada = "C:/localcsv/cata.csv";
        String rutaSalida = "C:/localcsv/cata_limpio.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(rutaEntrada));
             BufferedWriter bw = new BufferedWriter(new FileWriter(rutaSalida))) {

            String linea;
            String encabezado = br.readLine(); // Leer encabezado
            if (encabezado != null) {
                bw.write(encabezado);
                bw.newLine();
            }

            while ((linea = br.readLine()) != null) {
                String[] valores = linea.split(",");

                for (int i = 0; i < valores.length; i++) {
                    valores[i] = valores[i].trim();
                    // Reemplazar '*' con NULL
                    if (valores[i].equals("*")) {
                        valores[i] = "NULL";
                    }
                    // Reemplazar valores vacíos en columnas numéricas con 0.0
                    if (valores[i].isEmpty() && esColumnaNumerica(i)) {
                        valores[i] = "0.0";
                    }
                }

                bw.write(String.join(",", valores));
                bw.newLine();
            }

            System.out.println("Archivo limpio guardado en: " + rutaSalida);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para identificar columnas numéricas (ajustar índices según sea necesario)
    private static boolean esColumnaNumerica(int index) {
        int[] columnasNumericas = {5, 6, 9, 10, 11, 12, 13, 14, 15, 16, 18, 19, 24, 25}; // Índices basados en la estructura de la tabla
        for (int col : columnasNumericas) {
            if (index == col) {
                return true;
            }
        }
        return false;
    }
}
