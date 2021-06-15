package edu.school21.chat.models;

import java.util.List;

public class User {
    private Long id;
    private String login;
    private String password;
    private List<Chatroom> createdRooms;
    private List<Chatroom> rooms;
    User() {}
    @Override
    public int hashCode()
    {
        int result = login.hashCode();
        result = 31 * result + id.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + createdRooms.hashCode();
        result = 31 * result + rooms.hashCode();
        return result;
    }
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (id == other.id && login.equals(other.login) && password.equals(other.password)
                && createdRooms.equals(other.createdRooms) && rooms.equals(other.rooms))
            return true;
        return false;
    }
    @Override
    public String toString()
    {
        String result = "id=" + id + ", login=" + login +
                ", password=" + password + ", createdRooms=" + createdRooms + ", rooms=" + rooms;
        return result;
    }
}
