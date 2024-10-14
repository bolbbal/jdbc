create table score(
    bno number(4) not null,
    name varchar2(12) not null,
    kor number(3) not null,
    eng number(3) not null,
    mat number(3) not null,
    CONSTRAINT score_pk primary key (bno)
);
-- DML : insert, select, update, delete
insert into score (bno, name, kor, eng, mat) values (1, 'ȫ�浿', 100, 100, 100);
insert into score (bno, name, kor, eng, mat) values (2, '��浿', 90, 90, 90);
insert into score (bno, name, kor, eng, mat) values (3, '�ڱ浿', 40, 6, 70);
insert into score (bno, name, kor, eng, mat) values (4, '�ֱ浿', 50, 60, 80);
insert into score (bno, name, kor, eng, mat) values (5, '�ڱ浿', 85, 95, 70);

commit;
-- �ݵ�� commit �� ��
select * from score;
select name from score;
select name, bno from score;
select * from score where kor>=90;
select * from score where kor >= 90 and eng >= 90 and mat >= 90;
select * from score where name like '��%';
select * from score where name like '%��';
select * from score where name like '%��%';
select * from score where name like '��%';
select * from score where name like '��%' and kor >= 90;
select * from score where name like '��%' or kor >= 90;
select * from score where bno = 3;
select * from score where bno < 3;
select * from score;
-- 
--sequence
--������ 1�� �����ϸ鼭 ������ ���� ���� �� ���
create sequence score_seq;

--����
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

--����
select * from score;
update score set kor = 80, eng = 97, mat = 88 where bno = 5;
update score set name = '��Ʋ��' where name = '�����';
update score set kor = 65 where name = 'ä����';
update score set kor = kor+5 where name like '%��%';

select * from score;
--insert, delete, update�� �ݵ�� commit�Ұ�!

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
--�׷��ռ�
select * from emp;
select sum(commission) as Ŀ�̼��Ѿ� from emp;
select sum(salary) saltot from emp;
--���̺� �� ����
select count(*) as ����Ǽ� from emp;
select count(distinct job) as ������ from emp;
select max(salary) from emp;
select * from emp;
select dno, avg(salary) as salave from emp group by dno order by salave asc;
--�μ���, ������ �ο� ���� �޿� �Ѿ�, �޿� ����� ���Ͻÿ�
select dno, job, count(*) as jobtot, sum(salary) as saltot, avg(salary) as salave
from emp
group by dno, job
order by dno, job;
--�׷� ��� ����
--��� ���̺��� �μ��� �ְ� ���� �޴� ����� �޿��� ���϶�
--��, �޿��� 3000���� �̻��� ����� ��
select dno, max(salary) as maxsal
from emp
group by dno
having max(salary) >= 3000;
--���̺� ��ü ���� ������ where, �׷� ���� ������ �� ������ having
select * from emp;
select * from emp where ename = upper('scott');
select * from emp where ename = lower('scott');
--���� ���� ��ȯ
select length('oracle'), lengthb('����Ŭ') from dual; --b�� byte 
--���ڿ� ����
select 'oracle', 'mania', concat('Oracle', 'mania') from dual;
--���ڿ� �Ϻ� ����
select substr('oracle mania', 4, 3) from dual;
--87�⵵�� �Ի��� ��� ����
select * from emp;
select * from emp where substr(hiredate, 1, 2) = '87';
select * from emp where substr(ename, -1, 1) = 'N';
--���� �ڸ��� Ư�� ��ȣ ä���
select LPAD(salary, 10, '*') from emp;
select RPAD(salary, 10, '*') from emp;
--���� ����
select trim('   oracle  mania   ') from dual;
--�ݿø�
select 98.7654, round(98.7654), round(98.7654, 2), round(98.7654, -1) from dual;
--����
select 98.7654, trunc(98.7654), trunc(98.7654, 2), trunc(98.7654, -1) from dual;
--���� ��¥ �˻�
select sysdate from dual;
--��¥ ����
select sysdate-1 yesterday, sysdate today, sysdate+1 tomorrow from dual;
--��¥ �ݿø�
select round(sysdate - hiredate) �ٹ��ϼ� from emp;
--��¥ �ڸ���
select hiredate, trunc(hiredate, 'MONTH') from emp;
--��¥�� ��¥ ������ ���� �� ���ϱ�
select ename, sysdate, hiredate, trunc(months_between(sysdate, hiredate)) from emp;
--�ش� ��¥�� �������� ó�� ���ƿ�� ���Ͽ� �ش��ϴ� ��¥ ���ϱ�
select sysdate, next_day(sysdate, '�����') from dual;
--�ش� ��¥�� ���� ���� ������ ��¥ ���ϱ�
select ename, hiredate, last_day(hiredate) from emp;
--��¥�� ���ڸ� ���ڷ� ����ȯ
select ename, hiredate, to_char(hiredate, 'YY-MM'), to_char(hiredate, 'YYYY/MM/DD DAY') from emp;
--���ڿ��� ��¥ ������ ��ȯ
select ename, hiredate from emp where hiredate = to_date('19810220');
--���������� ����ȯ
select to_number('100000') - to_number('50000') from dual;
--null �Ǵ� 0�� �ٸ� ������ ��ȯ
select ename, salary, commission, NVL(commission, 0), salary*12+nvl(commission, 0) from emp order by job;
--�����ǿ� ���� �پ��� ���á�
select ename, dno, decode(dno, 10, 'aaa',
                20, 'bbb',
                30, 'ccc',
                'default') as dname from emp;
