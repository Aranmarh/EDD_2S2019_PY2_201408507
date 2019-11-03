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
public class tablaHash {
    int tamaño, disponibilidad;
    lista lista;

    public tablaHash(int tamaño) {
        this.tamaño = tamaño;
        this.disponibilidad = tamaño;
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
    this.lista.ver();
    
    
    }
    
    public void insertar(){
    
    
    };
    
    public void crecer(int x, int y){
        int tot = (int) (x*0.75);
        System.out.println(tot+"  "+x);
        
        if(tot>y){
            System.out.println("esta ok");
        }else{
            x= x+2;
            if(x%2!=0){
                System.out.println("es impar "+x);
            }else{  
                System.out.println("es par "+x);
            }
        }
        
    
    
    }
    
    
    
}
