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
    
    
    String accion;
    String usu;
    String date;

    public nodoLista(int id) {
        this.id = id;
        this.siguiente = null;
        this.anterior = null;
    }
    
     public nodoLista(int id,String usu,String accion, String date) {
        this.id = id;
        this.usu=usu;
        this.accion = accion;
        this.date = date;
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

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getUsu() {
        return usu;
    }

    public void setUsu(String usu) {
        this.usu = usu;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    
    
    
    
}
