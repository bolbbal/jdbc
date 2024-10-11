drop table post_suggest;
drop table post;
drop table post_type;
drop table users;
drop table music;
drop table singer;
drop sequence post_idx_seq;

create table post_type (
    post_type_idx number(2) not null,
    post_type varchar2(50) not null,
    constraint post_type_pk primary key (post_type_idx)
);
commit;
insert into post_type values (1, '����');
insert into post_type values (2, '��?��');
update post_type set post_type = '��?��' where post_type_idx = 2;
select * from post order by viewcount desc;

SELECT *
FROM (
    SELECT *
    FROM post
    join post_suggest on post.post_idx = post_suggest.post_idx
    ORDER BY (post.viewcount + (post.likecount * 2)) DESC
)
WHERE ROWNUM <= 5;

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

CREATE SEQUENCE post_idx_seq;

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
    post_idx number(4) not null,
    singer_idx number not null,
    singer varchar2(50) not null,
    singer_img varchar2(1000),
    constraint singer_pk primary key (singer_idx),
    constraint singer_fk foreign key (post_idx) references post (post_idx)
);

create sequence singer_seq;

insert into singer (singer_idx, singer) values (singer_seq.nextval, 'VAUNDY');

select * 
from singer
where singer like '%VAUNDY%';

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

create sequence music_seq;

insert into post (post_idx, title, contents, nickname, password) 
            values (post_idx_seq.nextval, '�������', '����������֪����ӹ�ȫ��髪�������êƪ����������������ʪ��ê����髪�����ê��Ϊǡ���?�˫﫯�﫯����?�ª��ê�����ӹ����?���������ت�ʰ���ʪ���?���������Φ��������<br>���?�����ت򪤪��Ī���?�������ɡ��֪ê������񪷪����󪤪������ǫ�����?��ڸ�����Ϊˡ�����ݻ�ª�����ʰ���ʪ��ê�����ӹ�Ȫ��������Ū��ʪ��顸�������?���񪷪���������ê�?�������<br>���髪���Ǫ�ᳪ������બ��﷪��Ȫ������Ȫ�����㪷���Ϫ�ê�֣㧪��ƫҫ�������ت������ʰ���������֪ê���������֪���򪺪ê���﷪˪��ƪ���������', '��Ҭ?�', '0420');
insert into post (post_idx, post_type_idx, title, contents, nickname, password) 
            values (post_idx_seq.nextval, 2, '�������', '������窬����������ʰ⢡�VAUNDY�Ρ���?���������˪Ī����Ū����������ت���?���������Ī����تǡ����ĪǪ�?�������������髪����ʰ�êƪߪ������֪êƪ��롣<br>�Ǫ�?ҷ�ʪ��Ȫˡ���?�Ϋ��髪���˪Ϫ����ت�??����ƪ��ʪ�����������ӹ����?�˫��髪�������êƪ⡢�����ت�ʰ�����Ȫ��Ǫ��ʪ�����?��?ҷ������Ϊ�?��������ت���ӹ����?��ʰ���ʪ���?���ߪ����Ϊˡ����쪬�Ǫ��ʪ����֪��������֪����ʪ롣<br>���Ī�VAUNDY���ت���?�Ϋ��髪������ʥ����몳�Ȫ��êêƪ��ơ�������?����������ӹ����?������߾���ê�ʰ������������⪽���ت�?����먪���ʪ��顢����������誦���֪���', '��Ҭ?�', '0420');
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

CREATE SEQUENCE users_seq;

insert into post (idx, title, singer, contents, nickname, password) values (post_seq.nextval, '1', '2', '3', '4', '5');

select *
from post_suggest;
select * from post;
select * from singer;

select * from music;

update post set viewcount = viewcount+1 where idx = 3;

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
    SELECT ROWNUM rn, p.post_idx, p.post_type, p.title, p.contents, p.nickname, p.password, p.imgurl, p.regdate, p.modifydate, p.viewcount, p.likecount, p.replycount, p.hatecount
    FROM (
        SELECT p.*, pt.post_type
        FROM post p
        JOIN post_type pt ON p.post_type_idx = pt.post_type_idx
        ORDER BY p.post_idx DESC
    ) p
    WHERE ROWNUM <= 5
)
WHERE rn > 0;

commit;

