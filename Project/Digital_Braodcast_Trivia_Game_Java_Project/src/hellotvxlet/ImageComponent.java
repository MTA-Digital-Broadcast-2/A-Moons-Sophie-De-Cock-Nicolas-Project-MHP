package hellotvxlet;

import org.havi.ui.*;
import java.awt.*;
import java.awt.Toolkit.*;

public class ImageComponent extends HComponent{

    private Image bitmap;
    private MediaTracker mtracker;
    //Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
    //double scWidth = screensize.width;
    //double scHeight = screensize.height;
    
    public ImageComponent (String bitmapName, int x, int y)
    {
    bitmap = this.getToolkit().getImage(bitmapName);
    mtracker = new MediaTracker(this);
    mtracker.addImage(bitmap,1);
    
    try
    {
    mtracker.waitForAll();
    }
    
    catch(Exception e)
    {
    System.out.println(e.toString());
    }
    //this.setBounds(x,y, (int)scWidth, (int)scHeight); //doubles geconverteerd naar int
    this.setBounds(x,y, bitmap.getWidth(this),bitmap.getHeight(this));
    }
    
    public ImageComponent (String bitmapName, int x, int y, int width, int height)
    {
    bitmap = this.getToolkit().getImage(bitmapName);
    mtracker = new MediaTracker(this);
    mtracker.addImage(bitmap,1);
    
    try
    {
    mtracker.waitForAll();
    }
    
    catch(Exception e)
    {
    System.out.println(e.toString());
    }
    this.setBounds(x,y,width,height);
    }
    
public void MoveImage (int x, int y)
{
this.setBounds(x,y,bitmap.getWidth(null),bitmap.getWidth(null));
}

public void paint (Graphics g)
{
g.drawImage(bitmap, 0, 0, null);
}


}

