-- 计算出秒
select 
ceil((To_date('2008-05-02 00:00:00' , 'yyyy-mm-dd hh24-mi-ss') 
- To_date('2008-04-30 23:59:59' , 'yyyy-mm-dd hh24-mi-ss'))
 * 24 * 60 * 60) 
 
-- 
-- 函数Lapd  || 拼接符号 
SELECT 'L'||TO_CHAR(sysdate, 'yyMMdd' )||LPAD('abc', 7, '0') FROM dual;
