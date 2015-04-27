package utilities;

import javax.swing.*;
import java.awt.*;

/**
 * Image manipulation utility class.
 *
 * @author heshamsalman
 */
public class ImageHelper {
    /**
     * Formats an image to be the size of the window.
     *
     * @param icon image to be reformatted
     * @return formatted icon
     */
    public static ImageIcon PrepareFullScreenImageIcon(ImageIcon icon) {
        double imageWidth = icon.getIconWidth();
        int imageHeight = icon.getIconHeight();
        imageWidth = 1280 / imageWidth;
        imageHeight = (int) (imageWidth * imageHeight);
        Image img = icon.getImage();
        return new ImageIcon(img.getScaledInstance(1280, imageHeight, Image.SCALE_SMOOTH));
    }
}
