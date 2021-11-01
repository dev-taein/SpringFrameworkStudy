create table tbl_member(
	uid varchar(50) not null,
    pwd varchar(50) not null,
    username varchar(50) not null,
    email varchar(100),
    regdate timestamp default now(),
    updateDate timestamp default now(),
    primary key(uid)
);

select * from tbl_member

