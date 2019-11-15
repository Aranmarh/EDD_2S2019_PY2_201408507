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
public class MatrizD {
    
    nodoM inicio, UltimoP, UltimoH;
    int idy =1;
    int idx=1;
   
   
    

    public MatrizD() {
        this.inicio = new nodoM(0,0, "");
        this.UltimoP = null;
        this.UltimoH = null;
        inicio();
    }
    
    public void insertarPadre(String s){
        nodoM nuevo =  new nodoM(0,idy, s);
        idy++;
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
        nodoM nuevo =  new nodoM(idx,0, s);
        idx++;
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
            System.out.println(actual.getIdx()+" "+ actual.getDirectorio());
            actual = actual.getDerecha();
        }
    
    }
    
    public void recorrerPadre(){
        nodoM actual = inicio.getAbajo();
        while(actual !=null){
            System.out.println(actual.getIdx()+","+actual.getIdy()+" "+ actual.getDirectorio());
            actual = actual.getAbajo();
        }
    
    }
    
    public nodoM buscarP(int x){
        nodoM actual= inicio.getAbajo();
        while(actual!=null){
        if (actual.getIdy()==x) {
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
        nodoM nuevo = new nodoM(UltimoH.getIdx(),x, padre.getDirectorio()+"/"+UltimoH.getDirectorio());
        actual.setDerecha(nuevo);
        nuevo.setIzquierda(actual);
        UltimoH.setAbajo(nuevo);
        nuevo.setArriba(UltimoH);
        
            
    
    }
    
    public void ingresarCarpeta(int CarpetaPadre, String hijo){
        insertarHijo(hijo);
        insertarDir(CarpetaPadre);
        insertarPadre(hijo);
        
        grafica();
        GraficaG();
    
    }
    
    public void inicio(){
        insertarPadre("/");
        insertarHijo("/");
         nodoM actual = buscarP(1);
         nodoM nuevoM= new nodoM(UltimoH.getIdx(),1,actual.getDirectorio());
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
       System.out.println(actual.getIdx()+","+actual.getIdy()+"  "+actual.getDirectorio());
       }
    
    }
    
    public nodoM BuscarEspacio(int x){
        nodoM  a = buscarP(x);
        while(a.getDerecha()!=null){
            System.out.print(a.getIdx()+","+a.getIdy()+" dir: "+a.getDirectorio()+"->");
            a= a.getDerecha();
        
        }
        System.out.println(a.getDirectorio());
    
    return a;
    }

 
    
    public String recorrer(){
        String Matrix="digraph G{\nnode [shape= record] \n";
        nodoM x =inicio;
        nodoM y = inicio;
        System.out.println("GRAFICAR!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        while(y!=null){
            while (x!=null) {
                Matrix+=x.getIdx()+""+x.getIdy()+"[label=\""+x.getDirectorio()+" \" pos=\""+x.getIdx()*3+","+x.getIdy()*-1+"!\"];\n";
                if(x.getArriba()!=null){
                   Matrix+= x.getIdx()+""+x.getIdy()+"->"+x.getArriba().getIdx()+x.getArriba().getIdy()+"\n";
                }
                if(x.getDerecha()!=null){
                    Matrix+= x.getIdx()+""+x.getIdy()+"->"+x.getDerecha().getIdx()+x.getDerecha().getIdy()+"\n";
                }
                 System.out.print(x.getIdx()+","+x.getIdy()+" dir: "+x.getDirectorio()+"   ");
                x = x.getDerecha();
            }
            System.out.println("");
            y = y.getAbajo();
            x=y;
        }
        Matrix+="}";
    
    return Matrix;
    }
    
    
    public void graphviz(){
        BufferedWriter graph;
        String rul=  "Matriz.dot";

            try {
                graph =new BufferedWriter(new FileWriter(rul));
                graph.write(recorrer());
                graph.flush();
                graph.close();
                
                } catch (Exception e) {
                }
            }
    
        public void graphvizG(){
        BufferedWriter graph;
        String rul=  "Grafo.txt";

            try {
                graph =new BufferedWriter(new FileWriter(rul));
                graph.write(Grafo());
                graph.flush();
                graph.close();
                
                } catch (Exception e) {
                }
            }
        
      
    public void dot(){
       String pro= "neato -Tpng -o matriz.png matriz.dot";
           try {
               ProcessBuilder p= new ProcessBuilder();
       p.command("cmd.exe","/c",pro);
       p.start();
           } catch (Exception e) {
           }

}
      public void deleteM(){
       String pro= "DEL matriz.dot";
           try {
               ProcessBuilder p= new ProcessBuilder();
       p.command("cmd.exe","/c",pro);
       p.start();
           } catch (Exception e) {
           }

}
    public void dotG(){
       String pro= "dot -Tpng Grafo.txt -o Grafo.png";
           try {
               ProcessBuilder p= new ProcessBuilder();
       p.command("cmd.exe","/c",pro);
       p.start();
           } catch (Exception e) {
           }

}
    public void delG(){
       String pro= "DEL Grafo.png";
           try {
               ProcessBuilder p= new ProcessBuilder();
       p.command("cmd.exe","/c",pro);
       p.start();
           } catch (Exception e) {
           }

}
 
    public void grafica(){
       // deleteM();
        graphviz();
        dot();
        
        
       // open();
    
    }
    
    public void GraficaG(){
       // delG();
        graphvizG();
        dotG();
        
    
    }
    
    public String Grafo(){
        String G = "digraph G{\nnode [shape= circle] \n";
        nodoM x =inicio.getAbajo();
        nodoM y = inicio.getAbajo();
        System.out.println("GRAFICAR!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        while(y!=null){
            G+=y.getIdy()+"[label=\""+y.getDirectorio()+"\"];\n";
            while (x!=null) {
                
               
                if(x.getDerecha()!=null){
                    G+= x.getIdy()+"->"+x.getDerecha().getIdx()+"\n";
                }
                
                x = x.getDerecha();
            }
            
            y = y.getAbajo();
            x=y;
        }
        G+="}";
    
    return G;
    
    
    }
    
    public void modificar(int x, int m, String s){
         nodoM  a = buscarP(x);
         nodoM p = a;
         while(a!=null){
             if(m==a.getIdx()){
                 System.out.println("se encontro");
                 break;
             }
         
         a= a.getDerecha();
         }
         if(a!=null){
             a.getArriba().setDirectorio(s);
             a.setDirectorio(p.getDirectorio()+"/"+s);
             buscarP(m).setDirectorio(s);
         }
    
    
    }
    
    public void eliminarP(int x){
        nodoM actual = inicio;
        nodoM anterior= inicio;

        if(x!=1){
            while(actual!=null){
                if(actual.getIdy()==x){
                    break;
                }
                anterior = actual;
                actual = actual.getAbajo();
            }

            if(actual!=null){
               anterior.setAbajo(actual.getAbajo());
               if(actual.getAbajo()!=null){
               actual.getAbajo().setArriba(anterior);
               }

            }
        
        
        }
    }
    
    public void eliminarH(int x){
        nodoM actual = inicio;
        nodoM anterior= inicio;
          if(x!=1){
            while(actual!=null){
                if(actual.getIdx()==x){
                    break;
                }
                anterior = actual;
                actual = actual.getAbajo();
            }

            if(actual!=null){
               anterior.setDerecha(actual.getAbajo());
               if(actual.getDerecha()!=null){
               actual.getDerecha().setIzquierda(anterior);
               }

            }
        
        
        }
    }
    
    public void Eliminar(int x){
        eliminarH(x);
        eliminarP(x);
    
    
    }
    
    
        public void MostrarM(){
        nodoM x =inicio;
        nodoM y = inicio;
       
        while(y!=null){
            while (x!=null) {
                System.out.print(x.getDirectorio()+"     ->    ");
               x= x.getDerecha();
            }
            System.out.println("");
            y = y.getAbajo();
            x=y;
        }
        
    
  
    }
}




