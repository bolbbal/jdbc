create table score(
    bno number(4) not null,
    name varchar2(12) not null,
    kor number(3) not null,
    eng number(3) not null,
    mat number(3) not null,
    CONSTRAINT score_pk primary key (bno)
);
-- DML : insert, select, update, delete
insert into score (bno, name, kor, eng, mat) values (1, '홍길동', 100, 100, 100);
insert into score (bno, name, kor, eng, mat) values (2, '김길동', 90, 90, 90);
insert into score (bno, name, kor, eng, mat) values (3, '박길동', 40, 6, 70);
insert into score (bno, name, kor, eng, mat) values (4, '최길동', 50, 60, 80);
insert into score (bno, name, kor, eng, mat) values (5, '박길동', 85, 95, 70);

commit;
-- 반드시 commit 할 것
select * from score;
select name from score;
select name, bno from score;
select * from score where kor>=90;
select * from score where kor >= 90 and eng >= 90 and mat >= 90;
select * from score where name like '박%';
select * from score where name like '%동';
select * from score where name like '%길%';
select * from score where name like '김%';
select * from score where name like '박%' and kor >= 90;
select * from score where name like '박%' or kor >= 90;
select * from score where bno = 3;
select * from score where bno < 3;
select * from score;
-- 
--sequence
--순번을 1씩 증가하면서 유일한 값을 만들 때 사용
create sequence score_seq;

--삭제
select * from score;
select * from score where kor >= 90;
delete from score where bno = 1;
select * from score;
delete from score;
select * from score;
select * from score;
select * from score order by bno desc;
select * from score order by bno asc;
commit;

--수정
select * from score;
update score set kor = 80, eng = 97, mat = 88 where bno = 5;
update score set name = '히틀러' where name = '서재덕';
update score set kor = 65 where name = '채선기';
update score set kor = kor+5 where name like '%인%';

select * from score;
--insert, delete, update는 반드시 commit할것!

select * from emp;
select * from dept;
select * from sal;
select * from emp where dno = 10;
select * from emp;
select * from emp where ename = 'SMITH';
select * from emp where hiredate < '81/01/01';
select * from emp where dno = 10 and job = 'MANAGER';
select * from emp where dno = 10 or job = 'MANAGER';
select * from emp where not dno = 10;
select * from emp where salary >= 1000 and salary <= 1500;
select * from emp where salary between 1000 and 1500;

select * from emp where commission = 300 or commission = 500 or commission = 1400;
select * from emp where commission in(300,500,1400);
select * from emp where ename like 'F%';
select * from emp where ename like '_A%';
select * from emp where commission is null;
select * from emp where commission is not null;
select * from emp order by salary asc;
select * from emp order by salary desc;
select * from emp order by salary desc, ename asc;
desc emp;
--그룹합수
select * from emp;
select sum(commission) as 커미션총액 from emp;
select sum(salary) saltot from emp;
--테이블 행 개수
select count(*) as 사원의수 from emp;
select count(distinct job) as 직업수 from emp;
select max(salary) from emp;
select * from emp;
select dno, avg(salary) as salave from emp group by dno order by salave asc;
--부서별, 직업별 인원 수와 급여 총액, 급여 평균을 구하시오
select dno, job, count(*) as jobtot, sum(salary) as saltot, avg(salary) as salave
from emp
group by dno, job
order by dno, job;
--그룹 결과 제한
--사원 테이블에서 부서별 최고 많이 받는 사람의 급여를 구하라
--단, 급여가 3000만원 이상인 사람들 중
select dno, max(salary) as maxsal
from emp
group by dno
having max(salary) >= 3000;
--테이블 전체 조건 지정은 where, 그룹 지운 데이터 중 조건은 having
select * from emp;
select * from emp where ename = upper('scott');
select * from emp where ename = lower('scott');
--문자 길이 반환
select length('oracle'), lengthb('오라클') from dual; --b는 byte 
--문자열 결합
select 'oracle', 'mania', concat('Oracle', 'mania') from dual;
--문자열 일부 발췌
select substr('oracle mania', 4, 3) from dual;
--87년도에 입사한 사원 추출
select * from emp;
select * from emp where substr(hiredate, 1, 2) = '87';
select * from emp where substr(ename, -1, 1) = 'N';
--남은 자리에 특정 기호 채우기
select LPAD(salary, 10, '*') from emp;
select RPAD(salary, 10, '*') from emp;
--공백 제거
select trim('   oracle  mania   ') from dual;
--반올림
select 98.7654, round(98.7654), round(98.7654, 2), round(98.7654, -1) from dual;
--버림
select 98.7654, trunc(98.7654), trunc(98.7654, 2), trunc(98.7654, -1) from dual;
--현재 날짜 검색
select sysdate from dual;
--날짜 연산
select sysdate-1 yesterday, sysdate today, sysdate+1 tomorrow from dual;
--날짜 반올림
select round(sysdate - hiredate) 근무일수 from emp;
--날짜 자르기
select hiredate, trunc(hiredate, 'MONTH') from emp;
--날짜와 날짜 사이의 개월 수 구하기
select ename, sysdate, hiredate, trunc(months_between(sysdate, hiredate)) from emp;
--해당 날짜를 기준으로 처음 돌아요는 요일에 해당하는 날짜 구하기
select sysdate, next_day(sysdate, '토요일') from dual;
--해당 날짜가 속한 달의 마지막 날짜 구하기
select ename, hiredate, last_day(hiredate) from emp;
--날짜나 숫자를 문자로 형변환
select ename, hiredate, to_char(hiredate, 'YY-MM'), to_char(hiredate, 'YYYY/MM/DD DAY') from emp;
--문자열을 날짜 형으로 변환
select ename, hiredate from emp where hiredate = to_date('19810220');
--숫자형으로 형번환
select to_number('100000') - to_number('50000') from dual;
--null 또는 0을 다른 값으로 변환
select ename, salary, commission, NVL(commission, 0), salary*12+nvl(commission, 0) from emp order by job;
--★조건에 따라 다양한 선택★
select ename, dno, decode(dno, 10, 'aaa',
                20, 'bbb',
                30, 'ccc',
                'default') as dname from emp;
select ename, dno, case when dno = 10 then 'aaa'
                        when dno = 20 then 'bbb'
                        when dno = 30 then 'ccc'
                        else 'default' end as dname from emp;
