package proyecto2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aran
 */
public class nodoM {
 int id;
 String Directorio;
 nodoM arriba, abajo, izquierda, derecha;

    public nodoM(int id, String Directorio) {
        this.id = id;
        this.Directorio = Directorio;
        this.arriba = null;
        this.abajo = null;
        this.izquierda = null;
        this.derecha = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDirectorio() {
        return Directorio;
    }

    public void setDirectorio(String Directorio) {
        this.Directorio = Directorio;
    }

    public nodoM getArriba() {
        return arriba;
    }

    public void setArriba(nodoM arriba) {
        this.arriba = arriba;
    }

    public nodoM getAbajo() {
        return abajo;
    }

    public void setAbajo(nodoM abajo) {
        this.abajo = abajo;
    }

    public nodoM getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(nodoM izquierda) {
        this.izquierda = izquierda;
    }

    public nodoM getDerecha() {
        return derecha;
    }

    public void setDerecha(nodoM derecha) {
        this.derecha = derecha;
    }
    
    
    
 
 
 
}
