package edu.school21.chat.models;

import java.util.List;

public class Chatroom {
    private Long id;
    private String name;
    private User owner;
    private List<Message> msgs;
    Chatroom() {}
    @Override
    public int hashCode()
    {
        int result = name.hashCode();
        result = 31 * result + id.hashCode();
        result = 31 * result + owner.hashCode();
        result = 31 * result + msgs.hashCode();
        return result;
    }
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Chatroom other = (Chatroom) obj;
        if (id == other.id && name.equals(other.name) && owner.equals(other.owner) && msgs.equals(other.msgs))
            return true;
        return false;
    }
    @Override
    public String toString()
    {
        String result = "id=" + id + ", name=" + name + ", owner=" + owner + ", messages=" + msgs;
        return result;
    }
}
