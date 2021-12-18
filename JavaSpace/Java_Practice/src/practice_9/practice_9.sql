--conn sys

CREATE TABLESPACE hostp_tbs
DATAFILE 'C:\oraclexe\app\oracle\oradata\XE\hospitaldb.dbf'
size 20M;

CREATE USER hospital
IDENTIFIED BY hospital
DEFAULT TABLESPACE hostp_tbs;

GRANT CONNECT, RESOURCE TO hospital;


--conn hospital
--CREATE TABLE
/*table 생성시 primary key, foreign key 등 설정할 것
Doctors 등 primary key를 위한 sequence를 create할 것*/
CREATE SEQUENCE doc_seq
INCREMENT BY 1
START WITH 1;

CREATE SEQUENCE nur_seq
INCREMENT BY 1
START WITH 1;

CREATE SEQUENCE pat_seq
INCREMENT BY 1
START WITH 1;

CREATE SEQUENCE treat_seq
INCREMENT BY 1
START WITH 1;

CREATE SEQUENCE chart_seq
INCREMENT BY 1
START WITH 1;

--시퀀스 초기화
DROP SEQUENCE doc_seq;
DROP SEQUENCE nur_seq;
DROP SEQUENCE pat_seq;
DROP SEQUENCE treat_seq;
DROP SEQUENCE chart_seq;

--의사는 의사ID를 부여하여 식별하며 담당진료과목, 성명, 성별, 전화번호, 이메일, 직급을 가짐
--환자에 대한 모든 정보 검색
CREATE TABLE Doctors (
    순서 NUMBER(4) UNIQUE NOT NULL, 
    doc_id NUMBER(10) NOT NULL,
    major_treat VARCHAR2(25) NOT NULL,
    doc_name VARCHAR2(20) NOT NULL,
    doc_gen CHAR(1) NOT NULL,
    doc_phone VARCHAR2(15) NULL,
    doc_email VARCHAR2(50) UNIQUE,
    doc_position VARCHAR2(20) NOT NULL
);

ALTER TABLE Doctors
ADD CONSTRAINT doc_id_pk PRIMARY KEY(doc_id);

--간호사ID를 부여하여 식별하며 담당업무, 성명, 성별, 전화번호, 이메일, 직급을 가짐
--병원 진료차트 정보 검색, 환자 관리
CREATE TABLE Nurses (
    순서 NUMBER(4) UNIQUE NOT NULL,
    nur_id NUMBER(10) NOT NULL,
    major_job VARCHAR2(25) NOT NULL,
    nur_name VARCHAR2(20) NOT NULL,
    nur_gen CHAR(1) NOT NULL,
    nur_phone VARCHAR2(15) NULL,
    nur_email VARCHAR2(50) UNIQUE,
    nur_position VARCHAR2(20) NOT NULL
);

ALTER TABLE Nurses
ADD CONSTRAINT nur_id_pk PRIMARY KEY(nur_id);

--환자ID를 부여하여 식별하며 담당의사, 담당간호사, 환자성명, 주민번호, 성별, 주소, 전화번호, 이메일, 직업을 가짐
--진료내용 등의 정보 검색, 담당의사 조회 가능
CREATE TABLE Patients (
    순서 NUMBER(4) UNIQUE NOT NULL,
    pat_id NUMBER(10) NOT NULL,
    nur_id NUMBER(10) NOT NULL,
    doc_id NUMBER(10) NOT NULL,
    pat_name VARCHAR2(20) NOT NULL,
    pat_gen CHAR(1) NOT NULL,
    pat_jumin VARCHAR2(14) NOT NULL,
    pat_addr VARCHAR2(100) NOT NULL,
    pat_phone VARCHAR2(15) NULL,
    pat_email VARCHAR2(50) UNIQUE,
    pat_job VARCHAR2(20) NOT NULL
);

ALTER TABLE Patients
ADD CONSTRAINT pat_id_pk PRIMARY KEY(pat_id);

ALTER TABLE Patients
ADD CONSTRAINT R_2 FOREIGN KEY(doc_id) REFERENCES Doctors(doc_id) ON DELETE CASCADE;

ALTER TABLE Patients
ADD CONSTRAINT R_3 FOREIGN KEY(nur_id) REFERENCES Nurses(nur_id)ON DELETE CASCADE;

