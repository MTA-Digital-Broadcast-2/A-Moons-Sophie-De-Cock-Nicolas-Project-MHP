package hellotvxlet;

import javax.tv.xlet.*;
import java.awt.*; //voor paint
import org.havi.ui.*;
//Voor DVB Colors te gebruiken, heb je deze bibliotheek nodig
import org.dvb.ui.*;
/**
 *
 * @author student
 */
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
    java.awt.Image imgjpeg = this.getToolkit().getImage("triviaImages/dickbutt.jpg"); //marcheert ni
    g.drawImage(bmap, 0,0,null);
    }
    
}
