package utilities;

import java.awt.Image;

import javax.swing.ImageIcon;

public class ImageHelper {

	public static ImageIcon PrepareFullScreenImageIcon(ImageIcon icon) {
		double imageWidth = icon.getIconWidth();
		int imageHeight = icon.getIconHeight();
		imageWidth = 1280/imageWidth;
		imageHeight = (int) (imageWidth * imageHeight);
		Image img = icon.getImage();
		return new ImageIcon(img.getScaledInstance(1280, imageHeight, Image.SCALE_SMOOTH));
	}
}
