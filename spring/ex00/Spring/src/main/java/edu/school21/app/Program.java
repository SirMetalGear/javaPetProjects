package edu.school21.app;

import edu.school21.impl.PrinterWithPrefixImpl;
import edu.school21.models.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Program {
    public static void main(String[] args) {
            ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
            PrinterWithPrefixImpl printer = context.getBean("PrinterWithPrefixImpl", PrinterWithPrefixImpl.class);
            printer.setPrefix("asd");
            printer.print("Hello!");
        }
}
