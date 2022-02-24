## Cheatsheet

### [order by specific field values](https://github.com/waqar3/CodeSignal-Databases/blob/86ed893c93dccd8f954f696978302acd4c56e51e/10-mischievousNephews/mischievousNephews.sql)
```mysql
select *
from TABLE
where expression
order by column, field(column, name, name, name) desc
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
datediff('2020-02-02','2010-04-04') # a - b

day('2020-05-05') # 05
month('2020-05-05') # 05
quarter('2020-05-05') # 4
year('2020-05-05') # 2020

weekday('2020-05-05') # 5 
week('2020-05-05') # 25 start from first monday of the given year
weekofyear('2020-05-05') # 25

date_add('2020-05-05', interval 1 day/week/month/year)
date_sub('2020-05-05', interval 1 day/week/month/year)
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

**rank/dense_rank/row() over(partition by ex order by ex) as ...**

**sum/max/avg() over(partition by ex order by ex) as ...**

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
**[sum() / case when / if](https://leetcode-cn.com/problems/capital-gainloss/)**
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