select ename, dno, case when dno = 10 then 'aaa'
                        when dno = 20 then 'bbb'
                        when dno = 30 then 'ccc'
                        else 'default' end as dname from emp;
--�ڡڡڡڡڡڡ����̺� ���Ρڡڡڡڡڡ�
--���� ���̺� ����� �����͸� �ѹ��� ��ȸ�ؾ� �� �ʿ䰡 ���� �� ���
--3���� ���̺��� ������ ���� ���� 2���� ���̺��� �����ϰ�, �� ����� ���Ӵ� ���̺��� �����Ѵ�
--join�� ����
--inner join(equal join, natual join, cross join) null ������ �����ʹ� ������� ����. ����ϰ� �ʹٸ� outer join�� �����
--outer join(left join, right join, full outer join)

--7788�� ����� �̸��� �Ҽ� �μ����� �˻��Ͻÿ�
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

--��ȣ�� �÷��� �ڼ��� �����Ͽ� �˻��ϱ�
select e.eno, e.ename, e.salary, e.dno, d.dname
from emp e, dept d
where e.dno = d.dno and e.eno = 7788;

--������ ������ �����ϰų� ������ �÷��� �����Ͽ� �˻�
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
--where ���� <, between a and b �� ���� = ������ �ƴ� �����ڸ� ���
select ename, salary, grade
from emp, sal
where salary between losal and hisal;

