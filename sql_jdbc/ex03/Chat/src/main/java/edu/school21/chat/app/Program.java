package edu.school21.chat.app;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.*;
import edu.school21.chat.repositories.*;
import java.util.Optional;

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
            Optional<Message> msg = msgs.findById(2L);
            if (msg.isPresent())
            {
                Message message = msg.get();
                message.setText("ZHIGA RULIT2");
                msgs.update(message);
            }
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
