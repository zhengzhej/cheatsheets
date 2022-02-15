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