--★★★★★★★테이블 조인★★★★★★
--여러 테이블에 저장된 데이터를 한번에 조회해야 할 필요가 있을 때 사용
--3개의 테이블을 조인할 때는 먼저 2개의 테이블을 조인하고, 그 결과와 나머니 테이블을 조인한다
--join의 종류
--inner join(equal join, natual join, cross join) null 상태의 데이터는 취급하지 않음. 출력하고 싶다면 outer join을 사용함
--outer join(left join, right join, full outer join)

--7788인 사원의 이름과 소속 부서명을 검색하시오
select * from emp where eno = 7788;
select * from dept where dno = 20;

--equal join
select eno, ename, emp.dno, dname
from emp, dept
where emp.dno = dept.dno;

--equal join
select e.eno, e.ename, e.salary, e.dno, d.dname
from emp e, dept d
where e.dno = d.dno;

--모호한 컬럼명 자세히 지정하여 검색하기
select e.eno, e.ename, e.salary, e.dno, d.dname
from emp e, dept d
where e.dno = d.dno and e.eno = 7788;

--임의의 조건을 지정하거나 조인할 컬럼을 지정하여 검색
select e.eno, e.ename, d.dname, e.dno
from emp e join dept d
on e.dno = d.dno
where e.eno = 7788;

select e.eno, e.ename, dno, d.dname
from emp e join dept d
using (dno)
where e.eno = 7788;

select * from sal;

--non equi join
--where 절에 <, between a and b 와 같이 = 조건이 아닌 연산자를 사용
select ename, salary, grade
from emp, sal
where salary between losal and hisal;

--3개의 테이블 조인하기
select e.ename, d.dname, e.salary, s.grade
from emp e, dept d, sal s
where e.dno = d.dno and salary between losal and hisal;
drop table student;
create table tbl_student_201905 (
    syear char(1) not null,
    sclass char(2) not null,
    sno char(2) not null,
    sname varchar2(20),
    birth char(8),
    gender char(1),
    tel1 char(3),
    tel2 char(4),
    tel3 char(4),
    constraint student_pk primary key (syear, sclass, sno)    
);
insert into tbl_student_201905 values ('1', '01', '01', '김학생', '20020101', 'F', '010', '1234', '1001');
insert into tbl_student_201905 values ('1', '01', '02', '이학생', '20020201', 'M', '010', '1234', '1002');
insert into tbl_student_201905 values ('1', '01', '03', '박학생', '20020301', 'M', '010', '1234', '1003');
insert into tbl_student_201905 values ('1', '02', '01', '조학생', '20020401', 'M', '010', '1234', '1004');
insert into tbl_student_201905 values ('1', '02', '02', '유학생', '20020501', 'M', '010', '1234', '1005');
insert into tbl_student_201905 values ('1', '02', '03', '여학생', '20020601', 'M', '010', '1234', '1006');
insert into tbl_student_201905 values ('1', '03', '01', '남학생', '20020701', 'F', '010', '1234', '1007');
insert into tbl_student_201905 values ('1', '03', '02', '황학생', '20020801', 'F', '010', '1234', '1008');
insert into tbl_student_201905 values ('1', '03', '03', '전학생', '20020901', 'F', '010', '1234', '1009');
select * from tbl_student_201905;
commit;
create table tbl_dept_201905 (
    syear char(1) not null,
    sclass char(2) not null,
    tname varchar2(20),
    constraint tbl_dept_pk primary key (syear, sclass)
);
insert into tbl_dept_201905 values ('1', '01', '김교사');
insert into tbl_dept_201905 values ('1', '02', '이교사');
insert into tbl_dept_201905 values ('1', '03', '박교사');
select * from tbl_dept_201905;
commit;
create table tbl_score_201905 (
    syear char(1),
    sclass char(2),
    sno char(2),
    kor number(3),
    eng number(3),
    mat number(3),
    constraint tbl_score_fk foreign key(syear, sclass, sno) REFERENCES tbl_student_201905(syear, sclass, sno)
);
insert into tbl_score_201905 values ('1', '01', '01', 50, 50, 50);
insert into tbl_score_201905 values ('1', '01', '02', 60, 40, 100);
insert into tbl_score_201905 values ('1', '01', '03', 70, 70, 70);
insert into tbl_score_201905 values ('1', '02', '01', 80, 80, 80);
insert into tbl_score_201905 values ('1', '02', '02', 50, 50, 50);
insert into tbl_score_201905 values ('1', '02', '03', 40, 90, 80);
insert into tbl_score_201905 values ('1', '03', '01', 70, 70, 70);
insert into tbl_score_201905 values ('1', '03', '02', 80, 60, 90);
insert into tbl_score_201905 values ('1', '03', '03', 90, 80, 70);
drop table tbl_score_201905;
select * from tbl_score_201905;
select * from tbl_student_201905;
commit;
--join
select std.syear, std.sclass, std.sno, std.sname, std.gender, sc.kor, sc.eng, sc.mat, sc.kor + sc.eng + sc.mat as tot, round((sc.kor + sc.eng + sc.mat) / 3, 1) as ave
from tbl_student_201905 std, tbl_score_201905 sc  
where std.syear = sc.syear and std.sclass = sc.sclass and std.sno = sc.sno;

select d.syear, d.sclass, d.tname, sum(sc.kor) as korSum, sum(sc.eng) as engSum, sum(sc.mat) as matSum, round(avg(sc.kor), 1) as korAve, round(avg(sc.eng), 1) as engAve, round(avg(sc.mat), 1) as matAve
from tbl_dept_201905 d, tbl_score_201905 sc
where d.syear = sc.syear and d.sclass = sc.sclass
group by d.syear, d.sclass, d.tname;

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

