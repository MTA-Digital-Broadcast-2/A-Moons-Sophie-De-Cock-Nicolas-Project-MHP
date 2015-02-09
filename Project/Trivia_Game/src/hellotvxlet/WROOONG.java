package hellotvxlet;


import javax.tv.xlet.*;
import org.dvb.ui.*;
import java.awt.*;
import java.awt.event.*;
import org.havi.ui.event.*;
import org.havi.ui.*;

public class WROOONG extends HComponent {
    int xPos;
    int yPos;
    int width;
    int height;

    public WROOONG(){
        
//        xPos = 0;
//        yPos = 0;
//        width = 1000;
//        height = 1000;
//        this.setBounds(xPos,yPos,width,height);
    }
    
    public void paint(Graphics g){   
        super.paint(g);
        g.setColor(new DVBColor(255,0,0,255));
        g.drawLine(100,350,300,350);
        //g.setColor(Color.white);
    }
}
