package com.gmail.gabrielkorherr;

@FunctionalInterface
public interface DrawOperation {
    void applyTo(Surface surface);
}
