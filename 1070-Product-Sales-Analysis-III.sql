-- Write your PostgreSQL query statement below
WITH fyear AS(
    SELECT product_id,
    MIN(year) as first_year
    FROM Sales
    GROUP BY product_id
)
SELECT s.product_id,
f.first_year,
s.quantity, s.price
FROM Sales s
JOIN fyear f
ON 
s.product_id=f.product_id AND 
s.year=f.first_year;