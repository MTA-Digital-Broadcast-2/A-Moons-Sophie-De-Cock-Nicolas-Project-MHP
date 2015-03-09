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
    public HScene sceneMenu, sceneVraag; //elke scene is interactief, dus 2 scenes.
    
    //initialiseer knopobject
    private HTextButton startKnop, stopKnop, hulpKnop, 
            triviaAntw1, triviaAntw2,triviaAntw3, triviaAntw4;
    private HStaticText triviaVraag;
    //private Image
    private boolean debug = true;
    
  
    public HelloTVXlet() { }

    public void initXlet(XletContext context) {
      if(debug){
        System.out.println("Xlet initialiseren");
      }
      this.actualXletcontext = context;
      HSceneTemplate sceneTemplateMenu = new HSceneTemplate(); //Menu
      
      //Menu
      sceneTemplateMenu.setPreference(HSceneTemplate.SCENE_SCREEN_DIMENSION, new HScreenDimension(1.0f,1.0f), HSceneTemplate.REQUIRED);
      sceneTemplateMenu.setPreference(HSceneTemplate.SCENE_SCREEN_LOCATION, new HScreenPoint(0.0f,0.0f), HSceneTemplate.REQUIRED);
      
      // kan nog veranderd worden (het zijn maar afmetingen)
      sceneMenu = HSceneFactory.getInstance().getBestScene(sceneTemplateMenu);

       //Omega Stap 2: object aanmaken, eigenschappen instellen
     //Menu
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
     sceneMenu.add(startKnop);
     sceneMenu.add(stopKnop);
     sceneMenu.add(hulpKnop);
     
     //Requestknop Menu
     startKnop.requestFocus(); //Menu

     //MijnComponent
     MijnComponent achtergrondImage=new MijnComponent("bitmap1.jpeg", 200, 200, 300, 60);
     sceneMenu.add(achtergrondImage);
     
     //MijnTriviavraag mTriviavraag = new MijnTriviavraag();
     //sceneVraag.add(mTriviavraag); //Verder bekijken hoe dit werkt...
     
     //VRAAG
     HSceneTemplate sceneTemplateVraag = new HSceneTemplate(); //Vraag
     
     sceneTemplateVraag.setPreference(HSceneTemplate.SCENE_SCREEN_DIMENSION, new HScreenDimension(1.0f,1.0f), HSceneTemplate.REQUIRED);
     sceneTemplateVraag.setPreference(HSceneTemplate.SCENE_SCREEN_LOCATION, new HScreenPoint(0.0f,0.0f), HSceneTemplate.REQUIRED);
      
     sceneVraag = HSceneFactory.getInstance().getBestScene(sceneTemplateVraag);
     
      //Vraag
     triviaVraag = new HStaticText("Wat is het antwoord op de vraag?");
      
     triviaVraag.setLocation(100,70);
     triviaVraag.setSize(350,100);
     triviaVraag.setForeground(new DVBColor(40,40,100,255));
     triviaVraag.setBackground(new DVBColor(255,255,255,255));
     triviaVraag.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
     triviaAntw1 = new HTextButton("Dit is misschien het antwoord");
     triviaAntw1.setLocation(102,200);
     triviaAntw1.setSize(347,50);
     triviaAntw1.setBackground(new DVBColor(100,210,70,255));
     triviaAntw1.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
     triviaAntw2 = new HTextButton("Dit is mogelijks het antwoord");
     triviaAntw2.setLocation(102,280);
     triviaAntw2.setSize(347,50);
     triviaAntw2.setBackground(new DVBColor(200,90,30,255));
     triviaAntw2.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
     triviaAntw3 = new HTextButton("Dit is zeker niet het antwoord");
     triviaAntw3.setLocation(102,360);
     triviaAntw3.setSize(347,50);
     triviaAntw3.setBackground(new DVBColor(100,40,170,255));
     triviaAntw3.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
     triviaAntw4 = new HTextButton("Dit is onwaarschijnlijk als antwoord");
     triviaAntw4.setLocation(102,440);
     triviaAntw4.setSize(347,50);
     triviaAntw4.setBackground(new DVBColor(100,90,140,255));
     triviaAntw4.setBackgroundMode(HVisible.BACKGROUND_FILL);
     
      //Navigeerbaar maken
      triviaAntw1.setFocusTraversal(null, triviaAntw2, null, null);
      triviaAntw2.setFocusTraversal(triviaAntw1, triviaAntw1, null, null);
      triviaAntw3.setFocusTraversal(triviaAntw2, triviaAntw4, null, null);
      triviaAntw4.setFocusTraversal(triviaAntw3, null, null, null);
      
      ColorBox cb = new ColorBox(100, 70, 450, 350);
      Background bg = new Background();
      
      //knop aan scene toevoegen
      sceneVraag.add(triviaAntw1);
      sceneVraag.add(triviaAntw2);
      sceneVraag.add(triviaAntw3);
      sceneVraag.add(triviaAntw4);
      sceneVraag.add(triviaVraag);      
      sceneVraag.add(cb);
      sceneVraag.add(bg);
     
     //beginfocus instellen 1 van de knoppen
     triviaAntw1.requestFocus();
    }

    public void startXlet() {
        if(debug){
            System.out.println("Xlet starten");
        }
       sceneMenu.validate();
       sceneMenu.setVisible(true);
       
     //Acties laten uitvoeren
     //Menu  
     startKnop.setActionCommand("startKnop_actioned");
     stopKnop.setActionCommand("stopKnop_actioned");
     hulpKnop.setActionCommand("hulpKnop_actioned");
     startKnop.addHActionListener(this);
     stopKnop.addHActionListener(this);
     hulpKnop.addHActionListener(this);
     
     //Vraag is actief, maar nog niet visible (Startknop menu zal dit veranderen)
     sceneVraag.validate();
     sceneVraag.setVisible(false);
     
    //Vraag
     triviaAntw1.setActionCommand("triviaAntw1_actioned");
     triviaAntw1.addHActionListener(this);
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
    
    //Bij een actie...
    public void actionPerformed(ActionEvent e){
    System.out.println(e.getActionCommand());
    
    //Menu
    if(e.getActionCommand().equals("startKnop_actioned"))
    {
     sceneMenu.setVisible(false);  
     sceneVraag.setVisible(true); 
    }
    
    if(e.getActionCommand().equals("stopKnop_actioned"))
    {
        
    }
    
    if(e.getActionCommand().equals("hulpKnop_actioned"))
    {

    }
    
    //Vraag
    if(e.getActionCommand().equals("triviaAnsw1_actioned")) 
    {
            WrongAnswer wrong = new WrongAnswer();
            sceneVraag.add(wrong);    
    }
    
        if(e.getActionCommand().equals("triviaAnsw2_actioned"))
    {
            WrongAnswer wrong = new WrongAnswer();
            sceneVraag.add(wrong);    
    }
        if(e.getActionCommand().equals("triviaAnsw3_actioned"))
    {
           // RightAnswer right = new RightAnswer(); //Moet nog een klasse van gemaakt worden
           // sceneVraag.add(right);    
    }
    
            if(e.getActionCommand().equals("triviaAnsw4_actioned")) 
    {
            WrongAnswer wrong = new WrongAnswer();
            sceneVraag.add(wrong);    
    }
    } 
}

