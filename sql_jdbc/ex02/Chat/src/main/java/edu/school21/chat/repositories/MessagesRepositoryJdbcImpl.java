package edu.school21.chat.repositories;

import edu.school21.chat.app.NotSavedSubEntityException;
import edu.school21.chat.models.*;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository {
    DataSource db;
    public MessagesRepositoryJdbcImpl(DataSource db) {
        this.db = db;
    }
    private User getUser(Connection connect, Long user_id) throws SQLException
    {
        PreparedStatement statement = connect.prepareStatement("SELECT * FROM users WHERE id = (?)");
        statement.setInt(1, user_id.intValue());
        final ResultSet resultSet = statement.executeQuery();
        if (resultSet.next())
        {
            String login = resultSet.getString(2);
            String password = resultSet.getString(3);
            return new User(user_id, login, password,null, null);
        }
        return null;
    }
    private Chatroom getRoom(Connection connect, Long room_id) throws SQLException
    {
        PreparedStatement statement = connect.prepareStatement("SELECT * FROM chatroom WHERE id = (?)");
        statement.setInt(1, room_id.intValue());
        final ResultSet resultSet = statement.executeQuery();
        if (resultSet.next())
        {
            String room_name = resultSet.getString(2);
            Chatroom newRoom = new Chatroom(room_id, room_name, null, null);
            return newRoom;
        }
        return null;
    }

    public Optional<Message> findById(Long id)
    {
        try {
            Connection connect = db.getConnection();
            try (PreparedStatement statement = connect.prepareStatement("SELECT * FROM message WHERE id = (?)")) {
                statement.setInt(1, id.intValue());
                final ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    Long msg_id = resultSet.getLong(1);
                    Long author_id = resultSet.getLong(2);
                    Long room_id = resultSet.getLong(3);
                    String msg_text = resultSet.getString(4);
                    Date date_time = resultSet.getDate(5);
                    return Optional.of(new Message(msg_id, getUser(connect, author_id),
                                getRoom(connect, room_id), msg_text, date_time));
                } else
                    return Optional.empty();
            }
            finally {
                connect.close();
            }
        }
        catch (SQLException e) {
            return Optional.empty();
        }
    }
    private boolean getUserBool(Connection connect, Long user_id) throws SQLException
    {
        PreparedStatement statement = connect.prepareStatement("SELECT * FROM users WHERE id = (?)");
        statement.setInt(1, user_id.intValue());
        final ResultSet resultSet = statement.executeQuery();
        if (resultSet.next())
        {
            return true;
        }
        return false;
    }
    private boolean getRoomBool(Connection connect, Long room_id) throws SQLException
    {
        PreparedStatement statement = connect.prepareStatement("SELECT * FROM chatroom WHERE id = (?)");
        statement.setInt(1, room_id.intValue());
        final ResultSet resultSet = statement.executeQuery();
        if (resultSet.next())
        {
            return true;
        }
        return false;
    }

    public void save(Message message)
    {
        try (Connection connect = db.getConnection()) {
            if (message.getAuthor() == null || !getUserBool(connect, message.getAuthor().getId()))
                throw new NotSavedSubEntityException();
            Chatroom room;
            if (message.getRoom() == null || !getRoomBool(connect, message.getRoom().getId()))
                throw new NotSavedSubEntityException();
            PreparedStatement statement = connect.prepareStatement(
                    "INSERT INTO message (id, author_id, room_id, msg_text, date_time) " +
                            "VALUES (DEFAULT, (?), (?), (?), (?)) RETURNING id");
            statement.setLong(1, message.getAuthor().getId());
            statement.setLong(2, message.getRoom().getId());
            statement.setString(3, message.getText());
            statement.setDate(4, message.getDateTime());
            ResultSet rs = statement.executeQuery();
            rs.next();
            message.setId(rs.getLong(1));
            System.out.println(message);
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
}