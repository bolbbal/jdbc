drop table member_want;
drop table car_detail_info;
drop table member;
drop table car_info;
drop table manufact_comp;
drop table car_type;
drop table country;
drop table car_option;
drop table color;
drop table fuel;
drop table sales_area;
drop table transmission;
drop SEQUENCE member_seq;
drop SEQUENCE country_seq;
drop SEQUENCE manufact_comp_seq;
drop SEQUENCE car_type_seq;
drop SEQUENCE fuel_seq;
drop SEQUENCE car_info_seq;
drop sequence sales_area_seq;
drop sequence car_option_seq;
drop sequence color_seq;
drop sequence car_detail_info_seq;


create table member (
    member_no number(10) not null,
    member_name varchar2(20) not null,
    member_jumin varchar2(13) not null,
    member_call varchar2(15) not null,
    member_address varchar2(50) not null,
    member_email varchar2(30),
    member_type number(2),
    
    constraint member_pk primary key (member_no)
);

create SEQUENCE member_seq
       INCREMENT by 1
       start with 1
       minvalue 1
       maxvalue 10000;

insert into member values (member_seq.nextval, '최용욱', '9807191111111', '01065699007', '전주', 'cdyddnr25@gmail.com', 1);
insert into member values (member_seq.nextval, '김용욱', '9907192111112', '01065698007', '서울', 'kdyddnr25@gmail.com', 1);
insert into member values (member_seq.nextval, '박용욱', '0007193111113', '01065697007', '대전', 'pdyddnr25@gmail.com', 2);
insert into member values (member_seq.nextval, '이용욱', '0107194111114', '01065696007', '인천', '', 2);
insert into member values (member_seq.nextval, '남용욱', '0207193111115', '01065695007', '부산', 'ndyddnr25@gmail.com', 1);

--회원정보 검색
select member_no, member_name, member_jumin, member_call, member_address, member_email, 
decode (member_type, 1, '일반',
                     2, '딜러') as member_type
from member
order by member_no;

commit;

create table country (
    country_code number(2) not null,
    country_name varchar2(20) not null,
    
    constraint country_pk PRIMARY key (country_code)
);

create SEQUENCE country_seq
       INCREMENT by 1
       start with 1
       minvalue 1
       maxvalue 99;
       
insert into country values(country_seq.nextval, '한국');
insert into country values(country_seq.nextval, '일본');
insert into country values(country_seq.nextval, '독일');
insert into country values(country_seq.nextval, '미국');
insert into country values(country_seq.nextval, '스웨덴');

commit;

create table manufact_comp (
    company_code number(3) not null,
    country_code number(2) not null,
    company_name varchar2(20) not null,
    
    constraint manufact_comp_pk primary key (company_code),
    
    constraint manufact_comp_fk FOREIGN key (country_code) REFERENCES country (country_code)
);

create SEQUENCE manufact_comp_seq
       INCREMENT by 1
       start with 1
       minvalue 1
       maxvalue 999;
       
insert into manufact_comp values (manufact_comp_seq.nextval, 1, '현대');
insert into manufact_comp values (manufact_comp_seq.nextval, 1, '기아');
insert into manufact_comp values (manufact_comp_seq.nextval, 1, '르노삼성');
insert into manufact_comp values (manufact_comp_seq.nextval, 2, '도요타');
insert into manufact_comp values (manufact_comp_seq.nextval, 2, '혼다');
insert into manufact_comp values (manufact_comp_seq.nextval, 2, '닛산');
insert into manufact_comp values (manufact_comp_seq.nextval, 3, '벤츠');
insert into manufact_comp values (manufact_comp_seq.nextval, 3, '아우디');
insert into manufact_comp values (manufact_comp_seq.nextval, 3, 'BMW');
insert into manufact_comp values (manufact_comp_seq.nextval, 3, '폭스바겐');
insert into manufact_comp values (manufact_comp_seq.nextval, 3, '포르쉐');
insert into manufact_comp values (manufact_comp_seq.nextval, 4, '포드');
insert into manufact_comp values (manufact_comp_seq.nextval, 4, '케딜락');
insert into manufact_comp values (manufact_comp_seq.nextval, 4, '테슬라');
insert into manufact_comp values (manufact_comp_seq.nextval, 5, '볼보');
insert into manufact_comp values (manufact_comp_seq.nextval, 1, '제네시스');
insert into manufact_comp values (manufact_comp_seq.nextval, 2, '렉서스');

