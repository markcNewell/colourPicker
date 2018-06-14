import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseInputListener;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PixelDropper implements NativeMouseInputListener {

    public int x;
    public int y;
    public int button;

    public void nativeMouseClicked(NativeMouseEvent e) {
        //System.out.println("Mouse Clicked: " + e.getClickCount());
        x = e.getX();
        y = e.getY();
        button = e.getButton();
    }

    public void nativeMousePressed(NativeMouseEvent e) {
        //System.out.println("Mouse Pressed: " + e.getButton());
    }

    public void nativeMouseReleased(NativeMouseEvent e) {
        //System.out.println("Mouse Released: " + e.getButton());
    }

    public void nativeMouseMoved(NativeMouseEvent e) {
        //System.out.println("Mouse Moved: " + e.getX() + ", " + e.getY());
        this.x = e.getX();
        this.y = e.getY();
    }

    public void nativeMouseDragged(NativeMouseEvent e) {
        //System.out.println("Mouse Dragged: " + e.getX() + ", " + e.getY());
    }

    public static Color getPixelColor (PixelDropper dropper) {

        Color pixelColor = null;
        //int posX = (int) Math.round(dropper.x/2.25);
        //int posY = (int) Math.round(dropper.y/2.25);

        try {

            //Robot r = new Robot();
            //pixelColor = r.getPixelColor(posX,posY);

            Robot r = new Robot();
            BufferedImage img = r.createScreenCapture(new Rectangle(dropper.x, dropper.y, 1, 1));
            pixelColor = new Color(img.getRGB(0, 0));

        }
        catch (AWTException e ) {

            System.out.println(e);
            System.exit(1);
        }

        return pixelColor;

    }

    public static int[] convertToArray (Color pixelColor) {

        int[] colorArray = {pixelColor.getRed(), pixelColor.getGreen(), pixelColor.getBlue()};

        return colorArray;

    }

}
