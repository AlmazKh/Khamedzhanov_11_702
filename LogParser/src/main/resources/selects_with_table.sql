CREATE TABLE log (
  id SERIAL PRIMARY KEY,
  ip VARCHAR(20),
  date VARCHAR(50),
  method VARCHAR(10),
  url VARCHAR(30),
  protocol VARCHAR(10),
  status INTEGER,
  size INTEGER,
  client_id VARCHAR(10)
);

--количество пользователей
SELECT count(distinct client_id) FROM log;

--среднее кол-во страниц
SELECT count(url)/count(distinct client_id) FROM log;

--максимум страниц
WITH client_page AS(
    SELECT count(url) AS page_amount, client_id FROM log --sum(url) если тип числовой
    GROUP BY client_id
    )
SELECT max(page_amount) FROM client_page;

--минимум страниц
WITH client_page AS(
    SELECT count(url) AS page_amount, client_id FROM log
    GROUP BY client_id
    )
SELECT min(page_amount) FROM client_page;

--количество пользователей, совершивших покупку
SELECT count(distinct client_id) FROM log
  WHERE url LIKE '/addbasket.phtml?id_book=%';

--среднее количество заказов за день
SELECT count(url)/31 FROM log
  WHERE url LIKE '/addbasket.phtml?id_book=%';

--максимум покупок
WITH client_buy AS(
    SELECT count(url) AS page_amount, client_id FROM log
    WHERE url LIKE '/addbasket.phtml?id_book=%'
    GROUP BY client_id
    )
SELECT client_id, page_amount FROM client_buy
  WHERE page_amount = (SELECT max(page_amount) FROM client_buy);

--самые покупаемые книги
WITH book_buy AS(
    SELECT url FROM log
    WHERE url LIKE '/addbasket.phtml?id_book=%'
    )
SELECT count(url) AS book_popularity, url FROM book_buy
  GROUP BY url;


