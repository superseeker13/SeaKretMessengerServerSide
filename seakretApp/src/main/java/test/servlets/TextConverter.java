package test.servlets;

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
public class TextConverter {
//should be bmp, jpeg, or png
    private final String fileType;
    public final int WHITE = 16777215;
    public final int BLUE = 255;
    private final int BLACK = 0;

    public TextConverter(String type){
        fileType = type;
    }

    private void drawBox(BufferedImage img, int h, int w, int offsetX, int offsetY){

        int color = WHITE; // RGBA value, each component in a byte
        //Iterates through pixels, setting color based on x,y coords
        //Start at the offset, got until you have drawn 10 a line 10 percent of the overall width

        if(offsetX > w/80){
            for(int i = 0; i < offsetX - (w/80) && offsetX < 5*(w/80) ; i++){
                for(int j = 0; j < h; j++){
                    img.setRGB(i,j, color);
                }
            }
        }
        for(int xPos = offsetX; xPos < offsetX + 4*(w/80) && xPos < w; xPos++){
            //Start at the offset and go until a vertical line has been draw with the same number of pixels
            //as 10 percent of the width
            for(int yPos = offsetY; yPos < offsetY + 3*(h/30) && yPos < h; yPos++){
                img.setRGB(xPos,yPos, color);
            }//end for       
        }//end for
    }//end drawbox

    public void toImage(String message, String saveLocation) throws IOException {
        File directory = new File("/opt/bitnami/apache-tomcat/logs/Users/"  + saveLocation);
        if (! directory.exists()){
            directory.mkdir();
            System.out.println("Anything?\n");
            // If you require it to make the entire directory path including parents,
            // use directory.mkdirs(); here instead.
        }

        //String to convert
        String convertString = message;

        //Image file name
        String fileName = "baseImage";

        //create a File Object
        File newFile = new File("/opt/bitnami/apache-tomcat/logs/Users/"    + saveLocation + "/" + fileName + "." + fileType);

        //create the font you wish to use
        Font font = new Font("TimesNewRoman", Font.PLAIN, 48);

        //create the FontRendrContext object which helps us to measure the text size
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
        	ImageIO.write(image, fileType, newFile);
        	System.out.println("Complete:" + newFile);
        }
        catch(IOException e){
        	System.out.println("You done goofed: " + "redrawn");
        }

        //Make draw calls in a loop, adjust offset by index of loop counter as a fraction multiplier
        for(int j = 0; j < 5; j++){
            BufferedImage img = ImageIO.read(new File("/opt/bitnami/apache-tomcat/logs/Users/" + saveLocation + "/baseImage." + fileType));
            //every iteration skip 3 increments vertically
            for(int y = 0; y + (h/30) <= h; y += 3*(h/30)){
                //every iteration skip 5 increments horizontally
                for(int x = 0 + j*(w/80); x + (w/80) <= w; x += 5*(w/80)){
                    drawBox(img, h, w, x, y);
                }
            }

            try{
                ImageIO.write(img, "jpeg", new File("/opt/bitnami/apache-tomcat/logs/Users/" + saveLocation + "/redrawn" + j + "." + fileType));
                System.out.println("Complete:" + "redrawn" + j + "." + fileType);
            }
            catch(IOException e){
                System.out.println("You done goofed: " + "redrawn" + j + "." + fileType);
            }
        }
        
        String[] args = new String[]{"python","makeGif.py", "/opt/bitnami/apache-tomcat/logs/Users/" + saveLocation};

        Runtime app = Runtime.getRuntime();
        Process prg = app.exec(args);
    }

    public void scrubFiles(String username){
        String path = "/opt/bitnami/apache-tomcat/logs/Users/" + username;
        File dir = new File(path);
		
		if(dir.isDirectory() == false) {
			System.out.println("Not a directory. Do nothing");
			return;
		}
		File[] listFiles = dir.listFiles();
		for(File file : listFiles){
			System.out.println("Deleting "+file.getName());
			file.delete();
		}
		//now directory is empty, so we can delete it
		System.out.println("Deleting Directory. Success = "+dir.delete());
    }
}//end class
/*
from offset value to + w/60 dont draw, the from there draw to 4*(w/60);
*/