-- 코드를 입력하세요
SELECT WAREHOUSE_ID, WAREHOUSE_NAME, ADDRESS, IFNULL(FREEZER_YN, 'N') AS FREEZER_YN
FROM FOOD_WAREHOUSE
WHERE SUBSTRING(ADDRESS, 1, 4) = '경기도'
ORDER BY WAREHOUSE_ID