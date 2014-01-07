package tests;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class ImageTest {
    public static void main(String[] args){
         	ImageFrame frame = new ImageFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            while(true) {
            	try {Thread.sleep(500);} catch (InterruptedException e) {}
            	frame.repaint(); 
        	}


            }
}

class ImageFrame extends JFrame{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ImageFrame(){
        setTitle("ImageTest");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        ImageComponent component = new ImageComponent();
        add(component);

    }

    public static final int DEFAULT_WIDTH = 300;
    public static final int DEFAULT_HEIGHT = 200;
}


class ImageComponent extends JComponent{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Image image;
    private BufferedImage backgroundImage;
    public ImageComponent(){
        try{
            File image2 = new File("image/Kenny.png");
            image = ImageIO.read(image2);
            File back = new File("image/back.jpeg");
            backgroundImage = ImageIO.read(back);

        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public void paintComponent (Graphics g){
        if(image == null) return;

        //g.drawImage(image, 0, 96, 0, 96, 0, 96, 0, 96, this);
        
        Random r = new Random();
        g.drawImage(backgroundImage, 0, 0, getWidth(),getHeight(), null);
        g.drawImage(image, r.nextInt(getWidth()-25), r.nextInt(getHeight()-25), this);
      

        /*for (int i = 0; i*imageWidth <= getWidth(); i++)
            for(int j = 0; j*imageHeight <= getHeight();j++)
                if(i+j>0) g.copyArea(0, 0, imageWidth, imageHeight, i*imageWidth, j*imageHeight);*/
    }

}