--진료ID는 날짜+진료순번으로 부여하고 진료한 의사ID, 환자ID, 진료내용, 진료날짜를 포함한다
CREATE TABLE Treatments (
    순서 NUMBER(4) UNIQUE NOT NULL,
    treat_id NUMBER(15) NOT NULL,
    pat_id NUMBER(10) NOT NULL,
    doc_id NUMBER(10) NOT NULL,
    treat_contetns VARCHAR2(1000) NOT NULL,
    treat_date DATE NOT NULL
);

ALTER TABLE Treatments
ADD CONSTRAINT treat_pat_doc_id_pk PRIMARY KEY (treat_id, pat_id, doc_id);

ALTER TABLE Treatments
ADD CONSTRAINT R_5 FOREIGN KEY(pat_id) REFERENCES Patients(pat_id);

ALTER TABLE Treatments
ADD CONSTRAINT R_6 FOREIGN KEY(doc_id) REFERENCES Doctors(doc_id) ON DELETE CASCADE;

--차트는 차트번호를 부여하여 식별하며 담당의사ID, 간호사ID, 환자ID, 진료ID, 의사소견을 차트에 기록
CREATE TABLE Charts (
    순서 NUMBER(4) UNIQUE NOT NULL,
    chart_id VARCHAR2(20) NOT NULL,
    treat_id NUMBER(15) NOT NULL,
    doc_id NUMBER(10) NOT NULL,
    pat_id NUMBER(10) NOT NULL,
    nur_id NUMBER(10) NOT NULL,
    chart_contents VARCHAR2(1000) NOT NULL
);

ALTER TABLE Charts
ADD CONSTRAINT chart_treat_doc_pat_id_pk PRIMARY KEY (chart_id, treat_id, doc_id, pat_id);

ALTER TABLE Charts
ADD CONSTRAINT R_4 FOREIGN KEY(nur_id) REFERENCES Nurses(nur_id);

ALTER TABLE Charts
ADD CONSTRAINT R_7 FOREIGN KEY(treat_id, pat_id, doc_id) REFERENCES Treatments(treat_id, pat_id, doc_id) ON DELETE CASCADE;

/*============================================================================================*/
--INSERT
--Doctors
INSERT INTO Doctors VALUES (doc_seq.NEXTVAL, 980312, '소아과', '이태정', 'M', '010-333-1340', 'ltj@hanbh.com', '과장');
INSERT INTO Doctors VALUES (doc_seq.NEXTVAL, 000601, '내과', '안성기', 'M', '011-222-0987', 'ask@hanbh.com', '과장');
INSERT INTO Doctors VALUES (doc_seq.NEXTVAL, 001208, '외과', '김민종', 'M', '010-333-8743', 'kmj@hanbh.com', '과장');
INSERT INTO Doctors VALUES (doc_seq.NEXTVAL, 020403, '피부과', '이태서', 'M', '019-777-3764', 'lts@hanbh.com', '과장');
INSERT INTO Doctors VALUES (doc_seq.NEXTVAL, 050900, '소아과', '김연아', 'F', '010-555-3746', 'kya@hanbh.com', '전문의');
INSERT INTO Doctors VALUES (doc_seq.NEXTVAL, 050101, '내과', '차태현', 'M', '011-222-7643', 'cth@hanbh.com', '전문의');
INSERT INTO Doctors VALUES (doc_seq.NEXTVAL, 062019, '소아과', '전지현', 'F', '010-999-1265', 'jjh@hanbh.com', '전문의');
INSERT INTO Doctors VALUES (doc_seq.NEXTVAL, 070576, '피부과', '홍길동', 'M', '016-333-7263', 'hgd@hanbh.com', '전문의');
INSERT INTO Doctors VALUES (doc_seq.NEXTVAL, 080543, '방사과', '유재석', 'M', '010-222-1263', 'yjs@hanbh.com', '과장');
INSERT INTO Doctors VALUES (doc_seq.NEXTVAL, 091001, '외과', '김병만', 'M', '010-555-3542', 'kbm@hanbh.com', '전문의');

