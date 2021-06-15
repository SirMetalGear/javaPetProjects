INSERT INTO users (login, password) VALUES ('Mark2', 'asd');
INSERT INTO users (login, password) VALUES ('Supra', 'asd');
INSERT INTO users (login, password) VALUES ('Chaser', 'asd');
INSERT INTO users (login, password) VALUES ('Crown', 'asd');
INSERT INTO users (login, password) VALUES ('Cresta', 'asd');

INSERT INTO chatroom (room_name, owner_id) VALUES ('toyota_best', 1);
INSERT INTO chatroom (room_name, owner_id) VALUES ('toyota_super', 1);
INSERT INTO chatroom (room_name, owner_id) VALUES ('toyota_awesome', 1);
INSERT INTO chatroom (room_name, owner_id) VALUES ('drift', 3);
INSERT INTO chatroom (room_name, owner_id) VALUES ('drag', 3);

INSERT INTO message (author_id, room_id, msg_text, date_time) VALUES (1, 4, 'crypta ploha', current_date);
INSERT INTO message (author_id, room_id, msg_text, date_time) VALUES (2, 4, 'maining zlo', current_date);
INSERT INTO message (author_id, room_id, msg_text, date_time) VALUES (2, 2, 'hleb voda i zhizn horosha', current_date);
INSERT INTO message (author_id, room_id, msg_text, date_time) VALUES (2, 5, 'deneg net no vi derzhites', current_date);
INSERT INTO message (author_id, room_id, msg_text, date_time) VALUES (2, 3, 'kak tebe takoe melon mask', current_date);