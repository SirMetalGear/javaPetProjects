package edu.school21.printer.logic;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class getBMP {
    private BufferedImage image;
    public getBMP(String pathToBMP, ColoredPrint cp) throws IOException
    {
        File file = new File(pathToBMP);
        image = ImageIO.read(file);
        for (int y = 0; y < image.getHeight(); y++)
        {
            for (int x = 0; x < image.getWidth(); x++)
            {
                int color = image.getRGB(x, y);
                if (color == Color.BLACK.getRGB()) {
                    cp.print(0);
                }
                else {
                    cp.print(1);
                }
            }
            cp.print(3);
        }
    }
}