--Nurses
INSERT INTO Nurses VALUES (nur_seq.NEXTVAL, 050302, '소아과', '김은영', 'F', '010-555-8751', 'key@hanbh.com', '수간호사');
INSERT INTO Nurses VALUES (nur_seq.NEXTVAL, 050021, '내과', '윤성애', 'F', '016-333-8745', 'ysa@hanbh.com', '수간호사');
INSERT INTO Nurses VALUES (nur_seq.NEXTVAL, 040089, '피부과', '신지원', 'M', '010-666-7646', 'sjw@hanbh.com', '주임');
INSERT INTO Nurses VALUES (nur_seq.NEXTVAL, 070605, '방사선과', '유정화', 'F', '010-333-4588', 'yjh@hanbh.com', '주임');
INSERT INTO Nurses VALUES (nur_seq.NEXTVAL, 070804, '내과', '라하나', 'F', '010-222-1340', 'nhn@hanbh.com', '주임');
INSERT INTO Nurses VALUES (nur_seq.NEXTVAL, 071018, '소아과', '김화경', 'F', '019-888-4116', 'khk@hanbh.com', '주임');
INSERT INTO Nurses VALUES (nur_seq.NEXTVAL, 100356, '소아과', '이선용', 'M', '010-777-1234', 'lsy@hanbh.com', '간호사');
INSERT INTO Nurses VALUES (nur_seq.NEXTVAL, 104145, '외과', '김현', 'M', '010-999-8520', 'kh@hanbh.com', '간호사');
INSERT INTO Nurses VALUES (nur_seq.NEXTVAL, 120309, '피부과', '박성완', 'M', '010-777-4996', 'psw@hanbh.com', '간호사');
INSERT INTO Nurses VALUES (nur_seq.NEXTVAL, 130211, '외과', '이서연', 'F', '010-222-3214', 'lsy2@hanbh.com', '간호사');

--Patients
INSERT INTO Patients VALUES (pat_seq.NEXTVAL, 2345, 050302, 980312, '안상건', 'M', '232345', '서울', '010-555-7845', 'ask@ab.com', '회사원');
INSERT INTO Patients VALUES (pat_seq.NEXTVAL, 3545, 040089, 020403, '김성룡', 'M', '543545', '서울', '010-333-7812', 'ksr@bb.com', '자영업');
INSERT INTO Patients VALUES (pat_seq.NEXTVAL, 3424, 070605, 080543, '이종진', 'M', '433424', '부산', '019-888-4859', 'ljj@ab.com', '회사원');
INSERT INTO Patients VALUES (pat_seq.NEXTVAL, 7675, 100356, 050900, '최광석', 'M', '677675', '당진', '010-222-4847', 'cks@cc.com', '회사원');
INSERT INTO Patients VALUES (pat_seq.NEXTVAL, 4533, 070804, 000601, '정한경', 'M', '744533', '강릉', '010-777-9630', 'jhk@ab.com', '교수');
INSERT INTO Patients VALUES (pat_seq.NEXTVAL, 5546, 120309, 070576, '유원현', 'M', '765546', '대구', '016-777-0214', 'ywh@cc.com', '자영업');
INSERT INTO Patients VALUES (pat_seq.NEXTVAL, 4543, 070804, 050101, '최재정', 'M', '454543', '부산', '010-555-4187', 'cjj@bb.com', '회사원');
INSERT INTO Patients VALUES (pat_seq.NEXTVAL, 9768, 130211, 091001, '이진희', 'F', '119768', '서울', '010-888-3675', 'ljh@ab.com', '교수');
INSERT INTO Patients VALUES (pat_seq.NEXTVAL, 4234, 130211, 091001, '오나미', 'F', '234234', '속초', '010-999-6541', 'onm@cc.com', '학생');
INSERT INTO Patients VALUES (pat_seq.NEXTVAL, 7643, 071018, 062019, '송성묵', 'M', '987643', '서울', '010-222-5874', 'ssm@bb.com', '학생');

