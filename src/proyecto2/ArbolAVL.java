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
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Aran
 */
public class ArbolAVL {
       NodoAVL raiz;
       String g= "";
       BufferedWriter graph;
       ListaArchivos l;
    //Constructor del arbol
    public ArbolAVL(){
    raiz = null;
    l = new ListaArchivos();
    }
    
    //funcion para revisar que el arbol este vacio
    public boolean Vacio(){
        return raiz == null;
    }
    
    //crear un arbol logico vacio 
    public void CrearVacio(){
        raiz = null;
    }
    //Funcion para insertar datos
    public void insertar(String archivo,String contenido){
    raiz = insertar(archivo, contenido,raiz);
    }
// fincionque devuelve la alturaa de un nodo
    private int altura(NodoAVL t){  
        return t == null ?-1 : t.altura;
    }
    // fincion que devuelve el nodo mas a la izquierda o derecha
    private int max(int Izq,int der){
              return Izq > der ? Izq : der;
    }
    
    // metodo para insertar
    private NodoAVL insertar(String a,String c,NodoAVL t){
        if (t== null){
            t = new NodoAVL(a,c);
        }else if(a.compareToIgnoreCase(t.archivo)<0){
            t.izquierda = insertar(a,c,t.izquierda);
            if(altura(t.izquierda) - altura(t.derecha)==2)
                if(a.compareToIgnoreCase(t.izquierda.archivo)<0){
                    t = rotarConHijoIzquierdo(t);
                }else{
                    t = dobleRotacionConHijoIzquierdo(t);
                }
        }else if(a.compareToIgnoreCase(t.archivo) >0){
            t.derecha = insertar(a,c, t.derecha);
            
            if(altura(t.derecha) - altura(t.izquierda) == 2)
                if(a.compareToIgnoreCase(t.derecha.archivo)>0){
                    t= rotarConHijoDerecho(t);
                }else{
                    t=dobleRotacionConHijoDerecho(t);
                }
            
        }
        else{
            System.out.println("Nombre duplicada");
        }
        
        t.fe=altura(t.derecha) - altura(t.izquierda);
        
        t.altura = max(altura(t.izquierda), altura(t.derecha))+1;
        return t;
    }
    
    // rotar el arbol cpn el nodo izquierdo y sus hijos
   private NodoAVL rotarConHijoIzquierdo(NodoAVL k2){
   NodoAVL k1 =k2.izquierda;
   k2.izquierda = k1.derecha;
   k1.derecha = k2;
   k2.altura = max(altura(k2.izquierda), altura(k2.derecha))+1;
   k1.altura = max(altura(k1.izquierda),k2.altura)+1;
   return k1;
   } 
   
   //rotar con el arbol con el nodo derecho y su hijo
   private NodoAVL rotarConHijoDerecho(NodoAVL k1){
       NodoAVL k2 = k1.derecha;
       k1.derecha = k2.izquierda;
       k2.izquierda = k1;
       k1.altura = max(altura(k1.izquierda), altura(k1.derecha))+1;
       k2.altura = max(altura(k2.derecha),k1.altura)+1;
       return k2;
   }
   
   //doble rotacion con del arbol por la derecha
   
   private NodoAVL dobleRotacionConHijoIzquierdo(NodoAVL k3){
   k3.izquierda = rotarConHijoDerecho(k3.izquierda);
   return rotarConHijoIzquierdo(k3);
   }
   
   //doble rotacion con nodos del arbol por la izquierda
   
   private NodoAVL dobleRotacionConHijoDerecho(NodoAVL k1){
       k1.derecha = rotarConHijoDerecho(k1.derecha);
       return rotarConHijoDerecho(k1);
   }
   
   
   //funcion para contar nodos
   public int contarNodos(){
       return contarNodos(raiz);
   }
   
   private int contarNodos(NodoAVL r){
       if(r==null){
           return 0;
       }else{
       int i = 1;
       i += contarNodos(r.izquierda);
       i += contarNodos(r.derecha);
       return i;
       }
   }
   //funcion para buscar un dato dentro del arbol
   public boolean buscar(String id){
   return buscar(raiz,id);
   }
   
   private boolean buscar(NodoAVL r, String id){
       boolean encontrado = false;
       while((r != null) && !encontrado){
       String rId = r.archivo;
       if(id.compareToIgnoreCase(rId)<0)
           r = r.izquierda;
       else if ( id.compareToIgnoreCase(rId)>0)
           r = r.derecha;
       else{
       encontrado = true;
       break;
       }
          encontrado = buscar(r,id); 
       }
       return encontrado;
   }
   