create table TBL_ENTRY_202106 (
    ENTRY_NO char(4) not null,
    ENTRY_NAME VARCHAR2(10),
    ENTRY_JUMIN CHAR(13),
    ENTRY_TYPE CHAR(1),
    ENTRY_AREA VARCHAR(10),
    CONSTRAINT ENTRY_PK PRIMARY KEY (ENTRY_NO)
);
DESC TBL_ENTRY_202106;
INSERT INTO TBL_ENTRY_202106 VALUES ('0001', '김경연', '9901011000001', '1', '남원');
INSERT INTO TBL_ENTRY_202106 VALUES ('0002', '이경연', '9801022000002', '2', '남원');
INSERT INTO TBL_ENTRY_202106 VALUES ('0003', '박경연', '9701031000003', '3', '전주');
INSERT INTO TBL_ENTRY_202106 VALUES ('0004', '조경연', '9601042000004', '4', '전주');
INSERT INTO TBL_ENTRY_202106 VALUES ('0005', '하경연', '9501051000005', '1', '제주');
INSERT INTO TBL_ENTRY_202106 VALUES ('0006', '황경연', '9401062000006', '2', '남원');
INSERT INTO TBL_ENTRY_202106 VALUES ('0007', '봉경연', '9301071000007', '3', '울산');
INSERT INTO TBL_ENTRY_202106 VALUES ('0008', '양경연', '9201082000008', '4', '울산');
INSERT INTO TBL_ENTRY_202106 VALUES ('0009', '나경연', '9101091000009', '1', '제주');
INSERT INTO TBL_ENTRY_202106 VALUES ('0010', '차경연', '9001102000010', '2', '전주');
select * from TBL_ENTRY_202106;
CREATE TABLE TBL_RECORD_202106 (
    ENTRY_NO CHAR(4) NOT NULL,
    SCORE1 NUMBER(3),
    SCORE2 NUMBER(3),
    SCORE3 NUMBER(3),
    SCORE4 NUMBER(3),
    SCORE5 NUMBER(3),
    S_MAX NUMBER(3),
    S_MIN NUMBER(3),
    S_TOT NUMBER(4),
    S_AVE NUMBER(6,2),
    CONSTRAINT ENTRY_FK FOREIGN KEY (ENTRY_NO) REFERENCES TBL_ENTRY_202106 (ENTRY_NO)
);
INSERT INTO TBL_RECORD_202106 VALUES ('0001', 80, 80, 80, 70, 60, 80, 70, 230, 76.67);
INSERT INTO TBL_RECORD_202106 VALUES ('0002', 90, 80, 90, 80, 90, 90, 80, 260, 86.67);
INSERT INTO TBL_RECORD_202106 VALUES ('0003', 90, 80, 80, 80, 85, 90, 80, 245, 81.67);
INSERT INTO TBL_RECORD_202106 VALUES ('0004', 75, 80, 80, 85, 70, 85, 70, 235, 78.33);
INSERT INTO TBL_RECORD_202106 VALUES ('0005', 75, 75, 80, 65, 75, 80, 65, 225, 75);
INSERT INTO TBL_RECORD_202106 VALUES ('0006', 85, 85, 90, 82, 90, 90, 80, 260, 86.67);
INSERT INTO TBL_RECORD_202106 VALUES ('0007', 60, 70, 60, 60, 80, 80, 60, 190, 63.33);
INSERT INTO TBL_RECORD_202106 VALUES ('0008', 70, 80, 70, 70, 60, 80, 60, 210, 70);
INSERT INTO TBL_RECORD_202106 VALUES ('0009', 80, 90, 80, 80, 80, 90, 80, 240, 80);
INSERT INTO TBL_RECORD_202106 VALUES ('0010', 90, 90, 90, 90, 90, 90, 90, 270, 90);
SELECT * FROM tbl_record_202106;
CREATE TABLE TBL_REFEREE_202106 (
    RNAME1 VARCHAR2(10),
    RNAME2 VARCHAR2(10),
    RNAME3 VARCHAR2(10),
    RNAME4 VARCHAR2(10),
    RNAME5 VARCHAR2(10)
);
drop table TBL_REFEREE_202106;
COMMIT;
INSERT INTO TBL_REFEREE_202106 VALUES ('김심사', '이심사', '박심사', '황심사', '조심사');
SELECT * FROM tbl_referee_202106;
insert into tbl_record_202106 (entry_no, score1, score2, score3, score4, score5, s_max, s_min, s_tot, s_ave)
values ('0011', 100, 100, 100, 100, 95, greatest(100, 100, 100, 100, 95), least(100, 100, 100, 100, 95), (100+100+100+100+95), (100+100+100+100+95)/5);
--여러개의 컬럼 중 최대값, 최소값 구하기
select greatest(score1, score2, score3, score4, score5) as max_val from tbl_record_202106;
select least(score1, score2, score3, score4, score5) as min_val from tbl_record_202106;

select et.entry_no, et.entry_name, et.entry_jumin, et.entry_type, et.entry_area, re.rname1, re.rname2, re.rname3, re.rname4, re.rname5, rc.score1, rc.score2, rc.score3, rc.score4, rc.score5, rc.s_tot, rc.s_ave
from tbl_entry_202106 et, tbl_record_202106 rc, tbl_referee_202106 re
where et.entry_no = rc.entry_no;

select et.entry_no, et.entry_name, et.entry_jumin, et.entry_type, et.entry_area, rc.s_tot, rc.s_ave
from tbl_entry_202106 et, tbl_record_202106 rc
where et.entry_no = rc.entry_no
order by s_tot desc, et.entry_no asc;
select * from tbl_record_202106;
delete from tbl_record_202106 where entry_no = '0010';
commit;

SELECT * FROM all_tables WHERE table_name = 'TBL_COMPANY_EMPLOYEE';

select * from all_tables;
drop table tbl_company_employee;
create table tbl_company_employee (
    e_no char(4) not null,
    e_name varchar2(20) not null,
    e_depart char(2) not null,
    e_level char(2) not null,
    e_work_place char(2),
    performance char(1),
    e_join_date char(8) not null,
    constraint employee_pk primary key (e_no),
    constraint employee_fk1 foreign key (e_depart) references tbl_company_depart (depart_code),
    constraint employee_fk2 foreign key (e_level) references tbl_company_level (level_code),
    constraint employee_fk3 foreign key (e_work_place) references tbl_company_work (work_place)
);

