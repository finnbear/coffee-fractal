package com.finnbear.coffeefractal;

/**
 * © 2017 Finn Bear All Rights Reserved
 */
public class Mandelbrot extends Fractal {
    double _threshold = 2.0;

    public double sample(double x, double y, int iterations) {
        x -= 0.5;
        y -= 0.5;

        x *= _threshold * 2;
        y *= _threshold * 2;

        double x0 = x;
        double y0 = y;
        double thresholdSquared = Math.pow(_threshold, 2);

        for (int i = 0; i < iterations; i++) {
            if (x*x + y*y > thresholdSquared) {
                return i / (double)iterations;
            }

            double x1 = x;
            double y1 = y;

            x = x1 * x1 - y1 * y1 - 0.2278;
            y = x1 * y1 + y1 * x1 - 0.65;
        }

        return 1.0;
    }
}
