package info5100.numberrecognizor.model;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.paint.Color;

public class ImageProcessor  {

    public static float[][] convertImageToFloatArray(Image image) {
        int width = (int) image.getWidth();
        int height = (int) image.getHeight();
        PixelReader pixelReader = image.getPixelReader();

        float[][] imageData = new float[height][width];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Color color = pixelReader.getColor(x, y);
                float grayScale = (float) ((color.getRed() + color.getGreen() + color.getBlue()) / 3.0);
                imageData[y][x] = grayScale;
            }
        }
        return imageData;
    }
}

