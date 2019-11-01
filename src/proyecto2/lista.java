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
public class lista {
    nodoLista primero;
    nodoLista ultimo;
    int cantidad;
    int disponibles;

    public lista() {
        this.primero = null;
        this.ultimo = null;

    }
    
    public boolean isEmpity(nodoLista actual){
        if(actual==null){
         return true;
        }
    
    return false;
    }
    
    public boolean isEmpityU(nodoLista actual){
        if(actual.getU()==null){
         return true;
        }
    
    return false;
    }
    public void insertar(int id){
        nodoLista nuevo =  new nodoLista(id);
        if(primero== null){
            primero = nuevo;
            ultimo= primero;
        }else{
            ultimo.setSiguiente(nuevo);
            nuevo.setAnterior(ultimo);
            ultimo = nuevo; 
        }
        
    }
    
    public void ver(){
    nodoLista actual = primero;
    while(actual!=null){
        System.out.println(actual.getId());
       
        actual = actual.getSiguiente();
    
    }
    
    
    }
}