--3���� ���̺� �����ϱ�
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
insert into tbl_student_201905 values ('1', '01', '01', '���л�', '20020101', 'F', '010', '1234', '1001');
insert into tbl_student_201905 values ('1', '01', '02', '���л�', '20020201', 'M', '010', '1234', '1002');
insert into tbl_student_201905 values ('1', '01', '03', '���л�', '20020301', 'M', '010', '1234', '1003');
insert into tbl_student_201905 values ('1', '02', '01', '���л�', '20020401', 'M', '010', '1234', '1004');
insert into tbl_student_201905 values ('1', '02', '02', '���л�', '20020501', 'M', '010', '1234', '1005');
insert into tbl_student_201905 values ('1', '02', '03', '���л�', '20020601', 'M', '010', '1234', '1006');
insert into tbl_student_201905 values ('1', '03', '01', '���л�', '20020701', 'F', '010', '1234', '1007');
insert into tbl_student_201905 values ('1', '03', '02', 'Ȳ�л�', '20020801', 'F', '010', '1234', '1008');
insert into tbl_student_201905 values ('1', '03', '03', '���л�', '20020901', 'F', '010', '1234', '1009');
select * from tbl_student_201905;
commit;
create table tbl_dept_201905 (
    syear char(1) not null,
    sclass char(2) not null,
    tname varchar2(20),
    constraint tbl_dept_pk primary key (syear, sclass)
);
insert into tbl_dept_201905 values ('1', '01', '�豳��');
insert into tbl_dept_201905 values ('1', '02', '�̱���');
insert into tbl_dept_201905 values ('1', '03', '�ڱ���');
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
insert into tbl_artist_201905 values ('A001', '�轺Ÿ', 'F', '19970101', '1', 'A�������θ�Ʈ');
insert into tbl_artist_201905 values ('A002', '����Ÿ', 'M', '19980201', '2', 'B�������θ�Ʈ');
insert into tbl_artist_201905 values ('A003', '�ս�Ÿ', 'M', '19990301', '3', 'C�������θ�Ʈ');
insert into tbl_artist_201905 values ('A004', '����Ÿ', 'M', '20000401', '1', 'D�������θ�Ʈ');
insert into tbl_artist_201905 values ('A005', 'ȫ��Ÿ', 'F', '20010501', '2', 'E�������θ�Ʈ');
select * from tbl_artist_201905;
delete from tbl_artist_201905 where artist_id = 'A006';
create table tbl_mento_201905 (
    mento_id char(4) not null primary key,
    mento_name varchar2(20)
);
insert into tbl_mento_201905 values ('J001', '�Ը���');
insert into tbl_mento_201905 values ('J002', '�ڸ���');
insert into tbl_mento_201905 values ('J003', '�����');
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
INSERT INTO TBL_ENTRY_202106 VALUES ('0001', '��濬', '9901011000001', '1', '����');
INSERT INTO TBL_ENTRY_202106 VALUES ('0002', '�̰濬', '9801022000002', '2', '����');
INSERT INTO TBL_ENTRY_202106 VALUES ('0003', '�ڰ濬', '9701031000003', '3', '����');
INSERT INTO TBL_ENTRY_202106 VALUES ('0004', '���濬', '9601042000004', '4', '����');
INSERT INTO TBL_ENTRY_202106 VALUES ('0005', '�ϰ濬', '9501051000005', '1', '����');
INSERT INTO TBL_ENTRY_202106 VALUES ('0006', 'Ȳ�濬', '9401062000006', '2', '����');
INSERT INTO TBL_ENTRY_202106 VALUES ('0007', '���濬', '9301071000007', '3', '���');
INSERT INTO TBL_ENTRY_202106 VALUES ('0008', '��濬', '9201082000008', '4', '���');
INSERT INTO TBL_ENTRY_202106 VALUES ('0009', '���濬', '9101091000009', '1', '����');
INSERT INTO TBL_ENTRY_202106 VALUES ('0010', '���濬', '9001102000010', '2', '����');
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
INSERT INTO TBL_REFEREE_202106 VALUES ('��ɻ�', '�̽ɻ�', '�ڽɻ�', 'Ȳ�ɻ�', '���ɻ�');
SELECT * FROM tbl_referee_202106;
insert into tbl_record_202106 (entry_no, score1, score2, score3, score4, score5, s_max, s_min, s_tot, s_ave)
values ('0011', 100, 100, 100, 100, 95, greatest(100, 100, 100, 100, 95), least(100, 100, 100, 100, 95), (100+100+100+100+95), (100+100+100+100+95)/5);
--�������� �÷� �� �ִ밪, �ּҰ� ���ϱ�
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

insert into tbl_company_employee values ('E001', '������', '01', '20', '31', 'C', '20200825');
insert into tbl_company_employee values ('E002', '������', '02', '30', '32', 'C', '20210112');
insert into tbl_company_employee values ('E003', '��ȣ��', '02', '40', '32', 'D', '20210325');
insert into tbl_company_employee values ('E004', '������', '03', '50', '40', 'B', '20210814');
select * from tbl_company_employee;
commit;
create table tbl_company_depart (
    depart_code char(2) not null,
    name varchar2(20),
    constraint depart_pk primary key (depart_code)
);
insert into tbl_company_depart values ('01', '�λ�');
insert into tbl_company_depart values ('02', '�ѹ�');
insert into tbl_company_depart values ('03', '����');
insert into tbl_company_depart values ('04', '����');
select * from tbl_company_depart;
commit;
create table tbl_company_level (
    level_code char(2) not null,
    name varchar2(20),
    salary number(8),
    constraint level_pk primary key (level_code)
);
insert into tbl_company_level values ('10', '�̻�', 4500000);
insert into tbl_company_level values ('20', '����', 3500000);
insert into tbl_company_level values ('30', '����', 3000000);
insert into tbl_company_level values ('40', '�븮', 2500000);
insert into tbl_company_level values ('50', '���', 2000000);
select * from tbl_company_level;
commit;
create table tbl_company_work (
    work_place char(2) not null,
    name varchar2(20),
    constraint work_pk primary key (work_place)
);
insert into tbl_company_work values ('31', '����������');
insert into tbl_company_work values ('32', 'û�ֿ�����');
insert into tbl_company_work values ('33', '���ֿ�����');
insert into tbl_company_work values ('40', '�泲����');
insert into tbl_company_work values ('50', '����');
select * from tbl_company_work;
commit;

select * from tbl_company_employee;
desc tbl_company_employee;
select * from tbl_company_depart;
select * from tbl_company_level;
select * from tbl_company_work;
--����Ŭ ����
-- select from where ���� > ��� ���̺� ���� ����ϴ� ���̺� from�� �ۼ� > 
-- ���̺� ���� ����� ������ select�� �ۼ� > ���̺� ���� where ������ ����

