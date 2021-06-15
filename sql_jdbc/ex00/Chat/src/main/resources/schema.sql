CREATE DATABASE db_chat ENCODING 'UTF-8';

\c db_chat

CREATE TABLE users(
    id SERIAL PRIMARY KEY,
    login VARCHAR NOT NULL,
    password VARCHAR NOT NULL
);

CREATE TABLE chatroom (
    id SERIAL PRIMARY KEY,
    room_name VARCHAR NOT NULL,
    owner_id integer references Users (id)
);

CREATE TABLE message (
    id SERIAL PRIMARY KEY,
    author_id integer references Users (id),
    room_id integer references Chatroom (id),
    msg_text VARCHAR NOT NULL,
    date_time date NOT NULL
);
