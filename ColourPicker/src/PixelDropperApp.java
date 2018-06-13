import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PixelDropperApp {

    Color color;

    public static void main (String[] args) {

        // Get the logger for "org.jnativehook" and set the level to warning.
        Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
        logger.setLevel(Level.WARNING);

        // Don't forget to disable the parent handlers.
        logger.setUseParentHandlers(false);

        try {
            GlobalScreen.registerNativeHook();
        }
        catch (NativeHookException ex) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());

            System.exit(1);
        }

        // Construct the example object.
        PixelDropper example = new PixelDropper();

        // Add the appropriate listeners.
        GlobalScreen.addNativeMouseListener(example);

        while (example.button != 2) System.out.print("");

        Color pixColor = PixelDropper.getPixelColor(example);

        System.out.println(pixColor.getRGB());

        int[] rgbColor = PixelDropper.convertToArray(pixColor);

        for (int i = 0; i < 3; i++) {

            System.out.println(rgbColor[i]);

        }

        System.exit(1);

    }

}
