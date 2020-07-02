create table word (
    s1 varchar(255),
    s2 varchar(255),
    attribute varchar(255),
    pronunciation varchar(255),
    book_id int,
    id int auto_increment,
    foreign key (book_id) references book(id),
    primary key (id)
)