-- Write your PostgreSQL query statement below
SELECT query_name,
    ROUND(
    SUM(rating:: numeric/position)/ 
    COUNT(*),2) as quality,
    ROUND(
    COUNT(CASE WHEN rating<3 THEN 1 END):: numeric
    /COUNT(*)*100
    ,2) as poor_query_percentage
FROM Queries
GROUP BY query_name;