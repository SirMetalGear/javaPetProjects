package edu.school21.printer.app;

import edu.school21.printer.logic.*;
import com.beust.jcommander.*;

public class Program {
    public static void main(String[] args) {
        try {
            Args arguments = new Args();
            JCommander.newBuilder().addObject(arguments).build().parse(args);
            ColoredPrint cp = new ColoredPrint(arguments.arg1, arguments.arg2);
            getBMP bmp = new getBMP("./resources/image.bmp", cp);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