commit;

create table car_type (
    car_type_code number(2) not null,
    car_type_name varchar2(20) not null,
    
    constraint car_type_pk primary key (car_type_code)
);

create sequence car_type_seq
       INCREMENT by 1
       start with 1
       minvalue 1
       maxvalue 99;
       
insert into car_type values (car_type_seq.nextval, '경차');
insert into car_type values (car_type_seq.nextval, '준중형');
insert into car_type values (car_type_seq.nextval, '중형');
insert into car_type values (car_type_seq.nextval, '준대형');
insert into car_type values (car_type_seq.nextval, '대형');
insert into car_type values (car_type_seq.nextval, '소형');
insert into car_type values (car_type_seq.nextval, '스포츠카');

commit;

create table fuel (
    fuel_code number(2) not null,
    fuel_name varchar2(20) not null,
    
    constraint fuel_pk PRIMARY key (fuel_code)
);

create sequence fuel_seq
       INCREMENT by 1
       start with 1
       minvalue 1
       maxvalue 99;
       
insert into fuel values (fuel_seq.nextval, '디젤');
insert into fuel values (fuel_seq.nextval, '가솔린');
insert into fuel values (fuel_seq.nextval, '전기');
insert into fuel values (fuel_seq.nextval, '하이브리드');
insert into fuel values (fuel_seq.nextval, 'LPG');

commit;

create table car_info (
    car_id number(5) not null,
    company_code number(3) not null,
    car_name varchar2(100) not null,
    car_type_code number(2) not null,
    fuel_code number(2) not null,
    
    constraint car_info_pk primary key (car_id),
    
    constraint car_info_fk1 FOREIGN key (company_code) REFERENCES manufact_comp (company_code),
    constraint car_info_fk3 FOREIGN key (car_type_code) REFERENCES car_type (car_type_code),
    constraint car_info_fk2 FOREIGN key (fuel_code) REFERENCES fuel (fuel_code)
);

create sequence car_info_seq
       INCREMENT by 1
       start with 1
       minvalue 1
       maxvalue 99999;
       
