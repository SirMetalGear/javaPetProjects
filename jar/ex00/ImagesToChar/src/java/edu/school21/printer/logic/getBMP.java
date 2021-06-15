package edu.school21.printer.logic;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class getBMP {
    private char black;
    private char white;
    private BufferedImage image;
    public getBMP(String replace, String pathToBMP) throws IOException
    {
        white = replace.charAt(0);
        black = replace.charAt(1);
        File file = new File(pathToBMP);
        image = ImageIO.read(file);
        for (int y = 0; y < image.getHeight(); y++)
        {
            for (int x = 0; x < image.getWidth(); x++)
            {
                int color = image.getRGB(x, y);
                if (color == Color.BLACK.getRGB()) {
                    System.out.print(black);
                }
                else {
                    System.out.print(white);
                }
            }
            System.out.println();
        }
    }
}
