package histogramas;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.File.*;
import java.io.IOException;
import java.awt.Graphics2D;


import javax.imageio.ImageIO;

public class ImageResize {

		public static void main(String[] args) {	
			File pngOriginal = new File("C:\\Users\\Pedro\\Desktop\\PNG_transparency_demonstration_1.png");
			File pngResized = new File("C:\\Users\\Pedro\\Desktop\\resized.png");
			resizeImage(pngOriginal, pngResized, 400, 300, "png");
		}
		
		private static void resizeImage(File originalImage, File resizeImage,int width, int height, String format) {
			try {
				BufferedImage original = ImageIO.read(originalImage);
				BufferedImage resized = new BufferedImage(width, height, original.getType());
				Graphics2D g2 = resized.createGraphics();
				g2.drawImage(original, 0, 0, width, height, null);
				g2.dispose();
				ImageIO.write(resized, format, resizeImage);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
}
