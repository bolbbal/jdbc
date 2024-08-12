create table score (
    bno number(4) not null,
    name varchar2(12) not null,
    kor number(3) not null,
    eng number(3) not null,
    mat number(3) not null,
    tot number(3),
    ave number(5,2),
    grade varchar2(2),
    rank number(2),
    CONSTRAINT score_pk primary key (bno)
);
desc score;
--컬럼 이름 변경
alter table score rename column rank to ranking;
alter table score rename column ranking to rank;
--컬럼 삭제
alter table score drop column ranking;
--컬럼 추가
alter table score add(ranking number(2));
desc score;
--테이블 삭제
drop table score;