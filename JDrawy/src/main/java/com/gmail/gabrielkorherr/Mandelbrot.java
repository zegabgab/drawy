package com.gmail.gabrielkorherr;

import java.util.stream.*;

public class Mandelbrot {
    private record Iteration(Complex current, int count) {
    }

    public static FractalResult contains(Complex number, int maxIterations) {
        assert maxIterations >= 0;

        return Stream.iterate(Complex.ZERO,
                        previous -> previous.times(previous).plus(number))
                .limit(maxIterations)
                .filter(iteration -> !iteration.isWithin(2))
                .findFirst()
                .map(_ -> (FractalResult) new FractalResult.Outside(howFar(number, maxIterations)))
                .orElse(FractalResult.INSIDE);
    }

    private static int howFar(Complex number, int maxIterations) {
        return Stream.iterate(new Iteration(Complex.ZERO, 0),
                previous ->
                        new Iteration(
                                previous.current.times(previous.current).plus(number),
                                previous.count + 1))
                .filter(iteration -> !iteration.current.isWithin(1000))
                .findFirst()
                .map(Iteration::count)
                .orElse(maxIterations);
    }
}
