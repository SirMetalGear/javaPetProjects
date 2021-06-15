package edu.school21.impl;

import edu.school21.models.Printer;
import edu.school21.models.Renderer;
import java.time.LocalDateTime;

public class PrinterWithDateTimeImpl implements Printer {
    private boolean standartOutput;
    private boolean toUpper;
    private LocalDateTime date;
    public PrinterWithDateTimeImpl(Renderer renderer)
    {
        this.standartOutput = renderer.isStandartOutput();
        this.toUpper = renderer.isToUpper();
        date = null;
    }
    public void setCurrentTime()
    {
        this.date = LocalDateTime.now();
    }
    public void print(String text)
    {
        String result = date + " " + text;
        if (toUpper == true)
            result.toUpperCase();
        else
            result.toLowerCase();
        if (standartOutput == true)
            System.out.println(result);
        else
            System.err.println(result);
    }
}
