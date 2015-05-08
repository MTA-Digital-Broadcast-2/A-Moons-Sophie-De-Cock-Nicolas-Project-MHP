package hellotvxlet;

import javax.tv.xlet.*;
import org.dvb.ui.*;
import java.awt.*;
import java.awt.event.*;
import org.havi.ui.event.*;
import org.havi.ui.*;

public class SolidColorComponent extends HComponent {
    int xPos;
    int yPos;
    int width;
    int height;
    
   public int r,b,opacity;

    public SolidColorComponent(){
        
        xPos = 0;
        yPos = 0;
        width = 1000;
        height = 1000;
        r=255;
        b=0;
        opacity=255;
        this.setBounds(xPos,yPos,width,height);
    }
    
        public SolidColorComponent(int mR, int mB, int mOpacity){
        
        xPos = 0;
        yPos = 0;
        width = 1000;
        height = 1000;
        r= mR;
        b=mB;
        opacity=mOpacity;
        this.setBounds(xPos,yPos,width,height);
    }
    
    public void paint(Graphics g){        
        g.setColor(new DVBColor(r,0,b,opacity));
        g.fillRect(0,0,width,height);
        g.setColor(Color.white);
    }
}