/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estpsit;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author informatica
 */
public class Estpsit {

    public static int c=0;
    
    public static void main(String[] args) {
        
        Runnable r1= new MioRunnable();
        Runnable r2= new MioRunnable();
        Runnable r3= new MioRunnable();
       Thread t1=new Thread(r1,"contatore 1");
       Thread t2=new Thread(r2,"contatore 2");
       Thread t3=new Thread(r3,"contatore 3");

       t1.setPriority(6);
       t2.setPriority(4);
       t3.setPriority(7);
       t1.start();
       t2.start();
       t3.start();
       c=0;
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Estpsit.class.getName()).log(Level.SEVERE, null, ex);
        }
       c=2;
       
    }
    
}
