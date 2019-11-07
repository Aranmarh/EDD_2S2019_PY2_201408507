/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2;

import java.io.File;
import java.io.FileInputStream;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Aran
 */
public class tablaHash {
    int tamaño, disponibilidad;
    lista lista;
    
    private String url;
    private String doc;

    public tablaHash(int tamaño) {
        this.tamaño = tamaño;
        this.disponibilidad =1;
        this.lista = new lista();
        inicio();
    }
    
    
    public void inicio(){
    int x = 0;
        while (x<=tamaño){
            lista.insertar(x);
           // System.out.println(x);
            x++;
            
        }
   // this.lista.ver();
    
    
    }
    
    public void insertar(int id, String I, String C){
    
        lista.buscar(id,I,C);
    
    };
    
    
    public void insertarEnLaTabla(){
        hash h= new hash();
        int aux = (int) (tamaño*0.75);
        if(disponibilidad<aux){
        
        
        
        }
        
    
    
    }
    
    
    public void crecer(String id, String c){
        hash h = new hash();
        int dir = h.getID(id, tamaño);
        String pass = h.getPassword(c);
        int tot = (int) (tamaño*0.75);
        
        if(tot>disponibilidad){
            if(lista.validar(id)){
                insertar(dir, id, pass);
                disponibilidad ++;
            }else{
                System.out.println("nel");
            }
        }else{
            int p =h.iniciar(tamaño);
            aumentar(p);
            tamaño = tamaño+p;
            
        }
        
        //lista.ver();
    
    }
    
     public void aumentar(int p){
    int x = tamaño+1;
       
        while (x<=tamaño+p){
            lista.insertar(x);
            System.out.println(x);
            x++;
            
        }
    
}
     public boolean validar(String s){
      return lista.validar(s);
     
     }
     
     public boolean Login(String name, String contraseña){
         return lista.login(name, contraseña);
     }
     
     
     public void Graficar(){
     
         lista.graphviz();
         lista.dot();
         lista.open();
     
     
     }
     
     
     public void Carga(){
         
     
     }
     
      public String abrir(){
        JFileChooser abrir = new JFileChooser();
        //cambiar el filtro
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos csv", "csv");
        abrir.setFileFilter(filtro);
        abrir.showOpenDialog(abrir);
        
        try {
             url = abrir.getSelectedFile().getAbsolutePath();
            
            FileInputStream archivo = new FileInputStream(url);
            doc="";
            int ascci;
            while ((ascci= archivo.read())!=-1) {                
                char caracter = (char)ascci;
                doc +=caracter;
            }
        } catch (Exception e) {
            System.out.println("nel no se puede");
        }
        
          
          return doc;
    }
      
      public void Cargamasiva(){
      String c = abrir();
      String Salto[];
      String coma[];
       Salto= c.split("\n");
          for (int i = 1; i < Salto.length; i++) {
             coma= Salto[i].split(",");
              for (int j = 0; j < coma.length; j++) {
                  crecer(coma[0], coma[1]);
              }
             
          }
      
      Graficar();
      }
}
