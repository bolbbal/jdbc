create sequence music_seq;
CREATE SEQUENCE users_seq;
create sequence reply_seq;
create sequence singer_seq;
create sequence post_idx_seq;
create table post_type (
    post_type_idx number(2) not null,
    post_type varchar2(50) not null,
    constraint post_type_pk primary key (post_type_idx)
);

insert into post_type values (1, 'μιΪυ');
insert into post_type values (2, 'ͺͺ?ͺα');

create table users (
    user_idx number(4) not null,
    user_id varchar2(50) not null unique,
    user_pw varchar2(500) not null,
    user_nickname varchar2(50) not null unique,
    user_email varchar2(100) not null unique,
    user_img varchar2(200),
    joindate date default sysdate,
    constraint user_pk primary key (user_idx)
);

create table post (
    post_idx number(4) not null,
    post_type_idx number default 1,
    title varchar2(50) not null,
    contents varchar2(4000) not null,
    user_idx number(4), 
    nickname varchar2(50) not null,
    password varchar2(500) not null,
    imgurl varchar2(3000),
    regdate date default sysdate,
    modifydate date default null,
    viewcount number(4) default 0,
    likecount number(4) default 0,
    replycount number(4) default 0,
    constraint post_fk1 foreign key (post_type_idx) references post_type (post_type_idx),
    constraint post_fk2 foreign key (user_idx) references users (user_idx),
    constraint post_pk primary key (post_idx)
);

create table post_suggest (
    post_type_idx number default 2,
    post_idx number not null,
    youtube_url varchar2(1000) not null,
    thumnail varchar2(1000) not null,
    music varchar2(50) not null,
    singer varchar2(50) not null,
    lyrics varchar2(4000) not null,
    constraint post_suggest_fk1 foreign key (post_idx) references post (post_idx) on delete cascade,
    constraint post_suggest_fk2 foreign key (post_type_idx) references post_type (post_type_idx)
);

CREATE TABLE reply (
    reply_idx NUMBER NOT NULL,
    post_idx NUMBER NOT NULL,
    nickname VARCHAR2(50) NOT NULL,
    reply_password VARCHAR2(500) NOT NULL,
    comments VARCHAR2(4000) NOT NULL,
    regdate DATE DEFAULT SYSDATE,
    modifydate DATE DEFAULT NULL,
    user_idx number,
    CONSTRAINT reply_pk PRIMARY KEY (reply_idx),
    CONSTRAINT reply_fk FOREIGN KEY (post_idx) REFERENCES post (post_idx) on delete cascade
);

create table singer (
    singer_idx number not null,
    singer varchar2(50) not null,
    singer_img varchar2(1000),
    suggest_count NUMBER DEFAULT 1 not null,
    constraint singer_pk primary key (singer_idx)
);

create table singer_post_relation (
    singer_idx number not null,
    post_idx number not null,
    constraint spr_pk primary key (singer_idx, post_idx),
    constraint spr_fk1 foreign key (singer_idx) references singer (singer_idx) on delete cascade,
    constraint spr_fk2 foreign key (post_idx) references post (post_idx) on delete cascade
);
   
CREATE TABLE music (
    post_idx NUMBER(4) NOT NULL,
    music_idx NUMBER NOT NULL,
    singer_idx NUMBER NOT NULL,
    music VARCHAR(50) NOT NULL,
    lyrics VARCHAR2(4000) NOT NULL,
    CONSTRAINT music_pk PRIMARY KEY (music_idx),
    CONSTRAINT music_fk1 FOREIGN KEY (singer_idx) REFERENCES singer (singer_idx) ON DELETE CASCADE,
    CONSTRAINT music_fk2 FOREIGN KEY (post_idx) REFERENCES post (post_idx) ON DELETE CASCADE
);

drop table music;
drop table singer;
select * from singer_post_relation;
select * from music;
select * from singer;
select * from post;
select * from post_suggest;
commit;

update singer set suggest_count = suggest_count - 1 where singer_idx = 5;

commit;
