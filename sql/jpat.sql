drop table post_suggest;
drop table post;
drop table post_type;
drop table users;
drop table music;
drop table singer;
drop table reply;
drop table singer_post_relation;
drop sequence post_idx_seq;
drop sequence users_seq;
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

insert into post_type values (1, '?��?');
insert into post_type values (2, '��?�?');
commit;
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
    title varchar2(300) not null,
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
    constraint spr_fk1 foreign key (singer_idx) references singer (singer_idx),
    constraint spr_fk2 foreign key (post_idx) references post (post_idx) on delete cascade
);
   
CREATE TABLE music (
    post_idx NUMBER(4) NOT NULL,
    music_idx NUMBER NOT NULL,
    singer_idx NUMBER NOT NULL,
    music VARCHAR(50) NOT NULL,
    lyrics VARCHAR2(4000) NOT NULL,
    CONSTRAINT music_pk PRIMARY KEY (music_idx),
    CONSTRAINT music_fk1 FOREIGN KEY (singer_idx) REFERENCES singer (singer_idx),
    CONSTRAINT music_fk2 FOREIGN KEY (post_idx) REFERENCES post (post_idx) ON DELETE CASCADE
);
ALTER TABLE music DROP CONSTRAINT music_fk1;
ALTER TABLE music 
ADD CONSTRAINT music_fk1 FOREIGN KEY (singer_idx) REFERENCES singer(singer_idx);
commit;
select * from users;


select * from post;
select * from singer_post_relation where post_idx = 4;
select * from singer where singer_idx = 2;
select * from music where post_idx = 4;
select * from singer;
select * from music;
select * from singer_post_relation;
select * from post_suggest;

SELECT * FROM (
    SELECT ROW_NUMBER() OVER (ORDER BY p.post_idx DESC) AS rn, 
           p.post_idx, p.title, p.contents, p.nickname, p.password, 
           p.imgurl, p.regdate, p.modifydate, p.viewcount, 
           p.likecount, p.replycount, p.user_idx, 
           ps.youtube_url, ps.music, ps.singer, ps.thumnail, ps.lyrics, 
           u.user_img
    FROM post p 
    JOIN post_suggest ps ON p.post_idx = ps.post_idx 
    LEFT JOIN users u ON p.user_idx = u.user_idx 
) 
WHERE rn > ((2 - 1) * 5) AND rn <= (2 * 5)
ORDER BY rn aSC;

select /*+ index_desc (singer singer_pk) */ *
from singer
where suggest_count != 0
order by suggest_count desc;

update singer set singer = 'VAUNDY' where singer_idx = 2;

commit;
select * from post_suggest;
select count(*) as count from post_suggest where singer like '%VAUNDY%';
select * from users;

SELECT * 
FROM (SELECT ROW_NUMBER() OVER (ORDER BY p.post_idx DESC) AS rn,
 p.post_idx, p.title, p.contents, p.nickname, p.password, 
p.imgurl, p.regdate, p.modifydate, p.viewcount, p.likecount, 
 p.replycount, p.user_idx, ps.youtube_url, ps.music, ps.singer, 
 ps.thumnail, ps.lyrics, u.user_img 
 FROM post p 
JOIN post_suggest ps ON p.post_idx = ps.post_idx 
LEFT JOIN users u ON p.user_idx = u.user_idx
WHERE singer like '%TUKI.%'
) WHERE rn > ((1 - 1) * 5) AND rn <= (1 * 5)
ORDER BY rn aSC;
select * from music;
select * from post;
select * from singer;

select /*+ index_desc (singer singer_pk) */ count(count(*)) as count 
from singer
where suggest_count > 0
group by singer;

select /*+ index_desc (singer singer_pk) */ *
from singer where suggest_count > 0 
order by suggest_count desc;
ALTER TABLE post MODIFY (title VARCHAR2(300));
commit;
select * from post_suggest order by post_idx desc;
select * from users;

select * from reply;

select * from post where post_idx = 84;
select * from reply where post_idx = 84;

select * from post where post_type_idx = 2;