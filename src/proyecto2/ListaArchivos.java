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
public class ListaArchivos {
    NodoAVL primero;
    NodoAVL ultimo;
    //ArbolAVL ab=new ArbolAVL();
    
    public ListaArchivos(){
        primero=null;
        ultimo= null;
         
        
    }
    
    public void insertar(String Archivo, String Contenido){
        NodoAVL nuevo= new NodoAVL(Archivo, Contenido);
          
        if (primero==null) {
            
            primero= nuevo;
            ultimo=primero;
            nuevo.derecha=null;
            
        }else{
        
            ultimo.derecha= nuevo;
            ultimo=nuevo;
            
        }

    }
    
    public void eliminar(String archivo){
       NodoAVL actual=primero;
       archivo = archivo.trim();
        if (primero.archivo.equalsIgnoreCase(archivo)) {
            primero=primero.derecha;
        }else{
            while(actual.derecha!=null&& actual.derecha.archivo.equalsIgnoreCase(archivo)==false){
                   actual= actual.derecha;
                }
                 
            if (actual.derecha== null) {
                   System.out.println("Id:"+archivo+" no se pudo eliminar, por que no existe");
                }else{
                    System.out.println("Archivo: "+actual.derecha.archivo+" Contenido: "+actual.derecha.contenido);
                    System.out.println("Eliminado con exito");
                    actual.derecha= actual.derecha.derecha;
                   }
        }
     }
    
    public void Modificar(String archivo, String Nuevo, String Contendio){
       NodoAVL actual=primero;
        while (actual!=null) {            
            if(actual.archivo.equals(archivo)){
                actual.archivo=Nuevo;
                actual.contenido= Contendio;
            }
            actual = actual.derecha;
        }
        
     }
    
    public void mostrar(){
    NodoAVL actual = primero;
        while (actual!=null) {            
            System.out.println(actual.archivo);
            actual=actual.derecha;
        }
    
    }
    
  
}
