package hellotvxlet;


import javax.tv.xlet.*;
import org.dvb.ui.*;
import java.awt.*;
import java.awt.event.*;
import org.havi.ui.event.*;
import org.havi.ui.*;

public class Background extends HComponent {
    int xPos;
    int yPos;
    int width;
    int height;

    public Background(){
        
        xPos = 0;
        yPos = 0;
        width = 1000;
        height = 1000;
        this.setBounds(xPos,yPos,width,height);
    }
    
    public void paint(Graphics g){        
        g.setColor(new DVBColor(0,0,0,255));
        g.fillRect(0,0,width,height);
        g.setColor(Color.white);
    }
}
