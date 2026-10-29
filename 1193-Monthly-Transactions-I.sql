-- Write your PostgreSQL query statement below
SELECT TO_CHAR(trans_date,'YYYY-MM') as month,
    country,
    COUNT(id) as trans_count,
    SUM(amount) as trans_total_amount,
    COUNT(CASE WHEN state='approved' THEN 1 END) as approved_count,
    SUM(CASE WHEN state='approved' THEN amount ELSE 0 END) as approved_total_amount
FROM Transactions
GROUP BY month,country;


