package com.example.hundirlaflotafx.model;

import java.util.Random;

public class Tablero {
    private int filas;
    private int columnas;
    private Celda[][] celdas;

    public Tablero(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.celdas = new Celda[filas][columnas];
        inicializarCeldas();
    }

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    //Vreamos un metodo para inicializar las celdas vacias
    void inicializarCeldas() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                celdas[i][j] = new Celda(i, j);
            }
        }
    }

    // Método para ubicar un barco en una posición específica
    public void colocarBarco(int fila, int columna, Barco barco) {
            if (fila >= 0 && fila < filas && columna >= 0 && columna < columnas) {
                celdas[fila][columna] = new Celda(barco);
            }else {
            System.err.println("Posicion fuera del tablero "+fila+", "+columna);
        }
    }

    public boolean realizarAtaque(int fila, int columna) {
        boolean res = false;  // Inicializamos el resultado a false

        // Verifica si la posición está dentro de los límites del tablero
        if (fila >= 0 && fila < filas && columna >= 0 && columna < columnas) {
            Celda celda = celdas[fila][columna];
            boolean hayBarco = celda.atacar();

            if (hayBarco) {
                celda.getBarco().recibirImpacto();  // Registra el impacto en el barco
            }

            res = hayBarco;  // Asigna true a res si había un barco en la celda
        } else {
            System.err.println("Posición fuera del tablero: fila " + fila + ", columna " + columna);
        }

        return res;  // Un único return al final
    }

    //Verificar que los barcos estan hundidos
    public boolean todosLosBarcosHundidos() {
        boolean res = true;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                Barco barco = celdas[i][j].getBarco();//Llamo para comprobar si esta el barco
                if (barco != null && !barco.estaHundido()) {//Comprubo si barco si es distinto a nuli y si no esta hundido devuelo falso
                    res = false;
                }
            }
        }
        return res;
    }
    // Método para colocar barcos aleatorios
    public void colocarBarcosAleatorios(int cantidad) {
        Random random = new Random();
        for (int i = 0; i < cantidad; i++) {
            int fila = random.nextInt(celdas.length);
            int columna = random.nextInt(celdas[0].length - 1); // -1 para evitar desbordamiento
            int tamano = random.nextInt(2) + 2; // Barcos de tamaño 2 o 3
            colocarBarco(fila, columna, new Barco(tamano));
        }
    }

}
