package edu.school21.chat.app;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Message;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.util.Optional;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        HikariConfig conf = new HikariConfig();
        conf.setJdbcUrl("jdbc:postgresql://localhost:5432/db_chat");
        conf.setUsername("postgres");
        conf.setPassword("1");
        try
        {
            HikariDataSource ds = new HikariDataSource(conf);
            MessagesRepository msgs = new MessagesRepositoryJdbcImpl(ds);
            Scanner input = new Scanner(System.in);
            System.out.println("Enter a message ID");
            String userInput = input.nextLine();
            while (userInput != null && userInput.equals("42") != true) {
                Optional<Message> foundMsg = msgs.findById(Long.parseLong(userInput));
                if (foundMsg.isPresent()) {
                    System.out.println("Message : {");
                    System.out.println(foundMsg.get());
                    System.out.println("}");
                } else
                    System.out.println("Message has been not found");
                userInput = input.nextLine();
            }
            ds.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
            System.out.printf("FAIL");
        }
    }
}
