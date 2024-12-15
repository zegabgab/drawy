package com.gmail.gabrielkorherr;

import javax.imageio.*;
import java.awt.image.*;
import java.io.*;

public class Picture {
    private static final int ALPHA = 1 << (8 * 3);
    private static final int RED = 1 << (8 * 2);
    private static final int GREEN = 1 << 8;
    private static final int BLUE = 1;

    public static void save(String path) {
        var image = getImage();

        try {
            ImageIO.write(image, "png", new File(path));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    @SuppressWarnings("NumericOverflow")
    private static BufferedImage getImage() {
        var image = new BufferedImage(420, 69, BufferedImage.TYPE_4BYTE_ABGR);
        for (int i = 0; i < 420; i++) {
            for (int j = 0; j < 69; j++) {
                image.setRGB(i, j, ALPHA * 255 + RED * 100 + GREEN + BLUE * 120);
            }
        }

        return image;
    }
}
