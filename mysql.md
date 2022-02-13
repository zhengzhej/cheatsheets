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
