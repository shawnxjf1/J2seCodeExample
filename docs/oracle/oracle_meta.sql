-- 计算出秒
select 
ceil((To_date('2008-05-02 00:00:00' , 'yyyy-mm-dd hh24-mi-ss') 
- To_date('2008-04-30 23:59:59' , 'yyyy-mm-dd hh24-mi-ss'))
 * 24 * 60 * 60) 
 
-- 