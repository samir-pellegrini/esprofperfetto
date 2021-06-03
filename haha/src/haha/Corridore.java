package haha;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
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
public class Corridore extends JPanel{
  public int cordx;//coordinata x
  public int cordy;//coordinata y
  Image img; //varibile dell'immagine
    
  public Corridore(int cordy,int x) throws IOException
  {
      cordx=0;
      this.cordy=cordy;
      setSize(80,81);
      Toolkit tk=Toolkit.getDefaultToolkit();//serve per leggere i file,in questo caso l'immagine
      switch(x){//get dei 6 corridori
          case 1:{img = ImageIO.read(new URL("https://image.flaticon.com/icons/png/512/35/35983.png"));break;}
          case 2:{img = ImageIO.read(new URL("https://image.flaticon.com/icons/png/512/35/35983.png"));break;}
          case 3:{img = ImageIO.read(new URL("https://image.flaticon.com/icons/png/512/35/35983.png"));break;}
          case 4:{img = ImageIO.read(new URL("https://image.flaticon.com/icons/png/512/35/35983.png"));break;}
          case 5:{img = ImageIO.read(new URL("https://image.flaticon.com/icons/png/512/35/35983.png"));break;}
          case 6:{img = ImageIO.read(new URL("https://image.flaticon.com/icons/png/512/35/35983.png"));break;}
      }
      MediaTracker m=new MediaTracker(this);//gestione di un numero arbitrario
      m.addImage(img,1);//aggiunta dell'immagine in maniera parallela
      try {   m.waitForID(1);//aspetta l'id 1 prima di poter proseguire
      } catch (InterruptedException ex) {
          Logger.getLogger(Corridore.class.getName()).log(Level.SEVERE, null, ex);
      }
  }
  public void setCordx(int cordx)
  {
      this.cordx=cordx;
  }
  public  int getCordx()
  {
      return cordx;
  }
  public void paint(Graphics g)
  {
      g.drawImage(img,cordx,cordy,70,70,null);//aggiunta alla grafica lì'immagine del corridore 
  }
}
