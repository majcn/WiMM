package si.fri.wimm.util;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.MemoryCacheImageOutputStream;

public class ResizeHelper {
	
	
	
	/**
	 * Resizes the source image to specified targetWidth and targetHeight. Method maintains the acpect ratio of image by croping the image
	 * @param source Source image to resize
	 * @param targetWidth Result image width in pixels
	 * @param targetHeight Result image height in pixels
	 * @return
	 * @throws ImageResizeException
	 */
	public static BufferedImage resizeAndCrop(BufferedImage source, int targetWidth, int targetHeight) throws ImageResizeException {
		BufferedImage result = null;

		if (source == null) {
			throw new ImageResizeException("Source file is not applicable.");
		}

		int sourceWidth = source.getWidth();
		int sourceHeight = source.getHeight();
		
		if (targetWidth <= 0) {
			throw new ImageResizeException("Invalid value for image targetWidth");
		} else if (targetHeight <= 0) {
			throw new ImageResizeException("Invalid value for image targetHeight");
		}
		
		float aspectRatio = (float) sourceHeight / (float) sourceWidth;
		
		// Use aspect ratio to determine final image size and
		// work back to determine which dimension to use when
		// resizing
		
		double scale;
		
		if ((targetHeight / aspectRatio) < targetWidth) {
			scale = (double) targetWidth / sourceWidth;
		} else {
			scale = (double) targetHeight / sourceHeight;
		}
		int aspectTargetWidth = (int) Math.rint(scale * sourceWidth);
		int aspectTargetHeight = (int) Math.rint(scale * sourceHeight);
		
		result=resize(source, aspectTargetWidth, aspectTargetHeight, RenderingHints.VALUE_INTERPOLATION_BILINEAR, true);
		
		// We know our new image matches one target dimension so
		// crop the overhanging part of the other dimension in equal
		// parts
		if (aspectTargetHeight > targetHeight) { // Chop the extra height
			int yOffset = (int) Math.rint((aspectTargetHeight - targetHeight) / 2);
			result = result.getSubimage(0, yOffset, targetWidth, targetHeight);
		} else if (aspectTargetWidth > targetWidth) { // Chop the extra width
			int xOffset = (int) Math.rint((aspectTargetWidth - targetWidth) / 2);
			result = result.getSubimage(xOffset, 0, targetWidth, targetHeight);
		}
		
		return result;
	}
	
	
	/**
     * Convenience method that returns a scaled instance of the
     * provided {@code BufferedImage}.
     *
     * @param img the original image to be scaled
     * @param targetWidth the desired width of the scaled instance,
     *    in pixels
     * @param targetHeight the desired height of the scaled instance,
     *    in pixels
     * @param hint one of the rendering hints that corresponds to
     *    {@code RenderingHints.KEY_INTERPOLATION} (e.g.
     *    {@code RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR},
     *    {@code RenderingHints.VALUE_INTERPOLATION_BILINEAR},
     *    {@code RenderingHints.VALUE_INTERPOLATION_BICUBIC})
     * @param higherQuality if true, this method will use a multi-step
     *    scaling technique that provides higher quality than the usual
     *    one-step technique (only useful in downscaling cases, where
     *    {@code targetWidth} or {@code targetHeight} is
     *    smaller than the original dimensions, and generally only when
     *    the {@code BILINEAR} hint is specified)
     * @return a scaled version of the original {@code BufferedImage}
     */
    public static BufferedImage resize(BufferedImage img,
                                           int targetWidth,
                                           int targetHeight,
                                           Object hint,
                                           boolean higherQuality)
    {
        int type = (img.getTransparency() == Transparency.OPAQUE) ?
            BufferedImage.TYPE_INT_RGB : BufferedImage.TYPE_INT_ARGB;
        BufferedImage ret = (BufferedImage)img;
        int w, h;
        
        //check if targetWidth or targetHeight is grater than original size and disable higherQuality
        if(higherQuality && (targetWidth>img.getWidth()|| targetHeight>img.getHeight()))
        	higherQuality=false;
        
        if (higherQuality) {
            // Use multi-step technique: start with original size, then
            // scale down in multiple passes with drawImage()
            // until the target size is reached
            w = img.getWidth();
            h = img.getHeight();
        } else {
            // Use one-step technique: scale directly from original
            // size to target size with a single drawImage() call
            w = targetWidth;
            h = targetHeight;
        }
        
        do {
            if (higherQuality && w > targetWidth) {
                w /= 2;
                if (w < targetWidth) {
                    w = targetWidth;
                }
            }

            if (higherQuality && h > targetHeight) {
                h /= 2;
                if (h < targetHeight) {
                    h = targetHeight;
                }
            }

            BufferedImage tmp = new BufferedImage(w, h, type);
            Graphics2D g2 = tmp.createGraphics();
            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, hint);
            g2.drawImage(ret, 0, 0, w, h, null);
            g2.dispose();

            ret = tmp;
        } while (w != targetWidth || h != targetHeight);

        return ret;
    }
    
    
    public static ByteArrayInputStream writeJPEGByteStream(BufferedImage input) throws IOException {
		Iterator<ImageWriter> iter = ImageIO.getImageWritersByFormatName("JPG");
		if (iter.hasNext()) {
			ImageWriter writer = (ImageWriter) iter.next();
			ImageWriteParam iwp = writer.getDefaultWriteParam();
			iwp.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
			iwp.setCompressionQuality(0.9f);

			ByteArrayOutputStream output = new ByteArrayOutputStream();
			MemoryCacheImageOutputStream imgOutput = new MemoryCacheImageOutputStream(output);

			writer.setOutput(imgOutput);
			IIOImage image = new IIOImage(input, null, null);
			writer.write(null, image, iwp);

			imgOutput.close();
			
			return new ByteArrayInputStream(output.toByteArray());
			
		}
		return null;
	}


	
    
    
}
