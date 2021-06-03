package haha;
import java.awt.*;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author samir pellegrini
 */
public class Campo extends JPanel{
    public void paint(Graphics g)//ogni pilota avrà questo settaggio
    {
        g.setColor(Color.green);//settiamo il nero
        g.fillRect(0, 0, 1000, 645);//diciamo cosa deve essere nero
        //le linne fra le corsie
        g.setColor(Color.white);//colore della linea bianco
        g.fillRect(0, 0, 1000 ,10);//mettiamo la poszione della linea e la sua larghezza e lunghezza
        g.fillRect(0, 100, 1000 ,10);
        g.fillRect(0, 200, 1000 ,10);
        g.fillRect(0, 300, 1000 ,10);
        g.fillRect(0, 400, 1000 ,10);
        g.fillRect(0, 500, 1000 ,10);
        g.fillRect(0, 600, 1000 ,10);
        //traguardo
         g.fillRect(960, 0, 5 ,645);//le tre linee di traguardo,impostando i parametri
         g.fillRect(970, 0, 5 ,645);
         g.fillRect(980, 0, 5 ,645);
    }
}