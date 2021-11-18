## [🔗](http://c.biancheng.net/view/5852.html) one-dimensional array 
当数组中每个元素都只带有一个下标时，这种数组就是“一维数组”。一维数组（one-dimensional array）实质上是一组相同类型数据的线性集合，是数组中最简单的一种数组。

数组是引用数据类型，引用数据类型在使用之前一定要做两件事情：声明和初始化。所以本文将重点介绍一维数组的创建、初始化和使用。

### create one-dimensional array
declare + arrange space + initialize
```
type[] arrayName;
arrayName = new type[size];
type[] arrayName = new type[size];

type[] arrayName = new type[]{value1, value2, ...};
type[] arrayName = {value1, value2, ...}
```

### get value
```
for(int val:arrayName) System.out.print(val + "\t")
```


## interate int 

int to string(len, charAt), then to charArray (access with index)
```
String s = String.valueof(num);
int len = s.length();
char [] charArray = s.toCharArray();
char si = charArray[indexi];
charArray[indexi] = si;
```

charArray back to string, then to integer 
```
max = Math.max(max, Integer.parseInt(new String(charArray))); 
```
