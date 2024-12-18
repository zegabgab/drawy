package com.gmail.gabrielkorherr;

public class Mandelbrot {
    public static boolean contains(Complex number, int maxIterations) {
        assert maxIterations >= 0;

        return contains(Complex.ZERO, number, maxIterations);
    }

    private static boolean contains(Complex current, Complex origin, int maxIterations) {
        return current.isWithin(2) &&
                (maxIterations <= 0 || contains(iterate(current, origin), origin, maxIterations - 1));
    }

    private static Complex iterate(Complex current, Complex origin) {
        return current.times(current).plus(origin);
    }
}
