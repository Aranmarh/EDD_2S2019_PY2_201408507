/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Aran
 */
public class hash {
    
    
    
    private int hashId(String s){
        int d;
        d=0;
        for (int i = 0; i < Math.min(s.length(), 10); i++) {
            d = d*27+(int)s.charAt(i);
        }
        if(d<0) d=-d;
        
        return d;
    }

    public int getID(String s, int x){
        int m = hashId(s);
        int tot = m%x;
        System.out.println(tot);
            return tot;
    }
    
    public String getPassword(String S){
        
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");
    
        md.update(S.getBytes());
        
        byte[] digest = md.digest();
        StringBuffer sb = new StringBuffer();
        for (byte b : digest){
            sb.append(String.format("%02x", b & 0xff));
        }
        
          //  System.out.println(sb.toString());
        return sb.toString();
            } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(hash.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "x";
    }
        
    
    private boolean primo(int numero){
        int aux;
        for (int i = 2; i < numero; i++) {
            aux=numero%i;
            if(aux==0)return false;
        }
    
        return true;
    }
    
    public int iniciar(int limite){
      int aux = limite+1;
      while(primo(aux)==false){
          aux=aux+1;
      }
      return aux-limite;
    
    }
    }
    

