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
    public HTextButton startKnop, stopKnop, hulpKnop, backKnop,
            triviaAntw1, triviaAntw2,triviaAntw3, triviaAntw4;
    public HStaticText triviaVraag;
    //private Image
    private boolean debug = true;
    
    public boolean goedAntwoord, antwoordGegeven =false;
    
    //nieuwe backgrounds
    public ImageComponent backgroundMenu, backgroundBord, handleidingGame; //menu en spelbord
    
    //Sprites
    public ImageComponent spriteCinefielIm; //ook als gewone image krijg ik het niet normaal op
    
//    public SpriteCinefiel spriteCinefiel;
//    public SpriteSecurity spriteSecurity;
    
    public int startYPos = 513;
    public int startXPos = 329;
    
    public int eersteYPos = 513;
    public int eersteXPos = 329;
    
    public int widthCine = 53;
    public int heightCine = 50;
    
//    public int[] YPosCine,XPosCine;
    
    public int goedeAntwoorden; //om de spritearray af te gaan  

    //public int aantalBeurten=0; //voor de Security te triggeren (na 3 beurten)
    
    //Screen
    Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
    double scWidth = screensize.width;
    double scHeight = screensize.height;
    
    //klasse om een vraag aan te maken, 1 object aanmaken zodat methode voor nieuwe scene gebruikt kan worden
    MijnTriviavraag objTriviaVraag = new MijnTriviavraag();
       
    public int vraagnr = 1;

  
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
     
     //Handleiding
     backKnop =new HTextButton("Terug");
     backKnop.setLocation(300,480);
     backKnop.setSize(130,50);
     backKnop.setBackground(new DVBColor(0,0,0,179));
     backKnop.setBackgroundMode(HVisible.BACKGROUND_FILL);
     
     //Navigeerbaar maken
     startKnop.setFocusTraversal(null, stopKnop, null,hulpKnop);
     stopKnop.setFocusTraversal(startKnop, null, null,hulpKnop);
     hulpKnop.setFocusTraversal(null,null, startKnop,null);
     
     backKnop.setFocusTraversal(null,null, null,null);
     
     //knop aan scene toevoegen
     scene.add(startKnop);
     scene.add(stopKnop);
     scene.add(hulpKnop);
     
     scene.add(backKnop);
     
     //Requestknop Menu
     startKnop.requestFocus(); //Menu

     //Background ImageComponent
     backgroundMenu = new ImageComponent("gordijn.png",0,0,(int)scWidth, (int)scHeight);
     System.out.println("Image width: "+scWidth);
     System.out.println("Window height: "+scHeight);
     
     scene.add(backgroundMenu);
     scene.repaint(); //wat doet dit?

     
     goedeAntwoorden=0; //moet posArray opvolgen
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
     
     backKnop.setActionCommand("backKnop_actioned");
     
     startKnop.addHActionListener(this);
     stopKnop.addHActionListener(this);
     hulpKnop.addHActionListener(this);
     
     backKnop.addHActionListener(this);
     
     backKnop.setVisible(false);
     
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
     scene = objTriviaVraag.nieuweVraagMaken(scene,"","","","","",""); 

//     ImageComponent spriteCineImage = spriteCinefiel.nieuweSpriteMaken();
     
     //achtergrond vragen = spelbord
     backgroundBord = new ImageComponent("Howard_Drew_Theatre_Layout.png",0,0,(int)scWidth, (int)scHeight);
     
//     eersteXPos=XPosCine[goedeAntwoorden];
//     eersteYPos=YPosCine[goedeAntwoorden];
     
     spriteCinefielIm = new ImageComponent("Cinefieltje sprite.png",eersteXPos,eersteYPos,widthCine,heightCine); //De enige manier momenteel waarmee ik de sprite erop kan krijgen

