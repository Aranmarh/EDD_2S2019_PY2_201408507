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
import javax.swing.JOptionPane;
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
     
     public String Graficar(NodoAVL r){
         if(r!=null){
         
         g+=r.archivo+"[label=\" Carnet: "+r.archivo+"\\n Contenido: "+r.contenido+" \\n Altura:"+r.fe+" \\n FE: "+r.altura+"\"]\n";
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
         String rul=  "ArbolAVL.txt";
         g+="digraph G{\n";
         g+="node [shape= box];\n rankdir=TB\n";
         Graficar(raiz);
         //g+="}";
         
        try {
            graph =new BufferedWriter(new FileWriter(rul));
            graph.write(g);
            graph.write("}");
            graph.close();

         } catch (Exception e) {
         }
     }
     
      private void dot(){
       String pro= "dot  -Tpng ArbolAVL.txt -o ArbolAVL.png";
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
        g = "";
       // open();
    
    }
    
    public void Delete(String archivo){
         delete(raiz);
         l.mostrar();
         System.out.println("------------");
         l.eliminar(archivo);
         System.out.println("fin");
         l.mostrar();
        
        
     }

     private void delete(NodoAVL r){
         if (r != null){
             //System.out.println(r.archivo +" altura: "+r.altura+ " fe: "+r.fe);
             l.insertar(r.archivo, r.contenido);
             delete(r.izquierda);
             delete(r.derecha);
         }
     }
    
    public void Modify(String archivo, String nuevo, String contenido){
         modify(raiz);
         
         l.mostrar();
         System.out.println("------------");
         l.Modificar(archivo,nuevo,contenido);
         System.out.println("fin");
         l.mostrar();
        
        
     }

     private void modify(NodoAVL r){
         if (r != null){
             //System.out.println(r.archivo +" altura: "+r.altura+ " fe: "+r.fe);
             l.insertar(r.archivo, r.contenido);
             modify(r.izquierda);
             modify(r.derecha);
         }
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
              insert(coma[0], coma[1]);
             // System.out.println("");
              
          }
          
          getAVL();
          }

    public int getFe(NodoAVL r){
        if(r==null){
        
        return -1;
        }else{
            return r.getFe();
        }
    }
    
    public NodoAVL RI(NodoAVL  r){
        NodoAVL n = r.getIzquierda();
        r.setIzquierda(n.getDerecha());
        n.setDerecha(r);
        r.setFe(Math.max(getFe(r.getIzquierda()), getFe(r.getDerecha()))+1);
        n.setFe(Math.max(getFe(n.getIzquierda()), getFe(n.getDerecha()))+1);
        return n;

    }
    
    public NodoAVL RD(NodoAVL r){
        NodoAVL n = r.getDerecha();
        r.setDerecha(n.getIzquierda());
        n.setIzquierda(r);
        r.setFe(Math.max(getFe(r.getIzquierda()), getFe(r.getDerecha()))+1);
        n.setFe(Math.max(getFe(n.getIzquierda()), getFe(n.getDerecha()))+1);
        return n;
    
    }
    
    
    public NodoAVL RII(NodoAVL r){
        NodoAVL n;
        r.setIzquierda(RD(r.getIzquierda()));
        n=RI(r);
        return n;
        
    }
    public NodoAVL RDD(NodoAVL r){
        NodoAVL n;
        r.setDerecha(RI(r.getDerecha()));
        n = RD(r);
        return n;
    }
    
    public NodoAVL insert(NodoAVL nuevo, NodoAVL r){
        NodoAVL n = r;
        if(nuevo.getArchivo().compareToIgnoreCase(r.getArchivo())<0){
            if(r.getIzquierda()==null){
                r.setIzquierda(nuevo);
            }else{
                r.setIzquierda(insert(nuevo, r.getIzquierda()));
                if(getFe(r.getIzquierda())-getFe(r.getDerecha())==2){
                    if(nuevo.getArchivo().compareToIgnoreCase(r.getIzquierda().getArchivo())<0){
                        n=RI(r);
                    }else{
                        n = RII(r);
                    }
                
                }
            }
        
        }else if(nuevo.getArchivo().compareToIgnoreCase(r.getArchivo())>0){
            if(r.getDerecha()==null){
                r.setDerecha(nuevo);
            }else{
                n.setDerecha(insert(nuevo, r.getDerecha()));
                if(getFe(r.getDerecha())-getFe(r.getIzquierda())==2){
                    if(nuevo.getArchivo().compareToIgnoreCase(r.getDerecha().getArchivo())>0){
                        n=RD(r);
                    }else{
                        n = RDD(r);
                    }
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "dato duplicado");
        
        }
        
        if(r.getIzquierda()==null && r.getDerecha()!=null){
            r.setFe(r.getDerecha().getFe()+1);
            
            
        }else if(r.getIzquierda()!=null && r.getDerecha()==null){
            r.setFe(r.getIzquierda().getFe()+1);
            
        }else{
            r.setFe(Math.max(getFe(r.getIzquierda()), getFe(r.getDerecha()))+1);
            
        
        }
            r.setAltura(getFe(r.getDerecha())-getFe(r.getIzquierda()));
            
    return n;
    }
    
    public void insert(String  archivo, String contenido){
    
        NodoAVL nuevo = new NodoAVL(archivo, contenido);
        if(raiz==null){
            raiz  = nuevo;
        }else{
            raiz = insert(nuevo, raiz);
        }
        getAVL();
    }
    
    
      }