   //metodo para imprimir datos inorder  
   
   public void inorder(){
         inorder(raiz);
     }

     private void inorder(NodoAVL r){
         if (r != null){
             inorder(r.izquierda);
             System.out.println(r.archivo +" altura: "+r.altura+ " fe: "+r.fe);
             inorder(r.derecha);
         }
     }
    
   //metodo para imprimir datos preorder
     
       public void preorder(){
         preorder(raiz);
     }

     private void preorder(NodoAVL r){
         if (r != null){
             System.out.println(r.archivo +" altura: "+r.altura+ " fe: "+r.fe);
             preorder(r.izquierda);             
             preorder(r.derecha);
         }
     }  
     
     //metodo para imprimir posorder
     
      public void postorder(){
         postorder(raiz);
     }

     private void postorder(NodoAVL r){
         if (r != null)
         {
             postorder(r.izquierda);             
             postorder(r.derecha);
             System.out.print(r.archivo);
             
         }
     }  
     
     public String Graficar(NodoAVL r){
         if(r!=null){
         
         g+=r.archivo+"[label=\" Carnet: "+r.archivo+"\\n Contenido: "+r.contenido+" \\n Altura:"+r.altura+" \\n FE: "+r.fe+"\"]\n";
         if(r.izquierda!=null){
             g+=r.archivo+"->"+r.izquierda.archivo+"\n";
         }
         if(r.derecha!=null){
             g+=r.archivo+"->"+r.derecha.archivo+"\n";
         }
         
         Graficar(r.izquierda);
         
         Graficar(r.derecha);
         }
     return g;
     }
     
     private void G(){
         String rul=  ".\\src\\proyecto2\\ArbolAVL.txt";
         g+="digraph G{\n";
         g+="node [shape= box];\n rankdir=TB\n";
         Graficar(raiz);
         g+="}";
         
        try {
            graph =new BufferedWriter(new FileWriter(rul));
            graph.write(g);
            graph.write("}");
            graph.close();

         } catch (Exception e) {
         }
     }
     
      private void dot(){
       String pro= "dot  -Tpng .\\src\\proyecto2\\ArbolAVL.txt -o .\\src\\proyecto2\\ArbolAVL.png";
           try {
               ProcessBuilder p= new ProcessBuilder();
       p.command("cmd.exe","/c",pro);
       p.start();
           } catch (Exception e) {
           }

}
    private void open(){
        String pro= "ArbolAVL.png";
            try {
                ProcessBuilder p= new ProcessBuilder();
        p.command("cmd.exe","/c",pro);
        p.start();
            } catch (Exception e) {
            }

}
    
    public void getAVL(){
        G();
        dot();
        open();
    
    }
    
    public void Delete(String archivo){
         delete(raiz);
         l.mostrar();
         System.out.println("------------");
         l.eliminar(archivo);
         System.out.println("fin");
         l.mostrar();
        llenar();
        
     }

     private void delete(NodoAVL r){
         if (r != null){
             //System.out.println(r.archivo +" altura: "+r.altura+ " fe: "+r.fe);
             l.insertar(r.archivo, r.contenido);
             delete(r.izquierda);
             delete(r.derecha);
         }
     }
    
    public void Modify(String archivo, String nuevo){
         modify(raiz);
         
         l.mostrar();
         System.out.println("------------");
         l.Modificar(archivo,nuevo);
         System.out.println("fin");
         l.mostrar();
        llenar();
        
     }

     private void modify(NodoAVL r){
         if (r != null){
             //System.out.println(r.archivo +" altura: "+r.altura+ " fe: "+r.fe);
             l.insertar(r.archivo, r.contenido);
             modify(r.izquierda);
             modify(r.derecha);
         }
     }
     
     private void llenar(){
         raiz = null;
         NodoAVL actual = l.primero;
         while (actual!=null) {             
             insertar(actual.archivo, actual.contenido);
             actual = actual.derecha;
         }
         System.out.println("LLENADO");
         l.primero=null;
         inorder();
     }
     
      public String abrir(){
        String url;
        String doc="";
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
              coma=Salto[i].split(",");
              System.out.println(coma[0]+"   "+coma[1]);
              insertar(coma[0], coma[1]);
              System.out.println("");
              
          }
          }
      
          //getAVL();
      }

