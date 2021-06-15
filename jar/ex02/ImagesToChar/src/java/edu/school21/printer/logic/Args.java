package edu.school21.printer.logic;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

@Parameters(separators = "=")
public class Args {
    @Parameter(names = {"--white"})
    public String arg1;
    @Parameter(names = {"--black"})
    public String arg2;
    public void run()
    {
        System.out.println(arg1 + " " + arg2);
    }
}
