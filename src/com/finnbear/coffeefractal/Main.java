package com.finnbear.coffeefractal;

/**
 * © 2017 Finn Bear All Rights Reserved
 */

public class Main {
    static final int width = 40000;
    static final int height = 40000;

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.startTimer();

        ImageWriter imageWriter = new ImageWriter(width, height);

        long pixels = width * height;

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                float color = getColor(x, y);

                color /= 25;
                color *= (255 << 16) | (255 << 8) | 255;

                imageWriter.writePixel(x, y, (int)color);
                //imageWriter.writePixel(x, y, 255, 255, 255);
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

    public static int getColor(int ix, int iy) {
        int maxIterations = 25;
        double bound = 2.0;

        double x = ix;
        double y = iy;

        x -= width / 2;
        y -= height / 2;

        x /= width / (bound * 2);
        y /= height / (bound * 2);

        double x0 = x;
        double y0 = y;

        for (int t = 0; t < maxIterations; t++) {
            if (Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)) > bound) {
                //return (255 << 16) | (255 << 8) | 255;
                return t;
            }

            double x1 = x;
            double y1 = y;

            x = x1 * x1 - y1 * y1;
            y = x1 * y1 + y1 * x1;

            x += x0;
            y += y0;
        }

        //return 0;
        return maxIterations;
    }
}
