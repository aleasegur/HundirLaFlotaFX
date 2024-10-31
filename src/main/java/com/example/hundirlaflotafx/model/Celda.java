package com.example.hundirlaflotafx.model;

public class Celda {
    private int x,y;
    private boolean atacar;
    private Barco barco;

    public Celda(int x, int y, boolean atacar, Barco barco) {
        this.x = x;
        this.y = y;
        this.atacar = atacar;
        this.barco = barco;
    }

    public Celda(int x, int y, boolean atacar) {
        this.x = x;
        this.y = y;
        this.atacar = atacar;
    }

    public Celda(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Celda(Barco barco) {
        this.barco = barco;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean getAtacar() {
        return atacar;
    }

    public void setAtacar(boolean atacar) {
        this.atacar = atacar;
    }

    public Barco getBarco() {
        return barco;
    }

    public void setBarco(Barco barco) {
        this.barco = barco;
    }

    boolean atacar(){
        atacar=true;//Marca como atacado la celda
        boolean res=(barco!=null);//Devuelve verdadero si hay un barco en esta celda
        return res;
    }

}
