drop table post;
drop table post_suggest;
drop table post_type;
drop table users;
drop SEQUENCE post_seq;

create table post_type (
    post_type_idx number(2) not null,
    post_type varchar2(50) not null,
    constraint post_type_pk primary key (post_type_idx)
);

insert into post_type values (1, 'free');
insert into post_type values (2, 'suggest');

create table post (
    post_idx number(4) not null,
    post_type_idx number default 1,
    title varchar2(50) not null,
    contents varchar2(4000) not null,
    nickname varchar2(50) not null,
    password varchar2(50) not null,
    imgurl varchar2(50) not null,
    regdate date default sysdate,
    modifydate date default null,
    viewcount number(4) default 0,
    likecount number(4) default 0,
    replycount number(4) default 0,
    hatecount number(4) default 0,
    constraint post_fk foreign key (post_type_idx) references post_type (post_type_idx),
    constraint post_pk primary key (post_idx)
);

CREATE SEQUENCE post_seq;

create table post_suggest (
    post_type_idx number not null,
    post_idx number not null,
    youtube_url varchar2(1000) not null,
    song_title varchar2(50) not null,
    singer varchar2(50) not null,
    constraint post_suggest_fk1 foreign key (post_idx) references post (post_idx),
    constraint post_suggest_fk2 foreign key (post_type_idx) references post_type (post_type_idx)
);

create table users (
    user_idx number(4) not null,
    user_id varchar2(50) not null,
    user_pw varchar2(50) not null,
    user_nickname varchar2(50) not null,
    user_img varchar2(200) not null,
    joindate date default sysdate,
    constraint user_pk primary key (user_idx)
);



select * from post order by idx desc;

insert into post (idx, title, singer, contents, nickname, password) values (post_seq.nextval, '1', '2', '3', '4', '5');

update post set viewcount = viewcount+1 where idx = 3;

commit;