insert into tbl_company_employee values ('E001', '김태형', '01', '20', '31', 'C', '20200825');
insert into tbl_company_employee values ('E002', '박지민', '02', '30', '32', 'C', '20210112');
insert into tbl_company_employee values ('E003', '정호석', '02', '40', '32', 'D', '20210325');
insert into tbl_company_employee values ('E004', '민윤기', '03', '50', '40', 'B', '20210814');
select * from tbl_company_employee;
commit;
create table tbl_company_depart (
    depart_code char(2) not null,
    name varchar2(20),
    constraint depart_pk primary key (depart_code)
);
insert into tbl_company_depart values ('01', '인사');
insert into tbl_company_depart values ('02', '총무');
insert into tbl_company_depart values ('03', '영업');
insert into tbl_company_depart values ('04', '생산');
select * from tbl_company_depart;
commit;
create table tbl_company_level (
    level_code char(2) not null,
    name varchar2(20),
    salary number(8),
    constraint level_pk primary key (level_code)
);
insert into tbl_company_level values ('10', '이사', 4500000);
insert into tbl_company_level values ('20', '부장', 3500000);
insert into tbl_company_level values ('30', '과장', 3000000);
insert into tbl_company_level values ('40', '대리', 2500000);
insert into tbl_company_level values ('50', '사원', 2000000);
select * from tbl_company_level;
commit;
create table tbl_company_work (
    work_place char(2) not null,
    name varchar2(20),
    constraint work_pk primary key (work_place)
);
insert into tbl_company_work values ('31', '대전영업소');
insert into tbl_company_work values ('32', '청주영업소');
insert into tbl_company_work values ('33', '공주영업소');
insert into tbl_company_work values ('40', '충남본부');
insert into tbl_company_work values ('50', '본사');
select * from tbl_company_work;
commit;

select * from tbl_company_employee;
desc tbl_company_employee;
select * from tbl_company_depart;
select * from tbl_company_level;
select * from tbl_company_work;
--오라클 조인
-- select from where 세팅 > 결과 테이블 보고 사용하는 테이블 from에 작성 > 
-- 테이블 보고 출력할 데이터 select에 작성 > 테이블 보고 where 절에서 조인

-- 사원 목록 조회
select e.e_no, e.e_name, d.name, l.name, w.name, e.performance, e.e_join_date
from tbl_company_employee e, tbl_company_depart d, tbl_company_level l, tbl_company_work w
where e.e_depart = d.depart_code and e.e_level = l.level_code and e.e_work_place = w.work_place
order by e.e_no asc;

-- 사원 급여 조회
select e.e_no, e.e_name as ename, d.name as dname, l.name as lname, w.name as wname, e.performance,
decode(e.performance, 'D', l.salary ,
                      'C', l.salary + (l.salary * 0.05),
                      'B', l.salary + (l.salary * 0.08),
                      'A', l.salary + (l.salary * 0.1)) as salary
from tbl_company_employee e, tbl_company_depart d, tbl_company_level l, tbl_company_work w
where e.e_depart = d.depart_code and e.e_level = l.level_code and e.e_work_place = w.work_place
order by e.e_level asc;

--부서별 급여 조회
select d.depart_code, d.name as dname, sum(decode(e.performance, 'D', l.salary,
                                                             'C', l.salary + (l.salary * 0.05),
                                                             'B', l.salary + (l.salary * 0.08),
                                                             'A', l.salary + (l.salary * 0.1))) as sal
from tbl_company_employee e, tbl_company_depart d, tbl_company_level l
where e.e_depart = d.depart_code and e.e_level = l.level_code 
group by d.depart_code, d.name
order by d.depart_code;
--지역별 급여 조회
select w.work_place, w.name as wname, sum(decode(e.performance, 'D', l.salary,
                                                             'C', l.salary + (l.salary * 0.05),
                                                             'B', l.salary + (l.salary * 0.08),
                                                             'A', l.salary + (l.salary * 0.1))) as sal
from tbl_company_employee e, tbl_company_level l, tbl_company_work w
where e.e_work_place = w.work_place and e.e_level = l.level_code 
group by w.work_place, w.name
order by w.work_place;



















select * from tbl_company_employee;
select * from tbl_company_depart;
select * from tbl_company_level;
select * from tbl_company_work;
--사원목록조회
select e.e_no, e.e_name, d.name as dname, l.name as lname, w.name as wname, e.performance, e.e_join_date
from tbl_company_employee e, tbl_company_depart d, tbl_company_level l, tbl_company_work w
where e.e_depart = d.depart_code and e.e_level = l.level_code and e.e_work_place = w.work_place
order by e.e_no;
--사원급여조회
select e.e_no, e.e_name, d.name as dname, l.name as lname, w.name as wname, e.performance,
decode(e.performance, 'A', l.salary + (l.salary * 0.1),
                      'B', l.salary + (l.salary * 0.08),
                      'C', l.salary + (l.salary * 0.05),
                      'D', l.salary) as sal
from tbl_company_employee e, tbl_company_depart d, tbl_company_level l, tbl_company_work w
where e.e_depart = d.depart_code and e.e_level = l.level_code and e.e_work_place = w.work_place
order by d.depart_code;
--부서별급여조회
select d.depart_code, d.name as dname,
sum(decode(e.performance, 'A', l.salary + (l.salary * 0.1),
                      'B', l.salary + (l.salary * 0.08),
                      'C', l.salary + (l.salary * 0.05),
                      'D', l.salary)) as sal
from tbl_company_employee e, tbl_company_depart d, tbl_company_level l
where e.e_depart = d.depart_code and e.e_level = l.level_code
group by d.depart_code, d.name
order by d.depart_code;
--지역별급여조회
select w.work_place, w.name as wname,
sum(decode(e.performance, 'A', l.salary + (l.salary * 0.1),
                      'B', l.salary + (l.salary * 0.08),
                      'C', l.salary + (l.salary * 0.05),
                      'D', l.salary)) as sal
from tbl_company_employee e, tbl_company_level l, tbl_company_work w
where e.e_work_place = w.work_place and e.e_level = l.level_code
group by w.work_place, w.name
order by w.work_place;
commit;

--ansi join
select w.work_place, w.name as wname,
        sum(decode(e.performance, 'A', l.salary + (l.salary * 0.1),
                                  'B', l.salary + (l.salary * 0.08),
                                  'C', l.salary + (l.salary * 0.05),
                                  'D', l.salary)) as sal
from tbl_company_employee e
join tbl_company_work w -- inner 는 생략 가능
on e.e_work_place = w.work_place
inner join tbl_company_level l
on e.e_level = l.level_code
group by w.work_place, w.name
order by w.work_place;

--outer join
--조인 조건이 null인 레코드를 검색할 때 사용
select * from emp;
select * from dept;

select e.eno, e.ename, e.manager, e.commission, d.dname
from emp e, dept d
where e.dno = d.dno;

select e.eno, e.ename, e.manager, e.commission, d.dname
from emp e
join dept d
on e.dno = d.dno;

--오라클 OUTER JOIN
select e.eno, e.ename, e.job, e.manager, e.commission, d.dname
from emp e, dept d
where e.dno = d.dno(+) and e.job = 'MANAGER';

