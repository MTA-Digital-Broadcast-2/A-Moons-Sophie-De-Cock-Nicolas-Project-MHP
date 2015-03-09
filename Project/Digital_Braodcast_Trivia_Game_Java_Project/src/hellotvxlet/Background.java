/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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
    
   public int r,b,opacity;

    public Background(){
        
        xPos = 0;
        yPos = 0;
        width = 1000;
        height = 1000;
        r=255;
        b=0;
        opacity=255;
        this.setBounds(xPos,yPos,width,height);
    }
    
        public Background(int mR, int mB, int mOpacity){
        
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

/*RESTANT COMPONENT KLASSE WAAR IK IMAGES VAN PROBEERDE TE KRIJGEN
 //Doet feitelijk niks, is meer een testklasse om images te leren implementeren

public class MijnComponent extends HComponent//klasse HComponent overerven
{
    int width;
    int height;
    int x;
    int y;
    
    private Image bmap;
    private MediaTracker mtrack;
    
//Plaats en locatie instellen constructor
    public MijnComponent(String bitmapnaam, int h, int w, int xPos, int yPos)
    {
        bmap = this.getToolkit().getImage(bitmapnaam);
        mtrack = new MediaTracker(this);
        mtrack.addImage(bmap,0);
    
        height=h;
        width=w;
        x=xPos;
        y=yPos;
        
    try
    {
    mtrack.waitForAll();
    }
    catch(Exception e)
    {
    System.out.println(e.toString());
    }
    this.setBounds(x,y,bmap.getWidth(null),bmap.getWidth(null));
    }
    
    //Paint methode overschrijven
    public void paint(Graphics g)
    {
    java.awt.Image imgjpeg = this.getToolkit().getImage("gordijn.jpeg"); //marcheert ni //ben er nu mee bezig
    g.drawImage(bmap, 0,0,null);
    }
    
}
 */ 
