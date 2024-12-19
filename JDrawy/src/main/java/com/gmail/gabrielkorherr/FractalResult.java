package com.gmail.gabrielkorherr;

public sealed interface FractalResult permits FractalResult.Inside, FractalResult.Outside {
    record Inside() implements FractalResult {}

    record Outside(int iterations) implements FractalResult {}
}
