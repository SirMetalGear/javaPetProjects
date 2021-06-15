package edu.school21.chat.app;

import java.sql.*;

public class Program {
    public static void main(String[] args) {
        final String user = "postgres";
        final String password = "1";
        final String url = "jdbc:postgresql://localhost:5432/db_chat";
        try
        {
            Connection db = DriverManager.getConnection(url, user, password);
            System.out.println("SUCCESS");
            db.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
            System.out.printf("FAIL");
        }
    }
}