-- ��� ��� ��ȸ
select e.e_no, e.e_name, d.name, l.name, w.name, e.performance, e.e_join_date
from tbl_company_employee e, tbl_company_depart d, tbl_company_level l, tbl_company_work w
where e.e_depart = d.depart_code and e.e_level = l.level_code and e.e_work_place = w.work_place
order by e.e_no asc;

-- ��� �޿� ��ȸ
select e.e_no, e.e_name as ename, d.name as dname, l.name as lname, w.name as wname, e.performance,
decode(e.performance, 'D', l.salary ,
                      'C', l.salary + (l.salary * 0.05),
                      'B', l.salary + (l.salary * 0.08),
                      'A', l.salary + (l.salary * 0.1)) as salary
from tbl_company_employee e, tbl_company_depart d, tbl_company_level l, tbl_company_work w
where e.e_depart = d.depart_code and e.e_level = l.level_code and e.e_work_place = w.work_place
order by e.e_level asc;

--�μ��� �޿� ��ȸ
select d.depart_code, d.name as dname, sum(decode(e.performance, 'D', l.salary,
                                                             'C', l.salary + (l.salary * 0.05),
                                                             'B', l.salary + (l.salary * 0.08),
                                                             'A', l.salary + (l.salary * 0.1))) as sal
from tbl_company_employee e, tbl_company_depart d, tbl_company_level l
where e.e_depart = d.depart_code and e.e_level = l.level_code 
group by d.depart_code, d.name
order by d.depart_code;
--������ �޿� ��ȸ
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
--��������ȸ
select e.e_no, e.e_name, d.name as dname, l.name as lname, w.name as wname, e.performance, e.e_join_date
from tbl_company_employee e, tbl_company_depart d, tbl_company_level l, tbl_company_work w
where e.e_depart = d.depart_code and e.e_level = l.level_code and e.e_work_place = w.work_place
order by e.e_no;
--����޿���ȸ
select e.e_no, e.e_name, d.name as dname, l.name as lname, w.name as wname, e.performance,
decode(e.performance, 'A', l.salary + (l.salary * 0.1),
                      'B', l.salary + (l.salary * 0.08),
                      'C', l.salary + (l.salary * 0.05),
                      'D', l.salary) as sal
from tbl_company_employee e, tbl_company_depart d, tbl_company_level l, tbl_company_work w
where e.e_depart = d.depart_code and e.e_level = l.level_code and e.e_work_place = w.work_place
order by d.depart_code;
--�μ����޿���ȸ
select d.depart_code, d.name as dname,
sum(decode(e.performance, 'A', l.salary + (l.salary * 0.1),
                      'B', l.salary + (l.salary * 0.08),
                      'C', l.salary + (l.salary * 0.05),
                      'D', l.salary)) as sal
from tbl_company_employee e, tbl_company_depart d, tbl_company_level l
where e.e_depart = d.depart_code and e.e_level = l.level_code
group by d.depart_code, d.name
order by d.depart_code;
--�������޿���ȸ
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
join tbl_company_work w -- inner �� ���� ����
on e.e_work_place = w.work_place
inner join tbl_company_level l
on e.e_level = l.level_code
group by w.work_place, w.name
order by w.work_place;

--outer join
--���� ������ null�� ���ڵ带 �˻��� �� ���
select * from emp;
select * from dept;

select e.eno, e.ename, e.manager, e.commission, d.dname
from emp e, dept d
where e.dno = d.dno;

select e.eno, e.ename, e.manager, e.commission, d.dname
from emp e
join dept d
on e.dno = d.dno;

--����Ŭ OUTER JOIN
select e.eno, e.ename, e.job, e.manager, e.commission, d.dname
from emp e, dept d
where e.dno = d.dno(+) and e.job = 'MANAGER';

--left outer join
select e.eno, e.ename, e.job, e.manager, e.commission, d.dname
from emp e
left outer join dept d
on e.dno = d.dno --���� ����
where e.job = 'MANAGER'; --�˻� ����

