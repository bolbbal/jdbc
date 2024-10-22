drop table post_suggest;
drop table post;
drop table post_type;
drop table users;
drop table music;
drop table singer;
drop sequence post_idx_seq;
drop sequence user_seq;
drop sequence reply_seq;
drop sequence music_seq;
drop sequence singer_seq;
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
select * from post p left outer join post_suggest ps on p.post_idx = ps.post_idx where p.post_idx = (select max(p.post_idx) from post p left outer JOIN post_suggest ps ON p.post_idx = ps.post_idx) or p.post_idx = (select max(p.post_idx) from post p left outer JOIN post_suggest ps ON p.post_idx = ps.post_idx where p.post_idx < (select max(post_idx) from post));
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
    constraint post_suggest_fk1 foreign key (post_idx) references post (post_idx),
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
    CONSTRAINT reply_pk PRIMARY KEY (reply_idx),
    CONSTRAINT reply_fk FOREIGN KEY (post_idx) REFERENCES post (post_idx)
);

create table singer (
    post_idx number(4) not null,
    singer_idx number not null,
    singer varchar2(50) not null,
    singer_img varchar2(1000),
    constraint singer_pk primary key (singer_idx),
    constraint singer_fk foreign key (post_idx) references post (post_idx)
);

alter table singer add suggest_count number default 1 not null;

create table music (
    post_idx number(4) not null,
    music_idx number not null,
    singer_idx number not null,
    music varchar(50) not null,
    lyrics varchar2(4000) not null,
    constraint music_pk primary key (music_idx),
    constraint music_fk1 foreign key (singer_idx) references singer (singer_idx),
    constraint music_fk2 foreign key (post_idx) references post (post_idx)
);
select * from reply;
select * 
from (select /*+ index_desc (post post_pk) */ rownum rn, post_idx, post_type_idx, title, contents, nickname, password, imgurl, regdate, modifydate, viewcount, likecount, replycount, hatecount
      from post 
      where rownum <= (1 * 5))
where rn > ((1-1) * 5);

SELECT *
FROM (SELECT /*+ index_desc(post post_pk) */ ROWNUM rn, p.post_idx, pt.post_type, p.title, p.contents, p.nickname, p.password, p.imgurl, p.regdate, p.modifydate, p.viewcount, p.likecount, p.replycount, p.hatecount
        FROM (SELECT p.*, pt.post_type
                FROM post p
                JOIN post_type pt ON p.post_type_idx = pt.post_type_idx
                ORDER BY p.post_idx desc)
    WHERE ROWNUM <= (1 * 5))
WHERE rn > ((1 - 1) * 5);

SELECT *
FROM (
    SELECT ROWNUM rn, p.post_idx, p.post_type, p.title, p.contents, p.nickname, p.password, p.imgurl, p.regdate, p.modifydate, p.viewcount, likecount, replycount, hatecount
    FROM (
        SELECT p.*, pt.*
        FROM post p
        JOIN post_type pt ON p.post_type_idx = pt.post_type_idx
        ORDER BY p.post_idx DESC
    ) p
    WHERE ROWNUM <= 5
)
WHERE rn > 0;

select * 
from (select /*+ index_desc (post post_pk) */ rownum rn, post_idx, post_type, title, contents, nickname, password, imgurl, regdate, modifydate, viewcount, likecount, replycount, hatecount, user_idx
		FROM (
            SELECT p.*, pt.*
            FROM post p
            JOIN post_type pt ON p.post_type_idx = pt.post_type_idx
            ORDER BY p.post_idx DESC
		) p
        where rownum <= 5
)
where rn > 0;

select * 
from (select /*+ index_desc (post post_pk) */ rownum rn, post_idx, title, contents, nickname, password, imgurl, regdate, modifydate, viewcount, likecount, replycount, hatecount, user_idx, youtube_url, music, singer, thumnail, lyrics
		FROM (
            SELECT p.*, ps.youtube_url, ps.thumnail, ps.music, ps.singer, ps.lyrics
            FROM post p
            JOIN post_suggest ps ON p.post_idx = ps.post_idx
		)
        where rownum <= 5
) 
where rn > 0;

select *
from (select /*+ index_desc (post post_pk) */ rownum rn, post_idx, title, contents, nickname, password, imgurl, regdate, modifydate, viewcount, likecount, replycount, hatecount, user_idx, youtube_url, music, singer, thumnail, lyrics;

select * from users where user_id like 'cyw9007' and user_pw like 'royalwook12!';

commit;
select * from post;
select * from post_suggest;
select * from (select /*+ index_desc (post post_pk) */ rownum rn, post_idx, title, contents, nickname, password, imgurl, regdate, modifydate, viewcount, likecount, replycount, user_idx, youtube_url, music, singer, thumnail, lyrics
            	FROM (
                    SELECT p.*, ps.youtube_url, ps.thumnail, ps.music, ps.singer, ps.lyrics
                    FROM post p
                    JOIN post_suggest ps ON p.post_idx = ps.post_idx
                    order by p.post_idx desc
                    )
                 where rownum <= (1 * 5)
                 )
where rn > ((1-1) * 5);
select * from post_suggest;
update post_suggest set thumnail = 'https://img.youtube.com/vi/V-gxqhWEbxI/mqdefault.jpg' where post_idx = 11;
commit;

select * from singer;

select /*+ index_desc (singer singer_pk) */ singer, count(*) as count, singer_img
from singer, singer_img
group by singer;

select /*+ index_desc (singer singer_pk) */ count(count(*)) as count
from singer 
group by singer;
select post_idx from post;

select * from post p left outer join post_suggest ps on p.post_idx = ps.post_idx where p.post_idx = (select max(p.post_idx) from post p left outer JOIN post_suggest ps ON p.post_idx = ps.post_idx) or p.post_idx = (select max(p.post_idx) from post p left outer JOIN post_suggest ps ON p.post_idx = ps.post_idx where p.post_idx < (select max(post_idx) from post));
select * from post;
select * from singer where singer like '%Vaundy%';
select * from users;
select * from music;