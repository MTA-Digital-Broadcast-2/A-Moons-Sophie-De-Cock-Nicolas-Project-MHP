package hellotvxlet;

import javax.tv.xlet.*;
//Extra stap! Voor DVB Colors te gebruiken, heb je deze bibliotheek nodig import org.dvb.ui.*; //Bèta Stap 1: voor de grafische toestanden import org.havi.ui.*;

//voor de acties die je wilt uitvoeren
import org.havi.ui.event.*;
import java.awt.event.*;


public class HelloTVXlet implements Xlet, HActionListener //laatste is voor acties uit te voeren via knoppen and such { //Xlet context wordt hierin bewaard
    private XletContext actueleXletContext;

//initialiseer scene voor grafische elementen
    private HScene scene;
    //Bèta Stap 2: initialiseer tekstobject private HStaticText textLabel, textLabel2; //Omega Stap 1: initialiseer knopobject private HTextButton knopA, knopB, knopC, knopD;

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
     textLabel2=new HStaticText("Wat is de juiste term voor het beschrijven"+"\n"+"van de geur van de Amorphophallus Titanum?");

     //Bèta Stap 4: eigenschappen textLabel instellen
     textLabel.setLocation(160,30);
     textLabel.setSize(400,50);
     /*textLabel.setBackground(new DVBColor(255,255,255,179));
     textLabel.setBackgroundMode(HVisible.BACKGROUND_FILL);*/

     textLabel2.setLocation(110,120);
     textLabel2.setSize(500,250);
     textLabel2.setForeground(new DVBColor(51,0,102,179)); //kan kleur tekst mee veranderen :D
     textLabel2.setBackground(new DVBColor(255,255,255,179));
     textLabel2.setBackgroundMode(HVisible.BACKGROUND_FILL);

     //Bèta Stap 5: textLabel aan de scene toevoegen
     scene.add(textLabel);
     scene.add(textLabel2);

     //Omega Stap 2: object aanmaken, eigenschappen instellen
     knopA=new HTextButton("Kak");
     knopA.setLocation(150,400);
     knopA.setSize(130,50);
     knopA.setBackground(new DVBColor(0,0,0,179));
     knopA.setBackgroundMode(HVisible.BACKGROUND_FILL);

     knopB=new HTextButton("Faeces");
     knopB.setLocation(450,400);
     knopB.setSize(130,50);
     knopB.setBackground(new DVBColor(0,0,0,179));
     knopB.setBackgroundMode(HVisible.BACKGROUND_FILL);

     knopC=new HTextButton("Ontlasting");
     knopC.setLocation(150,460);
     knopC.setSize(130,50);
     knopC.setBackground(new DVBColor(0,0,0,179));
     knopC.setBackgroundMode(HVisible.BACKGROUND_FILL);

     knopD=new HTextButton("Stront");
     knopD.setLocation(450,460);
     knopD.setSize(130,50);
     knopD.setBackground(new DVBColor(0,0,0,179));
     knopD.setBackgroundMode(HVisible.BACKGROUND_FILL);

     //Omega Stap 3: Navigeerbaar maken
     knopA.setFocusTraversal(null, knopC, null, knopB);
     knopB.setFocusTraversal(null, knopD, knopA, null);
     knopC.setFocusTraversal(knopA, null, null,knopD);
     knopD.setFocusTraversal(knopB,null,knopC,null);

     //Omega Stap 4: knop aan scene toevoegen
     scene.add(knopA);
     scene.add(knopB);
     scene.add(knopC);
     scene.add(knopD);

     //Omega Stap 5: beginfocus instellen 1 van de knoppen
     knopA.requestFocus();

    }

//Alfa Stap 2: Grafische methodes worden aangeroepen en reageert op input v.d gebruiker
    public void startXlet() throws XletStateChangeException
    {
    scene.validate();
    scene.setVisible(true);

     //Omega Stap 6: acties laten uitvoeren
     knopA.setActionCommand("knopA_actioned");
     knopB.setActionCommand("knopB_actioned");
     knopC.setActionCommand("knopC_actioned");
     knopD.setActionCommand("knopD_actioned");

     knopA.addHActionListener(this);
     knopB.addHActionListener(this);
     knopC.addHActionListener(this);
     knopD.addHActionListener(this);
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

    public void actionPerformed(ActionEvent e)
    {
    System.out.println(e.getActionCommand());

    if(e.getActionCommand()=="knopA_actioned")
    {
    knopA.setBackground(new DVBColor(255,0,0,179));
    }

    if(e.getActionCommand()=="knopB_actioned")
    {
    knopB.setBackground(new DVBColor(255,0,0,179));
    }

    if(e.getActionCommand()=="knopC_actioned")
    {
    knopC.setBackground(new DVBColor(255,0,0,179));
    }

    if(e.getActionCommand()=="knopD_actioned")
    {
    knopD.setBackground(new DVBColor(0,204,0,179));
    }
    }
}
