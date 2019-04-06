CREATE TABLE user (
    user_id int primary key,
    user_name varchar(500),
);

CREATE TABLE alter (
    room_number int primary key,

);

CREATE TABLE event (
    event_id int primary key,
    event_name varchar(500),
    start_time varchar(50),
    end_time varchar(50),
    room_number int,
);

CREATE TABLE schedule (
    user_id int primary key,
    event_id int,
    event_name varchar(500),
    room_number int,
);
