SELECT 
    T.SCORE,
    T.EMP_NO,
    T.EMP_NAME,
    T.POSITION,
    T.EMAIL
FROM (
    SELECT 
        HG.SCORE,
        HE.EMP_NO,
        HE.EMP_NAME,
        HE.POSITION,
        HE.EMAIL
    FROM HR_EMPLOYEES HE JOIN (
        SELECT 
            EMP_NO,
            SUM(SCORE) AS SCORE
        FROM HR_GRADE 
        GROUP BY EMP_NO 
    ) AS HG
    ON HE.EMP_NO = HG.EMP_NO 
) T
WHERE T.SCORE = (
    SELECT MAX(HG.SCORE)
    FROM (
        SELECT 
            EMP_NO,
            SUM(SCORE) AS SCORE
        FROM HR_GRADE
        GROUP BY EMP_NO
    ) HG
)