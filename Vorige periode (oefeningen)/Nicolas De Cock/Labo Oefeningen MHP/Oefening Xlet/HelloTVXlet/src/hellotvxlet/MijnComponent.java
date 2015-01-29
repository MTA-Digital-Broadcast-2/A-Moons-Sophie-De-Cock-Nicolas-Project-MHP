package hellotvxlet;


import javax.tv.xlet.*;
import org.dvb.ui.*;
import java.awt.*;
import java.awt.event.*;
import org.havi.ui.event.*;
import org.havi.ui.*;

public class MijnComponent extends HComponent {
    int xPos;
    int yPos;
    int width;
    int height;

    public MijnComponent(int initX,int initY,int initH,int initW){
        
        xPos = initX;
        yPos = initY;
        width = initW;
        height = initH;
        this.setBounds(xPos,yPos,width,height);
    }
    
    public void paint(Graphics g){
        g.setColor(new DVBColor(128,130,128,160));
        g.fillRoundRect(10,10,(width/2)+10,(height/2)+10,50,25);
        
        g.setColor(new DVBColor(30,144,255,255));
        g.fillRoundRect(0,0,width/2,height/2,50,25);
        g.setColor(Color.white);
        g.drawString("Keeewle text", 15, 25);
        
        
    }
}
