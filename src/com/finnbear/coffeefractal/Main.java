package com.finnbear.coffeefractal;

/**
 * © 2017 Finn Bear All Rights Reserved
 */

public class Main {
    static final int width = 45000;
    static final int height = 45000;

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.startTimer();

        ImageWriter imageWriter = new ImageWriter(width, height);

        Fractal fractal = new Mandelbrot();

        long pixels = width * height;

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                double fx = x / (double)width;
                double fy = y / (double)height;

                double sample1 = fractal.sample(fx, fy, 200);
                double sample2 = fractal.sample(fx, fy, 100);
                double sample3 = fractal.sample(fx, fy, 25);

                int color1 = (int)(sample1 * 255) << 16;
                int color2 = (int)(sample2 * 255) << 8;
                int color3 = (int)(sample3 * 255) << 0;

                int color = color1 | color2 | color3;

                imageWriter.writePixel(x, y, color);
            }

            if (y % 1000 == 0) {
                int percent = Math.round((width * y) / (float) pixels * 100);

                System.out.println("Progress: " + percent + "%");
            }
        }

        imageWriter.saveImage("image.png", "png");

        long elapsedTime = timer.endTimer();

        System.out.println("Elapsed time: " + elapsedTime + "ms");
    }
}