--Treatments
INSERT INTO Treatments VALUES (treat_seq.NEXTVAL, 130516023, 2345, 980312, '감기, 몸살', '2013-05-16');
INSERT INTO Treatments VALUES (treat_seq.NEXTVAL, 130628100, 3545, 020403, '피부 트러블 치료', '2013-06-28');
INSERT INTO Treatments VALUES (treat_seq.NEXTVAL, 131205056, 3424, 080543, '목 디스크로 MRI 촬영', '2013-12-05');
INSERT INTO Treatments VALUES (treat_seq.NEXTVAL, 131218024, 7675, 050900, '중이염', '2013-12-18');
INSERT INTO Treatments VALUES (treat_seq.NEXTVAL, 131224012, 4533, 000601, '장염', '2013-12-24');
INSERT INTO Treatments VALUES (treat_seq.NEXTVAL, 140103001, 5546, 070576, '여드름 치료', '2014-01-03');
INSERT INTO Treatments VALUES (treat_seq.NEXTVAL, 140109026, 4543, 050101, '위염', '2014-01-09');
INSERT INTO Treatments VALUES (treat_seq.NEXTVAL, 140226102, 9768, 091001, '화상치료', '2014-02-26');
INSERT INTO Treatments VALUES (treat_seq.NEXTVAL, 140303003, 4234, 091001, '교통사고 외상치료', '2014-03-03');
INSERT INTO Treatments VALUES (treat_seq.NEXTVAL, 140308087, 7643, 062019, '장염', '2014-03-08');

--Charts
INSERT INTO Charts VALUES (chart_seq.NEXTVAL, 'p_130516023', 130516023, 980312, 2345, 050302, '감기 주사 및 약 처방');
INSERT INTO Charts VALUES (chart_seq.NEXTVAL, 'd_130628100', 130628100, 020403, 3545, 040089, '피부 감염 방지 주사');
INSERT INTO Charts VALUES (chart_seq.NEXTVAL, 'r_131205056', 131205056, 080543, 3424, 070605, '주사 처방');
INSERT INTO Charts VALUES (chart_seq.NEXTVAL, 'p_131218024', 131218024, 050900, 7675, 100356, '귓속청소 및 약 처방');
INSERT INTO Charts VALUES (chart_seq.NEXTVAL, 'i_131224012', 131224012, 000601, 4533, 070804, '장염 입원치료');
INSERT INTO Charts VALUES (chart_seq.NEXTVAL, 'd_140103001', 140103001, 070576, 5546, 120309, '여드름 치료약 처방');
INSERT INTO Charts VALUES (chart_seq.NEXTVAL, 'i_140109026', 140109026, 050101, 4543, 070804, '위내시경');
INSERT INTO Charts VALUES (chart_seq.NEXTVAL, 's_140226102', 140226102, 091001, 9768, 130211, '화상 크림약 처방');
INSERT INTO Charts VALUES (chart_seq.NEXTVAL, 's_140303003', 140303003, 091001, 4234, 130211, '입원치료');
INSERT INTO Charts VALUES (chart_seq.NEXTVAL, 'p_140308087', 140308087, 062019, 7643, 071018, '장염 입원치료');

COMMIT;
/*============================================================================================*/
--UPDATE, DELETE
/*홍길동 의사가 맡고 있던 담당진료과목이 피부과에서 소아과로 변경되어 내일부터 진료를 시작할 예정이다.
이 정보에 대한 테이블 정보를 변경하시오.*/
UPDATE Doctors
SET major_treat = '소아과'
WHERE doc_name = '홍길동';

/*김은영 간호사는 대학원 진학으로 오늘까지만 근무하고 퇴사하게 되었다. 이 정보에 대한 테이블 정보를 변경하시오.*/
--외래키때문에 일단 보류
DELETE FROM Nurses
WHERE nur_name = '김은영';

/*담당 진료과목이 '소아과'인 의사에 대한 정보를 출력하시오.*/
SELECT * 
FROM Doctors
WHERE major_treat = '소아과';

/*홍길동 의사에게 진료를 받은 환자에 대한 모든 정보를 출력하시오.*/
SELECT p.*, d.doc_name
FROM Patients p, Doctors d
WHERE p.doc_id = d.doc_id
AND d.doc_name = '홍길동';

/*진료날짜가 2013년 12월인 환자에 대한 모든 정보를 오름차순 정렬하여 출력하시오.*/
SELECT p.*, t.treat_date
FROM Patients p, Treatments t
WHERE p.pat_id = t.pat_id
AND t.treat_date BETWEEN '2013-12-01' AND '2013-12-31'
ORDER BY t.treat_date ASC;

/*간호사ID가 05로 시작하는 모든 간호사 정보를 출력하시오.*/
SELECT *
FROM Nurses
WHERE nur_id LIKE 05 || '%';

COMMIT;
