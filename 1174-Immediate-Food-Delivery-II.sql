-- Write your PostgreSQL query statement below
WITH first_order AS(
    SELECT customer_id,
    MIN(order_date) as earliest_order
    FROM Delivery
    GROUP BY customer_id
)
SELECT
ROUND( 
    COUNT(CASE WHEN d.order_date=d.customer_pref_delivery_date THEN 1 END) :: numeric *100/
    COUNT(*),
    2
) as immediate_percentage
FROM Delivery d
JOIN first_order f
ON d.customer_id=f.customer_id AND 
    d.order_date=f.earliest_order;
