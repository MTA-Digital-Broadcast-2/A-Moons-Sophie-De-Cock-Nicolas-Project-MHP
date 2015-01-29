package hellotvxlet;

import javax.tv.xlet.*;
//Extra stap! Voor DVB Colors te gebruiken, heb je deze bibliotheek nodig import org.dvb.ui.*; //Bèta Stap 1: voor de grafische toestanden import org.havi.ui.*; //Aanpassen textsize en toestanden import java.awt.*;

public class HelloTVXlet implements Xlet { //Xlet context wordt hierin bewaard
    private XletContext actueleXletContext;

//initialiseer scene voor grafische elementen
    private HScene scene;
    //Bèta Stap 2: initialiseer tekstobject private HStaticText textLabel; //Omega Stap 1: initialiseer knopobject private HTextButton knopA, knopB;

    /*//constructor => feitelijk niet nodig
    public HelloTVXlet()
    {}*/

    //Alfa stap 1: initialiseer resources en variabelen
    public void initXlet(XletContext context)
    {
     this.actueleXletContext=context;

     //Template aanmaken
     HSceneTemplate sceneTemplate = new HSceneTemplate();

     //grootte scene aangeven
     sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_DIMENSION,new
HScreenDimension(1.0f, 1.0f), HSceneTemplate.REQUIRED);
     //positie scene aangeven
     sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_LOCATION,
new HScreenPoint(0.0f, 0.0f), HSceneTemplate.REQUIRED);

    //instantie Scene aanvragen aan de factory
     scene = HSceneFactory.getInstance().getBestScene(sceneTemplate);

     //Bèta Stap 3: object aanmaken
     textLabel=new HStaticText("Wordt Een Millionaire!");

     //Bèta Stap 4: eigenschappen textLabel instellen
     textLabel.setLocation(100,100);
     textLabel.setSize(400,250);
     textLabel.setBackground(new DVBColor(255,255,255,179));
     textLabel.setBackgroundMode(HVisible.BACKGROUND_FILL);

     //Bèta Stap 5: textLabel aan de scene toevoegen
     scene.add(textLabel);

     //Omega Stap 2: object aanmaken, eigenschappen instellen
     knopA=new HTextButton("BACK");
     knopA.setLocation(100,100);
     knopA.setSize(100,50);
     knopA.setBackground(new DVBColor(0,0,0,179));
     knopA.setBackgroundMode(HVisible.BACKGROUND_FILL);

     knopB=new HTextButton("FORWARD");
     knopB.setLocation(250,100);
     knopB.setSize(105,50);
     knopB.setBackground(new DVBColor(0,0,0,179));
     knopB.setBackgroundMode(HVisible.BACKGROUND_FILL);

     //Omega Stap 3: Navigeerbaar maken
     knopA.setFocusTraversal(null, null, null, knopB);
     knopB.setFocusTraversal(null, null, knopA, null);

     //Omega Stap 4: knop aan scene toevoegen
     scene.add(knopA);
     scene.add(knopB);

     //Omega Stap 5: beginfocus instellen 1 van de knoppen
     knopA.requestFocus();
    }

//Alfa Stap 2: Grafische methodes worden aangeroepen en reageert op input v.d gebruiker
    public void startXlet() throws XletStateChangeException
    {
    scene.validate();
    scene.setVisible(true);
    }

 //Alfa Stap 3: komt in rusttoestand en niet-benodigde resources kunnen worden vrijgegeven
    public void pauseXlet()
    {
     //(...)
    }

//Alfa Stap 4: beëindigen Xlet en vrijgeven gebruikte resources
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
}