//     scene.add(spriteCineImage);
     
     scene.add(spriteCinefielIm);
     scene.add(backgroundBord);
     scene.repaint(); //wat doet dit?
     
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
        System.exit(0); //stopt applicatie
    }
    
    if(e.getActionCommand().equals("hulpKnop_actioned"))
    {
     hulpKnop.setVisible(false);
     startKnop.setVisible(false);
     stopKnop.setVisible(false);
     
     //handleiding wordt gemaakt en backknop wordt visible
     backKnop.setVisible(true);
     backKnop.requestFocus();
     
     backgroundMenu.setVisible(false); 
     
     handleidingGame = new ImageComponent("gordijn handleiding.png",0,0,(int)scWidth, (int)scHeight);
     scene.add(handleidingGame);
     scene.repaint(); //wat doet dit?
    }
    
    if(e.getActionCommand().equals("backKnop_actioned"))
    {
     hulpKnop.setVisible(true);
     startKnop.setVisible(true);
     stopKnop.setVisible(true);
     
     backKnop.setVisible(false);
     startKnop.requestFocus();
     
     handleidingGame.setVisible(false);
     backgroundMenu.setVisible(true); 
    }
    
    //antwoord knoppen
    if(e.getActionCommand().equals("triviaAntw1_actioned")) 
    {        
        if(objTriviaVraag.correct.equals("1e antwoord"))
        {
            //je hebt de vraag goed beantwoord
            System.out.println("juist!!");
            goedAntwoord = true;
            vraagnr++; //op naar de volgende
            scene.repaint();
        }
        //else
         //goedAntwoord = false;
         antwoordGegeven=true;
         checkVooruitgang();
    }
    
        if(e.getActionCommand().equals("triviaAntw2_actioned"))
        {
            if(objTriviaVraag.correct.equals("2e antwoord"))
            {
                //je hebt de vraag goed beantwoord  
                System.out.println("juist!!");
                goedAntwoord = true;
                vraagnr++; //op naar de volgende
                scene.repaint();              
            }    
         //else
         //goedAntwoord = false;
            
        antwoordGegeven=true;
        checkVooruitgang();
        
        }
        if(e.getActionCommand().equals("triviaAntw3_actioned"))
        {
           // RightAnswer right = new RightAnswer(); //Moet nog een klasse van gemaakt worden
           // sceneVraag.add(right); 
            if(objTriviaVraag.correct.equals("3e antwoord"))
            {
                System.out.println("juist!!");
                goedAntwoord =true;
                vraagnr++;
                scene.repaint();      
            }
         //else
         //goedAntwoord = false;
            
        antwoordGegeven=true;
        checkVooruitgang();
        
        }
    
            if(e.getActionCommand().equals("triviaAntw4_actioned")) 
        {
            if(objTriviaVraag.correct.equals("4e antwoord"))
            {
                 System.out.println("juist!!");
                 goedAntwoord =true;
                 vraagnr++;
                 scene.repaint();
            }  
         //else
         //goedAntwoord = false;
            
        antwoordGegeven=true;
        checkVooruitgang();
        
        }
    
    //Hier switchen we van vragen
     System.out.println("vraagnr: " + vraagnr);
     
     switch(vraagnr)
     {
         case 1: 
                   objTriviaVraag.VragenVeranderen("Wie was het 1ste personage dat sprak in Star Wars?",
                                                    "Luke Skywalker",
                                                    "Prinses Leia",
                                                    "C3PO",
                                                    "R2-D2",
                                                     "3e antwoord");  
  
         break;
         
         case 2: 
             
             objTriviaVraag.VragenVeranderen("Wat was Sylvester Stalones job voordat hij acteur werd?",
                                                    "Reinigde leeuwenkooien",
                                                    "Professionele bokser",
                                                    "Olifantenmestopruimer",
                                                    "Postbode",
                                                     "1e antwoord");   
         break;

         case 3: 
             
             objTriviaVraag.VragenVeranderen("Wat was Bambi's 1ste woord?",
                                                    "Vlinder",
                                                    "Konijn",
                                                    "Vogel",
                                                    "Levensverzekering",
                                                     "3e antwoord");   
         break;
         
         case 4: 
             
             objTriviaVraag.VragenVeranderen("Hoe heet de protagonist in de musical Chicago?",
                                                    "Sarah Rose",
                                                    "Roxy Hart",
                                                    "Mary Summer",
                                                    "Barbara Lee",
                                                     "2e antwoord");   
         break;
         
         case 5: 
             
             objTriviaVraag.VragenVeranderen("In de film Alien, wat was het huisdier van Ripley?",
                                                    "Kanarievogel",
                                                    "Ze had geen huisdier",
                                                    "Kat",
                                                    "Muis",
                                                     "3e antwoord");   
         break;
         
         case 6: 
             
             objTriviaVraag.VragenVeranderen("Wat is de naam van de gestoorde dokter in"+"\n"+"The Rocky Horror Picture Show?",
                                                    "Dr. Frankenstein",
                                                    "Dr. Frankenschwein",
                                                    "Dr. Frankenfurter",
                                                    "Dr. Frankenfrey",
                                                     "3e antwoord");   
         break;
         
         case 7: 
             
             objTriviaVraag.VragenVeranderen("Wie is de meest genomineerde acteur/actrice"+"\n"+"voor een Oscar?",
                                                    "Leonardo Di Caprio",
                                                    "Meryl Streep",
                                                    "Jack Nicholson",
                                                    "Al Pacino",
                                                     "2e antwoord");   
        break;
        
        case 8: 
             
             objTriviaVraag.VragenVeranderen("Wat was de geniale manier waarop E.T. piraterij"+"\n"+"tegin ging?",
                                                    "Hun videocassettes waren"+"\n"+"allemaal groen",
                                                    "Er zat een speciaal"+"\n"+"gecodeerde sticker op de cassette",
                                                    "Ze brachten geen"+"\n"+"video's uit",
                                                    "Er was een geheime boodschap"+"\n"+"op het einde van de film",
                                                     "1e antwoord");   
        break;
        
        case 9: 
             
             objTriviaVraag.VragenVeranderen("In welke film kan je Mickey Mouse en Bugs Bunny in"+"\n"+"dezelfde scene zien?",
                                                    "Looney Tunes: Back In Action",
                                                    "Who Framed Roger Rabbit",
                                                    "Bah, Humduck!",
                                                    "Fantasia 2000",
                                                     "2e antwoord");   
        break;
        
       case 10: 
             
             objTriviaVraag.VragenVeranderen("Welke pil nam Neo in The Matrix?",
                                                    "De rode",
                                                    "De blauwe",
                                                    "Hij nam ze allebei",
                                                    "Hij nam er geen",
                                                     "2e antwoord");   
        break;
        
       case 11: 
             
             objTriviaVraag.VragenVeranderen("Wie sprak de stem in voor President Business in"+"\n"+"The Lego Movie?",
                                                    "Peter Cullen",
                                                    "Chad Smith",
                                                    "Will Ferrell",
                                                    "Steve Blum",
                                                     "3e antwoord");   
        break;
        
       case 12: 
             
             objTriviaVraag.VragenVeranderen("Hoe heet de film gespeeld, geschreven en geregiseerd"+"\n"+"door Tommy Wiseau?",
                                                    "The Chamber",
                                                    "The House",
                                                    "The Room",
                                                    "The Closet",
                                                     "3e antwoord");   
        break;
        
       case 13: 
             
             objTriviaVraag.VragenVeranderen("Welke film heeft het meest verdiend in de geschiedenis"+"\n"+"van cinema?",
                                                    "Avatar",
                                                    "Frozen",
                                                    "Titanic",
                                                    "The Lion King",
                                                     "1e antwoord");   
        break;
     
       case 14: 
             
             objTriviaVraag.VragenVeranderen("Wie of wat is Rosebud in Citizen Kane?",
                                                    "Zijn kont dat jeukte",
                                                    "Mrs. Pauwels",
                                                    "Zijn wachtwoord voor"+"\n"+"de kluis",
                                                    "Ik slaag deze vraag over",
                                                     "4e antwoord");   
        break;
        
       case 15: 
             
             objTriviaVraag.VragenVeranderen("Hoe heet de Directeur van S.H.I.E.L.D in "+"\n"+"The Avengers?",
                                                    "Nick Missouri",
                                                    "Nick Murrey",
                                                    "Nick Shirley",
                                                    "Nick Fury",
                                                     "4e antwoord");   
        break;
        
       case 16: 
             
             objTriviaVraag.VragenVeranderen("Wat was de werktitel van"+"\n"+"Star Wars: Return of The Jedi?",
                                                    "Space fight",
                                                    "Blue Harvest",
                                                    "Laser Swordfight Extreme",
                                                    "Space Balls",
                                                     "2e antwoord");   
        break;
        
        
       case 17: 
             
             objTriviaVraag.VragenVeranderen("In welke Saw film zaagt men effectief iets af?",
                                                    "Saw I",
                                                    "Saw II",
                                                    "Saw III",
                                                    "Het gebeurt nooit",
                                                     "1e antwoord");   
        break;
        
       case 18: 
             
             objTriviaVraag.VragenVeranderen("Wat is de Cornetto Trilogy?",
                                                    "3 Britse films met"+"\n"+"3 verschillende cornetto's",
                                                    "De 3 slechtste"+"\n"+"Italiaanse westerns",
                                                    "De 3 meligste Spaanse"+"\n"+"romantische films",
                                                    "Dat bestaat niet!",
                                                     "1e antwoord");   
        break;
        
       case 19: 
             
             objTriviaVraag.VragenVeranderen("In Eurotrip, wat was de nationaliteit van de in"+"\n"+"buitenland wonende crush?",
                                                    "Brits",
                                                    "Belgisch",
                                                    "Frans",
                                                    "Nederlands",
                                                     "4e antwoord");   
        break;
        
       case 20: 
             
             objTriviaVraag.VragenVeranderen("In Harry Potter and The Deathly Hallows, wie"+"\n"+"sterft er niet?",
                                                    "Dobby",
                                                    "Dumbledore",
                                                    "Hedwig",
                                                    "George Weasley",
                                                     "4e antwoord");   
        break;
        
       case 21: 
             
             objTriviaVraag.VragenVeranderen("Wat voor taart werd er misbruikt in American Pie?",
                                                    "Appeltaart",
                                                    "Bosbessentaart",
                                                    "Kersentaart",
                                                    "Rabarbertaart",
                                                     "1e antwoord");   
        break;
        
       case 22: 
             
             objTriviaVraag.VragenVeranderen("Welk dier valt op dramatische wijze in een klif in"+"\n"+"Ace Ventura Natura Calls?",
                                                    "Stokstaartje",
                                                    "Fret",
                                                    "Capucijnaapje",
                                                    "Wasbeer",
                                                     "1e antwoord");   
        break;
        
       case 23: 
             
             objTriviaVraag.VragenVeranderen("Welk videogame personage verschijnt niet in"+"\n"+"Wreck It Ralph?",
                                                    "Sonic",
                                                    "Mario",
                                                    "Bowser",
                                                    "Pacman",
                                                     "2e antwoord");   
        break;
        
       case 24: 
             
             objTriviaVraag.VragenVeranderen("Wat was de naam van de gravin in The Curse of"+"\n"+"The Were-rabbit?",
                                                    "Lady Tottington",
                                                    "Lady Tête de Carotte",
                                                    "Lady Bakeswell",
                                                    "Lady Thingers",
                                                     "1e antwoord");   
        break;
        
       case 25: 
             
             objTriviaVraag.VragenVeranderen("Waar halen de Na'vi uit Avatar hun levenskracht van?",
                                                    "De Boom des Tijds",
                                                    "De Boom der Leven",
                                                    "De Boom der Wijsheid",
                                                    "De Boom der Zielen",
                                                     "4e antwoord");   
        break;

       case 26: 
             
             objTriviaVraag.VragenVeranderen("Welke basketballster speelt de hoofdrol in Space Jam?",
                                                    "Trent Tucker",
                                                    "John Paxson",
                                                    "Micheal Jordan",
                                                    "Corey Williams",
                                                     "3e antwoord");   
        break;
     }
     
