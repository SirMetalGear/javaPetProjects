package edu.school21.printer.app;
import edu.school21.printer.logic.*;

public class Program {
    public static void main(String[] args) {
        if (args.length != 2 || args[0].length() != 2)
        {
            System.out.println("Wrong arguments");
            System.exit(-1);
        }
        try
        {
            getBMP bmp = new getBMP(args[0], args[1]);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.exit(-1);
        }
    }
}
