create table tbl_artist_201905 (
    artist_id char(4) not null primary key,
    artist_name varchar2(20),
    artist_gender char(1),
    artist_birth char(8),
    talent char(1),
    agency varchar2(20)
);
desc tbl_artist_201905;
insert into tbl_artist_201905 values ('A001', '김스타', 'F', '19970101', '1', 'A엔터테인먼트');
insert into tbl_artist_201905 values ('A002', '조스타', 'M', '19980201', '2', 'B엔터테인먼트');
insert into tbl_artist_201905 values ('A003', '왕스타', 'M', '19990301', '3', 'C엔터테인먼트');
insert into tbl_artist_201905 values ('A004', '정스타', 'M', '20000401', '1', 'D엔터테인먼트');
insert into tbl_artist_201905 values ('A005', '홍스타', 'F', '20010501', '2', 'E엔터테인먼트');
select * from tbl_artist_201905;
delete from tbl_artist_201905 where artist_id = 'A006';
create table tbl_mento_201905 (
    mento_id char(4) not null primary key,
    mento_name varchar2(20)
);
insert into tbl_mento_201905 values ('J001', '함멘토');
insert into tbl_mento_201905 values ('J002', '박멘토');
insert into tbl_mento_201905 values ('J003', '장멘토');
select * from tbl_mento_201905;
insert into tbl_point_201905 values ('2019001', 'A001', 'J001', 78);
insert into tbl_point_201905 values ('2019002', 'A001', 'J002', 76);
insert into tbl_point_201905 values ('2019003', 'A001', 'J003', 70);
insert into tbl_point_201905 values ('2019004', 'A002', 'J001', 80);
insert into tbl_point_201905 values ('2019005', 'A002', 'J002', 72);
insert into tbl_point_201905 values ('2019006', 'A002', 'J003', 78);
insert into tbl_point_201905 values ('2019007', 'A003', 'J001', 90);
insert into tbl_point_201905 values ('2019008', 'A003', 'J002', 92);
insert into tbl_point_201905 values ('2019009', 'A003', 'J003', 88);
insert into tbl_point_201905 values ('2019010', 'A004', 'J001', 96);
insert into tbl_point_201905 values ('2019011', 'A004', 'J002', 90);
insert into tbl_point_201905 values ('2019012', 'A004', 'J003', 98);
insert into tbl_point_201905 values ('2019013', 'A005', 'J001', 88);
insert into tbl_point_201905 values ('2019014', 'A005', 'J002', 86);
insert into tbl_point_201905 values ('2019015', 'A005', 'J003', 86);
select * from tbl_point_201905;
commit;
select p.serial_no, p.artist_id, p.mento_id, a.artist_birth, p.point, m.mento_name
from tbl_point_201905 p, tbl_artist_201905 a, tbl_mento_201905 m
where p.artist_id = a.artist_id and p.mento_id = m.mento_id
order by p.serial_no asc;

select a.artist_id, a.artist_name, a.artist_gender, sum(p.point) as sum, round(avg(p.point), 2) as ave
from tbl_point_201905 p, tbl_artist_201905 a
where p.artist_id = a.artist_id
group by a.artist_id, a.artist_name, a.artist_gender
order by ave desc;