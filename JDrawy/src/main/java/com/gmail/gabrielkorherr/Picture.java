package com.gmail.gabrielkorherr;

import javax.imageio.*;
import java.awt.image.*;
import java.io.*;

public class Picture {
    public static void save(String path, int maxIterations) {
        var image = getImage(maxIterations);

        try {
            ImageIO.write(image, "png", new File(path));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private static BufferedImage getImage(int maxIterations) {
        final int insideColor = color(100, 0, 150, 255);

        final int width = 7680 / 4;
        final int height = 4320 / 4;
        final double upperBound = 3.0;

        var image = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                final var complex = fromPixelSpace(i, j, width, height, upperBound);
                final var color = switch (Mandelbrot.contains(complex, maxIterations)) {
                    case FractalResult.Inside _ -> insideColor;
                    case FractalResult.Outside(var iterations) -> outsideColor(iterations);
                };
                image.setRGB(i, j, color);
            }
        }

        return image;
    }

    private static int outsideColor(int iterations) {
        final int sensitivity = 10;
        iterations %= sensitivity * 2;
        final double ratio = (double) (iterations % sensitivity) / sensitivity;

        if (iterations >= sensitivity) {
            return color(0, (int) (200 * ratio) + 55, 0, 255);
        }

        return color((int) (200.0 * ratio), (int) (180.0 * ratio), 0, 255);
    }

    private static Complex fromPixelSpace(int x, int y, int width, int height, double upperBound) {
        final double rightBound = upperBound * width / height;
        final double realX = (x - ((double) width / 2)) * (rightBound / (double) width);
        final double realY = (y - ((double) height / 2)) * (upperBound / (double) height);

        return new Complex(realX, realY);
    }

    private static int color(int red, int green, int blue, int alpha) {
        return (alpha << 24) | (red << 16) | (green << 8) | blue;
    }
}
