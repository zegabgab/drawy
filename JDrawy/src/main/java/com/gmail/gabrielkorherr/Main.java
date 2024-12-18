package com.gmail.gabrielkorherr;

public class Main {
    public static void main(String[] args) {
        System.out.println("let's goo");
        Picture.save("mandelbrot.png", Integer.parseInt(args[0]));
    }
}