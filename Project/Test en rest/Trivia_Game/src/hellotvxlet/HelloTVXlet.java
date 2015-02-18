package hellotvxlet;

import javax.tv.xlet.*;
import org.dvb.ui.*;
import java.awt.event.*;
import org.havi.ui.event.*;
import org.havi.ui.*;
import java.lang.Thread;


public class HelloTVXlet implements Xlet, HActionListener {

    private XletContext actualXletcontext;
    private HScene scene;
    
    private boolean debug = true;
    
    private HStaticText vraag1;
    private HTextButton antwoord1,antwoord2,antwoord3,antwoord4;
//    private int juisteAntwoord = 2;
  
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
      
      
      vraag1 = new HStaticText("Wat is het antwoord op de vraag?");
      
      vraag1.setLocation(100,70);
      vraag1.setSize(350,100);
      vraag1.setForeground(new DVBColor(40,40,100,255));
      vraag1.setBackground(new DVBColor(255,255,255,255));
      vraag1.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
      antwoord1 = new HTextButton("Dit is misschien het antwoord");
      antwoord1.setLocation(102,200);
      antwoord1.setSize(347,50);
      antwoord1.setBackground(new DVBColor(100,210,70,255));
      antwoord1.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
      antwoord2 = new HTextButton("Dit is mogelijks het antwoord");
      antwoord2.setLocation(102,280);
      antwoord2.setSize(347,50);
      antwoord2.setBackground(new DVBColor(200,90,30,255));
      antwoord2.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
      antwoord3 = new HTextButton("Dit is zeker niet het antwoord");
      antwoord3.setLocation(102,360);
      antwoord3.setSize(347,50);
      antwoord3.setBackground(new DVBColor(100,40,170,255));
      antwoord3.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
      antwoord4 = new HTextButton("Dit is onwaarschijnlijk als antwoord");
      antwoord4.setLocation(102,440);
      antwoord4.setSize(347,50);
      antwoord4.setBackground(new DVBColor(100,90,140,255));
      antwoord4.setBackgroundMode(HVisible.BACKGROUND_FILL);
     
      
      antwoord1.setFocusTraversal(null, antwoord2, null, null);
      antwoord2.setFocusTraversal(antwoord1, antwoord3, null, null);
      antwoord3.setFocusTraversal(antwoord2, antwoord4, null, null);
      antwoord4.setFocusTraversal(antwoord3, null, null, null);
//      knop2.setFocusTraversal(knop1, knopHulpLijn, null, knop4);
      
//      MijnComponent mc = new MijnComponent(30,30,300,300);
      ColorBox cb = new ColorBox(100, 70, 450, 350);
      Background bg = new Background();
      //ColorBox cb2 = new ColorBox(100, 170, 350, 450);
      
      scene.add(antwoord1);
      scene.add(antwoord2);
      scene.add(antwoord3);
      scene.add(antwoord4);
      scene.add(vraag1);      
      scene.add(cb);
      scene.add(bg);
      //scene.add(cb2);
      
      
      antwoord1.requestFocus();
    }

    public void startXlet() {
        if(debug){
            System.out.println("Xlet starten");
        }
        scene.validate();
        scene.setVisible(true);
        
        antwoord1.setActionCommand("antwoord1_actioned");
        
       antwoord1.addHActionListener(this);
        
    }

    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) {
     
    }
    
    public void actionPerformed(ActionEvent e){
        System.out.println(e.getActionCommand());
        if(e.getActionCommand() == "antwoord1_actioned")
        {
            WROOONG wr = new WROOONG();
            scene.add(wr);
            
        }
                
//        if(e.getActionCommand() == "knop2_actioned")
//        {
//            
//        }     
    }
    
}