insert into car_info values(car_info_seq.nextval, 1, '그랜저', 4, 2);
insert into car_info values(car_info_seq.nextval, 1, '그랜저_LPG', 4, 5);
insert into car_info values(car_info_seq.nextval, 1, '쏘나타', 3, 2);
insert into car_info values(car_info_seq.nextval, 1, '아반떼', 2, 2);
insert into car_info values(car_info_seq.nextval, 1, '케스퍼', 1, 2);
insert into car_info values(car_info_seq.nextval, 1, '케스퍼_일렉트릭', 1, 3);
insert into car_info values(car_info_seq.nextval, 1, '투싼', 2, 2);
insert into car_info values(car_info_seq.nextval, 1, '싼타페', 2, 2);
insert into car_info values(car_info_seq.nextval, 1, '팰리세이드', 2, 2);
insert into car_info values(car_info_seq.nextval, 1, '아이오닉6', 3, 3);
insert into car_info values(car_info_seq.nextval, 1, '코나일렉트릭', 1, 3);
insert into car_info values(car_info_seq.nextval, 1, '아이오닉5', 2, 3);
insert into car_info values(car_info_seq.nextval, 1, '아이오닉9', 4, 3);
insert into car_info values(car_info_seq.nextval, 2, '모닝', 1, 2);
insert into car_info values(car_info_seq.nextval, 2, '레이', 1, 2);
insert into car_info values(car_info_seq.nextval, 2, '레이_일렉트릭', 1, 3);
insert into car_info values(car_info_seq.nextval, 2, 'K3', 2, 2);
insert into car_info values(car_info_seq.nextval, 2, 'K4', 3, 2);
insert into car_info values(car_info_seq.nextval, 2, 'K5', 3, 2);
insert into car_info values(car_info_seq.nextval, 2, 'K5_LPG', 3, 5);
insert into car_info values(car_info_seq.nextval, 2, 'K7', 4, 2);
insert into car_info values(car_info_seq.nextval, 2, 'K8', 4, 2);
insert into car_info values(car_info_seq.nextval, 2, 'K8_LPG', 4, 5);
insert into car_info values(car_info_seq.nextval, 2, 'K9', 5, 2);
insert into car_info values(car_info_seq.nextval, 2, '카니발', 5, 2);
insert into car_info values(car_info_seq.nextval, 2, '카니발_디젤', 5, 1);
insert into car_info values(car_info_seq.nextval, 2, '스포티지', 2, 2);
insert into car_info values(car_info_seq.nextval, 2, '스포티지_디젤', 2, 1);
insert into car_info values(car_info_seq.nextval, 2, '스포티지_하이브리드', 2, 4);
insert into car_info values(car_info_seq.nextval, 2, '쏘렌토', 3, 2);
insert into car_info values(car_info_seq.nextval, 2, '쏘렌토_디젤', 3, 1);
insert into car_info values(car_info_seq.nextval, 16, 'G70', 3, 2);
insert into car_info values(car_info_seq.nextval, 16, 'G80', 4, 2);
insert into car_info values(car_info_seq.nextval, 16, 'G80_일렉트릭', 4, 3);
insert into car_info values(car_info_seq.nextval, 16, 'G90', 5, 2);
insert into car_info values(car_info_seq.nextval, 16, 'GV60', 2, 3);
insert into car_info values(car_info_seq.nextval, 16, 'GV70', 3, 2);
insert into car_info values(car_info_seq.nextval, 16, 'GV70_일렉트릭', 3, 3);
insert into car_info values(car_info_seq.nextval, 16, 'GV80', 4, 2);
insert into car_info values(car_info_seq.nextval, 16, 'GV90', 5, 3);
insert into car_info values(car_info_seq.nextval, 3, 'SM3_디젤', 2, 1);
insert into car_info values(car_info_seq.nextval, 3, 'SM3', 2, 2);
insert into car_info values(car_info_seq.nextval, 3, 'SM3_일렉트릭', 2, 3);
insert into car_info values(car_info_seq.nextval, 3, 'SM5_디젤', 3, 1);
insert into car_info values(car_info_seq.nextval, 3, 'SM5', 3, 2);
insert into car_info values(car_info_seq.nextval, 3, 'SM5_일렉트릭', 3, 3);
insert into car_info values(car_info_seq.nextval, 3, 'SM6', 3, 2);
insert into car_info values(car_info_seq.nextval, 3, 'SM6_LPG', 3, 5);
insert into car_info values(car_info_seq.nextval, 3, 'SM7', 4, 2);
insert into car_info values(car_info_seq.nextval, 3, 'SM7_LPG', 4, 5);
insert into car_info values(car_info_seq.nextval, 3, 'QM3_디젤', 6, 1);
insert into car_info values(car_info_seq.nextval, 3, 'QM3', 6, 2);
insert into car_info values(car_info_seq.nextval, 3, 'QM5_디젤', 3, 1);
insert into car_info values(car_info_seq.nextval, 3, 'QM5', 3, 2);
insert into car_info values(car_info_seq.nextval, 3, 'QM6_디젤', 3, 1);
insert into car_info values(car_info_seq.nextval, 3, 'QM6', 3, 2);
insert into car_info values(car_info_seq.nextval, 3, 'QM6_LPG', 3, 5);
insert into car_info values(car_info_seq.nextval, 4, '야리스', 6, 4);
insert into car_info values(car_info_seq.nextval, 4, '프리우스', 2, 4);
insert into car_info values(car_info_seq.nextval, 4, '캠리', 3, 4);
insert into car_info values(car_info_seq.nextval, 4, '크라운', 4, 4);
insert into car_info values(car_info_seq.nextval, 4, '센추리', 5, 4);
insert into car_info values(car_info_seq.nextval, 17, 'IS', 3, 2);
insert into car_info values(car_info_seq.nextval, 17, 'LS', 5, 2);
insert into car_info values(car_info_seq.nextval, 17, 'LS_하이브리드', 5, 4);
insert into car_info values(car_info_seq.nextval, 17, 'ES', 4, 2);
insert into car_info values(car_info_seq.nextval, 17, 'CT', 2, 2);
insert into car_info values(car_info_seq.nextval, 17, 'RC', 7, 2);
insert into car_info values(car_info_seq.nextval, 17, 'RC_하이브리드', 7, 4);
insert into car_info values(car_info_seq.nextval, 17, 'UX_일렉트릭', 6, 3);
insert into car_info values(car_info_seq.nextval, 17, 'UX', 6, 4);
insert into car_info values(car_info_seq.nextval, 17, 'NX', 3, 4);
insert into car_info values(car_info_seq.nextval, 5, '시티', 6, 2);
insert into car_info values(car_info_seq.nextval, 5, '시빅', 2, 2);
insert into car_info values(car_info_seq.nextval, 5, '어코드', 3, 2);
insert into car_info values(car_info_seq.nextval, 6, '데이즈', 1, 2);
insert into car_info values(car_info_seq.nextval, 6, '마치', 6, 2);
insert into car_info values(car_info_seq.nextval, 6, '센트라', 2, 2);
insert into car_info values(car_info_seq.nextval, 6, '알티마', 3, 2);
insert into car_info values(car_info_seq.nextval, 7, 'EQA', 2, 3);
insert into car_info values(car_info_seq.nextval, 7, 'EQB', 2, 3);
insert into car_info values(car_info_seq.nextval, 7, 'EQC', 3, 3);
insert into car_info values(car_info_seq.nextval, 7, 'EQE', 4, 3);
insert into car_info values(car_info_seq.nextval, 7, 'EQS', 5, 3);
insert into car_info values(car_info_seq.nextval, 7, 'GT-4DOOR', 4, 3);
insert into car_info values(car_info_seq.nextval, 7, 'GT', 7, 2);
insert into car_info values(car_info_seq.nextval, 7, 'SL', 7, 2);
insert into car_info values(car_info_seq.nextval, 7, 'A_CLASS', 2, 2);
insert into car_info values(car_info_seq.nextval, 7, 'B_CLASS', 2, 2);
insert into car_info values(car_info_seq.nextval, 7, 'C_CLASS', 3, 2);
insert into car_info values(car_info_seq.nextval, 7, 'E_CLASS', 4, 2);
insert into car_info values(car_info_seq.nextval, 7, 'S_CLASS', 5, 2);
insert into car_info values(car_info_seq.nextval, 7, 'G_CLASS', 3, 2);
insert into car_info values(car_info_seq.nextval, 7, 'GLA', 2, 2);
insert into car_info values(car_info_seq.nextval, 7, 'GLB', 2, 2);
insert into car_info values(car_info_seq.nextval, 7, 'GLC', 3, 2);
insert into car_info values(car_info_seq.nextval, 7, 'GLE', 4, 2);
insert into car_info values(car_info_seq.nextval, 7, 'GLS', 5, 2);
insert into car_info values(car_info_seq.nextval, 7, '마이바흐_GLS', 5, 2);
insert into car_info values(car_info_seq.nextval, 7, '마이바흐_S_CLASS', 5, 2);
insert into car_info values(car_info_seq.nextval, 8, 'A1', 6, 2);
insert into car_info values(car_info_seq.nextval, 8, 'A3', 2, 2);
insert into car_info values(car_info_seq.nextval, 8, 'A4', 3, 2);
insert into car_info values(car_info_seq.nextval, 8, 'A5', 3, 2);
insert into car_info values(car_info_seq.nextval, 8, 'A6', 4, 2);
insert into car_info values(car_info_seq.nextval, 8, 'A6_E_TRON', 4, 3);
insert into car_info values(car_info_seq.nextval, 8, 'A7', 4, 2);
insert into car_info values(car_info_seq.nextval, 8, 'E_TRON_GT', 4, 3);
insert into car_info values(car_info_seq.nextval, 8, 'A8', 5, 2);
insert into car_info values(car_info_seq.nextval, 8, 'Q2', 6, 2);
insert into car_info values(car_info_seq.nextval, 8, 'Q2_E_TRON', 6, 3);
insert into car_info values(car_info_seq.nextval, 8, 'Q3', 2, 2);
insert into car_info values(car_info_seq.nextval, 8, 'Q4_E_TRON', 3, 3);
insert into car_info values(car_info_seq.nextval, 8, 'Q5', 3, 2);
insert into car_info values(car_info_seq.nextval, 8, 'Q5_E_TRON', 3, 3);
insert into car_info values(car_info_seq.nextval, 8, 'Q6_E_TRON', 3, 3);
insert into car_info values(car_info_seq.nextval, 8, 'Q6', 4, 2);
insert into car_info values(car_info_seq.nextval, 8, 'Q7', 4, 2);
insert into car_info values(car_info_seq.nextval, 8, 'Q8', 4, 2);
insert into car_info values(car_info_seq.nextval, 8, 'Q8_E_TRON', 4, 3);

