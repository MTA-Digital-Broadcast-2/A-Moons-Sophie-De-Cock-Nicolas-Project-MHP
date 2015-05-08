package hellotvxlet; //altijd hetzelfde als packagenaam!!

import javax.tv.xlet.*;
//Extra stap! Voor DVB Colors te gebruiken, heb je deze bibliotheek nodig
import org.dvb.ui.*;
//Bèta Stap 1: voor de grafische toestanden
import org.havi.ui.*;
//import java.awt.Toolkit;
import java.awt.*;
//voor de acties die je wilt uitvoeren
import org.havi.ui.event.*;
import java.awt.event.*;


public class HelloTVXlet implements Xlet, HActionListener {

    private XletContext actualXletcontext;
    public HScene scene; //elke scene is interactief, dus 2 scenes.
    
    //initialiseer knopobject
    public HTextButton startKnop, stopKnop, hulpKnop, 
            triviaAntw1, triviaAntw2,triviaAntw3, triviaAntw4;
    public HStaticText triviaVraag;
    //private Image
    private boolean debug = true;
    
    //nieuwe backgrounds
    public ImageComponent backgroundMenu, backgroundVraag;
    
    Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
    double scWidth = screensize.width;
    double scHeight = screensize.height;
    
    //klasse om een vraag aan te maken, 1 object aanmaken zodat methode voor nieuwe scene gebruikt kan worden
    MijnTriviavraag objTriviaVraag = new MijnTriviavraag();
  
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
      scene = HSceneFactory.getInstance().getBestScene(sceneTemplateMenu);

       //Omega Stap 2: object aanmaken, eigenschappen instellen
     //Menu
     startKnop=new HTextButton("Start");
     startKnop.setLocation(300,410);
     startKnop.setSize(130,50);
     startKnop.setBackground(new DVBColor(0,0,0,179));
     startKnop.setBackgroundMode(HVisible.BACKGROUND_FILL);
     
     stopKnop=new HTextButton("Stop");
     stopKnop.setLocation(300,480);
     stopKnop.setSize(130,50);
     stopKnop.setBackground(new DVBColor(0,0,0,179));
     stopKnop.setBackgroundMode(HVisible.BACKGROUND_FILL);
     
     hulpKnop=new HTextButton("?");
     hulpKnop.setLocation(620,500);
     hulpKnop.setSize(75,50);
     hulpKnop.setBackground(new DVBColor(0,0,0,179));
     hulpKnop.setBackgroundMode(HVisible.BACKGROUND_FILL);
     
     //Navigeerbaar maken
     startKnop.setFocusTraversal(null, stopKnop, null,hulpKnop);
     stopKnop.setFocusTraversal(startKnop, null, null,hulpKnop);
     hulpKnop.setFocusTraversal(null,null, startKnop,null);
     
     //knop aan scene toevoegen
     scene.add(startKnop);
     scene.add(stopKnop);
     scene.add(hulpKnop);
     
     //Requestknop Menu
     startKnop.requestFocus(); //Menu

     //Background
     //achtergrondImageMenu=new Background(); //Is nu tijdelijk een vaste kleur
     //scene.add(achtergrondImageMenu);
     
     //Background ImageComponent
     backgroundMenu = new ImageComponent("gordijn.png",0,0,(int)scWidth, (int)scHeight);
     System.out.println("Image width: "+scWidth);
     System.out.println("Window height: "+scHeight);
     
     scene.add(backgroundMenu);
     scene.repaint(); //wat doet dit?
     
     }

    public void startXlet() {
        if(debug){
            System.out.println("Xlet starten");
        }
     scene.validate();
     scene.setVisible(true);

     //Acties laten uitvoeren
     //Menu  
     startKnop.setActionCommand("startKnop_actioned");
     stopKnop.setActionCommand("stopKnop_actioned");
     hulpKnop.setActionCommand("hulpKnop_actioned");
     startKnop.addHActionListener(this);
     stopKnop.addHActionListener(this);
     hulpKnop.addHActionListener(this);
     
     //Vraag
     //scene.validate();
     //scene.setVisible(true);    
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
     System.out.println("sceneVraag wordt visible");
     //invisible achtergrondmenu
     backgroundMenu.setVisible(false); 
    
     //manueel knoppen onzichtbaar maken
     startKnop.setVisible(false);
     stopKnop.setVisible(false);
     hulpKnop.setVisible(false);
     
     //Nieuwe vraag maken, huidige scene meegeven + vraag / antw1 / antw2 / antw3 / antw4 + int juisteAntw (getal dat zegt welk antwoord juist is)
     scene = objTriviaVraag.nieuweVraagMaken(scene,"Wat is het antwoord op de 1e vraag?",
                                                    "Dit is misschien het antwoord",
                                                    "Dit is mogelijks het antwoord",
                                                    "Dit is zeker niet het antwoord",
                                                    "Dit is onwaarschijnlijk als antwoord",
                                                     "1e antwoord");     
     //focus op 1e antwoord knop
     objTriviaVraag.triviaAntw1.requestFocus();
     
     //zodat er ook geregistreerd word als er op de antwoord knoppen wordt gedrukt
     objTriviaVraag.triviaAntw1.setActionCommand("triviaAntw1_actioned");
     objTriviaVraag.triviaAntw2.setActionCommand("triviaAntw2_actioned");
     objTriviaVraag.triviaAntw3.setActionCommand("triviaAntw3_actioned");
     objTriviaVraag.triviaAntw4.setActionCommand("triviaAntw4_actioned");
     objTriviaVraag.triviaAntw1.addHActionListener(this); 
     objTriviaVraag.triviaAntw2.addHActionListener(this); 
     objTriviaVraag.triviaAntw3.addHActionListener(this); 
     objTriviaVraag.triviaAntw4.addHActionListener(this); 
    }
    
    if(e.getActionCommand().equals("stopKnop_actioned"))
    {
        
    }
    
    if(e.getActionCommand().equals("hulpKnop_actioned"))
    {

    }
    
    //antwoord knoppen
    if(e.getActionCommand().equals("triviaAntw1_actioned")) 
    {        
        if(objTriviaVraag.correct.equals("1e antwoord"))
        {
            //je hebt de vraag goed beantwoord
            System.out.println("juist!!");
        }  
    }
    
        if(e.getActionCommand().equals("triviaAntw2_actioned"))
        {
            if(objTriviaVraag.correct.equals("2e antwoord"))
            {
                System.out.println("juist!!");
                //je hebt de vraag goed beantwoord                
            }    
        }
        if(e.getActionCommand().equals("triviaAntw3_actioned"))
        {
           // RightAnswer right = new RightAnswer(); //Moet nog een klasse van gemaakt worden
           // sceneVraag.add(right); 
            if(objTriviaVraag.correct.equals("3e antwoord"))
            {
                //je hebt de vraag goed beantwoord
            }
        }
    
            if(e.getActionCommand().equals("triviaAntw4_actioned")) 
        {
            if(objTriviaVraag.correct.equals("4e antwoord"))
            {
                //je hebt de vraag goed beantwoord
            }   
        }
    }
}

