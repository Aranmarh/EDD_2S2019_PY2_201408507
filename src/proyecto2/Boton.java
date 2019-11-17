/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Aran
 */
public class Boton {
    JButton b;
    Action a;
    Archivo arch;
    int x,y;
    String s, Archi, Contenido;

    public Boton(Archivo arch,String s, int x, int y) {
        this.arch = arch;
        this.x = x;
        this.y = y;
        this.s=s;
    }

    public Boton(Archivo arch, String Archi, String Contenido) {
        this.arch = arch;
        this.Archi = Archi;
        this.Contenido = Contenido;
        
    }
    
    
    
    ImageIcon Archivo = new ImageIcon(".\\src\\Iconos\\Archivo.png");
    ImageIcon File = new ImageIcon(".\\src\\Iconos\\File.png");
    
    
    public JButton MakeButtonArch(){
       b = new JButton(s,File);
      // b.setContentAreaFilled(false);
       b.setHorizontalAlignment(b.CENTER);
       b.setHorizontalTextPosition(b.CENTER);
       b.setVerticalAlignment(b.CENTER);
       b.setVerticalTextPosition(b.BOTTOM);
       b.setBackground(Color.decode("#9B81B2"));
       b.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               arch.carpetaA=y;
               arch.carpetaS=x;
               arch.arbol=0;
               System.out.println("Carpeta Actual:"+y+" Carpeta Siguiente"+x);
           }
       });
        
    return b;
    }
    
        public JButton MakeButtonTXT(){
       b = new JButton(Archi,Archivo);
      // b.setContentAreaFilled(false);
       b.setHorizontalAlignment(b.CENTER);
       b.setHorizontalTextPosition(b.CENTER);
       b.setBackground(Color.decode("#8366A6"));
       b.setVerticalAlignment(b.CENTER);
       b.setVerticalTextPosition(b.BOTTOM);
       b.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               arch.Archivo=Archi;
               arch.Contenido=Contenido;
               System.out.println("Nombre A:"+Archi+" Contenido:"+Contenido);
               arch.arbol=1;
           }
       });
        
    return b;
    }
}
