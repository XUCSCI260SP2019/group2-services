CREATE TABLE user (
    user_id int primary key,
    user_name varchar(500),
    password varchar(50)
);

CREATE TABLE alter (
    room_number int primary key,

);

CREATE TABLE event (
    event_id int primary key,
    event_name varchar(500),
    start_time int,
    end_time int,
    room_number int,
);

CREATE TABLE schedule (
    user_id int primary key,
    event_id int,
    event_name varchar(500),
    room_number int,
);

INSERT into ALTER VALUES(101);
INSERT into EVENT VALUES(1,'test event',8,9,101);
INSERT into EVENT VALUES(2,'test event',10,11,101);
INSERT into EVENT VALUES(3,'test event3',11,12,101);
INSERT into USER VALUES(000647468,'tyler', 'trst');