--self join
--�ϳ��� ���̺� �ִ� �÷����� �����ؾ� �ϴ� ������ �ʿ��� ���
--����� ���� ����� �˻�

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
insert into tbl_cusinfo_202010 values ('1001', '���', '9901011000001', '010', '1234', '0001');
insert into tbl_cusinfo_202010 values ('1002', '�̰�', '8901011000002', '010', '1234', '0002');
insert into tbl_cusinfo_202010 values ('1003', '�ڰ�', '7901011000003', '010', '1234', '0003');
insert into tbl_cusinfo_202010 values ('1004', '����', '6901011000004', '010', '1234', '0004');
insert into tbl_cusinfo_202010 values ('1005', 'Ȳ��', '5901011000005', '010', '1234', '0005');
insert into tbl_cusinfo_202010 values ('1006', 'ȫ��', '9501011000006', '010', '1234', '0006');
insert into tbl_cusinfo_202010 values ('1007', '�ְ�', '8701011000007', '010', '1234', '0007');
commit;

create table tbl_oilinfo_202010 (
    oiltype char(1) not null,
    oilname varchar2(20),
    constraint oil_pk primary key (oiltype)
);
insert into tbl_oilinfo_202010 values ('1', '�ֹ���');
insert into tbl_oilinfo_202010 values ('2', '����ֹ���');
insert into tbl_oilinfo_202010 values ('3', '����');
insert into tbl_oilinfo_202010 values ('4', '����');
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

--��ü������ȸ
select s.saleno, s.oildate, o.oilname, s.amount, s.paytype, c.custname, c.custno, c.custtel1, c.custtel2, c.custtel3, s.creditcart, s.oilcost
from tbl_saleinfo_202010 s
left outer join tbl_oilinfo_202010 o
on s.oiltype = o.oiltype
left outer join tbl_cusinfo_202010 c
on s.custno = c.custno
order by s.saleno;

select s.saleno, 
TO_CHAR(TO_DATE(s.oildate, 'YYYYMMDD'), 'YYYY"��"MM"��"DD"��"') as oildate, o.oilname, s.amount, s.paytype, c.custname, c.custno, 
c.custtel1||'-'||c.custtel2||'-'||c.custtel3 as tel, s.creditcart, s.oilcost
from tbl_saleinfo_202010 s
left outer join tbl_oilinfo_202010 o
on s.oiltype = o.oiltype
left outer join tbl_cusinfo_202010 c
on s.custno = c.custno
order by s.saleno;

--�� �������
select s.oildate, o.oilname, count(s.oiltype) as count, sum(s.oilcost) as tot
from tbl_saleinfo_202010 s, tbl_oilinfo_202010 o
where s.oiltype = o.oiltype
group by s.oildate, o.oilname
order by s.oildate asc, o.oilname asc;

select to_char(to_date(s.oildate,'yyyyMMdd'), 'yyyy"��"MM"��"dd"��"') as oildate, o.oilname, count(s.oiltype) as count, sum(s.oilcost) as tot
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
insert into member_tbl_02 values (100001, '���ູ', '010-1111-2222', '���� ���빮�� �ְ�1��', '20151202', 'A', '01');
insert into member_tbl_02 values (100002, '���ູ', '010-1111-3333', '���� ���빮�� �ְ�2��', '20151206', 'B', '01');
insert into member_tbl_02 values (100003, '�����', '010-1111-4444', '�︪�� �︪�� ����1��', '20151001', 'B', '30');
insert into member_tbl_02 values (100004, '�ֻ��', '010-1111-5555', '�︪�� �︪�� ����2��', '20151113', 'A', '30');
insert into member_tbl_02 values (100005, '����ȭ', '010-1111-6666', '���ֵ� ���ֽ� �ܳ�����', '20151225', 'B', '60');
insert into member_tbl_02 values (100006, '������', '010-1111-7777', '���ֵ� ���ֽ� �ܳ�����', '20151211', 'C', '60');
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

--��������
--scott���� ���� �޿��� �޴� ����� ã���ÿ�
select ename, salary from emp where ename = 'SCOTT';
select ename, salary from emp where salary > 3000;

select ename, salary
from emp
where salary  > (select salary
                 from emp
                 where ename = 'SCOTT');

--SCOTT�� ���� �μ����� ���ϴ� ����� �̸��� �޿�
select dno from emp where ename = 'SCOTT'; --������ ����
select ename, salary from emp where dno = 20;

select ename, salary from emp where dno = (select dno from emp where ename = 'SCOTT');

--���� ������ ������ ����ϱ� ���� where�� ��� having�� ��� ����
--���� �������� ������� �׷��Լ��� ���ؾ� �� ��� having���� ��� ����

--30�� �μ��� �ּ� �޿��� ���� �� �μ��� �ּ� �޿��� �ּұ޿����� ū �μ��� ���
select min(salary)
from emp
where dno = 30;

select dno, min(salary)
from emp
group by dno
having min(salary) > (select min(salary)
                      from emp
                      where dno = 30);
                      
