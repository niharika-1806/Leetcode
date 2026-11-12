-- Write your PostgreSQL query statement below
WITH consecutive AS(
    SELECT num,
    LEAD(num,1) OVER (ORDER BY id) as next_num,
    LEAD(num,2) OVER(ORDER BY id) as next_next_num
    FROM Logs
)
SELECT DISTINCT num as ConsecutiveNums
FROM consecutive
WHERE num=next_num AND next_num=next_next_num;