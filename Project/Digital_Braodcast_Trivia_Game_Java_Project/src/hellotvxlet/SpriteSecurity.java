
package hellotvxlet;

import javax.tv.xlet.*;
import org.dvb.ui.*;
import org.havi.ui.*;
//voor de acties die je wilt uitvoeren
import org.havi.ui.event.*;
import java.awt.event.*;

public class SpriteSecurity { //voorbeeld van de oude manier waarop SpriteCinefiel werkte
    
    public ImageComponent spriteSecurity;
    public String pathImageSecurity="Security sprite.png";
    
    public int startYPos = 498;
    public int startXPos = 329;
    
    public int[] YPosSecu;
    public int[] XPosSecu;
    
    public int widthCine = 53;
    public int heightCine = 66;
    
    public int i = 0;

    public SpriteSecurity(int i)
    {
     //Sprites en hun posities (altijd een nieuwe = easy voor invisible maken en gewoon array afgaan van vss sprites)
     YPosSecu[0]= (startYPos);
     XPosSecu[0]=(startXPos); //t.e.m 1
     YPosSecu[1]=(startYPos-75); //t.e.m 5
     XPosSecu[1]=(startXPos);
     YPosSecu[2]=(startYPos-75); //t.e.m 5
     XPosSecu[2]=(startXPos-55);
     YPosSecu[3]=(startYPos-75); //t.e.m 5
     XPosSecu[3]=(startXPos-110);
     YPosSecu[4]=(startYPos-75); //t.e.m 5
     XPosSecu[4]=(startXPos-175);
     YPosSecu[5]=(startYPos-75); //t.e.m 5     
     XPosSecu[5]=(startXPos-230);
     YPosSecu[6]=(startYPos-145); //t.e.m 13     
     XPosSecu[6]=(startXPos-220);
     YPosSecu[7]=(startYPos-145); //t.e.m 13   
     XPosSecu[7]=(startXPos-165);
     YPosSecu[8]=(startYPos-145); //t.e.m 13     
     XPosSecu[8]=(startXPos-110);
     YPosSecu[9]=(startYPos-145); //t.e.m 13   
     XPosSecu[9]=(startXPos-45);
     YPosSecu[10]=(startYPos-145); //t.e.m 13   
     XPosSecu[10]=(startXPos+10);
     YPosSecu[11]=(startYPos-145); //t.e.m 13   
     XPosSecu[11]=(startXPos+75);
     YPosSecu[12]=(startYPos-145); //t.e.m 13   
     XPosSecu[12]=(startXPos+130);
     YPosSecu[13]=(startYPos-145); //t.e.m 13   
     XPosSecu[13]=(startXPos+195);
     YPosSecu[14]=(startYPos-210); //t.e.m 17   
     XPosSecu[14]=(startXPos+215);
     YPosSecu[15]=(startYPos-210); //t.e.m 17   
     XPosSecu[15]=(startXPos+155);
     YPosSecu[16]=(startYPos-210); //t.e.m 17   
     XPosSecu[16]=(startXPos+95);
     YPosSecu[17]=(startYPos-210); //t.e.m 17   
     XPosSecu[17]=(startXPos+35);
     YPosSecu[18]=(startYPos-250);    
     XPosSecu[18]=(startXPos); //t.e.m 20
     YPosSecu[19]=(startYPos-365);    
     XPosSecu[19]=(startXPos+2); //t.e.m 20
     YPosSecu[19]=(startYPos-400);    
     XPosSecu[19]=(startXPos); //t.e.m 20
     
     spriteSecurity=new ImageComponent(pathImageSecurity,YPosSecu[i],XPosSecu[i],widthCine,heightCine);
     
     System.out.println("DE HUIDIGE POSITIE IS: "+i);
    }
    
    public void changePosition()
    {
     i++;
    }
}
