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
public class NodoAVL {
    NodoAVL izquierda, derecha;
    String archivo;
    String contenido;
    int altura;
    int fe;
   



    public NodoAVL(String n, String c) {
        izquierda = null;
        derecha = null;
        archivo = n;
        contenido=c;
        altura = 0;
        fe = 0;
    }
    
    
}
