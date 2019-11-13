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
public class usuario {
    String name; 
    String contraseña;
    MatrizD md;

    public usuario(String name, String contraseña) {
        this.name = name;
        this.contraseña = contraseña;
        this.md = new MatrizD();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public MatrizD getMd() {
        return md;
    }

    public void setMd(MatrizD md) {
        this.md = md;
    }
    
    
    
}
