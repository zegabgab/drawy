package com.gmail.gabrielkorherr;

public class Mandelbrot {
    public static FractalResult contains(Complex number, int maxIterations) {
        assert maxIterations >= 0;
        var current = number;

        for (int i = 0; i < maxIterations; i++) {
            if (!current.isWithin(2)) {
                return new FractalResult.Outside(howFar(number, maxIterations));
            }

            current = iterate(current, number);
        }

        return new FractalResult.Inside();
    }

    private static int howFar(Complex number, int maxIterations) {
        var current = number;

        for (int i = 0; i < maxIterations; i++) {
            if (!current.isWithin(1000)) {
                return i;
            }

            current = iterate(current, number);
        }

        return maxIterations;
    }

    private static Complex iterate(Complex current, Complex origin) {
        return current.times(current).plus(origin);
    }
}
