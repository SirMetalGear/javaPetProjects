package edu.school21.impl;

import edu.school21.models.Printer;
import edu.school21.models.Renderer;

public class PrinterWithPrefixImpl implements Printer {
    private boolean standartOutput;
    private boolean toUpper;
    private String prefix;
    public PrinterWithPrefixImpl(Renderer renderer)
    {
        this.standartOutput = renderer.isStandartOutput();
        this.toUpper = renderer.isToUpper();
        prefix = null;
    }
    public void setPrefix(String prefix)
    {
        this.prefix = prefix;
    }
    public void print(String text)
    {
        String result = prefix + " " + text;
        if (toUpper == true)
            result = result.toUpperCase();
        else
            result = result.toLowerCase();
        if (standartOutput == true)
            System.out.println(result);
        else
            System.err.println(result);
    }
}