commit;

create table color (
    color_code number(2) not null,
    color_name varchar2(20) not null,
    
    constraint color_pk PRIMARY key (color_code)
);

create sequence color_seq
       INCREMENT by 1
       start with 1
       minvalue 1
       maxvalue 99;
       
insert into color values (color_seq.nextval, '흰색');
insert into color values (color_seq.nextval, '검정색');
insert into color values (color_seq.nextval, '회색');
insert into color values (color_seq.nextval, '빨간색');
insert into color values (color_seq.nextval, '파란색');
insert into color values (color_seq.nextval, '노란색');

commit;

create table car_option (
    car_option_code number(2) not null,
    car_option_count varchar2(50) not null,
    
    constraint car_option_pk PRIMARY key (car_option_code)
);

create sequence car_option_seq
       INCREMENT by 1
       start with 1
       minvalue 1
       maxvalue 98;

insert into car_option values (car_option_seq.nextval, '옵션없음');
insert into car_option values (99, '풀옵션');
insert into car_option values (car_option_seq.nextval, '1개');
insert into car_option values (car_option_seq.nextval, '2개');
insert into car_option values (car_option_seq.nextval, '3개');

commit;

create table transmission (
    transmission_code number(2) not null,
    transmission_name varchar2(20) not null,
    
    constraint transmission_pk PRIMARY key (transmission_code)
);

