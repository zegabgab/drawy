package com.gmail.gabrielkorherr;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class MandelbrotTest {
    @Test
    public void zeroContained() {
        assertInstanceOf(FractalResult.Inside.class, Mandelbrot.contains(Complex.ZERO, 1000));
    }

    @Test
    public void negativeOneContained() {
        assertInstanceOf(FractalResult.Inside.class, Mandelbrot.contains(Complex.ONE.negative(), 1000));
    }

    @Test
    public void oneOutside() {
        assertInstanceOf(FractalResult.Outside.class, Mandelbrot.contains(Complex.ONE, 1000));
    }
}