--������ ��������
--���� �������� ����� ������� �ο찡 �Ѱ�
--���� �� �� ������ (>, >=, <, <=, <>)

--������ ��������
--���� �������� ����� ������� �ο찡 ������
--������ �� ������ (IN, ANY, SOME, ALL, EXISTS)
--IN : ���� ���� �� ����(=)�� ���������� ��� �߿��� �ϳ��� ��ġ�ϸ� ��
--ANY, SOME : ���� ���� �� ������ ���������� �˻� ����� �ϳ� �̻��� ��ġ�ϸ� ��
--ALL : ���� ���� �� ������ ���������� �˻� ����� ��� ���� ��ġ�ϸ� ��
--EXISTS : ���� ���� �� ������ ���������� ��� �߿��� �����ϴ� ���� �ϳ��� �����ϸ� ��

--�μ��� �ּ� �޿��� �޴� ����� ��� ��ȣ�� �̸��� ���
select eno, ename
from emp
where salary in (select min(salary) from emp group by dno);
-- '=' ��� �Ұ�. �������� ���� �޾� ó���� �� ���� ������

-- <any : �ִ밪���� ����, >any : �ּҰ����� ŭ, = any : in�� ����

--������ salseman�� �ƴϸ鼭 �޿��� ������ salesman���� ���� ��� ���
select * from emp;
select eno, ename, job, salary from emp where salary < any (select salary from emp where job = 'SALESMAN') and job <> 'SALESMAN';
--������ salseman�� �ƴϸ鼭 ������ salesman�� ������� �޿��� ���� ��� ���
select min(salary) from emp where job = 'SALESMAN';
select eno, ename, job, salary from emp where salary < all (select salary from emp where job = 'SALESMAN');
--�����ȣ�� 7788�� ����� ��� ������ ���� ����� �̸��� ������ �˻�
select ename, job from emp where job  = (select job from emp where eno = 7788);
--�����ȣ�� 7788�� ������� �޿��� ���� ����� �̸��� ��� ����
select ename, job from emp where salary > (select salary from emp where eno = 7788);
--�ּ� �޿��� �޴� ����� �̸�, ������ �� �޿� �˻�
select ename, job, salary from emp where salary = (select min(salary) from emp);

--�����ȣ�� 7499�� ����� ��� ������ ���� ����� �̸��� ������ �˻�
select ename, job from emp where dno = (select dno from emp where eno = 7499);
--�����ȣ�� 7499�� ������� �޿��� ���� ����� �̸��� ��� ����
select ename, job from emp where salary > (select salary from emp where eno = 7499);
--�ּ� �޿��� �޴� ����� �̸�, ������ �� �޿� �˻�
select ename, job, salary from emp where salary = (select min(salary) from emp);
--��� �޿��� ���� ���� ����� �������� ã�� ���ް� �޿� ����� ���
select * from emp;
select job, round(avg(salary),1) from emp group by job having round(avg(salary),1) = (select min(round(avg(salary),1)) from emp group by job); 
select min(avg(salary)) from emp group by job;

--�� �μ��� �ּ� �޿��� �޴� ����� �˻��Ͽ� �̸�, �޿�, �μ���ȣ�� ���
select ename, salary, dno from emp where salary in (select min(salary) from emp group by dno);
select ename, salary, dno from emp where salary = any (select min(salary) from emp group by dno);

--��� ������ analyst�� ������� �޿��� �����鼭 ������ analyst�� �ƴ� ����� �� �����ȣ, �̸�, ������, �޿��� ���
select eno, ename, job, salary from emp where salary < any (select salary from emp where job = 'ANALYST') and job <> 'ANALYST';

--���������� ���� ����� �̸��� ����Ͻÿ�
select ename from emp where manager is null;
select ename from emp where eno in (select eno from emp where manager is null);
select ename from emp where eno in (select eno from emp where manager is not null);

--BLAKE�� ������ �μ��� ���� ����� �Ϲǰ� �Ի����� ǥ��
select ename, hiredate from emp where dno = (select dno from emp where ename = 'BLAKE') and ename <> 'BLAKE';

--�޿��� ��� �޿����� ���� ������� �����ȣ�� �̸��� ǥ���ϵ� ����� �޿��� ���ؼ� ������������ ����
SELECT ENO, ENAME FROM EMP WHERE SALARY > (SELECT AVG(SALARY) FROM EMP) ORDER BY SALARY ASC;

--�̸��� K�� ���Ե� ����� ���� �μ����� ���ϴ� ����� ��� ��ȣ�� �̸�
SELECT ENO, ENAME FROM EMP WHERE DNO IN (SELECT DNO FROM EMP WHERE ENAME LIKE '%K%');

