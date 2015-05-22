package hellotvxlet;
import org.dvb.ui.*;
import org.havi.ui.*;
//voor de acties die je wilt uitvoeren

public class MijnTriviavraag {
    public HScene vraagScene;
    
    public HTextButton triviaAntw1, triviaAntw2,triviaAntw3, triviaAntw4;
    public HStaticText triviaVraag;
    
    //public ImageComponent backgroundVraag;
    
    public String correct= "";
    //public string triviaVraag, triviaAntwoord

    
    public HScene nieuweVraagMaken(HScene scene,String vraag,String antw1,String antw2,String antw3,String antw4,String juisteAntwoord)
    {
     vraagScene = scene;
     correct = juisteAntwoord;
     
     triviaVraag = new HStaticText(vraag);
      
     triviaVraag.setLocation(90,40);
     triviaVraag.setSize(550,100);
     triviaVraag.setForeground(new DVBColor(0,65,107,255));
     triviaVraag.setBackground(new DVBColor(255,255,255,255));
     triviaVraag.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
     triviaAntw1 = new HTextButton(antw1);
     triviaAntw1.setLocation(192,150);
     triviaAntw1.setSize(347,90);
     triviaAntw1.setBackground(new DVBColor(19,191,189,255));
     triviaAntw1.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
     triviaAntw2 = new HTextButton(antw2);
     triviaAntw2.setLocation(192,250);
     triviaAntw2.setSize(347,90);
     triviaAntw2.setBackground(new DVBColor(237,76,8,255));
     triviaAntw2.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
     triviaAntw3 = new HTextButton(antw3);
     triviaAntw3.setLocation(192,350);
     triviaAntw3.setSize(347,90);
     triviaAntw3.setBackground(new DVBColor(242,169,12,255));
     triviaAntw3.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
     triviaAntw4 = new HTextButton(antw4);
     triviaAntw4.setLocation(192,450);
     triviaAntw4.setSize(347,90);
     triviaAntw4.setBackground(new DVBColor(59,11,159,255));
     triviaAntw4.setBackgroundMode(HVisible.BACKGROUND_FILL);
     
      //Navigeerbaar maken
      triviaAntw1.setFocusTraversal(triviaAntw4, triviaAntw2, null, null);
      triviaAntw2.setFocusTraversal(triviaAntw1, triviaAntw3, null, null);
      triviaAntw3.setFocusTraversal(triviaAntw2, triviaAntw4, null, null);
      triviaAntw4.setFocusTraversal(triviaAntw3, triviaAntw1, null, null);
      
      //ColorBox cb = new ColorBox(190, 100, 450, 350);
     //backgroundVraag = new ImageComponent("Howard_Drew_Theatre_Layout.png",0,0,720,576);
      
      //knop aan scene toevoegen
      vraagScene.add(triviaAntw1);
      vraagScene.add(triviaAntw2);
      vraagScene.add(triviaAntw3);
      vraagScene.add(triviaAntw4);
      vraagScene.add(triviaVraag);      
      //vraagScene.add(cb);
      //vraagScene.add(backgroundVraag);
     
     
     return vraagScene;
    }
    
    public void VragenVeranderen(String vraag,String antw1,String antw2,String antw3,String antw4,String juisteAntwoord)
    {
     triviaVraag.setTextContent(vraag, HState.NORMAL_STATE);
     triviaAntw1.setTextContent(antw1, HState.NORMAL_STATE);
     triviaAntw2.setTextContent(antw2, HState.NORMAL_STATE);
     triviaAntw3.setTextContent(antw3, HState.NORMAL_STATE);
     triviaAntw4.setTextContent(antw4, HState.NORMAL_STATE);
     correct = juisteAntwoord;
   
    }
}
