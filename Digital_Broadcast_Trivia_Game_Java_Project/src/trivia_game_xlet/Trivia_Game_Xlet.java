package trivia_game_xlet;

import javax.tv.xlet.*;
import org.dvb.ui.*;
import java.awt.event.*;
import org.havi.ui.event.*;
import org.havi.ui.*;


public class Trivia_Game_Xlet implements Xlet, HActionListener {

    private XletContext actualXletcontext;
    private HScene scene;
    
    private boolean debug = true;
    
  
    public Trivia_Game_Xlet() { }

    public void initXlet(XletContext context) {
      if(debug){
        System.out.println("Xlet initialiseren");
      }
      this.actualXletcontext = context;
      HSceneTemplate sceneTemplate = new HSceneTemplate();
      
      sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_DIMENSION, new HScreenDimension(1.0f,1.0f), HSceneTemplate.REQUIRED);
      sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_LOCATION, new HScreenPoint(0.0f,0.0f), HSceneTemplate.REQUIRED);
      // kan nog veranderd worden (het zen mor afmetingen)
      scene = HSceneFactory.getInstance().getBestScene(sceneTemplate);
    }

    public void startXlet() {
        if(debug){
            System.out.println("Xlet starten");
        }
        scene.validate();
        scene.setVisible(true);
    }

    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) {
     
    }
    
    public void actionPerformed(ActionEvent e){
        System.out.println(e.getActionCommand());
                
    }
    
}