select * from emp;
--�μ� ��ġ�� dallas�� ����� �̸��� �μ���ȣ �� ������
select ename, dno, job from emp where dno = (select dno from dept where loc = 'DALLAS');

--king���� �����ϴ� ��� ����� �̸��� �޿�
select ename, salary from emp where manager = (select eno from emp where ename = 'KING');

--��� �޿����� ���� �޿��� �ް� �̸��� M�� ���Ե� ����� ���� �μ����� �ٹ��ϴ� ����� �����ȣ, �̸�, �޿�
--select eno, ename, salary from emp where dno in (select dno from emp where salary > (select avg(salary) from emp) and ename like '%M%');
select eno, ename, salary from emp where salary > (select avg(salary) from emp) and dno in (select dno from emp where ename like '%M%');

--��� �޿��� ���� ���� ������ ã�� ����, ��� �޿��� ǥ��
select job, avg(salary) from emp group by job having avg(salary) = (select min(avg(salary)) from emp group by job);

--��� ������ MANAGER�� ����� �Ҽӵ� �μ��� ������ �μ��� ���
select ename from emp where dno in (select dno from emp where job = 'MANAGER');

-- DML
    -- select
    -- insert
    -- update
    -- delete

-- DDL(������ ���Ǿ�)
    -- create table 
    -- drop table
    -- alter table 
    -- rename
    -- truncate 

-- TCL
    -- commit, rollback
    
-- Data Dictionary
-- ����ڿ� �����ͺ��̽� �ڿ��� ȿ������ ������ ���� �پ��� ������ �����ϴ� �ý��� ���̺��, �ڵ����� ���ŵȴ�.
-- ���ξ�
-- USER_ : �ڽ��� ������ ������ ��ü � ���� ���� ��ȸ
-- ALL_ : �ڽ��� ������ �����ϰų� ������ �ο� ���� ��ü � ���� ���� ��ȸ
-- DBA_ : �����ͺ��̽� �����ڸ� ���� ������ ��ü ���� ���� ��ȸ

select table_name from user_tables;
select sequence_name from user_sequences;
select view_name from user_views;

select owner, table_name from all_tables;
select owner, table_name from dba_tables;

--�ٸ� ���̺��� ������ �����ϱ�
select * from dept;

create table dept_copy  as select * from dept;
select * from dept_copy;

--10�� �μ��� �������� 20�� �μ��� ���������� �����Ͻÿ�
update dept_copy set loc = (select loc from dept_copy where dno = 20) where dno = 10;
rollback;

--�������� �÷����� ���ÿ� ����
update dept_copy set dname = (select dname from dept_copy where dno = 30), 
                     loc = (select loc from dept_copy where dno = 30) 
                 where dno = 10;
select * from dept_copy;

-- �ٸ� ���̺��� ������� �ο����
create table emp_copy as select * from emp;
select * from emp_copy;
delete emp_copy where dno = (select dno from dept where dname = 'SALES');

-- Ʈ����� ����
-- �������� ��ɾ� ������ ���������� ó���Ǹ� ���� �����ϰ�, �ϳ��� �߸��ȴٸ� ��ü�� ����Ѵ�.
-- DML �۾��� ���������� ó���Ǿ����� commit��, ����ؾ��Ѵٸ� rollback�� ����
-- commit�� Ʈ����� ó�� ������ �ݿ��Ͽ� ����� ������ ��� ���� �����Ѵ�
-- rollback�� Ʈ����� ó�� ���� �� �߻��� ��������� ����Ѵ�
-- rollback�� �����ϸ� �ϳ��� ���� ó���� ���۵Ǳ� ���� ���·� ���ư���

-- ��������
-- ���̺� ��ȿ���� ���� �����Ͱ� �ԷµǴ� ���� �����ϱ� ���� ���̺� ���� �� �� �÷��� ���� �����ϴ� ��Ģ
-- not null : null ���� �������� ���ϵ��� ����
-- unique : ��� �ο쿡 ���� ������ ��
-- primary key : �� ���� �ĺ��ϱ� ���� not null�� unique ������ ����
-- foreign key : �����Ǵ� ���̺� �÷����� �׻� �����ؾ� ��
-- check : ���� ������ ������ ���� ������ ������ �����Ͽ� ������ ���� ���

create table emp2 (
    eno number(4) constraint emp2_pk primary key,
    ename varchar2(10),
    salary number constraint emp2_min check(salary > 0)
);