//     switch(goedeAntwoorden)
//     {
//         case 1:
//             spriteCinefiel.changePosition();
//             break;
//     }
     }
    
    public void checkVooruitgang() //zou de doorloop of stilstaan van de positiearray moeten verzorgen
    {
    //Sprites, wanneer een antwoord gegeven is, wordt het spelbord getoond
         System.out.println("CHECKING VOORUITGANG");
         
//     objTriviaVraag.triviaVraag.setVisible(false);
//     objTriviaVraag.triviaAntw1.setVisible(false);
//     objTriviaVraag.triviaAntw2.setVisible(false);
//     objTriviaVraag.triviaAntw3.setVisible(false);
//     objTriviaVraag.triviaAntw4.setVisible(false);

     
     if(antwoordGegeven==true)
     {
     System.out.println("Er is een antwoord gegeven!");

               
     if(goedAntwoord==true) //wanneer het antwoord juist is, wordt de volgende positie sprite ge-add
     {
     System.out.println("Er is een JUIST antwoord gegeven");    
     
     System.out.println("DE VORIGE SPRITE POS WAS NR: "+goedeAntwoorden);

     //SpriteCinefiel
     switch(goedeAntwoorden)
     {     
         case 0:
             spriteCinefielIm.MoveImage(eersteXPos, eersteYPos - 75);
             break;

         case 1:
             spriteCinefielIm.MoveImage(eersteXPos - 55, eersteYPos - 75);
             break;

         case 2:
             spriteCinefielIm.MoveImage(eersteXPos - 110, eersteYPos - 75);
             break;

         case 3:
             spriteCinefielIm.MoveImage(eersteXPos - 175, eersteYPos - 75);
             break;

         case 4:
             spriteCinefielIm.MoveImage(eersteXPos - 230, eersteYPos - 75);
             break;

         case 5:
             spriteCinefielIm.MoveImage(eersteXPos - 220, eersteYPos - 145);
             break;

         case 6:
             spriteCinefielIm.MoveImage(eersteXPos - 165, eersteYPos - 145);
             break;

         case 7:
             spriteCinefielIm.MoveImage(eersteXPos - 110, eersteYPos - 145);
             break;

         case 8:
             spriteCinefielIm.MoveImage(eersteXPos -95, eersteYPos - 145);
             break;

         case 9:
             spriteCinefielIm.MoveImage(eersteXPos +10, eersteYPos - 145);
             break;

         case 10:
             spriteCinefielIm.MoveImage(eersteXPos + 75, eersteYPos - 145);
             break;

         case 11:
             spriteCinefielIm.MoveImage(eersteXPos + 130, eersteYPos - 145);
             break;

         case 12:
             spriteCinefielIm.MoveImage(eersteXPos + 195, eersteYPos - 145);
             break;

         case 13:
             spriteCinefielIm.MoveImage(eersteXPos + 215, eersteYPos - 210);
             break;

         case 14:
             spriteCinefielIm.MoveImage(eersteXPos + 155, eersteYPos - 210);
             break;

         case 15:
             spriteCinefielIm.MoveImage(eersteXPos + 95, eersteYPos - 210);
             break;

         case 16:
             spriteCinefielIm.MoveImage(eersteXPos + 35, eersteYPos - 210);
             break;

         case 17:
             spriteCinefielIm.MoveImage(eersteXPos, eersteYPos - 250);
             break;

         case 18:
             spriteCinefielIm.MoveImage(eersteXPos, eersteYPos - 330);
             break;

         case 19:
             spriteCinefielIm.MoveImage(eersteXPos+2, eersteYPos - 400);
             break;
         }

     goedeAntwoorden++;     
     //aantalBeurten++; //voor wanneer de security sprite wordt geactiveerd (na 3 beurten)
     
     System.out.println("DE HUIDIGE SPRITE POS IS NU NR: "+goedeAntwoorden);
     scene.repaint();
          
     goedAntwoord = false;
     }
     
     else if(goedAntwoord ==false) //wanneer het antwoord fout is, wordt de huidige positie sprite gehouden (geen goedeAntwoorden++)
     {
     System.out.println("Er is een FOUT antwoord gegeven");
     
     //aantalBeurten++; //voor wanneer de security sprite wordt geactiveerd (na 3 beurten)
     }
     
       
     antwoordGegeven=false;
     }
     
     else if(antwoordGegeven=false)
     {
              try{
     Thread.sleep(1000);
     }
     catch(InterruptedException ex){
     Thread.currentThread().interrupt();
     }
     objTriviaVraag.triviaVraag.setVisible(true);
     objTriviaVraag.triviaAntw1.setVisible(true);
     objTriviaVraag.triviaAntw2.setVisible(true);
     objTriviaVraag.triviaAntw3.setVisible(true);
     objTriviaVraag.triviaAntw4.setVisible(true);
     }
    }
}

