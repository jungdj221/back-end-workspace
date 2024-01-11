-- for practice 
-- 1. select 복습
SELECT actor_id, first_name, last_name, last_update 
FROM actor
WHERE first_name  LIKE 'A%';

SELECT distinct title
FROM film_list, category
WHERE category IN('Sci-Fi', 'Family') AND rating = 'PG' AND title LIKE '%GO%';

SELECT fid, title
FROM film_list
WHERE fid <= 7 OR fid NOT IN (4,6);

SELECT title
FROM film_list
WHERE price BETWEEN 2 AND 4 AND category IN('Documentary', 'Animation') AND actors LIKE'%BOB%';

SELECT substr(address, (instr(address,' ')+1), char_length(address)), district
FROM address
WHERE district IS NOT NULL;

SELECT id, name
FROM customer_list
WHERE id NOT BETWEEN 1 AND 5
ORDER BY ID asc
LIMIT 10;

SELECT concat(last_name,' ' ,first_name) 이름, char_length(concat(last_name,first_name)) 글자수
FROM actor
WHERE last_name LIKE 'J%';