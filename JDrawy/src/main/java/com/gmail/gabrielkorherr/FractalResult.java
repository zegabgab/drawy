package com.gmail.gabrielkorherr;

public sealed interface FractalResult permits FractalResult.Inside, FractalResult.Outside {
    FractalResult INSIDE = new FractalResult.Inside();

    record Inside() implements FractalResult {}

    record Outside(int iterations) implements FractalResult {}
}
