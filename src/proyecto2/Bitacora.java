/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Aran
 */
public class Bitacora {
    nodoLista primero;
    nodoLista ultimo;
    int id =1;
    Date date = new Date();
    DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
    

    public Bitacora() {
        this.primero = null;
        this.ultimo = null;
    }
    
    public String gethora(){
        String s  = hourdateFormat.format(date);
    return s;
    }
    
     public void push(String usu, String accion){
        nodoLista nuevo = new nodoLista(id,usu, accion, gethora());
        id++;
         if (primero==null) {
               primero=nuevo; 
               nuevo.siguiente=null;
               ultimo=primero;
         }else{
             
             
             nuevo.siguiente=primero;
             primero=nuevo;
             
         
         }
     }
    
     
     
         public void graphviz(){
        String t="digraph D { \n  node [shape=plaintext]";
        String rul=  "Bitacora.txt";

        nodoLista actual=primero;
        t+="\n   nodo [";
        t+="\n  label=< \n <table border=\"0px\">\n";
        t+="<tr><td bgcolor=\"#E6E6FA\">  USUARIO   </td><td bgcolor=\"#E6E6FA\">  ACCION  </td><td bgcolor=\"#E6E6FA\">FECHA</td></tr>\n";
            while(actual!=null){
                t+="\n<tr><td bgcolor=\"lightblue\">  "+actual.getUsu()+"  </td><td bgcolor=\"lightblue\">   "+actual.getAccion()+"  </td><td bgcolor=\"lightblue\">   "+actual.getDate()+"   </td></tr>\n";
                
                
                actual = actual.getSiguiente();
            }
             t+="\n </table>";
                t+="\n >";
                t+="\n ];";   
            
                        try {
            BufferedWriter graph = new BufferedWriter(new FileWriter(rul));
                graph.write(t);
                graph.write("}");
                graph.close();
                
                } catch (Exception e) {
                }
            }
        
      
    public void dot(){
       String pro= "dot  -Tpng Bitacora.txt -o Bitacora.png";
           try {
               ProcessBuilder p= new ProcessBuilder();
       p.command("cmd.exe","/c",pro);
       p.start();
           } catch (Exception e) {
           }
     
     }
    
}
