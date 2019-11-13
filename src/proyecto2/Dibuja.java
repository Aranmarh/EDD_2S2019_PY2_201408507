/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2;

import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author Aran
 */
public class Dibuja {
    ImageIcon dibujo =new ImageIcon(new ImageIcon(getClass().getResource("/proyecto2/ArbolAVL.jpg")).getImage());
    
    public void CargarImagen(Graphics g){
        g.drawImage(dibujo.getImage(), 50, 50, 200,200,null);
    }
}
