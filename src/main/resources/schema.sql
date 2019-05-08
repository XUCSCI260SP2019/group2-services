create table if not exists event(
    id int auto_increment primary key,
    name varchar(255),
    startTime int,
    requestor varchar(255),
    roomNumber int,
    isConfirmed boolean
);