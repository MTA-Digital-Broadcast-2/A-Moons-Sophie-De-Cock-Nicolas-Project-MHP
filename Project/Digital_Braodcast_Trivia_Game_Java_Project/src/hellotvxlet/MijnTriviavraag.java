package hellotvxlet;
import javax.tv.xlet.*;
import org.dvb.ui.*;
import org.havi.ui.*;
//voor de acties die je wilt uitvoeren
import org.havi.ui.event.*;
import java.awt.event.*;

public class MijnTriviavraag {
    public HScene vraagScene;
    
    public HTextButton   triviaAntw1, triviaAntw2,triviaAntw3, triviaAntw4;
    public HStaticText triviaVraag;
    
    public Background achtergrondImageVraag;
    
    public String correct= "1e antwoord";
    //public string triviaVraag, triviaAntwoord

    //Hier zullen we de vragen insteken
    //Elke keer als een vorige vraag afgerond is, wordt deze overschreven door een nieuwe (we gaan scenes aanmaken en alterneren tussen deze)
    /*public HScene Vraagwhatever(String vraag, String antwoord1, String antwoord2, String antwoord3, String antwoord4)
    {
    System.out.println("Meh");
    
    }*/
    
    public HScene nieuweVraagMaken(HScene scene,String vraag,String antw1,String antw2,String antw3,String antw4,String juisteAntwoord)
    {
     vraagScene = scene;
     correct = juisteAntwoord;
     
     triviaVraag = new HStaticText(vraag);
      
     triviaVraag.setLocation(200,70);
     triviaVraag.setSize(350,100);
     triviaVraag.setForeground(new DVBColor(40,40,100,255));
     triviaVraag.setBackground(new DVBColor(255,255,255,255));
     triviaVraag.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
     triviaAntw1 = new HTextButton(antw1);
     triviaAntw1.setLocation(202,200);
     triviaAntw1.setSize(347,50);
     triviaAntw1.setBackground(new DVBColor(100,210,70,255));
     triviaAntw1.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
     triviaAntw2 = new HTextButton(antw2);
     triviaAntw2.setLocation(202,280);
     triviaAntw2.setSize(347,50);
     triviaAntw2.setBackground(new DVBColor(200,90,30,255));
     triviaAntw2.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
     triviaAntw3 = new HTextButton(antw3);
     triviaAntw3.setLocation(202,360);
     triviaAntw3.setSize(347,50);
     triviaAntw3.setBackground(new DVBColor(100,40,170,255));
     triviaAntw3.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
     triviaAntw4 = new HTextButton(antw4);
     triviaAntw4.setLocation(202,440);
     triviaAntw4.setSize(347,50);
     triviaAntw4.setBackground(new DVBColor(100,90,140,255));
     triviaAntw4.setBackgroundMode(HVisible.BACKGROUND_FILL);
     
      //Navigeerbaar maken
      triviaAntw1.setFocusTraversal(triviaAntw4, triviaAntw2, null, null);
      triviaAntw2.setFocusTraversal(triviaAntw1, triviaAntw3, null, null);
      triviaAntw3.setFocusTraversal(triviaAntw2, triviaAntw4, null, null);
      triviaAntw4.setFocusTraversal(triviaAntw3, triviaAntw1, null, null);
      
      ColorBox cb = new ColorBox(200, 70, 450, 350);
      Background bg = new Background();
      
      //knop aan scene toevoegen
      vraagScene.add(triviaAntw1);
      vraagScene.add(triviaAntw2);
      vraagScene.add(triviaAntw3);
      vraagScene.add(triviaAntw4);
      vraagScene.add(triviaVraag);      
      vraagScene.add(cb);
      vraagScene.add(bg);
     
     achtergrondImageVraag = new Background(121,20,255);
     vraagScene.add(achtergrondImageVraag);
     
     return vraagScene;
    }
}
