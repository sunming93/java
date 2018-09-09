# - 2018.9.3
- #### 不会的及时问
- #### 遇到知识点的问题，看单一源（官方文档，源码），不要看别人嚼剩下的（博客），学会看英文文档
- #### 不会的词，查词典，了解本身的含义
- #### 准备四个问题：
 1. 这个测试在测什么
 1. 为什么挂了
 1. 你是怎么改的
 1. 你为什么这么改

# - 2018.9.4
### IntegerTypeTest, FloatingTypeTest, CharTypeTest, BooleanOperatorsTest, ArrayTest
- ####  内存空间
1.  byte: 8 bits ; 最大值为 2^7-1,最小值为 -2^7
1.  short: 2 bytes = 16 bits ; 最大值为 2^15-1,最小值为 -2^15
1.  int: 4 bytes = 32 bits ; 最大值为 2^31-1,最小值为 -2^31
1.  long: 8 bytes = 64 bits ; 最大值为 2^63-1,最小值为 -2^63
1.  float: 4 bytes = 32 bits
1.  double: 8 bytes = 64 bits
1.  char: 2 bytes = 16 bits

- #### 类型转换
|   |byte | short | int | long | float | double |
|---|---|---|---|---|---|---|
byte | \ | 隐 | 隐 | 隐 | 隐 | 隐
short | 显 | \ | 隐 | 隐 | 隐 | 隐
int | 显 | 显 | \ | 隐 | 隐 | 隐
long | 显 | 显 | 显 | \ | 隐 | 隐
float | 显 | 显 | 显 | 显 | \ | 隐
double | 显 | 显 | 显 | 显 | 显 | \

- #### 计算机中存的是补码，首位为符号位，负数的符号位为1

- #### underscore
便于理解，但不能用于开头和结尾

- #### 计算时要注意溢出
若溢出则会得到非预期的结果

- #### 直接写一个整数，默认为int，会自动补0
初始化short类型要强转；初始化long类型要加L（建议不要用l）

- #### ++ i 和 i ++
- ++i 是先自增，再赋值
- i++ 是先赋值，再自增


- #### 相加时，为了避免溢出，使用Math.addExact()方法

- ####  直接写一个小数，默认为double
初始化float类型要加f或F

- #### >>和<<为有符号移位，>>>为无符号移位

- #### 十六进制不要加负号
最小值加负号还是最小值
  
- #### Double.NaN != Double.NaN

- #### 小数转整数时，是直接取整数部分
若要四舍五入，可以用Math.round()

- #### ASCII Unicode UTF-8 UTF-16 UTF-32等之间的关系

| 最早| ASCII||
---|---|---
编码方式 | Unicode | USC
实现方式 | UTF - 8,16,32 | USC - 2,4
##### ASCII为8位，但有效只有7位，首位为0
##### 从Java5开始，Java使用UTF-16，之前使用UCS-2

- #### 转义字符
'\b','\n','\r'等

- #### &，&&，|，||区别
1. &和|为位运算符，&&和||位逻辑运算符
2. &&和||有短路特性

- #### &，|，~的优先级
##### ~ > & > |

- #### 默认值
- 整数默认为0
- 小数默认为0.0
- 对象默认为null
- boolean默认为false
- char默认为'\u0000'

##### field会有默认值，若不初始化调用的就是默认值；
##### variable没有默认值，若不初始化就不能使用；
##### 数组初始化了却没有赋值，则里面存的是默认值

# - 2018.9.5
### StringTest, ObjectTest
- #### String是immutable的

- #### 字符串拼接时，最好用StringBuild

- #### codePoint
codePoint的长度可能不只一个字符，有时候需要不只一个字符来表示一个codePoint

- #### final关键字
- final变量不可改变：基本类型不能被重新赋值，对象类型不能改变其引用关系
- final方法不能被override
- final类不能被继承

- #### ==判断是不是同一个对象，而不是对象的值是否相等

- #### parameter vs argument
- parameter形参，方法里面的参数，方法结束就会消失
- argument实参，传进去的参数，不会在方法里面被更改

- #### 执行顺序：
1. 首先执行父类中的静态域和静态代码块（静态域和静态代码块的具体执行顺序依代码中定义的顺序而定）；
1. 然后执行子类中的静态域和静态代码块；
1. 然后执行父类中的非静态域和非静态代码块；
1. 接着执行父类的初始化方法（如果子类在构造函数中明确指明了调用父类的哪一个构造函数，则调用相应的构造函数，否则调用父类的无参构造函数）
1. 然后执行子类中的非静态域和非静态代码块；
1. 最后执行子类的初始化方法（即被调用的那一个构造函数）。

- #### 方法签名 = 方法名 + 形参列表

# - 2018.9.6
### InheritanceTest, ReflectionTest
- #### access modifier 
Modifier | Class | Package | Subclass | World
---|---|---|---|---
public | Y | Y | Y | Y
protected | Y | Y | Y | N
package-private | Y | Y | N | N
private | Y | N | N | N

- #### 调用most derived方法

- #### perfect equals
- 自反性
- 对称性
- 传递性
- 一致性
##### * 父子类不能比较相等

- #### 相等比较
##### identity > equality > hashcode equality
hascode(太强或太弱性能都不好)

- #### instanceof 
##### 能强制转换不出错就返回true
The instanceof operator compares an object to a specified type. You can use it to test if an object is 
- an instance of a class, 
- an instance of a subclass, or 
- an instance of a class that implements a particular interface.

- #### 构造器调用顺序
- 先调用父类构造器（无super指定则默认无参），如果父类没有无参构造器，会报错，可以显式调用父类有参构造器，但必须在第一行。
- 再调用自己的构造器
##### * 构造方法不能递归调用

- #### 类的描述信息，存在.class中，是一个Class对象的实例

- #### getModifers()返回的是一个int


- #### getMethods()和getDeclaredMethods()
- getMethods()返回类的所有public方法，包括声明的，从父类继承的，接口继承的
- getDeclaredMethods()返回类的所有声明的方法，包括public,protected,package-private,private,但不包括继承的

- #### 获取数组元素的类型用.getComponentType()

- #### 数组元素有继承关系不代表数组有继承关系

# - 2018.9.7
### InterfaceTest, LambdaTest
- #### interface特性
1. 类可以实现多个接口
1. 不能实现,接口中的方法不能被实现
1. field 默认为public final static
1. 只有static or default才有方法体
1. 不可初始化
1. 接口中的static方法不能被继承到子类中，子类不能调用接口的static方法
1. 接口只能继承接口
1. 类继承接口必须实现接口的所有方法
1. 方法默认为public
1. default方法可以被继承
1. 默认为abstract，package private
1. can be type
1. 钻石问题

- #### 钻石问题解决办法
<Intercace-name>.super.<methodName>

- #### 内部类调用外部类的方法
<class-name>.this.<methodName>

- #### Arrays.sort()是根据元素的compareTo()方法的返回值来排序的

- #### lambda是为了使匿名类看起来更简单
functional interface是一种只有一个抽象方法的接口


- #### 被lamda表达式捕获的变量是immutable的
lamda invocation is lazy

- #### method reference
Kind |	Example
---|---
Reference to a static method|	ContainingClass::staticMethodName
Reference to an instance method of a particular object|	containingObject::instanceMethodName
Reference to an instance method of an arbitrary object of a particular type|	ContainingType::methodName
Reference to a constructor|	ClassName::new