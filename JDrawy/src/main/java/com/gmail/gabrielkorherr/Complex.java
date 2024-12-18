package com.gmail.gabrielkorherr;

/**
 * A complex number
 * @param real the real part
 * @param imag the imaginary part
 */
public record Complex(double real, double imag) {
    public static final Complex ZERO = new Complex(0, 0);
    public static final Complex ONE = new Complex(1, 0);
    public static final Complex I = new Complex(0, 1);

    public Complex negative() {
        return new Complex(-real, -imag);
    }

    public Complex conjugate() {
        return new Complex(real, -imag);
    }

    public Complex plus(Complex other) {
        return new Complex(real + other.real, imag + other.imag);
    }

    public Complex times(Complex other) {
        return new Complex(real * other.real - imag * other.imag, real * other.imag + imag * other.real);
    }

    public boolean isWithin(double absolute) {
        return real * real + imag * imag <= absolute;
    }
}
