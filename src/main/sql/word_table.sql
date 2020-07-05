create table word (
    s1 varchar(255),
    s2 varchar(255),
    attribute varchar(255),
    pronunciation varchar(255),
    bookId int,
    userId int,
    id int auto_increment,
    foreign key (bookId) references book(id),
    foreign key (userId) references users(id),
    primary key (id)
)