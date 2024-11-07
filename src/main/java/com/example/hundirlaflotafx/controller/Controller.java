package com.example.hundirlaflotafx.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import com.example.hundirlaflotafx.model.Tablero;
import com.example.hundirlaflotafx.model.Barco;

public class Controller {
    private final int FILAS = 5;  // Número de filas en el tablero
    private final int COLUMNAS = 5; // Número de columnas en el tablero
    private Tablero tablero; // Instancia del tablero de juego

    @FXML
    private GridPane tableroGrid; // El tablero visual
    @FXML
    private Text resultado; // Mensaje de resultado
    @FXML
    private Label welcomeText; // Label para mostrar el texto de bienvenida

    public void initialize() {
        iniciarJuego(); // Inicializa el juego al arrancar
    }

    private void iniciarJuego() {
        tablero = new Tablero(FILAS, COLUMNAS); // Crea una nueva instancia del tablero
        colocarBarcosAleatorios(3); // Coloca 3 barcos aleatorios en el tablero
        crearBotonesTablero(); // Crea los botones que representan las celdas
        resultado.setText(""); // Reinicia el mensaje de resultado
    }

    public void colocarBarcosAleatorios(int cantidad) {
        tablero.colocarBarcosAleatorios(cantidad);
    }

    public void crearBotonesTablero() {
        tableroGrid.getChildren().clear(); // Limpia el tablero anterior
        for (int fila = 0; fila < FILAS; fila++) {
            for (int columna = 0; columna < COLUMNAS; columna++) {
                Button boton = new Button();
                boton.setPrefSize(50, 50); // Tamaño del botón
                final int f = fila; // Necesitamos una copia final para la expresión lambda
                final int c = columna;

                // Añadimos un evento al botón
                boton.setOnAction(e -> {
                    boolean ataqueResultante = tablero.realizarAtaque(f, c); // Realiza el ataque
                    if (ataqueResultante) {
                        boton.setStyle("-fx-background-color: red;"); // Color rojo si se golpeó un barco
                        resultado.setText("¡Ataque exitoso!"); // Mensaje de éxito
                    } else {
                        boton.setStyle("-fx-background-color: blue;"); // Color azul si no se golpeó
                        resultado.setText("¡Agua!"); // Mensaje de fallo
                    }

                    // Comprobar si todos los barcos están hundidos
                    if (tablero.todosLosBarcosHundidos()) {
                        resultado.setText("¡Has hundido todos los barcos!"); // Mensaje final
                    }
                });

                tableroGrid.add(boton, columna, fila); // Añadimos el botón al tablero
            }
        }
    }
    /*
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("¡Bienvenido al juego de Batalla Naval!");
    }*/

    @FXML
    public void reiniciarJuego() {
        iniciarJuego(); // Reinicia el juego
        welcomeText.setText("¡Juego reiniciado!"); // Mensaje de reinicio
    }
}
