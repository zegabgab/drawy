package com.gmail.gabrielkorherr;

/**
 * A mutable complex number. This exists purely for performance reasons.
 */
public class ComplexMut {
    private double real;
    private double imag;

    public ComplexMut(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public static ComplexMut fromComplex(Complex other) {
        return new ComplexMut(other.real(), other.imag());
    }

    public ComplexMut add(ComplexMut other) {
        real += other.real;
        imag += other.imag;

        return this;
    }

    public ComplexMut multiply(ComplexMut other) {
        var real = this.real * other.real - this.imag * other.imag;
        var imag = this.real * other.imag + this.imag * other.real;

        set(real, imag);

        return this;
    }

    public boolean isOutside(double absoluteValue) {
        return !(real * real + imag * imag <= absoluteValue * absoluteValue);
    }

    public void set(double real, double imag) {
        setReal(real);
        setImag(imag);
    }

    public void setReal(double real) {
        this.real = real;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }
}
