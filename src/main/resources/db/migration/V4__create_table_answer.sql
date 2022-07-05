create table answer(
    id bigint not null,
    message varchar(300) not null,
    created_date datetime not null,
    topic_id bigint not null,
    author_id bigint not null,
    solution int not null,
    primary key(id),
    foreign key(topic_id) references topic_question(id),
    foreign key(author_id) references person(id)
);