--left outer join
select e.eno, e.ename, e.job, e.manager, e.commission, d.dname
from emp e
left outer join dept d
on e.dno = d.dno --조인 조건
where e.job = 'MANAGER'; --검색 조건

--self join
--하나의 테이블에 있는 컬럼끼리 연결해야 하는 조인이 필요한 경우
--사원의 직속 상관을 검색

select a.eno, a.ename, a.job, b.ename
from emp a 
join emp b
on a.manager = b.eno
order by a.eno;

select * from emp;

create table tbl_cusinfo_202010 (
    custno char(4) not null,
    custname varchar2(20),
    custjumin char(13),
    custtel1 char(3),
    custtel2 char(4),
    custtel3 char(4),
    constraint cust_pk primary key (custno)
);
insert into tbl_cusinfo_202010 values ('1001', '김고객', '9901011000001', '010', '1234', '0001');
insert into tbl_cusinfo_202010 values ('1002', '이고객', '8901011000002', '010', '1234', '0002');
insert into tbl_cusinfo_202010 values ('1003', '박고객', '7901011000003', '010', '1234', '0003');
insert into tbl_cusinfo_202010 values ('1004', '조고객', '6901011000004', '010', '1234', '0004');
insert into tbl_cusinfo_202010 values ('1005', '황고객', '5901011000005', '010', '1234', '0005');
insert into tbl_cusinfo_202010 values ('1006', '홍고객', '9501011000006', '010', '1234', '0006');
insert into tbl_cusinfo_202010 values ('1007', '최고객', '8701011000007', '010', '1234', '0007');
commit;

create table tbl_oilinfo_202010 (
    oiltype char(1) not null,
    oilname varchar2(20),
    constraint oil_pk primary key (oiltype)
);
insert into tbl_oilinfo_202010 values ('1', '휘발유');
insert into tbl_oilinfo_202010 values ('2', '고급휘발유');
insert into tbl_oilinfo_202010 values ('3', '경유');
insert into tbl_oilinfo_202010 values ('4', '등유');
commit;

drop table tbl_saleinfo_202010;
create table tbl_saleinfo_202010 (
    saleno char(4) not null,
    oildate char(8),
    oiltype char(1),
    amount number(4),
    paytype char(1),
    custno char(4),
    creditcart char(16),
    oilcost number(7),
    constraint sale_pk primary key (saleno),
    constraint sale_fk1 foreign key (oiltype) references tbl_oilinfo_202010 (oiltype),
    constraint sale_fk2 foreign key (custno) references tbl_cusinfo_202010 (custno)
);

insert into tbl_saleinfo_202010 values ('9001', '20211001', '1', 30, '2', '1001', '3001200130014001', 45000); 
insert into tbl_saleinfo_202010 values ('9002', '20211001', '1', 40, '1', '1002', '', 56000); 
insert into tbl_saleinfo_202010 values ('9003', '20211001', '2', 40, '2', '1003', '4001200130014003', 72000); 
insert into tbl_saleinfo_202010 values ('9004', '20211002', '2', 60, '2', '1004', '5001200130014004', 102000); 
insert into tbl_saleinfo_202010 values ('9005', '20211002', '3', 50, '1', '', '', 55000); 
insert into tbl_saleinfo_202010 values ('9006', '20211002', '3', 50, '2', '', '3001200130014005', 55000); 
commit;

select * from tbl_saleinfo_202010;
select * from tbl_oilinfo_202010;
select * from tbl_cusinfo_202010;

--전체매출조회
select s.saleno, s.oildate, o.oilname, s.amount, s.paytype, c.custname, c.custno, c.custtel1, c.custtel2, c.custtel3, s.creditcart, s.oilcost
from tbl_saleinfo_202010 s
left outer join tbl_oilinfo_202010 o
on s.oiltype = o.oiltype
left outer join tbl_cusinfo_202010 c
on s.custno = c.custno
order by s.saleno;

select s.saleno, 
TO_CHAR(TO_DATE(s.oildate, 'YYYYMMDD'), 'YYYY"년"MM"월"DD"일"') as oildate, o.oilname, s.amount, s.paytype, c.custname, c.custno, 
c.custtel1||'-'||c.custtel2||'-'||c.custtel3 as tel, s.creditcart, s.oilcost
from tbl_saleinfo_202010 s
left outer join tbl_oilinfo_202010 o
on s.oiltype = o.oiltype
left outer join tbl_cusinfo_202010 c
on s.custno = c.custno
order by s.saleno;

--일 매출통계
select s.oildate, o.oilname, count(s.oiltype) as count, sum(s.oilcost) as tot
from tbl_saleinfo_202010 s, tbl_oilinfo_202010 o
where s.oiltype = o.oiltype
group by s.oildate, o.oilname
order by s.oildate asc, o.oilname asc;

select to_char(to_date(s.oildate,'yyyyMMdd'), 'yyyy"년"MM"월"dd"일"') as oildate, o.oilname, count(s.oiltype) as count, sum(s.oilcost) as tot
from tbl_saleinfo_202010 s, tbl_oilinfo_202010 o
where s.oiltype = o.oiltype
group by s.oildate, o.oilname
order by s.oildate asc, o.oilname asc;

create table member_tbl_02 (
    custno number(6) not null,
    custname varchar2(20),
    phone varchar(13),
    address varchar2(60),
    joindate date,
    grade char(1),
    city char(2),
    constraint member_pk primary key (custno)
);
commit;
drop table member_tbl_02;
insert into member_tbl_02 values (100001, '김행복', '010-1111-2222', '서울 동대문구 휘경1동', '20151202', 'A', '01');
insert into member_tbl_02 values (100002, '이축복', '010-1111-3333', '서울 동대문구 휘경2동', '20151206', 'B', '01');
insert into member_tbl_02 values (100003, '장믿음', '010-1111-4444', '울릉군 울릉읍 독도1리', '20151001', 'B', '30');
insert into member_tbl_02 values (100004, '최사랑', '010-1111-5555', '울릉군 울릉읍 독도2리', '20151113', 'A', '30');
insert into member_tbl_02 values (100005, '진평화', '010-1111-6666', '제주도 제주시 외나무골', '20151225', 'B', '60');
insert into member_tbl_02 values (100006, '차공단', '010-1111-7777', '제주도 제주시 외나무골', '20151211', 'C', '60');
select * from member_tbl_02;

