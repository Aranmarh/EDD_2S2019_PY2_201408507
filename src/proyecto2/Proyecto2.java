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
public class Proyecto2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    tablaHash t =  new tablaHash(7);
        //t.insertar(1, "1234HOLA","mara");
        //t.insertar(1, "1werty","maa");
        //t.insertar(7, "findelos tiempos", "Findelostiempos");
        //t.insertar(8, "findelostiemposXD", "Findelostiempos");
       // t.lista.ver();
        System.out.println("______Inicio__________");
       t.crecer("1234HOLA","mara");
        System.out.println("______2__________");
       t.crecer("1werty","maa");
       System.out.println("______3__________");
       t.crecer("1werty","maa");
       System.out.println("______4__________");
       t.crecer("findtiempos", "Finiempos");
       System.out.println("______5__________");
       t.crecer("findos", "Finies");
       System.out.println("______end__________");
       t.crecer("fiiempos", "Finiempos");
       t.crecer("ndtiempos", "Finies");
        System.out.println(t.validar("fiie"));
        System.out.println("contraseña");
        System.out.println(t.Login("ndtiempos", "Finies"));
        t.Graficar();
  //  hash h = new hash();
       // h.getID("holacomoestas", 7);
       // h.getPassword("MeChupaunhuevo");
      //  System.out.println(h.iniciar(7));
   // t.crecer(11, 8);
    }
    
}