insert into emp2 values (11, 'aaa', -100);
alter table emp2 add birth date default sysdate;

-- ��(View) ���̺�
-- �������� ���̺��� �ٰ��� ������ ���� ���̺�
-- ��ũ ���� ������ �Ҵ���� �ʴ´�
-- �ܼ� �� : �ϳ��� �⺻ ���̺�� ������ ��
-- ���� �� : �ΰ� �̻��� �⺻ ���̺�� ������ ��
-- �並 ����ϴ� ���� : ���Ȱ� ����� ���Ǽ�

-- ������ ���� ��Ȱ��
create view v_emp_sample as
    select eno, ename, job, manager, dno from emp;
select * from v_emp_sample;

-- ������ �ս��� ��� ���� �� Ȱ��
create view v_emp_sample2 as
    select e.eno, e.ename, e.salary, dno, d.dname, d.loc
    from emp e natural join dept d;

select * from v_emp_sample2;

-- ��� �����͸� �����ϰ� ���� ���� �������̺��̹Ƿ� ��ü�� ����.
-- �䰡 ���̺�ó�� ���� �� �ִ� ������ �並 ������ �� create view ��ɾ� ������ as���� ����� ���� ���� ��ü�� �����ϰ� �ִٰ� �̸� �����ϱ� �����̴�.

-- �信 �׷��Լ� ����ϱ�
create view v_emp_salary
    as
    select dno, sum(salary) as "salsum", avg(salary) as "salavg"
    from emp group by dno;
-- �׷� �Լ��� ���� �÷� ��Ī�� ����� ��. ������� ������ ����
-- �׷��Լ��� ���� �÷����� ���� �信 ���� dml�� ��� �Ұ�

insert into v_emp_salary values (8000, 1000, 300); --����

-- �� ����
drop view v_emp_salary;

-- �ε���
-- �˻� �ӵ��� ����Ű�� ���� ���
-- �⺻Ű�� ������ Ű�� �ε����� �ڵ����� �����ȴ�.
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
decode(std.gender, 'M', '��',
                   'F', '��') as gender, 
sc.kor, sc.eng, sc.mat, sum(kor+eng+mat) as tot, 
round(avg((kor+eng+mat)/3),1) as ave 
from tbl_student_201905 std, tbl_score_201905 sc 
where std.sno = sc.sno and std.sclass = sc.sclass
group by std.syear, std.sclass, std.sno, std.sname, sc.kor, 
sc.eng, sc.mat, decode(std.gender, 'M', '��', 'F', '��')
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

update notice set title='����', content='��', writer='����' where idx = 22;

select title, idx from notice where idx = (select max(idx) from notice where idx < 4);
select title from notice where idx = (select min(idx) from notice where idx > 4);

select * from notice where title like '%����%';

--����¡ó��
--order by ���ٴ� index
-- select /*+ */ Ǯ ��Ʈ
-- Ǯ ��Ʈ ������ ������ �־ select���� �����

select * from notice where idx > 0 order by idx desc;
select /*+ index_desc(notice notice_pk) */ * from notice where idx > 0;

-- rownum �� �ζ��� ��
-- ������ ó���� �ϱ� ���� �������� ������ ���̰� rownum �̶�� Ű���� ���
-- mysql�� limit Ű���� ���
select /*+ index_asc (notice notice_pk)*/ rownum rn, idx, title from notice;
select /*+ index_desc (notice notice_pk)*/ rownum rn, idx, title from notice;

select * from notice;

select /*+ index_desc (notice notice_pk)*/ rownum rn, idx, title from notice where rownum <= 3;
--�������� �´°� ������ �����δ� ����� �ȳ���
select /*+ index_desc (notice notice_pk)*/ rownum rn, idx, title from notice where 0 < rownum and rownum <= 10;
insert into notice (idx, title, content, writer) values (notice_seq.nextval, '����ȭ�� ��', '���� ������ �� �ۿ� ����', '��â��');
insert into notice (idx, title, content, writer) values (notice_seq.nextval, '���������� ����', '���߳�', '��â��');
insert into notice (idx, title, content, writer) values (notice_seq.nextval, '�� �����ݾ�', '�׳� ���� �� �����ݾ�', '��â��');
commit;
-- rownum�� �̿��� ������ �˻� ���(inline view)
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
    where rownum <= 20 and title like '%����ȭ%')
where rn > 10;
select count(*) as count from notice;

--��Ʈ������ ���̺�
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

insert into hanulso values (1, '������', 'system', '1234', '0212345678', 'dyddnr25@gmail.com');
select * from hanulso;
commit;

