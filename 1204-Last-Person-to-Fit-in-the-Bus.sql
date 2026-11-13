-- Write your PostgreSQL query statement below
WITH running_weight AS(
    SELECT person_name,
    turn,
    SUM(weight) OVER(ORDER BY turn) as total_weight
    FROM Queue
)
SELECT person_name
FROM running_weight
WHERE total_weight<=1000
ORDER BY turn DESC
LIMIT 1;
