create table mvc_bbs(
    bNo number(3) primary key,
    bName varchar2(20),
    bSubject varchar2(80),
    bContent varchar2(300),
    bDate date DEFAULT sysdate,
    bHit number(3) default 0,
    bGroup number(4),
    bStep number(4),
    bIndent number(4)
);

drop table mvc_bbs;

--시퀀스는 순서대로 번호를 만들어 준다. 주로 게시판 번호를 순차적으로 할당할 때 쓴다.
--BOARD_SEQ.NEXTVAL        -- 시퀀스 번호 추출
--BOARD_SEQ.CURRVAL        -- 현재 시퀀스 번호 확인
create SEQUENCE seq_bbs;

insert into mvc_bbs(bNo, bName, bSubject, bContent, bhit, bGroup, bStep, bIndent) 
            values (seq_bbs.nextval, 'test', 'test입니다', '안녕하세요', 0, seq_bbs.CURRVAL, 0, 0);
            
select * from mvc_bbs;    
