-- Write your PostgreSQL query statement below
SELECT r.contest_id, 
ROUND(
    COUNT(r.user_id) :: numeric
    / (SELECT COUNT(*) FROM Users)
    *100, 2) as percentage
FROM Register r
LEFT JOIN Users u
ON
    u.user_id=r.user_id
GROUP BY r.contest_id
ORDER BY percentage DESC ,contest_id ASC;