package hellotvxlet;


import javax.tv.xlet.*;
import org.dvb.ui.*;
import java.awt.*;
import java.awt.event.*;
import org.havi.ui.event.*;
import org.havi.ui.*;

public class ColorBox extends HComponent {
    int xPos;
    int yPos;
    int width;
    int height;

    public ColorBox(int initX,int initY,int initH,int initW){
        
        xPos = initX;
        yPos = initY;
        width = initW;
        height = initH;
        this.setBounds(xPos,yPos,width,height);
    }
    
    public void paint(Graphics g){        
        g.setColor(new DVBColor(30,144,255,255));
        g.fillRect(0,0,width,height);
        g.setColor(Color.white);
    }
}
