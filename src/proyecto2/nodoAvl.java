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
public class nodoAvl {
    nodoAvl izquierda, derecha;
    String archivo, contenido;
    int altura;
    
    
        public nodoAvl() {
        izquierda = null;
        derecha = null;
        archivo = "";
        contenido="";
        altura = 0;

    }

    public nodoAvl(String a, String c) {
        izquierda = null;
        derecha = null;
        archivo = a;
        contenido= c;
        altura = 0;
    }
}
