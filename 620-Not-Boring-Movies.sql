-- Write your PostgreSQL query statement below
SELECT id,movie,description,rating
FROM Cinema
WHERE description NOT LIKE 'boring'
    AND id%2!=0
ORDER BY rating DESC;