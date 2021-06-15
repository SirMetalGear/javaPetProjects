package edu.school21.chat.models;

import java.sql.Connection;
import java.util.Date;

public class Message {
    private Long id;
    private User author;
    private Chatroom room;
    private String text;
    private Date dateTime;
    private Connection db;
    public Message(Connection db, Long id, User author, Chatroom room, String text, Date dateTime) {
        this.id = id;
        this.author = author;
        this.room = room;
        this.text = text;
        this.dateTime = dateTime;
    }
    @Override
    public int hashCode()
    {
        int result = author.hashCode();
        result = 31 * result + id.hashCode();
        result = 31 * result + room.hashCode();
        result = 31 * result + text.hashCode();
        result = 31 * result + dateTime.hashCode();
        return result;
    }
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Message other = (Message) obj;
        if (id == other.id && author.equals(other.author) && room.equals(other.room)
                && text.equals(other.text) && dateTime.equals(other.dateTime))
            return true;
        return false;
    }
    @Override
    public String toString()
    {
        String result = "id=" + id + ",\nauthor={" + author +
                "},\nroom={" + room + "},\ntext=\"" + text + "\",\ndateTime=" + dateTime;
        return result;
    }
    public Long getId() { return id; }
}
