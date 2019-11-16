package proyecto2;

import sun.misc.Contended;

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
 int idx,idy;
 String Directorio;
 nodoM arriba, abajo, izquierda, derecha;
 ArbolAVL a = new ArbolAVL();

    public nodoM(int idx, int idy, String Directorio) {
        this.idx = idx;
        this.idy=idy;
        this.Directorio = Directorio;
        this.arriba = null;
        this.abajo = null;
        this.izquierda = null;
        this.derecha = null;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public int getIdy() {
        return idy;
    }

    public void setIdy(int idy) {
        this.idy = idy;
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
    
    
   
    
    public void  eliminarArchivo(String Archivo){
        a.Delete(Archivo);
    
    }
    
   
    
    public void GraficarArbol(){
    
        a.getAVL();
    }

    public ArbolAVL getA() {
        return a;
    }

    public void setA(ArbolAVL a) {
        this.a = a;
    }
    
 
 
}
