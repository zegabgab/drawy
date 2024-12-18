package com.gmail.gabrielkorherr;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class MandelbrotTest {
    @Test
    public void zeroContained() {
        assertTrue(Mandelbrot.contains(Complex.ZERO, 1000));
    }

    @Test
    public void negativeOneContained() {
        assertTrue(Mandelbrot.contains(Complex.ONE.negative(), 1000));
    }

    @Test
    public void oneOutside() {
        assertFalse(Mandelbrot.contains(Complex.ONE, 1000));
    }
}