create table money_tbl_02 (
    custno number(6) not null,
    saleno number(8) not null,
    pcost number(8),
    amount number(4),
    price number(8),
    pcode varchar2(4),
    sdate date,
    constraint money_fk foreign key (custno) references member_tbl_02 (custno),
    constraint money_pk primary key (saleno)
);

insert into money_tbl_02 values (100001, 20160001, 500, 5, (500*5), 'A001', '20160101');
insert into money_tbl_02 values (100001, 20160002, 1000, 4, (1000*4), 'A002', '20160101');
insert into money_tbl_02 values (100001, 20160003, 500, 3, (500*3), 'A008', '20160101');
insert into money_tbl_02 values (100002, 20160004, 2000, 1, (2000*1), 'A004', '20160102');
insert into money_tbl_02 values (100002, 20160005, 500, 1, (500*1), 'A001', '20160103');
insert into money_tbl_02 values (100003, 20160006, 1500, 2, (1500*2), 'A003', '20160103');
insert into money_tbl_02 values (100004, 20160007, 500, 2, (500*2), 'A001', '20160104');
insert into money_tbl_02 values (100004, 20160008, 300, 1, (300*1), 'A005', '20160104');
insert into money_tbl_02 values (100004, 20160009, 600, 1, (600*1), 'A006', '20160104');
insert into money_tbl_02 values (100004, 20160010, 3000, 1, (3000*1), 'A007', '20160106');
select * from money_tbl_02;
commit;

select max(custno)+1 as custno
from member_tbl_02;

select *
from member_tbl_02
order by custno;

select mem.custno, mem.custname, mem.grade, sum(mon.price) as totcost
from member_tbl_02 mem, money_tbl_02 mon
where mem.custno = mon.custno
group by mem.custno, mem.custname, mem.grade
order by sum(mon.price) desc;

--서브쿼리
--scott보다 많은 급여를 받는 사원을 찾으시오
select ename, salary from emp where ename = 'SCOTT';
select ename, salary from emp where salary > 3000;

select ename, salary
from emp
where salary  > (select salary
                 from emp
                 where ename = 'SCOTT');

--SCOTT과 같은 부서에서 일하는 사람의 이름과 급여
select dno from emp where ename = 'SCOTT'; --단일행 쿼리
select ename, salary from emp where dno = 20;

select ename, salary from emp where dno = (select dno from emp where ename = 'SCOTT');

--메인 쿼리에 조건을 기술하기 위해 where절 대신 having절 사용 가능
--서브 쿼리문의 결과값을 그룹함수와 비교해야 할 경우 having절을 사용 가능

--30번 부서의 최소 급여를 구한 후 부서별 최소 급여가 최소급여보다 큰 부서만 출력
select min(salary)
from emp
where dno = 30;

select dno, min(salary)
from emp
group by dno
having min(salary) > (select min(salary)
                      from emp
                      where dno = 30);
                      
--단일행 서브쿼리
--내부 쿼리문의 결과로 얻어지는 로우가 한개
--단일 행 비교 연산자 (>, >=, <, <=, <>)

--다중행 서브쿼리
--내부 쿼리문의 결과로 얻어지는 로우가 여러개
--다중행 비교 연산자 (IN, ANY, SOME, ALL, EXISTS)
--IN : 메인 쿼리 비교 조건(=)이 서브쿼리의 결과 중에서 하나라도 일치하면 참
--ANY, SOME : 메인 쿼리 비교 조건이 서브쿼리의 검색 결과와 하나 이상이 일치하면 참
--ALL : 메인 쿼리 비교 조건이 서브쿼리의 검색 결과와 모든 값이 일치하면 참
--EXISTS : 메임 쿼리 비교 조건이 서브쿼리의 결과 중에서 만족하는 값이 하나라도 존재하면 참

--부서별 최소 급여를 받는 사원의 사원 번호와 이름을 출력
select eno, ename
from emp
where salary in (select min(salary) from emp group by dno);
-- '=' 사용 불가. 여러개의 값을 받아 처리할 수 없기 때문에

-- <any : 최대값보다 작음, >any : 최소값보다 큼, = any : in과 동일

--직급이 salseman이 아니면서 급여가 임의의 salesman보다 낮은 사원 출력
select * from emp;
select eno, ename, job, salary from emp where salary < any (select salary from emp where job = 'SALESMAN') and job <> 'SALESMAN';
--직급이 salseman이 아니면서 직급이 salesman인 사원보다 급여가 적은 사원 출력
select min(salary) from emp where job = 'SALESMAN';
select eno, ename, job, salary from emp where salary < all (select salary from emp where job = 'SALESMAN');
--사원번호가 7788인 사원과 담당 업무가 같은 사원의 이름과 담당업무 검색
select ename, job from emp where job  = (select job from emp where eno = 7788);
--사원번호가 7788인 사원보다 급여가 많은 사원의 이름과 담당 업무
select ename, job from emp where salary > (select salary from emp where eno = 7788);
--최소 급여를 받는 사원의 이름, 담당업무 및 급여 검색
select ename, job, salary from emp where salary = (select min(salary) from emp);

--사원번호가 7499인 사원과 담당 업무가 같은 사원의 이름과 담당업무 검색
select ename, job from emp where dno = (select dno from emp where eno = 7499);
--사원번호가 7499인 사원보다 급여가 많은 사원의 이름과 담당 업무
select ename, job from emp where salary > (select salary from emp where eno = 7499);
--최소 급여를 받는 사원의 이름, 담당업무 및 급여 검색
select ename, job, salary from emp where salary = (select min(salary) from emp);
--평균 급여가 가장 적은 사원의 담당업무를 찾아 직급과 급여 평균을 출력
select * from emp;
select job, round(avg(salary),1) from emp group by job having round(avg(salary),1) = (select min(round(avg(salary),1)) from emp group by job); 
select min(avg(salary)) from emp group by job;

--각 부서의 최소 급여를 받는 사원을 검색하여 이름, 급여, 부서번호를 출력
select ename, salary, dno from emp where salary in (select min(salary) from emp group by dno);
select ename, salary, dno from emp where salary = any (select min(salary) from emp group by dno);

--담당 업무가 analyst인 사원보다 급여가 적으면서 업무가 analyst가 아닌 사원들 중 사원번호, 이름, 담당업무, 급여를 출력
select eno, ename, job, salary from emp where salary < any (select salary from emp where job = 'ANALYST') and job <> 'ANALYST';

