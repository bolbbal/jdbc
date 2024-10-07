drop table post_suggest;
drop table post;
drop table post_type;
drop table users;
<<<<<<< HEAD
drop SEQUENCE post_seq;
=======
drop table music;
drop table singer;
drop sequence post_idx_seq;
>>>>>>> a4a0a91ee6cacdf63fa45d5c3aea68d265c8a595

create table post_type (
    post_type_idx number(2) not null,
    post_type varchar2(50) not null,
    constraint post_type_pk primary key (post_type_idx)
);

insert into post_type values (1, '����');
insert into post_type values (2, '��?��');

create table post (
    post_idx number(4) not null,
    post_type_idx number default 1,
    title varchar2(50) not null,
    contents varchar2(4000) not null,
    nickname varchar2(50) not null,
    password varchar2(50) not null,
    imgurl varchar2(50),
    regdate date default sysdate,
    modifydate date default null,
    viewcount number(4) default 0,
    likecount number(4) default 0,
    replycount number(4) default 0,
    hatecount number(4) default 0,
    constraint post_fk foreign key (post_type_idx) references post_type (post_type_idx),
    constraint post_pk primary key (post_idx)
);

<<<<<<< HEAD
CREATE SEQUENCE post_seq;
=======
CREATE SEQUENCE post_idx_seq;
>>>>>>> a4a0a91ee6cacdf63fa45d5c3aea68d265c8a595

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

create table singer (
    singer_idx number not null,
    singer varchar2(50) not null,
    singer_img varchar2(1000),
    constraint singer_pk primary key (singer_idx)
);

create sequence singer_seq;

insert into singer (singer_idx, singer) values (singer_seq.nextval, 'VAUNDY');

select * 
from singer
where singer like '%VAUNDY%';

create table music (
    music_idx number not null,
    singer_idx number not null,
    music varchar(50) not null,
    constraint music_pk primary key (music_idx),
    constraint music_fk foreign key (singer_idx) references singer (singer_idx)
);

create sequence music_seq;

insert into post (post_idx, title, contents, nickname, password) 
            values (post_idx_seq.nextval, '��������', '�����������֪����ӹ�ȫ��髪�������êƪ����������������ʪ��ê����髪�����ê��Ϊǡ���?�˫﫯�﫯����?�ª��ê�����ӹ����?���������ت�ʰ���ʪ���?���������Φ��������<br>���?�����ت򪤪��Ī���?�������ɡ��֪ê������񪷪����󪤪�������ǫ�����?��ڸ�����Ϊˡ�����ݻ�ª�����ʰ���ʪ��ê�����ӹ�Ȫ��������Ū��ʪ��顸�������?���񪷪���������ê�?�������<br>���髪���Ǫ�ᳪ������બ��﷪��Ȫ������Ȫ�����㪷���Ϫ�ê�֣㧪��ƫҫ�������ت������ʰ���������֪ê����������֪���򪺪ê���﷪˪��ƪ���������', '��Ҭ?�', '0420');
insert into post (post_idx, post_type_idx, title, contents, nickname, password) 
            values (post_idx_seq.nextval, 2, '��������', '�������窬����������ʰ⢡�VAUNDY�Ρ���?���������˪Ī����Ū����������ت���?���������Ī����تǡ����ĪǪ�?�������������髪����ʰ�êƪߪ������֪êƪ��롣<br>�Ǫ�?ҷ�ʪ��Ȫˡ���?�Ϋ��髪���˪Ϫ����ت�??����ƪ��ʪ�����������ӹ����?�˫��髪�������êƪ⡢�����ت�ʰ�����Ȫ��Ǫ��ʪ�����?��?ҷ������Ϊ�?��������ت���ӹ����?��ʰ���ʪ���?���ߪ����Ϊˡ����쪬�Ǫ��ʪ����֪��������֪����ʪ롣<br>���Ī�VAUNDY���ت���?�Ϋ��髪������ʥ����몳�Ȫ��êêƪ��ơ���������?����������ӹ����?������߾���ê�ʰ�������������⪽���ت�?����먪���ʪ��顢�����������誦���֪���', '��Ҭ?�', '0420');
insert into post_suggest (post_idx, youtube_url, music, singer, lyrics, thumnail) 
            values (30, 'https://youtu.be/UM9XNpgrqVk?si=wn7a9mLW4aosMJER', '��?������',��'VAUNDY', '���� ����', 'thumnail');

commit;

select * from post join post_suggest on post.post_idx = post_suggest.post_idx where post.post_idx = 30;

create table users (
    user_idx number(4) not null,
    user_id varchar2(50) not null,
    user_pw varchar2(50) not null,
    user_nickname varchar2(50) not null,
    user_img varchar2(200) not null,
    joindate date default sysdate,
    constraint user_pk primary key (user_idx)
);

<<<<<<< HEAD


select * from post order by idx desc;
=======
CREATE SEQUENCE users_seq;
>>>>>>> a4a0a91ee6cacdf63fa45d5c3aea68d265c8a595

insert into post (idx, title, singer, contents, nickname, password) values (post_seq.nextval, '1', '2', '3', '4', '5');

select *
from post
order by post_idx desc;

update post set viewcount = viewcount+1 where idx = 3;

select * 
from (select /*+ index_desc (post post_pk) */ rownum rn, post_idx, post_type_idx, title, contents, nickname, password, imgurl, regdate, modifydate, viewcount, likecount, replycount, hatecount
      from post 
      where rownum <= (1 * 5))
where rn > ((1-1) * 5);

SELECT *
FROM (SELECT /*+ index_desc(post post_pk) */ ROWNUM rn, post_idx, post_type_idx, title, contents, nickname, password, imgurl, regdate, modifydate, viewcount, likecount, replycount, hatecount
        FROM (SELECT p.*, pt.post_type
                FROM post p
                JOIN post_type pt ON p.post_type_idx = pt.post_type_idx
                ORDER BY p.post_idx desc)
    WHERE ROWNUM <= (1 * 5))
WHERE rn > ((1 - 1) * 5);

commit;

SELECT * FROM (
    SELECT p.post_idx, p.imgurl, p.contents, 
           SUM(likecount) AS total_likes, 
           SUM(viewcount) AS total_views,
           CASE 
               WHEN SUM(viewcount) > 0 THEN (SUM(likecount) / SUM(viewcount)) 
               ELSE 0 
           END AS like_view_ratio
    FROM post p
    join post_suggest ps on p.post_idx = ps.post_idx
    WHERE regdate >= SYSDATE - INTERVAL '1' DAY
    GROUP BY post_idx
    ORDER BY like_view_ratio DESC
)
WHERE ROWNUM <= 5;
