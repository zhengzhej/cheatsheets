## [Selection](https://towardsdatascience.com/23-efficient-ways-of-subsetting-a-pandas-dataframe-6264b8000a77)
### DataFrame, Series, and Array
### Selection
**Selection by Column Name**
```python
df['column_name'] # Return a Series
df[['column_name']] # Return a DataFrame
# Or
df.column_name # Only for single column selection

df[[cn1, cn2, cn3, ...]]
```
**Selection by index: .iloc()**
```python
df.iloc['row_index', 'column_index']

df.iloc[['row_index_1', 'row_index_2'], ['column_index_1', 'column_index_2']]
```
**Selecting Rows and Columns**
```python
df.loc['row_label', 'column_label']

df.loc[[r1, r2],[cn1, cn2]]
df.loc[:, [cn1,cn2]]
df.loc[[r1,r2],:]
```
### Filtering

### Chain Selection

## Data Type Conversion
In general, there are 4 ways to convert data types in Pandas
- to_numeric() - provides functionality to safely convert non-numeric types (e.g. strings) to a suitable numeric type. (See also to_datetime() and to_timedelta().)
```python
s = pd.Series(['1.0', '2', -3])
pd.to_numeric(s, downcast='float')
```
- astype() - convert (almost) any type to (almost) any other type (even if it's not necessarily sensible to do so). Also allows you to convert to categorial types (very useful).
```python
df.astype('int32')
```
- infer_objects() - a utility method to convert object columns holding Python objects to a pandas type if possible.
- convert_dtypes() - convert DataFrame columns to the "best possible" dtype that supports pd.NA (pandas' object to indicate a missing value).

**[Datetime](https://towardsdatascience.com/working-with-datetime-in-pandas-dataframe-663f7af6c587)**
```Python 3
df = pd.DataFrame({'date': ['2016-6-10 20:30:0', 
                            '2016-a-1 19:45:30', 
                            '2013-10-12 4:5:1'],
                   'value': [2, 3, 4]})

# string to datetime, and set format                   
pd.to_datetime(df['date'], format="%Y-%d-%m %H:%M:%S")
# ignore errors
pd.to_datetime(df['date'], errors='ignore')
pd.to_datetime(df['date'], errors='ignore') # force an invalid value to NaT

# datetime from multiple columns
df = pd.DataFrame({'year': [2015, 2016],
                   'month': [2, 3],
                   'day': [4, 5]})
df['date'] = pd.to_datetime(df)

# get year, month, day, and week
df['year']= df['DoB'].dt.year
df['month']= df['DoB'].dt.month
df['day']= df['DoB'].dt.day
df['week_of_year'] = df['DoB'].dt.week
df['day_of_week'] = df['DoB'].dt.dayofweek

# select data by date
condition = (df['date'] > start_date) & (df['date'] <= end_date)
df.loc[condition]

# read date correctly while importing data with read_csv
pd.read_csv('data/data_3.csv', parse_dates=['date'])
pd.read_csv('data/data_4.csv', parse_dates=[['year', 'month', 'day']]) # default column name is 'year-month-day'
pd.read_csv('data/data_4.csv', parse_dates={ 'date': ['year', 'month', 'day'] })
```