--부하직원이 없는 사원의 이름을 출력하시오
select ename from emp where manager is null;
select ename from emp where eno in (select eno from emp where manager is null);
select ename from emp where eno in (select eno from emp where manager is not null);

--BLAKE와 동일한 부서에 속한 사원의 일므과 입사일을 표시
select ename, hiredate from emp where dno = (select dno from emp where ename = 'BLAKE') and ename <> 'BLAKE';

--급여가 평균 급여보다 많은 사원들의 사원번호와 이름을 표시하되 결과를 급여에 대해서 오름차순으로 정렬
SELECT ENO, ENAME FROM EMP WHERE SALARY > (SELECT AVG(SALARY) FROM EMP) ORDER BY SALARY ASC;

--이름에 K가 포함된 사원과 같은 부서에서 일하는 사원의 사원 번호와 이름
SELECT ENO, ENAME FROM EMP WHERE DNO IN (SELECT DNO FROM EMP WHERE ENAME LIKE '%K%');

select * from emp;
--부서 위치가 dallas인 사원의 이름과 부서번호 및 담당업부
select ename, dno, job from emp where dno = (select dno from dept where loc = 'DALLAS');

--king에게 보고하는 모든 사원의 이름과 급여
select ename, salary from emp where manager = (select eno from emp where ename = 'KING');

--평균 급여보다 많은 급여를 받고 이름에 M이 포함된 사원과 같은 부서에서 근무하는 사원의 사원번호, 이름, 급여
--select eno, ename, salary from emp where dno in (select dno from emp where salary > (select avg(salary) from emp) and ename like '%M%');
select eno, ename, salary from emp where salary > (select avg(salary) from emp) and dno in (select dno from emp where ename like '%M%');

--평균 급여가 가장 적은 업무를 찾아 직업, 평균 급여를 표시
select job, avg(salary) from emp group by job having avg(salary) = (select min(avg(salary)) from emp group by job);

--담당 업무가 MANAGER인 사원이 소속된 부서와 동일한 부서의 사원
select ename from emp where dno in (select dno from emp where job = 'MANAGER');

-- DML
    -- select
    -- insert
    -- update
    -- delete

-- DDL(데이터 정의어)
    -- create table 
    -- drop table
    -- alter table 
    -- rename
    -- truncate 

-- TCL
    -- commit, rollback
    
-- Data Dictionary
-- 사용자와 데이터베이스 자원의 효율적인 관리를 위한 다양한 정보를 저장하는 시스템 테이블로, 자동으로 갱신된다.
-- 접두어
-- USER_ : 자신의 계정이 소유한 객체 등에 관한 정보 조회
-- ALL_ : 자신의 계정을 소유하거나 권한을 부여 받은 객체 등에 관한 정보 조회
-- DBA_ : 데이터베이스 관리자만 접근 가능한 객체 등의 정보 조회

select table_name from user_tables;
select sequence_name from user_sequences;
select view_name from user_views;

select owner, table_name from all_tables;
select owner, table_name from dba_tables;

--다른 테이블에서 데이터 복사하기
select * from dept;

create table dept_copy  as select * from dept;
select * from dept_copy;

--10번 부서의 지역명을 20번 부서의 지역명으로 변경하시오
update dept_copy set loc = (select loc from dept_copy where dno = 20) where dno = 10;
rollback;

--여러개의 컬럼값을 동시에 변경
update dept_copy set dname = (select dname from dept_copy where dno = 30), 
                     loc = (select loc from dept_copy where dno = 30) 
                 where dno = 10;
select * from dept_copy;

-- 다른 테이블을 기반으로 로우삭제
create table emp_copy as select * from emp;
select * from emp_copy;
delete emp_copy where dno = (select dno from dept where dname = 'SALES');

-- 트랜잭션 관리
-- 여러개의 명령어 집합이 정상적으로 처리되면 정상 종료하고, 하나라도 잘못된다면 전체를 취소한다.
-- DML 작업이 성공적으로 처리되었으면 commit을, 취소해야한다면 rollback을 실행
-- commit은 트랜잭션 처리 과정을 반영하여 변경된 내용을 모두 영구 저장한다
-- rollback은 트랜잭션 처리 과정 중 발생한 변경사항을 취소한다
-- rollback을 실행하면 하나의 묶음 처리가 시작되기 이전 상태로 돌아간다

-- 제약조건
-- 테이블에 유효하지 않은 데이터가 입력되는 것을 방지하기 위해 태이블 생성 시 각 컬럼에 대해 정의하는 규칙
-- not null : null 값을 포함하지 못하도록 지정
-- unique : 모든 로우에 대해 유일한 값
-- primary key : 각 행을 식별하기 위해 not null과 unique 조건을 결합
-- foreign key : 참조되는 테이블에 컬럼값이 항상 존재해야 함
-- check : 저장 가능한 데이터 값의 범위나 조건을 지정하여 설정한 값만 허용

create table emp2 (
    eno number(4) constraint emp2_pk primary key,
    ename varchar2(10),
    salary number constraint emp2_min check(salary > 0)
);

insert into emp2 values (11, 'aaa', -100);
alter table emp2 add birth date default sysdate;

-- 뷰(View) 테이블
-- 물리적인 테이블을 근거한 논리적인 가상 테이블
-- 디스크 저장 공간이 할당되지 않는다
-- 단순 뷰 : 하나의 기본 테이블로 생성한 뷰
-- 복합 뷰 : 두개 이상의 기본 테이블로 생성한 뷰
-- 뷰를 사용하는 이유 : 보안과 사용의 편의성

-- 보안을 위한 뷰활용
create view v_emp_sample as
    select eno, ename, job, manager, dno from emp;
select * from v_emp_sample;

-- 정보를 손쉽게 얻기 위해 뷰 활용
create view v_emp_sample2 as
    select e.eno, e.ename, e.salary, dno, d.dname, d.loc
    from emp e natural join dept d;

select * from v_emp_sample2;

-- 뷰는 데이터를 저장하고 있지 않은 가상테이블이므로 실체가 없다.
-- 뷰가 테이블처럼 사용될 수 있는 이유는 뷰를 정의할 때 create view 명령어 다음의 as절에 기술한 쿼리 문장 자체를 저장하고 있다가 이를 실행하기 때문이다.

