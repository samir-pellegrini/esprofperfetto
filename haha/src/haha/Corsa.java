/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haha;

import java.awt.*;
import java.io.IOException;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author samir pellegrini
 */
public class Corsa extends JFrame {
    int pos;//posizione
    Corridore [] partecipanti;
    CorridoriInGara  [] thread_partecipanti;
    Campo pista;//pista
    Graphics offscreen;//gestione del doppio buffering
    Image buffer;

    public Corsa() throws IOException {
        super("gara ciclistica");
        this.setBounds(10, 40,1000,700);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        pista=new Campo();
        partecipanti=new Corridore[6];
        thread_partecipanti=new CorridoriInGara[6];
        pos=1;
        
        //aggiungo le immagini e le collego al thread
        int partenza=15;//posizione corsia
        for(int i=0;i<6;i++)
        {
            partecipanti[i] = new Corridore(partenza,i+1);
            thread_partecipanti[i]=new CorridoriInGara(partecipanti[i],this);
            partenza=partenza+100;
        }
        this.add(pista);
        this.setVisible(true);
    }
    
    
  public synchronized int getpos() {//da la posizione al concorrente appena arrivato
      return pos++;
    }

    public synchronized void controlloArrivi() {//controlla se sono arrivati tutti
        boolean arrivati=true;
        for(int i=0; i<6; i++)
        {
           if( thread_partecipanti[i].pos == 6)
           {
               arrivati=false;
           }
        }
        if(arrivati==false)
        {
            visualizzaclassfica();
        }
    }
    
    public void visualizzaclassfica()
    {
        JLabel[] arrivi;
        arrivi=new JLabel[6];
        JFrame classifica=new JFrame("classifica");
        classifica.setBounds(350, 350, 500, 500);
        classifica.setDefaultCloseOperation(EXIT_ON_CLOSE);
        classifica.getContentPane().setLayout(new GridLayout(6,1));
        //visualizza 
        for(int i=1;i<7;i++)
        {
            for(int z=0;z<6;z++)
            {
                if(thread_partecipanti[z].pos == i)
                {
                   
                    arrivi[z]=new JLabel(i + "classificato in " +(z+1) +" corsie");
                    classifica.getContentPane().add(arrivi[z]);
                }
            }
        }
        classifica.setVisible(true);
    }      
    public void update(Graphics g)
    {
        paint(g);
    }
      public void paint (Graphics g)
    {
        if (partecipanti!= null)
        {
            Graphics2D screen=(Graphics2D)g;
            buffer=createImage(1000,645);
            offscreen=buffer.getGraphics();
            Dimension d=getSize();
            pista.paint(offscreen);
            for (int xx=0;xx<6;xx++)
            {
                partecipanti[xx].paint(offscreen);
            }
            screen.drawImage(buffer,0,20,this);
            offscreen.dispose();
        }
    }
}
