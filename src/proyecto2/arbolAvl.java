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
public class arbolAvl {
    nodoAvl raiz;
    
    public arbolAvl(){
        raiz = null;
    }
    
    public boolean Vacio(){
        return raiz == null;
    }
    
    //crear un arbol logico vacio 
    public void CrearVacio(){
        raiz = null;
    }
    //Funcion para insertar datos
    public void insertar(String a, String c){
    raiz = insertar(a,c,raiz);
    }
// fincionque devuelve la alturaa de un nodo
    private int altura(nodoAvl t){  
        return t == null ?-1 : t.altura;   
    }
    // fincion que devuelve el nodo mas a la izquierda o derecha
    private int max(int Izq,int der){
              return Izq > der ? Izq : der;
    }
    
    // metodo para insertar
    private nodoAvl insertar(String a,String c, nodoAvl t){
        if (t== null){
            t = new nodoAvl(a,c);
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
        
        
        t.altura = max(altura(t.izquierda), altura(t.derecha))+1;
        return t;
    }
    
    // rotar el arbol cpn el nodo izquierdo y sus hijos
   private nodoAvl rotarConHijoIzquierdo(nodoAvl k2){
   nodoAvl k1 =k2.izquierda;
   k2.izquierda = k1.derecha;
   k1.derecha = k2;
   k2.altura = max(altura(k2.izquierda), altura(k2.derecha))+1;
   k1.altura = max(altura(k1.izquierda),k2.altura)+1;
   return k1;
   } 
   
   //rotar con el arbol con el nodo derecho y su hijo
   private nodoAvl rotarConHijoDerecho(nodoAvl k1){
       nodoAvl k2 = k1.derecha;
       k1.derecha = k2.izquierda;
       k2.izquierda = k1;
       k1.altura = max(altura(k1.izquierda), altura(k1.derecha))+1;
       k2.altura = max(altura(k2.derecha),k1.altura)+1;
       return k2;
   }
   
   //doble rotacion con del arbol por la derecha
   
   private nodoAvl dobleRotacionConHijoIzquierdo(nodoAvl k3){
   k3.izquierda = rotarConHijoDerecho(k3.izquierda);
   return rotarConHijoIzquierdo(k3);
   }
   
   //doble rotacion con nodos del arbol por la izquierda
   
   private nodoAvl dobleRotacionConHijoDerecho(nodoAvl k1){
       k1.derecha = rotarConHijoDerecho(k1.derecha);
       return rotarConHijoDerecho(k1);
   }
   
   
   //funcion para contar nodos
   public int contarNodos(){
       return contarNodos(raiz);
   }
   
   private int contarNodos(nodoAvl r){
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
   
   private boolean buscar(nodoAvl r, String id){
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

     private void inorder(nodoAvl r){
         if (r != null){
             inorder(r.izquierda);
             System.out.print(r.archivo +" ");
             inorder(r.derecha);
         }
     }
    
   //metodo para imprimir datos preorder
     
       public void preorder(){
         preorder(raiz);
     }

     private void preorder(nodoAvl r){
         if (r != null){
             System.out.print(r.archivo +" ");
             preorder(r.izquierda);             
             preorder(r.derecha);
         }
     }  
     
     //metodo para imprimir posorder

     
     

    
}
