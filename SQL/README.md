## Cheatsheet

### [order by specific field values](https://github.com/waqar3/CodeSignal-Databases/blob/86ed893c93dccd8f954f696978302acd4c56e51e/10-mischievousNephews/mischievousNephews.sql)
```mysql
select *
from TABLE
where expression
order by column, field(column, name, name, name) desc # 'name' for string
```

### [Count()](https://www.cnblogs.com/zhuchenglin/p/12077989.html)
count(expression) returns not null counts regardless of the expression, so it's used to count records or null rows
sum(expression) returns valid row count
```mysql
SELECT
    c.customer_id, c.customer_name
FROM
    Orders o LEFT JOIN Customers c ON o.customer_id = c.customer_id
GROUP BY c.customer_id
HAVING
    SUM(product_name = 'A') * SUM(product_name = 'B') > 0
    AND SUM(product_name = 'C') = 0
ORDER BY c.customer_id

作者：rosieisme
链接：https://leetcode-cn.com/problems/customers-who-bought-products-a-and-b-but-not-c/solution/liang-chong-fang-shi-xi-huan-jiu-xing-by-rosieisme/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

### [🔗](https://www.mysqltutorial.org/mysql-date/) Datetime
```mysql
now() # 2022-02-13 13:34:35
date(now()) # 2022-02-13
date_format(now(), '%y-%m-%d') # 22-02-13
datediff('2020-04-02','2020-04-04') # a - b, return -2
to_days('2020-04-04') - to_days('2020-04-02') # return 2
timediff('2020-05-05 10:10:10','2020-05-05 10:10:00') # return 00:00:10
between '2013-10-01' and '2013-10-03' # used in filtering

day('2020-05-05') # 05
month('2020-05-05') # 05
quarter('2020-05-05') # 4
year('2020-05-05') # 2020
time_to_sec('00:00:35') # 35

weekday('2020-05-05') # 5 
week('2020-05-05') # 25 start from first monday of the given year
weekofyear('2020-05-05') # 25

date_add('2020-05-05', interval 1 day/week/month/year)
date_sub('2020-05-05', interval 1 day/week/month/year)
```
case
```mysql
# calculate time difference in second
time_to_sec(timediff('2020-05-05 10:10:10','2020-05-05 10:10:00')) # return 10
```

### Union
```mysql
select c from table1
union
select c from table 2;
```
### NULL
```mysql

a is null
a is not null

isnull(expression) # return 0 or 1

ifnull(value, function)
```

### Window Function
[Optimization of Analytic Window Functions](https://ericfu.me/sql-window-function/)
```mysql
/*syntax*/
WINDOW_FUNCTION (expression) OVER (
    [PARTITION BY part_list],
    [ORDER BY order_list],
    [{ ROWS | RANGE} BETWEEN frame_start AND frame_end]
)
/*
CURRENT ROW
  | UNBOUNDED PRECEDING
  | UNBOUNDED FOLLOWING
  | expr PRECEDING
  | expr FOLLOWING
*/
```
window >> order >> frame for each row >> function
```mysql
# Aggregate
sum/max/avg/count(ex) over(partition by ex order by ex rows between n preceding and current row) as ...
# Ranking
rank/dense_rank/row() over(partition by ex order by ex) as ...
# Value
lead/lag/first_value/last_value(ex, n, default) over(partition by ex order by ex) as ...
```
```mysql
# moving average with window function
SELECT *,
      avg(confirmed_day) OVER(
          PARTITION BY country
          ORDER BY date
          ROWS BETWEEN 6 PRECEDING AND CURRENT ROW)
          AS 7day_moving_average
FROM confirmed_covid;
```

[case](https://leetcode-cn.com/problems/calculate-salaries/solution/xiao-bai-si-lu-zhi-jie-qiu-chu-lai-jiu-x-0xlg/)
```mysql
select
    case 
        when max(salary)over(partition by company_id)>10000 then salary*0.51
        when max(salary)over(partition by company_id) between 1000 and 10000 then salary*0.76
        else salary 
     end as salary
from  Salaries
```

### Limit and Offset
```mysql
select * from `members` limit 1, 2; # offset 1, limit 2
```
## Cases
### [sum() / case when / if](https://leetcode-cn.com/problems/capital-gainloss/)
```mysql
select 
  stock_name, 
  sum(if(operation='Sell',price,0))-sum(if(operation='Buy',price,0)) as capital_gain_loss 
from Stocks
group by stock_name
```
or
```mysql
select  
  stock_name, 
  sum(case when operation="Buy" then -price else price end) as capital_gain_loss
from Stocks 
group by stock_name
```
### [dancing competition](https://wachino.github.io/codefights/codefights-arcade/codefights-arcade-databases/63_dancingCompetition/README.html)
```mysql
SELECT arbiter_id, first_criterion, second_criterion, third_criterion
FROM scores, (
    SELECT 
        MAX(first_criterion) AS max1,
        MIN(first_criterion) AS min1,
        MAX(second_criterion) AS max2,
        MIN(second_criterion) AS min2,
        MAX(third_criterion) AS max3,
        MIN(third_criterion) AS min3
    FROM scores LIMIT 1) t
WHERE (IF(first_criterion = max1 OR first_criterion = min1, 1, 0) + 
    IF(second_criterion = max2 OR second_criterion = min2, 1, 0) + 
    IF(third_criterion = max3 OR third_criterion = min3, 1, 0)) < 2;
```
### Correlated Subquery
[About Correlated Subquery](https://ericfu.me/subquery-optimization/)

[Case: 15 Days of Learning SQL](https://www.hackerrank.com/challenges/15-days-of-learning-sql/problem)

**Date**-**Summary** Subquery based on Date-**ID** Subquery based on Date-**Name** Subquery based on ID
```mysql
select
    /*date*/
    s1.submission_date, 
    /*summary*/
    (select count(distinct s3.hacker_id)
     from Submissions s3
     where s3.submission_date = s1.submission_date and 
        datediff(s1.submission_date, '2016-03-01') = (
            select count(distinct s4.submission_date)
            from Submissions s4
            where s4.hacker_id = s3.hacker_id and s4.submission_date < s3.submission_date
        )
    ),
    /*id*/
    (select hacker_id
     from Submissions s2
     where s2.submission_date = s1.submission_date
     group by hacker_id
     order by count(hacker_id) desc, hacker_id
     limit 1
    ) as h,
    /*name*/
    (select name from Hackers where Hackers.hacker_id = h)
from (select distinct submission_date from Submissions) as s1;
```

### Consecutive Numbers
[Case: LC180. Consecutive Numbers](https://leetcode-cn.com/problems/consecutive-numbers/)
- for n<=3: self-join with id/row_num; lead() + lag()
- solution: row_number() over() - row_number() over(partition by num) as sub; select count(num) .. groupby num, sub
```mysql
SELECT DISTINCT Num ConsecutiveNums
FROM(
SELECT *,
      ROW_NUMBER() OVER (PARTITION BY Num ORDER BY Id) rownum
FROM LOGS
) t
GROUP BY (Id+1-rownum),Num 
HAVING COUNT(*)>=3

作者：pipideveloper
链接：https://leetcode-cn.com/problems/consecutive-numbers/solution/mysql-jie-fa-tong-jie-ren-yi-lian-xu-nwe-hxg4/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```
- easy way: set variables
```mysql
select distinct num
from (
    select
        num,
        if(num=@curr, @count := @count + 1, @count := 1) as ConNum,
        @curr:=num
    from Logs as l, (select @curr:= null, @count:=1) as v
) as t
where ConNum >=3;
```
