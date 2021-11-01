create table tbl_board(
	bid int not null auto_increment,
    subject varchar(200) not null,
    content text null,
    writer varchar(50) not null,
    regdate timestamp not null default now(),
    hit int default 0,
    primary key(bid)
);

insert into tbl_board(subject, content, writer) values("테스트 제목 입니다.", "안녕하세요!!!", "홍길동");

select * from tbl_board;




SELECT * FROM spring_prj.tbl_board;

select count(*) from tbl_board;

-- limit가 0페이지는 첫페이지 0부터 10개  ==> limit 0,10
-- limit가 1페이지는 두번째페이지 10부터 10개  ==> limit 10,10
-- limit가 2페이지는 세번째페이지 20부터 10개   ==> limit 20,10
select * from tbl_board where bid > 0 order by bid desc limit 0, 10;

-- 현재 테이블의 컬럼을 복사해서 그대로 붙여넣기때문에 2배씩 증가한다.
insert into tbl_board(subject, content, writer) (select subject, content, writer from tbl_board);

-- 댓글 테이블
create table reply(
	rebid int not null auto_increment,
    bid int not null default 0,
    replyContent varchar(1000) not null,
    replyer varchar(50) not null,
    regdate timestamp not null default now(),
    udatedate timestamp not null default now(),
    primary key(rebid)
);

alter table reply add constraint fk_bid foreign key(bid) references tbl_board(bid);

select * from reply;