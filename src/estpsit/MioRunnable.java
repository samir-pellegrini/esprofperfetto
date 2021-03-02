/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estpsit;

/**
 *
 * @author informatica
 */
public class MioRunnable implements Runnable  {
    
    public int i=0;
    public void run()
    {
        while(Estpsit.c==0)
        {
            
        }
        while(Estpsit.c==1)
        {
            i++;
            System.out.println("la conta è" + i);
        }
    }
}
