-- Write your PostgreSQL query statement below
SELECT DISTINCT t1.id,
CASE 
-- if there is no parent for the current node
    WHEN t1.p_id IS NULL THEN 'Root'
    -- if there is no child for the current node
    WHEN t2.p_id IS NULL THEN 'Leaf'
    ELSE 'Inner'
END as type
FROM Tree t1
LEFT JOIN Tree t2
ON t1.id=t2.p_id;
