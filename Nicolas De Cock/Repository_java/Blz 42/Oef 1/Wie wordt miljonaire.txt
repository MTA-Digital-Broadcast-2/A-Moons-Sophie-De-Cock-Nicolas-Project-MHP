package hellotvxlet;

import javax.tv.xlet.*;
import org.dvb.ui.*;
import java.awt.event.*;
import org.havi.ui.event.*;
import org.havi.ui.*;


public class HelloTVXlet implements Xlet, HActionListener {

    private XletContext actualXletcontext;
    private HScene scene;
    
    private boolean debug = true;
    
    private HStaticText tekstLabel;
    private HTextButton knop1,knop2,knop3,knop4,knopHulpLijn;
    private int juisteAntwoord = 2;
  
    public HelloTVXlet() { }

    public void initXlet(XletContext context) {
      if(debug){
        System.out.println("Xlet initialiseren");
      }
      this.actualXletcontext = context;
      HSceneTemplate sceneTemplate = new HSceneTemplate();
      
      sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_DIMENSION, new HScreenDimension(1.0f,1.0f), HSceneTemplate.REQUIRED);
      sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_LOCATION, new HScreenPoint(0.0f,0.0f), HSceneTemplate.REQUIRED);
      
      scene = HSceneFactory.getInstance().getBestScene(sceneTemplate);
      
      tekstLabel = new HStaticText("Wordt een Miljonaire.. \n Wat is het antwoord op de vraag?");
      
      tekstLabel.setLocation(100,100);
      tekstLabel.setSize(400,250);
      tekstLabel.setForeground(new DVBColor(100,100,100,255));
      tekstLabel.setBackground(new DVBColor(255,255,255,179));
      tekstLabel.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
      knop1 = new HTextButton("Antwoord 1");
      knop1.setLocation(100,100);
      knop1.setSize(160,40);
      knop1.setBackground(new DVBColor(0,0,0,179));
      knop1.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
      knop2 = new HTextButton("Antwoord 2");
      knop2.setLocation(100,310);
      knop2.setSize(160,40);
      knop2.setBackground(new DVBColor(0,0,0,179));
      knop2.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
      knop3 = new HTextButton("Antwoord 3");
      knop3.setLocation(340,100);
      knop3.setSize(160,40);
      knop3.setBackground(new DVBColor(0,0,0,179));
      knop3.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
      knop4 = new HTextButton("Antwoord 4");
      knop4.setLocation(340,310);
      knop4.setSize(160,40);
      knop4.setBackground(new DVBColor(0,0,0,179));
      knop4.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
      knopHulpLijn = new HTextButton("Hulplijn");
      knopHulpLijn.setLocation(220,400);
      knopHulpLijn.setSize(160,40);
      knopHulpLijn.setBackground(new DVBColor(0,0,0,179));
      knopHulpLijn.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
      knop1.setFocusTraversal(null, knop2, null, knop3);
      knop2.setFocusTraversal(knop1, knopHulpLijn, null, knop4);
      knop3.setFocusTraversal(null, knop4, knop1, null);
      knop4.setFocusTraversal(knop3, knopHulpLijn, knop2, null);
      knopHulpLijn.setFocusTraversal(knop2, null, null, null);
      
      scene.add(tekstLabel);
      scene.add(knop1);
      scene.add(knop2);
      scene.add(knop3);
      scene.add(knop4);
      scene.add(knopHulpLijn);
      
      knop1.requestFocus();
    }

    public void startXlet() {
        if(debug){
            System.out.println("Xlet starten");
        }
        scene.validate();
        scene.setVisible(true);
        
        knop1.setActionCommand("knop1_actioned");
        knop2.setActionCommand("knop2_actioned");
        knop3.setActionCommand("knop3_actioned");
        knop4.setActionCommand("knop4_actioned");
        knopHulpLijn.setActionCommand("knopHulpLijn_actioned");
        
        knop1.addHActionListener(this);
        knop2.addHActionListener(this);
        knop3.addHActionListener(this);
        knop4.addHActionListener(this);
        knopHulpLijn.addHActionListener(this);
    }

    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) {
     
    }
    
    public void actionPerformed(ActionEvent e){
        System.out.println(e.getActionCommand());
        if(e.getActionCommand() == "knop1_actioned")
        {
            knop2.setBackground(new DVBColor(0,0,0,179));
            knop3.setBackground(new DVBColor(0,0,0,179));
            knop4.setBackground(new DVBColor(0,0,0,179));
            
            knop1.setBackground(new DVBColor(255,0,0,255));
        }
                
        if(e.getActionCommand() == "knop2_actioned")
        {
            knop1.setBackground(new DVBColor(0,0,0,179));
            knop3.setBackground(new DVBColor(0,0,0,179));
            knop4.setBackground(new DVBColor(0,0,0,179));
            
            knop2.setBackground(new DVBColor(0,255,0,255));
            knop2.setForeground(new DVBColor(0,0,0,255));
        }
        
        if(e.getActionCommand() == "knop3_actioned")
        {
            knop1.setBackground(new DVBColor(0,0,0,179));
            knop2.setBackground(new DVBColor(0,0,0,179));
            knop4.setBackground(new DVBColor(0,0,0,179));
            
            knop3.setBackground(new DVBColor(255,0,0,255));
        }
        
        if(e.getActionCommand() == "knop4_actioned")
        {
            knop1.setBackground(new DVBColor(0,0,0,179));
            knop2.setBackground(new DVBColor(0,0,0,179));
            knop3.setBackground(new DVBColor(0,0,0,179));
            
            knop4.setBackground(new DVBColor(255,0,0,255));
        }
        
        if(e.getActionCommand() == "knopHulpLijn_actioned")
        {
            knop1.setVisible(false);
            knop3.setVisible(false);
            knopHulpLijn.setBackground(new DVBColor(0,0,0,60));
        }
        
    }
    
}

