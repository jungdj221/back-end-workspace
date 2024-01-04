/*
	TCL(Transcation Control Language)
    - 트랜젝션을 제어하는 언어
    - 데이터베이스는 데이터의 변경 사항(INSERT, UPDATE, DELETE)들을 묶어서 하나의 트랜젝션에 담아서 처리
    
    트랜젝션(Transcation)
    - 하나의 논리적인 작업 단위
    ex) ATM에서 현금출력
		1. 카드삽입
        2. 메뉴선택
        3. 금액확인
        4. 인증 - 비밀번호입력
        5. 실제 계좌에서 금액만큼 인출
        6. 현금인출
        7. 완료
	- 각각의 업무들을 묶어서 하나의 작업 단위로 만드는것을 트랜젝션
    
    COMIT
    - 모든 작업들을 정상적으로 처리하겠다는 구문
    
    ROLLBACK
    - 모든 작업들을 취소하겠다고 확정하는 구문 (마지막 commit 시점으로 돌아감)
    
    SAVEPOINT
    - 저장점을 지정하고 ROLBACK을 진행 시 전체 작업을 ROLLBACK하는게 아니라
	  SAVEPOINT까지 일부만 ROLLBACK.
	SAVEPOINT 포인트명;
    ROLLBACK TO 포인트명;
*/
-- MySQL에서는 기본적으로 autocommit 모드가 활설화 돼있음
set autocommit = 0;

-- 트랜젝션 시작
START transaction;

DROP TABLE dept_copy;
-- 테스트 진행할 테이블들 추가
CREATE TABLE dept_copy
AS SELECT * FROM kh.department;

CREATE TABLE emp_salary
AS SELECT emp_id, emp_name, dept_code, salary, bonus
	FROM kh.employee;
    

SELECT * FROM dept_copy;
-- dept_copy 테이블에서 dept_id가 'D9'인 부서명을 '잔략기획팀'으로 수정
-- UPDATE 테이블 SET 변경할내용 WHERE 조건;
UPDATE dept_copy
SET dept_title = '전략기획팀'
WHERE dept_id ='D9';

ROLLBACK;

COMMIT;

SELECT * FROM emp_salary;
-- emp_salary 테이블에서 노옹철 사원의 급여를 1000000원으로 변경
UPDATE emp_salary
SET salary = '3000000'
WHERE emp_name = '노옹철';

ROLLBACK;








DROP TABLE emp_test;
CREATE TABLE emp_test
AS SELECT emp_id, emp_name, dept_code
FROM kh.employee;
SELECT * FROM emp_test;
 
START transaction;

-- emp_test에서 emp_id가 213, 218인 사원을 삭제
-- DELETE FROM 테이블명 WHERE 조건;
DELETE FROM emp_test
WHERE emp_id IN (213,218);

-- 두 개의 행이 삭제된 시점에서 SAVEPOINT 지정
SAVEPOINT sp;

-- emp_id가 200인 사원 삭제
DELETE FROM emp_test
WHERE emp_id ='200';

ROLLBACK TO sp;

ROLLBACK;
-- DDL 구문을 실행하는 순간 임시 저장된 변경사항들을 무조건 반영
DROP TABLE test;
CREATE TABLE test(
	tid INT
);

-- >> 트랜잭션 : Java -> JDBC (Java Data Base Connection, Java - MySQL연결)
-- >> 						--> JDBC 때 다룰 예정 
