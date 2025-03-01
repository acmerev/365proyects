package com.indigo.deepseekchat;

import java.io.*;
import java.nio.file.*;

public class ReemplazarAsteriscos {
    public static void main(String[] args) {
        // Ruta del archivo CSV de entrada
        String inputFile = "C:/localcsv/cata.csv";
        // Ruta del archivo CSV de salida
        String outputFile = "C:/localcsv/cata_mod.csv";

        try {
            // Leer el archivo CSV
            BufferedReader reader = Files.newBufferedReader(Paths.get(inputFile));
            // Crear el archivo de salida
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputFile));

            String line;
            while ((line = reader.readLine()) != null) {
                // Reemplazar todos los asteriscos '*' por '0'
                String modifiedLine = line.replace("*", "0");
                // Escribir la línea modificada en el archivo de salida
                writer.write(modifiedLine);
                writer.newLine();
            }

            // Cerrar los flujos de lectura y escritura
            reader.close();
            writer.close();

            System.out.println("El archivo ha sido modificado con éxito.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
