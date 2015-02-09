package hellotvxlet; //altijd hetzelfde als packagenaam!!

import javax.tv.xlet.*;
//Extra stap! Voor DVB Colors te gebruiken, heb je deze bibliotheek nodig
import org.dvb.ui.*;
//Bèta Stap 1: voor de grafische toestanden
import org.havi.ui.*;
//import java.awt.Toolkit;
//import java.awt.Image;

//voor de acties die je wilt uitvoeren
import org.havi.ui.event.*;
import java.awt.event.*;


public class HelloTVXlet implements Xlet, HActionListener {

    private XletContext actualXletcontext;
    private HScene scene;
    
    //initialiseer knopobject
    private HTextButton startKnop, stopKnop, hulpKnop;
    //private Image
    private boolean debug = true;
    
  
    public HelloTVXlet() { }

    public void initXlet(XletContext context) {
      if(debug){
        System.out.println("Xlet initialiseren");
      }
      this.actualXletcontext = context;
      HSceneTemplate sceneTemplate = new HSceneTemplate();
      
      sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_DIMENSION, new HScreenDimension(1.0f,1.0f), HSceneTemplate.REQUIRED);
      sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_LOCATION, new HScreenPoint(0.0f,0.0f), HSceneTemplate.REQUIRED);
      // kan nog veranderd worden (het zijn maar afmetingen)
      scene = HSceneFactory.getInstance().getBestScene(sceneTemplate);
      
       //Omega Stap 2: object aanmaken, eigenschappen instellen
     startKnop=new HTextButton("Start");
     startKnop.setLocation(150,450);
     startKnop.setSize(130,50);
     startKnop.setBackground(new DVBColor(0,0,0,179));
     startKnop.setBackgroundMode(HVisible.BACKGROUND_FILL);
     
     stopKnop=new HTextButton("Stop");
     stopKnop.setLocation(450,450);
     stopKnop.setSize(130,50);
     stopKnop.setBackground(new DVBColor(0,0,0,179));
     stopKnop.setBackgroundMode(HVisible.BACKGROUND_FILL);
     
     hulpKnop=new HTextButton("?");
     hulpKnop.setLocation(620,500);
     hulpKnop.setSize(75,50);
     hulpKnop.setBackground(new DVBColor(0,0,0,179));
     hulpKnop.setBackgroundMode(HVisible.BACKGROUND_FILL);
     
     //Navigeerbaar maken
     startKnop.setFocusTraversal(null, hulpKnop, null,stopKnop);
     stopKnop.setFocusTraversal(null, hulpKnop, startKnop,null);
     hulpKnop.setFocusTraversal(stopKnop,null, stopKnop,null);
     
     //knop aan scene toevoegen
     scene.add(startKnop);
     scene.add(stopKnop);
     scene.add(hulpKnop);
     
     //beginfocus instellen 1 van de knoppen
     startKnop.requestFocus();

     //MijnComponent
     MijnComponent achtergrondImage=new MijnComponent("bitmap1.jpeg", 200, 200, 300, 60);
     scene.add(achtergrondImage);
    }

    public void startXlet() {
        if(debug){
            System.out.println("Xlet starten");
        }
       scene.validate();
       scene.setVisible(true);
     //Acties laten uitvoeren
     startKnop.setActionCommand("startKnop_actioned");
     stopKnop.setActionCommand("stopKnop_actioned");
     hulpKnop.setActionCommand("hulpKnop_actioned");
     
     startKnop.addHActionListener(this);
     stopKnop.addHActionListener(this);
     hulpKnop.addHActionListener(this);
    }

    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) throws XletStateChangeException
    {
      //mag het beëindigt worden? -> emulator zijn debug krijgt dit te zien
      if(unconditional)
      {
        System.out.println("De Xlet moet beëindigd worden");
      }
      
      //mag het nog niet beëindigt worden? -> hetzelfde met een andere boodschap
      else
      {
      System.out.println("De mogelijkheid bestaat "+"door het werpen van een exceptie "+"de Xlet in leven te houden.");
      throw new XletStateChangeException("Laat mij leven!");
      }
    }
    
    public void actionPerformed(ActionEvent e){
    System.out.println(e.getActionCommand());
    
    if(e.getActionCommand().equals("startKnop_actioned"))
    {
        
    }
    
    if(e.getActionCommand().equals("stopKnop_actioned"))
    {
        
    }
    
    if(e.getActionCommand().equals("hulpKnop_actioned"))
    {

    }
    
  
    } 
}