-- 뷰에 그룹함수 사용하기
create view v_emp_salary
    as
    select dno, sum(salary) as "salsum", avg(salary) as "salavg"
    from emp group by dno;
-- 그룹 함수에 대해 컬럼 명칭을 사용할 것. 사용하지 않으면 오류
-- 그룹함수를 가상 컬럼으로 갖는 뷰에 대해 dml문 사용 불가

insert into v_emp_salary values (8000, 1000, 300); --에러

-- 뷰 제거
drop view v_emp_salary;

-- 인덱스
-- 검색 속도를 향상시키기 위해 사용
-- 기본키나 유일한 키는 인덱스가 자동으로 생성된다.
commit;
select * from member_tbl_02;
delete from member_tbl_02 where custno = 100007;

select * from money_tbl_02;

select mem.custno, mem.custname, mem.grade, sum(price) as price
from member_tbl_02 mem, money_tbl_02 mon
where mem.custno = mon.custno
group by mem.custno, mem.custname, mem.grade
order by price desc;

select * from member_tbl_02;

select mem.custno, mem.custname, mem.grade, sum(mon.price) as price
from member_tbl_02 mem, money_tbl_02 mon
where mem.custno = mon.custno
group by mem.custno, mem.custname, mem.grade
order by price desc;

select * from tbl_student_201905;
select * from tbl_score_201905;

select std.syear, std.sclass, std.sno, std.sname, 
decode(std.gender, 'M', '남',
                   'F', '여') as gender, 
sc.kor, sc.eng, sc.mat, sum(kor+eng+mat) as tot, 
round(avg((kor+eng+mat)/3),1) as ave 
from tbl_student_201905 std, tbl_score_201905 sc 
where std.sno = sc.sno and std.sclass = sc.sclass
group by std.syear, std.sclass, std.sno, std.sname, sc.kor, 
sc.eng, sc.mat, decode(std.gender, 'M', '남', 'F', '여')
order by sclass asc, sno asc;

select sum(kor) as tkor, sum(eng) as teng, sum(mat) as tmat
from tbl_score_201905;

select avg(kor) as akor, avg(eng) as aeng, avg(mat) as amat
from tbl_score_201905;

select dept.syear, dept.sclass, dept.tname, 
sum(kor) as tkor, sum(eng) as teng, sum(mat) as tmat,
round(avg(kor),1) as akor, round(avg(eng),1) as aeng, round(avg(mat),1) as amat
from tbl_dept_201905 dept, tbl_score_201905 score
where dept.sclass = score.sclass
group by dept.syear, dept.tname, dept.sclass;

delete from tbl_student;

create table notice (
    idx number(4) not null,
    title varchar2(200) not null,
    content varchar2(4000) not null,
    writer varchar2(20) not null,
    regdate date default sysdate,
    viewcount number(4) default 0,
    constraint notice_pk primary key (idx)
);

create sequence notice_seq;

select * from notice order by idx desc;
select count(*) as count from notice where idx is not null;
commit;

update notice set viewcount = viewcount+1 where idx = 1;

update notice set title='수정', content='함', writer='내가' where idx = 22;

select title, idx from notice where idx = (select max(idx) from notice where idx < 4);
select title from notice where idx = (select min(idx) from notice where idx > 4);

select * from notice where title like '%구하%';

--페이징처리
--order by 보다는 index
-- select /*+ */ 풀 힌트
-- 풀 힌트 내부의 에러가 있어도 select문은 실행됨

select * from notice where idx > 0 order by idx desc;
select /*+ index_desc(notice notice_pk) */ * from notice where idx > 0;

-- rownum 과 인라인 뷰
-- 페이지 처리를 하기 위해 데이터의 순번을 붙이고 rownum 이라는 키워드 사용
-- mysql은 limit 키워드 사용
select /*+ index_asc (notice notice_pk)*/ rownum rn, idx, title from notice;
select /*+ index_desc (notice notice_pk)*/ rownum rn, idx, title from notice;

select * from notice;

select /*+ index_desc (notice notice_pk)*/ rownum rn, idx, title from notice where rownum <= 3;
--논리상으로 맞는거 같지만 실제로는 결과가 안나옴
select /*+ index_desc (notice notice_pk)*/ rownum rn, idx, title from notice where 0 < rownum and rownum <= 10;
insert into notice (idx, title, content, writer) values (notice_seq.nextval, '정상화의 신', '나는 찬양할 수 밖에 없어', '신창섭');
insert into notice (idx, title, content, writer) values (notice_seq.nextval, '인장주작은 뭐야', '씨발년', '신창섭');
insert into notice (idx, title, content, writer) values (notice_seq.nextval, '다 해줬잖아', '그냥 씨발 다 해줬잖아', '신창섭');
commit;
-- rownum을 이용한 페이지 검색 방법(inline view)
select * from (
    select /*+ index_desc (notice notice_pk)*/ 
    rownum rn, idx, title, content, writer, regdate, viewcount
    from notice
    where rownum <= 20)
where rn > 10;

select * from (
    select /*+ index_desc (notice notice_pk)*/
    rownum rn, idx, title, content, writer, regdate, viewcount
    from notice
    where rownum <= 20 and title like '%정상화%')
where rn > 10;
select count(*) as count from notice;

--포트폴리오 테이블
create table portfolio (
    idx number not null,
    regdate date default sysdate,
    title varchar2(200) not null,
    content varchar2(4000) not null,
    writer varchar2(20) not null,
    viewcount number default 0,
    imgurl varchar2(200),
    constraint portfolio_pk primary key (idx)
);

create sequence portfolio_seq;
select /*+ index_desc (portfolio portfolio_pk)*/ * from portfolio;
select * from (select /*+ index_desc (portfolio portfolio_pk)*/
            rownum rn, idx, regdate, title, content, writer, viewcount, imgurl
            from portfolio 
            where rownum <= (1 * 5))
where rn > ((1 - 1) * 5);

select /*+ index_desc (portfolio portfolio_pk)*/ *
from portfolio;

create table hanulso (
    member_idx number not null,
    name varchar2(30) not null,
    id varchar2(50) not null,
    password varchar2(500) not null,
    phone varchar2(15) not null,
    email varchar2(50) not null,
    constraint hanulso_pk primary key (member_idx)
);

create sequence hanulso_seq;

insert into hanulso values (1, '관리자', 'system', '1234', '0212345678', 'dyddnr25@gmail.com');
select * from hanulso;
commit;

