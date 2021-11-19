# String
## String and Integer
[🔗](http://c.biancheng.net/view/5820.html) valueOf(), toString(), and parse()
### String to Integer
```java
public static void main(String[] args) {
    String str = "123";
    int n = 0;
    // 第一种转换方法：Integer.parseInt(str)
    n = Integer.parseInt(str);
    System.out.println("Integer.parseInt(str) : " + n);
    // 第二种转换方法：Integer.valueOf(str).intValue()
    n = 0;
    n = Integer.valueOf(str).intValue();
    System.out.println("Integer.parseInt(str) : " + n);
}
```

### Integer to String
```java
public static void main(String[] args) {
    int num = 10;
    // 第一种方法：String.valueOf(i);
    num = 10;
    String str = String.valueOf(num);
    System.out.println("str:" + str);
    // 第二种方法：Integer.toString(i);
    num = 10;
    String str2 = Integer.toString(num);
    System.out.println("str2:" + str2);
    // 第三种方法："" + i;
    String str3 = num + "";
    System.out.println("str3:" + str3);
}
```

### Iterate Integer using String
int to string(len, charAt), then to charArray (access with index)
```java
String s = String.valueof(num);
int len = s.length();
char [] charArray = s.toCharArray();
char si = charArray[indexi];
charArray[indexi] = si;
```

charArray back to string, then to integer 
```java
max = Math.max(max, Integer.parseInt(new String(charArray))); 
```

# Array
## [🔗](http://c.biancheng.net/view/5852.html) one-dimensional array 
当数组中每个元素都只带有一个下标时，这种数组就是“一维数组”。一维数组（one-dimensional array）实质上是一组相同类型数据的线性集合，是数组中最简单的一种数组。

数组是引用数据类型，引用数据类型在使用之前一定要做两件事情：声明和初始化。所以本文将重点介绍一维数组的创建、初始化和使用。

### create one-dimensional array
declare + arrange space + initialize
```java
type[] arrayName;
arrayName = new type[size];
type[] arrayName = new type[size];

type[] arrayName = new type[]{value1, value2, ...};
type[] arrayName = {value1, value2, ...}
```

### get value
```java
for(int val:arrayName) System.out.print(val + "\t")
```


