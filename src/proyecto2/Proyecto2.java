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
   // tablaHash t =  new tablaHash(7);
   MatrizD m = new MatrizD();
   m.recorrerPadre();
   m.recorrerHijo();
   m.BuscarEspacio(1);
   
        System.out.println("insertar.....");
        m.ingresarCarpeta(1,"Descarga ");
        System.out.println("-------2-------");
         m.ingresarCarpeta(1,"Mis documentos");
         
         System.out.println("recorrer");
         m.BuscarEspacio(1);
         
         m.ingresarCarpeta(2, "packs");
         m.ingresarCarpeta(2, "LOL");
         m.ingresarCarpeta(2, "Netbeans projects");
         m.ingresarCarpeta(2, "Pycharm");
         m.BuscarEspacio(2);
         m.recorrerPadre();
//        System.out.println("padre");
//   m.recorrerPadre();
//        System.out.println("hijo");
//   m.recorrerHijo();
   
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //////Arbol avl/////
    //  ArbolAVL av = new ArbolAVL();
//    av.insertar("hola", "x");
//    av.insertar("mi", "x");
//    av.insertar("nombre", "x");
//    av.insertar("es", "x");
//    av.insertar("chara", "x");
//    av.insertar("de ", "x");
//    av.insertar("undertale", "x");
//  //  av.preorder();
//        System.out.println("inicio------");
//    av.Modify("hola","Adios");
        //System.out.println("-----------------------");
   // av.preorder();
   
    
   // av.inorder();
   // av.getAVL();
    
    
    
    
    
    
    
    ////////////tablaHash//////////////
    // t.Cargamasiva();
    
    /*
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
    
    */
    
}
