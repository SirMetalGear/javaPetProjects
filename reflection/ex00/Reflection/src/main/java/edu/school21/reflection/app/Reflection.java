package edu.school21.reflection.app;

import java.lang.reflect.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Reflection {
    Scanner in;
    public Reflection() {
        this.in = new Scanner(System.in);
    }
    public List<String> getClassesNames()
    {
        List<String> files = new ArrayList<>();
        try (Stream<Path> paths = Files.walk(Paths.get(System.getProperty("user.dir")))) {
            files = paths
                    .filter(Files::isRegularFile)
                    .filter(p -> p.getFileName().toString().endsWith(".java"))
                    .filter(p -> !p.getFileName().toString().equals("Program.java"))
                    .filter(p -> !p.getFileName().toString().equals("Reflection.java"))
                    .map(Objects::toString)
                    .collect(Collectors.toList());
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
        for (int i = 0; i < files.size(); i++) {
            String file = files.get(i);
            file = file.replace(System.getProperty("user.dir") + "/src/main/java/", "");
            file = file.replace("/", ".");
            file = file.replace(".java", "");
            files.set(i, file);
        }
        return files;
    }
    public List<String> ShowClassesAndReturnSimpleNames(List<String> files)
    {
        List<String> classSimpleName = new ArrayList<>();
        System.out.println("Classes:");
        for (String file : files)
        {
            String[] classSegments = file.split("\\.");
            classSimpleName.add(classSegments[classSegments.length - 1]);
            System.out.println("  - " + classSegments[classSegments.length - 1]);
        }
        return classSimpleName;
    }
    public List<String> ShowAndReturnFields(Object newclass) {
        List<String> fieldNames = new ArrayList<>();
        Field[] fields = newclass.getClass().getDeclaredFields();
        System.out.println("fields:");
        for (int i = 0; i < fields.length; i++) {
            System.out.print("        " + fields[i].getType().getSimpleName());
            System.out.println(" " + fields[i].getName());
            fieldNames.add(fields[i].getName());
        }
        return fieldNames;
    }
    public List<String> ShowAndReturnMethods(Object newclass)
    {
        List<String> methodNames = new ArrayList<>();
        Method[] methods = newclass.getClass().getDeclaredMethods();
        System.out.println("methods:");
        for (int i = 0; i < methods.length; i++)
        {
            if (methods[i].getParameterCount() != 0) {
                String parameters = methods[i].getName() + "(";
                for (int j = 0; j < methods[i].getParameterCount(); j++)
                {
                    parameters += methods[i].getParameterTypes()[j].getSimpleName();
                    if (j + 1 != methods[i].getParameterCount())
                        parameters += ", ";
                }
                parameters += ")";
                methodNames.add(parameters);
                System.out.println("        " +
                        methods[i].getReturnType().getSimpleName() + " " + parameters);
            }
        }
        return methodNames;
    }
    public Object CreateNewObjectWithParameters(List<String> fields, Object newclass) throws Exception {
        System.out.println("Let's create an object.");
        List<Object> userInputParams = new ArrayList<>();
        Class[] params = newclass.getClass().getDeclaredConstructors()[1].getParameterTypes();
        for (int i = 0; i < fields.size(); i++)
        {
            System.out.println(fields.get(i) + ":");
            boolean isCorrectInput = false;
            while (!isCorrectInput)
            {
                Object userInput = params[i].getDeclaredConstructor(String.class).newInstance(in.nextLine());
                if (userInput != "")
                    isCorrectInput = true;
                userInputParams.add(userInput);
            }
        }
        for (int i = 0; i < 3; i++)
            System.out.println(userInputParams.get(i));
        Object myClass = newclass.getClass().getDeclaredConstructor(params)
                .newInstance(userInputParams.get(0), userInputParams.get(1), userInputParams.get(2));
        System.out.println("Object created: " + myClass);
        return myClass;
    }
    public void UpdateObject(Object newObject, List<String> fields)
    {
        boolean isCorrectInput = false;
        while (!isCorrectInput)
        {
            System.out.println("Enter name of the field for changing:");
            String userInput = in.nextLine();
            for (int i = 0; i < fields.size(); i++) {
                if (fields.get(i).equals(userInput)) {
                    isCorrectInput = true;
                    String SimpleName = fields.get(i).split("\\(")[0];
                    try
                    {
                        Field field = newObject.getClass().getDeclaredField(SimpleName);
                        System.out.println("Enter " + field.getType().getSimpleName() + " value:");
                        Object userUpdateInput = field.getType().getDeclaredConstructor(String.class).newInstance(in.nextLine());
                        field.setAccessible(true);
                        field.set(newObject, userUpdateInput);
                    }
                    catch (Exception e)
                    {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
        System.out.println("Object updated: " + newObject);
    }
    public Object MethodCall(Object newObject)
    {
        boolean isCorrectInput = false;
        Object result = null;
        while (!isCorrectInput)
        {
            Method[] methods = newObject.getClass().getDeclaredMethods();
            System.out.println("Available methods: ");
            for (int i = 0; i < methods.length; i++)
                if (methods[i].getParameterCount() != 0)
                    System.out.println(methods[i].getName());
            System.out.println("Enter name of the method for call:");
            String userInput = in.nextLine();
            for (Method method : methods) {
                if (method.getName().equals(userInput) && method.getParameterCount() != 0) {
                    isCorrectInput = true;
                    try
                    {
                        System.out.println("Enter " + method.getParameterTypes()[0].getSimpleName() + " value:");
                        Object userChangeInput = method
                                .getReturnType()
                                .getDeclaredConstructor(String.class)
                                .newInstance(in.nextLine());
                        result = method.invoke(newObject, userChangeInput);
                    }
                    catch (Exception e)
                    {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
        System.out.println("Object after method call: " + newObject);
        return result;
    }
    public Object getNewInstance(String className)
    {
        try
        {
            Object newclass = Class.forName(className).newInstance();
            return newclass;
        }
        catch (Exception e)
        {
            return null;
        }
    }
    public String getUserChoiceClass(List<String> classSimpleNames, List<String> files)
    {
        String userInput = "";
        boolean isCorrectInput = false;
        while (!isCorrectInput)
        {
            System.out.println("Enter class name:");
            userInput = in.nextLine();
            for (int i = 0; i < classSimpleNames.size(); i++) {
                if (classSimpleNames.get(i).equals(userInput)) {
                    isCorrectInput = true;
                    userInput = files.get(i);
                }
            }
        }
        return userInput;
    }
}
