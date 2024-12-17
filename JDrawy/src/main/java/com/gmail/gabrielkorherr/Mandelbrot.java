package com.gmail.gabrielkorherr;

public class Mandelbrot {
    public static boolean isContained(Complex number, int maxIterations) {
        assert maxIterations >= 0;

        return isContained(Complex.ZERO, number, maxIterations);
    }

    private static boolean isContained(Complex current, Complex origin, int maxIterations) {
        return absWithin(current, 2) &&
                (maxIterations <= 0 || isContained(iterate(current, origin), origin, maxIterations - 1));
    }

    private static Complex iterate(Complex current, Complex origin) {
        return current.times(current).plus(origin);
    }

    private static boolean absWithin(Complex number, double boundary) {
        return number.real() * number.real() + number.imag() * number.imag() <= boundary * boundary;
    }
}
