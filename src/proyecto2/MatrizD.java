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
public class MatrizD {
    
    nodoM inicio, UltimoP, UltimoH;
    int id =1;
    

    public MatrizD() {
        this.inicio = new nodoM(0, "");
        this.UltimoP = null;
        this.UltimoH = null;
        inicio();
    }
    
    public void insertarPadre(String s){
        nodoM nuevo =  new nodoM(id, s);
        id++;
        if(inicio.getAbajo()==null){
            inicio.setAbajo(nuevo);
            nuevo.setArriba(inicio);
            UltimoP=inicio.getAbajo();
        
        }else{
            UltimoP.setAbajo(nuevo);
            nuevo.setArriba(UltimoP);
            UltimoP = nuevo;
        
        }
    
    
    }   
    
        public void insertarHijo(String s){
        nodoM nuevo =  new nodoM(0, s);
        if(inicio.getDerecha()==null){
            inicio.setDerecha(nuevo);
            nuevo.setIzquierda(inicio);
            UltimoH=inicio.getDerecha();
        
        }else{
            UltimoH.setDerecha(nuevo);
            nuevo.setIzquierda(UltimoP);
            UltimoH = nuevo;
        
        }
    
    
    }  
         public void recorrerHijo(){
        nodoM actual = inicio.getDerecha();
        while(actual !=null){
            System.out.println(actual.getId()+" "+ actual.getDirectorio());
            actual = actual.getDerecha();
        }
    
    }
    
    public void recorrerPadre(){
        nodoM actual = inicio.getAbajo();
        while(actual !=null){
            System.out.println(actual.getId()+" "+ actual.getDirectorio());
            actual = actual.getAbajo();
        }
    
    }
    
    public nodoM buscarP(int x){
        nodoM actual= inicio.getAbajo();
        while(actual!=null){
        if (actual.getId()==x) {
                //System.out.println("se encontro el nodo----"+actual.getX());
                return actual;
            }
            actual=actual.getAbajo();
        }
       if(actual !=null){
           return actual;
       }
    return null;
    }
    
    public void insertarDir(int x){
        nodoM padre = buscarP(x);
        nodoM actual = BuscarEspacio(x);
        nodoM nuevo = new nodoM(0, padre.getDirectorio()+"/"+UltimoH.getDirectorio());
        actual.setDerecha(nuevo);
        nuevo.setIzquierda(actual);
        UltimoH.setAbajo(nuevo);
        nuevo.setArriba(UltimoH);
        
            
    
    }
    
    public void ingresarCarpeta(int CarpetaPadre, String hijo){
        insertarHijo(hijo);
        insertarDir(CarpetaPadre);
        insertarPadre(hijo);
    
    }
    
    public void inicio(){
        insertarPadre("/");
        insertarHijo("/");
         nodoM actual = buscarP(1);
         nodoM nuevoM= new nodoM(0,actual.getDirectorio());
         actual.setDerecha(nuevoM);
         nuevoM.setIzquierda(actual);
         UltimoH.setAbajo(nuevoM);
         nuevoM.setArriba(UltimoH);
        //System.out.println(actual.getDirectorio());
       // System.out.println(UltimoH.getAbajo().getDirectorio());

    }
    
    public void recorrerDirectorios(int padre){
       nodoM actual= buscarP(padre);
       if(actual==null){
           System.out.println(" es nulo");
       }else{
       System.out.println(actual.getDirectorio());
       }
    
    }
    
    public nodoM BuscarEspacio(int x){
        nodoM  a = buscarP(x);
        while(a.getDerecha()!=null){
            System.out.print(a.getDirectorio()+"->");
            a= a.getDerecha();
        
        }
        System.out.println(a.getDirectorio());
    
    return a;
    }

    public void graficar(){
        nodoM primero = inicio;
        
    
    }

}




