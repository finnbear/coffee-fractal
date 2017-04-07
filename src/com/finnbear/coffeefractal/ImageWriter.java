package com.finnbear.coffeefractal;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * © 2017 Finn Bear All Rights Reserved
 */

public class ImageWriter {
    BufferedImage _bufferedImage = null;

    public ImageWriter(int width, int height) {
        _bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    }

    public void writePixel(int x, int y, int r, int g, int b) {
        int rgb = (r << 16) | (g << 8) | b;

        writePixel(x, y, rgb);
    }

    public void writePixel(int x, int y, int rgb) {
        _bufferedImage.setRGB(x, y, rgb);
    }

    public boolean saveImage(String name, String extension) {
        File file = new File(name);

        try {
            ImageIO.write(_bufferedImage, extension, file);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
