create table book (
    id int auto_increment,
    name varchar(255),
    description varchar(255),
    star int,
    fork int,
    user_id int,
    is_public int,
    foreign key (user_id) references user(user_id),
    primary key (id)
)