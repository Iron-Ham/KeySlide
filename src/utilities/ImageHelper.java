package utilities;

import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * Image manipulation utility class.
 * @author heshamsalman
 *
 */
public class ImageHelper {
	/**
	 * Formats an image to be the size of the window.
	 * @param icon
	 * @return
	 */
	public static ImageIcon PrepareFullScreenImageIcon(ImageIcon icon) {
		double imageWidth = icon.getIconWidth();
		int imageHeight = icon.getIconHeight();
		imageWidth = 1280/imageWidth;
		imageHeight = (int) (imageWidth * imageHeight);
		Image img = icon.getImage();
		return new ImageIcon(img.getScaledInstance(1280, imageHeight, Image.SCALE_SMOOTH));
	}
}
