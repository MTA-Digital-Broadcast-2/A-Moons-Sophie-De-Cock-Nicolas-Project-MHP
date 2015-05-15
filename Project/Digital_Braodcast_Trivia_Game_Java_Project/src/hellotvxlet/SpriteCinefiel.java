
package hellotvxlet;

import javax.tv.xlet.*;
import org.dvb.ui.*;
import org.havi.ui.*;
//voor de acties die je wilt uitvoeren
import org.havi.ui.event.*;
import java.awt.event.*;

public class SpriteCinefiel {
        
    public ImageComponent spriteCinefiel;
    public String pathImageCinefiel="Cinefieltje sprite.png";
    
    public int startYPos = 513;
    public int startXPos = 329;
    
    public int[] YPosCine;
    public int[] XPosCine;
    
    public int widthCine = 53;
    public int heightCine = 50;
    
    public int i=0;

    public SpriteCinefiel()
    {
//     Cinefielsprite posities, Raar genoeg verdwijnen alle images wanneer ik deze data gebruik
//     YPosCine[0]=(startYPos);
//     XPosCine[0]=(startXPos); //t.e.m 1
//     YPosCine[1]=(startYPos-75); //t.e.m 5
//     XPosCine[1]=(startXPos);
//     YPosCine[2]=(startYPos-75); //t.e.m 5
//     XPosCine[2]=(startXPos-55);
//     YPosCine[3]=(startYPos-75); //t.e.m 5
//     XPosCine[3]=(startXPos-110);
//     YPosCine[4]=(startYPos-75); //t.e.m 5
//     XPosCine[4]=(startXPos-175);
//     YPosCine[5]=(startYPos-75); //t.e.m 5     
//     XPosCine[5]=(startXPos-230);
//     YPosCine[6]=(startYPos-145); //t.e.m 13     
//     XPosCine[6]=(startXPos-220);
//     YPosCine[7]=(startYPos-145); //t.e.m 13   
//     XPosCine[7]=(startXPos-165);
//     YPosCine[8]=(startYPos-145); //t.e.m 13     
//     XPosCine[8]=(startXPos-110);
//     YPosCine[9]=(startYPos-145); //t.e.m 13   
//     XPosCine[9]=(startXPos-165);
//     YPosCine[10]=(startYPos-145); //t.e.m 13   
//     XPosCine[10]=(startXPos+10);
//     YPosCine[11]=(startYPos-145); //t.e.m 13   
//     XPosCine[11]=(startXPos+75);
//     YPosCine[12]=(startYPos-145); //t.e.m 13   
//     XPosCine[12]=(startXPos+130);
//     YPosCine[13]=(startYPos-145); //t.e.m 13   
//     XPosCine[13]=(startXPos+195);
//     YPosCine[14]=(startYPos-210); //t.e.m 17   
//     XPosCine[14]=(startXPos+215);
//     YPosCine[15]=(startYPos-210); //t.e.m 17   
//     XPosCine[15]=(startXPos+155);
//     YPosCine[16]=(startYPos-210); //t.e.m 17   
//     XPosCine[16]=(startXPos+95);
//     YPosCine[17]=(startYPos-210); //t.e.m 17   
//     XPosCine[17]=(startXPos+35);
//     YPosCine[18]=(startYPos-250);    
//     XPosCine[18]=(startXPos); //t.e.m 20
//     YPosCine[19]=(startYPos-330);    
//     XPosCine[19]=(startXPos); //t.e.m 20
//     YPosCine[19]=(startYPos-400);    
//     XPosCine[19]=(startXPos); //t.e.m 20
        
//     spriteCinefiel=new ImageComponent(pathImageCinefiel,YPosCine[i],XPosCine[i],widthCine,heightCine);

    }
    
    public ImageComponent nieuweSpriteMaken()
    {     
     spriteCinefiel=new ImageComponent(pathImageCinefiel,YPosCine[i],XPosCine[i],widthCine,heightCine);
     System.out.println("DE HUIDIGE SPRITE IS: "+pathImageCinefiel);
     System.out.println("DEZE STAAT OP LOCATIE: "+YPosCine+" "+XPosCine);
     
     return spriteCinefiel;
    }
    
    public void changePosition()
    {
     spriteCinefiel.MoveImage(YPosCine[i++], XPosCine[i++]);

     System.out.println("DE HUIDIGE POSITIE IS: "+i);
    }
}