insert into transmission values (1, '자동');
insert into transmission values (2, '수동');

commit;

create table sales_area (
    sales_area_code number(2) not null,
    sales_area_name varchar2(20) not null,
    
    constraint sales_area_pk PRIMARY key (sales_area_code)
);

create sequence sales_area_seq
       INCREMENT by 1
       start with 1
       minvalue 1
       maxvalue 99;
       
insert into sales_area values (sales_area_seq.nextval, '서울');
insert into sales_area values (sales_area_seq.nextval, '인천');
insert into sales_area values (sales_area_seq.nextval, '대전');
insert into sales_area values (sales_area_seq.nextval, '부산');
insert into sales_area values (sales_area_seq.nextval, '전주');

commit;
       
create table car_detail_info (
    regist_no number(10) not null primary key,
    member_no number(10) not null,
    car_number varchar2(20) not null,
    car_id number(5) not null,
    made_at date not null,
    mileage number(8) not null,
    accident_exist number(2) not null,
    color_code number(2) not null,
    transmission_code number(2) not null,
    car_option_code number(2) not null,
    sales_area_code number(2) not null,
    price number(10) not null,
    regist_date date not null,
    
    constraint car_detail_info_fk1 FOREIGN key (member_no) REFERENCES member (member_no),
    constraint car_detail_info_fk2 FOREIGN key (car_id) REFERENCES car_info (car_id),
    constraint car_detail_info_fk3 FOREIGN key (color_code) REFERENCES color (color_code),
    constraint car_detail_info_fk4 FOREIGN key (transmission_code) REFERENCES transmission (transmission_code),
    constraint car_detail_info_fk5 FOREIGN key (car_option_code) REFERENCES car_option (car_option_code),
    constraint car_detail_info_fk6 FOREIGN key (sales_area_code) REFERENCES sales_area (sales_area_code)
);

create sequence car_detail_info_seq
       INCREMENT by 1
       start with 1
       minvalue 1
       maxvalue 999999;

INSERT INTO CAR_DETAIL_INFO 
(REGIST_NO, MEMBER_NO, CAR_NUMBER, CAR_ID, MADE_AT, MILEAGE, ACCIDENT_EXIST, 
COLOR_CODE, TRANSMISSION_CODE, CAR_OPTION_CODE, SALES_AREA_CODE, PRICE, regist_date)
VALUES (car_detail_info_seq.nextval, 1, '38너1094', 11, to_date('1803','yyMM'), 101615, 1,
1, 1, 99, 1, 2300, '230305');

select * from CAR_DETAIL_INFO;

create table member_want (
    want_no number(10) not null primary key,
    regist_no number(10) not null,
    member_no number(10) not null,
    
    constraint member_want_fk1 FOREIGN key (member_no) REFERENCES member (member_no),
    constraint member_want_fk2 FOREIGN key (regist_no) REFERENCES car_detail_info (regist_no)
);


