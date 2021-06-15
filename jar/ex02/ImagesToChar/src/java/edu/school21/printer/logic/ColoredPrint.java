package edu.school21.printer.logic;

import com.diogonunes.jcdp.color.ColoredPrinter;
import com.diogonunes.jcdp.color.api.Ansi;

public class ColoredPrint {
    private ColoredPrinter white;
    private ColoredPrinter black;
    private ColoredPrinter none;
    public ColoredPrint(String whiteColor, String blackColor) {
        white = new ColoredPrinter.Builder(1, false)
                .foreground(Ansi.FColor.valueOf(whiteColor)).background(Ansi.BColor.valueOf(whiteColor)).build();
        black = new ColoredPrinter.Builder(1, false)
                .foreground(Ansi.FColor.valueOf(blackColor)).background(Ansi.BColor.valueOf(blackColor)).build();
        none = new ColoredPrinter.Builder(1, false)
                .foreground(Ansi.FColor.NONE).background(Ansi.BColor.NONE).build();
        none.clear();
    }
    public void print(int colorSwitch)
    {
        if (colorSwitch == 0)
            black.print(" ");
        else if (colorSwitch == 1)
            white.print(" ");
        else
            none.println("");
    }
}