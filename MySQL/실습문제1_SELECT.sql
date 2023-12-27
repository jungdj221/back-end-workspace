-- sakila, 정렬은 결과 화면대로
-- 1. actor 테이블에서 first_name이 A로 시작하는 배우들만 조회 
SELECT *
FROM actor
WHERE substr(first_name,1,1)='A'; -- first_name like 'A%'

SELECT *
FROM actor
WHERE first_name < 'B';

-- 2. film_list 테이블에서 category가 Sci-Fi 또는 Family면서
-- rating이 PG면서 영화 제목(title)에 GO가 포함되는 영화 제목 조회
SELECT title
FROM film_list
WHERE  (category = 'SCi-Fi' OR category = 'Family') AND rating='PG' AND title LIKE '%GO%';
-- WHERE (category IN('SCi-Fi','Family)

-- 3. film_list 테이블에서 fid가 7 이하면서 4와 6이 아닌 fid, title 조회
SELECT fid, title
FROM film_list
WHERE fid <=7 AND fid !=4 AND fid !=6
LIMIT 4;
-- AND NOT (fid =4 OR fid =6);
-- -> AND NOT fid IN (4,6)

-- 4. film_list 테이블에서 가격(price)은 2 이상 4 이하이면서 category가 Documentary거나 Animation이고 
-- 배우들(actors) 중 BOB가 포함되어 있는 영화 제목(title)만 조회
SELECT title
FROM film_list
WHERE price BETWEEN 2 AND 4
AND category in ('Documentary', 'Animation') 
AND actors LIKE '%B0B%';

-- 5. address 테이블에서 district가 비어있지 않고 앞에 숫자 제외 주소만 10개 조회
SELECT substr(address, instr(address, ' ')+1, char_length(address)) 'address', district
FROM address
WHERE district != ''
ORDER BY 2, 1 desc
LIMIT  10;

-- 6. customer_list 테이블에서 id가 6인 사람부터 10명 조회
SELECT id, name
FROM customer_list
WHERE id between 6 and 15
ORDER BY id;

SELECT id, name
FROM customer_list
ORDER BY ID
LIMIT 5, 10;

-- 7. actor 테이블에서 J로 시작하는 이름과 글자수 조회 (공백 X, 정렬은 글자수가 많은 사람 순으로)
SELECT concat(first_name,' ',Last_name)'이름', char_length(concat(first_name, Last_name)) '글자수'
FROM actor
WHERE  instr(first_name, 'J') ='1' -- first_name LIKE 'J%'
ORDER BY 2 desc;

-- 8. film 테이블에서 description에서 of 이전 문장만 중복 없이 10개만 추출해서 조회
SELECT distinct substr(description,1,instr(description, 'of')-1)
FROM film
ORDER BY 1 desc
LIMIT 10;

-- 9. film 테이블에서 replacement_cost 최소 비용과 최대 비용 조회
SELECT min(replacement_cost)'최소비용', max(replacement_cost)'최대비용'
FROM film;
