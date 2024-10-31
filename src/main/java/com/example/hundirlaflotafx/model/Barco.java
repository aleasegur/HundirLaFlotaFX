package com.example.hundirlaflotafx.model;

public class Barco {
    private int tamano;
    private int impacto=0;

    public Barco(int tamano){
        this.tamano=tamano;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    public int getImpacto(){
        return impacto;
    }

    void recibirImpacto(){
        if (impacto<tamano){
            impacto++;
        }
    }

    boolean estaHundido(){
        boolean res=impacto>=tamano;
        return res;
    }


}
