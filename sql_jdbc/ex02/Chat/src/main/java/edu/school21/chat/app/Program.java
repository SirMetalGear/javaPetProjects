package edu.school21.chat.app;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.*;
import edu.school21.chat.repositories.*;
import java.util.ArrayList;
import java.util.Calendar;

public class Program {
    public static void main(String[] args) {
        HikariConfig conf = new HikariConfig();
        conf.setJdbcUrl("jdbc:postgresql://localhost:5432/db_chat");
        conf.setUsername("postgres");
        conf.setPassword("1");
        HikariDataSource ds = null;
        try
        {
            ds = new HikariDataSource(conf);
            MessagesRepository msgs = new MessagesRepositoryJdbcImpl(ds);
            User creator = new User(1L, "user", "user",
                    new ArrayList<Chatroom>(), new ArrayList<Chatroom>());
            User author = creator;
            Chatroom room = new Chatroom(2L, "room", creator, new ArrayList<Message>());
            Message message = new Message(null, author, room, "Hello!",
                    new java.sql.Date(Calendar.getInstance().getTime().getTime()));
            msgs.save(message);
            ds.close();
        }
        catch(Exception e)
        {
            ds.close();
            System.out.println(e);
            System.out.printf("FAIL");
        }
    }
}
