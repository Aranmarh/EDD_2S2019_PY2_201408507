/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 *
 * @author Aran
 */
public class lista {
    nodoLista primero;
    nodoLista ultimo;
    BufferedWriter graph;
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
        if (actual.getU()!=null) {
            System.out.println("ID  "+actual.getU().getName()+" Cotraseña"+actual.getU().getContraseña());
        }else{
            System.out.println("DISPONIBLE");
        
        }
       
        actual = actual.getSiguiente();
    
    }
    
    
    }
    
    public void buscar(int id, String im, String contraseña){
    nodoLista actual = primero;
    usuario u = new usuario(im, contraseña);
    while(actual!=null){
        if (id==actual.getId()) {
            break;
        }else{
    
        actual = actual.getSiguiente();
        }
    }
        if (actual!=null) {
            if(id==actual.getId()){
        
                    System.out.println(id);
                    insertarU(actual, u);
                
                
            }else{System.out.println("no encontrado");}
        }else{
            System.out.println("fin de la cadena");
        }
    
    }
    
    
    public String insertarU(nodoLista actual, usuario u){
        if(actual!=null){
            if(actual.getU()==null){
                actual.setU(u);
                System.out.println(actual.getId()+"--------");
                System.out.println("se agrego ID "+u.getName()+" Contraseña "+u.getContraseña());
                return "se agrego";
            }else{
                System.out.println(actual.getSiguiente().getId());
                return insertarU(actual.getSiguiente(),u);
            }
        }
        
        
        return "no se agrego";
    }
    
    
    public boolean validar(String codigo){
     nodoLista actual = primero;
        while (actual!=null) {     
            usuario u = actual.getU();
            if(u!=null){
                if(u.getName()==codigo){
                break;
                }
            }
            actual = actual.getSiguiente();
        }
        if(actual!=null){
            usuario u = actual.getU();
            if(u!=null && u.getName().equals(codigo)){
                return false;
            }else{
                return true;
            }
        }else{
            return true;
        }
        
    }
    
    
    public boolean login(String nombre, String contraseña){
        hash h = new hash();
        String pass = h.getPassword(contraseña);
         nodoLista actual = primero;
        while (actual!=null) {     
            usuario u = actual.getU();
            if(u!=null){
                if(u.getName().equals(nombre) && u.getContraseña().equals(pass)){
                break;
                }
            }
            actual = actual.getSiguiente();
        }
        if(actual!=null){
            usuario u = actual.getU();
            if(u.getName().equals(nombre) && u.getContraseña().equals(pass)){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
        
    
    }
    
    
    
    public void graphviz(){
        String t="digraph D { \n  node [shape=plaintext]";
        String rul=  "TablaHASH.txt";

        nodoLista actual=primero;
        t+="\n   nodo [";
        t+="\n  label=< \n <table border=\"0px\">";
            while(actual!=null){
                t+="\n<tr><td bgcolor=\"lightblue\">"+actual.getId()+"</td>";
                if(actual.getU()!=null){
                t+="<td bgcolor=\"gray\">ID: "+actual.getU().getName()+" Contraseña: "+actual.getU().getContraseña()+"</td>";
                }
                t+="</tr>";
                
                actual = actual.getSiguiente();
            }
             t+="\n </table>";
                t+="\n >";
                t+="\n ];";   
            
                        try {
                graph =new BufferedWriter(new FileWriter(rul));
                graph.write(t);
                graph.write("}");
                graph.close();
                
                } catch (Exception e) {
                }
            }
        
      
    public void dot(){
       String pro= "dot  -Tpng TablaHASH.txt -o TablaHASH.png";
           try {
               ProcessBuilder p= new ProcessBuilder();
       p.command("cmd.exe","/c",pro);
       p.start();
           } catch (Exception e) {
           }

}
    public void open(){
        String pro= "TablaHASH.png";
            try {
                ProcessBuilder p= new ProcessBuilder();
        p.command("cmd.exe","/c",pro);
        p.start();
            } catch (Exception e) {
            }

}
    public usuario getU(String nombre){
        nodoLista actual = primero;
        while (actual!=null) {     
            usuario u = actual.getU();
            if(u!=null){
                if(u.getName().equals(nombre)){
                break;
                }
            }
            actual = actual.getSiguiente();
        }if(actual!=null){
            usuario u = actual.getU();
            if(u.getName().equals(nombre)){
                return u;
            }
    }
    return null;
}
    
    
    
}
