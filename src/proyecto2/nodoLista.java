/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2;

/**
 *
 * @author Aran
 */
public class nodoLista {
    int id;
    usuario u;
    nodoLista siguiente;
    nodoLista anterior;

    public nodoLista(int id) {
        this.id = id;
        this.siguiente = null;
        this.anterior = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public usuario getU() {
        return u;
    }

    public void setU(usuario u) {
        this.u = u;
    }

    public nodoLista getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(nodoLista siguiente) {
        this.siguiente = siguiente;
    }

    public nodoLista getAnterior() {
        return anterior;
    }

    public void setAnterior(nodoLista anterior) {
        this.anterior = anterior;
    }
    
    
    
    
    
}
