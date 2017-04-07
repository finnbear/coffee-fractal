package com.finnbear.coffeefractal;

/**
 * © 2017 Finn Bear All Rights Reserved
 */

public class Main {
    static final int width = 1000;
    static final int height = 1000;

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.startTimer();

        ImageWriter imageWriter = new ImageWriter(width, height);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                imageWriter.writePixel(x, y, 255, 255, 255);
            }
        }

        imageWriter.saveImage("image.png", "png");

        long elapsedTime = timer.endTimer();

        System.out.println("Elapsed time: " + elapsedTime + "ms");
    }
}
