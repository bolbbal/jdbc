create table post (
    idx number(4) not null primary key,
    title varchar2(50) not null,
    singer varchar2(50),
    contents varchar2(4000) not null,
    nickname varchar2(50) not null,
    password varchar2(50) not null,
    regdate date default sysdate,
    viewcount number(4) default 0,
    likecount number(4) default 0,
    replycount number(4) default 0
);

CREATE SEQUENCE post_seq;

select * from post order by idx desc;

alter table post add hatecount number(4) default 0;

insert into post (idx, title, singer, contents, nickname, password) values (post_seq.nextval, '1', '2', '3', '4', '5');

update post set viewcount = viewcount+1 where idx = 3;

commit;