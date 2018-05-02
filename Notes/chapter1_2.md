### 抽象数据类型
> **Note:**
> - 抽象数据类型不同于静态方法库，静态方法库一般不包含构造函数。
> - 抽象数据类型不需要static关键字。
> - 对象的三大重要特性：状态（值），标识（变量名）和行为（函数）
> - 静态方法的主要作用是实现函数，非静态（实例）方法的主要作用是实现数据类型的操作。
> - Java存在两种数据类型，原始数据类型和引用类型。原始数据类型是指int, float, double, char, short, long, bool。原始数据类型遵从按值传递，而引用类型
（类，数组，字符串）是默认的按引用传递，不同于C++的显式形参引用声明。
 
### 比较两个对象是否相等

```
public boolean equals(Object x)
{
  if(this == x) return true; //引用相同，同一个对象
  if(x == null) return false; //非空性
  if(this.getClass() != x.getClass()) return false; // 所属类型是否相同
  Data that = (Date) x; //因为上一语句，所以此处类型转换是安全的。以Date为例，其他类的equals方法类似
  if(this.day != that.day) return false;
  if(this.month != that.month) return false;
  if(this.year != that.year) return false;
  return true;
}
```
