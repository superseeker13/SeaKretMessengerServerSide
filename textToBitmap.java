import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import javax.imageio.*;
import java.io.File;
import java.io.IOException;

//convert text from string to bitmap
public class textToBitmap {

    public static void textToBitmap(String text, String fileName){
        //create a File Object
        File newFile = new File("./" + fileName + ".bmp");

        //create the font you wish to use
        Font font = new Font("TimesNewRoman", Font.PLAIN, 11);

        //create the FontRenderContext object which helps us to measure the text size
        FontRenderContext frc = new FontRenderContext(null, true, true);

        //get the height and width of the text
        Rectangle2D bounds = font.getStringBounds(convertString, frc);
        int w = (int) bounds.getWidth();
        int h = (int) bounds.getHeight();

        //create a BufferedImage object
        BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);

        //calling createGraphics() to get the Graphics2D
        Graphics2D g = image.createGraphics();

        //set color and other parameters
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, w, h);
        g.setColor(Color.BLACK);
        g.setFont(font);
        g.drawString(convertString, (float) bounds.getX(), (float) -bounds.getY());

        //releasing resources
        g.dispose();

        //creating the file
        try{
			ImageIO.write(image, "bmp", newFile);
			System.out.println("Complete:" + newFile);
        }
        catch(IOException e){
			ystem.out.println("Shits broke yo" + newFile);
        }
    }
}
