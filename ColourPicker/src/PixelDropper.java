import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseInputListener;

import java.awt.*;

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
    }

    public void nativeMouseDragged(NativeMouseEvent e) {
        //System.out.println("Mouse Dragged: " + e.getX() + ", " + e.getY());
    }

    public static Color getPixelColor (PixelDropper dropper) {

        Color pixelColor = null;

        try {

            Robot r = new Robot();
            pixelColor = r.getPixelColor(dropper.x,dropper.y);
            System.out.println(dropper.x);

        }
        catch (AWTException e ) {

            System.out.println(e);
            System.exit(1);
        }

        System.out.println(pixelColor.toString());

        return pixelColor;

    }

    public static int[] convertToArray (Color pixelColor) {

        int[] colorArray = {pixelColor.getRed(), pixelColor.getGreen(), pixelColor.getBlue()};

        //System.out.println(pixelColor.getRed());

        return colorArray;

    }

}
