package edu.school21.reflection.app;

import java.util.*;

public class Program {
    public static void main(String[] args) {

        Reflection ref = new Reflection();
        List<String> files = ref.getClassesNames();
        if (files == null)
        {
            System.err.println("No classes has been found");
            System.exit(-1);
        }
        List<String> classSimpleNames = ref.ShowClassesAndReturnSimpleNames(files);
        System.out.println("---------------------");
        String userInput = ref.getUserChoiceClass(classSimpleNames, files);
        Object newclass = ref.getNewInstance(userInput);
        System.out.println("---------------------");
        List<String> fields = ref.ShowAndReturnFields(newclass);
        List<String> methods = ref.ShowAndReturnMethods(newclass);
        System.out.println("---------------------");
        Object newObject = null;
        try
        {
            newObject = ref.CreateNewObjectWithParameters(fields, newclass);
        }
        catch (Exception e)
        {
            System.out.println("FAIL");
            System.out.println(e.getMessage());
            System.exit(-1);
        }
        System.out.println("---------------------");
        ref.UpdateObject(newObject, fields);
        System.out.println("---------------------");
        Object returnValue = ref.MethodCall(newObject);
        System.out.println("Method returned:\n" + returnValue);
    }
}
