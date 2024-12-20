package com.gmail.gabrielkorherr;

public class Mandelbrot {
    public static FractalResult contains(Complex number, int maxIterations) {
        assert maxIterations >= 0;

        var origin = ComplexMut.fromComplex(number);
        var current = ComplexMut.fromComplex(number);

        for (int i = 0; i < maxIterations; i++) {
            if (current.isOutside(2)) {
                return new FractalResult.Outside(howFar(number, maxIterations));
            }

            iterate(current, origin);
        }

        return FractalResult.INSIDE;
    }

    private static int howFar(Complex number, int maxIterations) {
        var origin = ComplexMut.fromComplex(number);
        var current = ComplexMut.fromComplex(number);

        for (int i = 0; i < maxIterations; i++) {
            if (current.isOutside(500)) {
                return i;
            }

            iterate(current, origin);
        }

        return maxIterations;
    }

    private static void iterate(ComplexMut current, ComplexMut origin) {
        current.multiply(current).add(origin);
    }
}
