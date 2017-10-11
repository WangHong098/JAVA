##实验二_JAVA的控制语句


####（一）判断闰年
* 编写Java程序，输出从公元1990年到2007年所有闰年的年号，每输出两个年号换一行。
判断年号是否为闰年的条件是：
（1）若年号能被4整除，而不能被100整除，则是闰年；
（2）若年号能被400整除也是闰年。

* ######源代码：LeapYear.java
* ######void printLeapYear ( int start, int end)方法实现批量判断从start到end是否为闰年，是的输出。

####（二）百分制成绩转化为等级成绩
* 实现方法ToGradeScore，将百分制成绩转化为等级成绩。要求对一组数据，实现批量转化。
等级与百分制对照
优：[90,100]
良：[89,80]
中：[79,70]
及格：[69,60]
不及格：[0,59]

* ######源代码：Change.java
* ######void ToGradeScore(double[] score)方法实现批量转换数组score中的成绩为对应的A、B、C、D、E五个等级输出；若成绩输入有误则提示错误成绩，并转换后的输出为null。


####（三）打印图案
* 利用for循环编写一个程序，将如下图案（菱形）分别打印输
出。

* ######源代码：Printf.java


####（四）水仙花数
* 编写程序找出所有的水仙花数；水仙花数是三位数，它的各位数字的立方和等于这个三位数本身。

* ######源代码：Flower.java
* ######void ShuiXianHuaShu( int num)方法实现判断一个数是否为水仙花数，若是，则输出这个数；在main()中利用for循环测试所有3位数中的水仙花数。



##实验三_JAVA的面向对象基础


####（一）JAVA访问权限修饰符的掌握
* 编写一个具有public、private、protected、default访问权限的数据成员和成员函数的class。
为它产生一个对象并进行观：当你尝试取用所有class成员时、会产生什么类型的编译消息。
* ######源代码：Try.java以及Try2.java。 
* ######在Try类中测试所有public、private、protected、default权限的成员以及成员函数都可以正常调用输出；Try2作为Try类同包的子类，其中private访问权限的成员无法被调用。

####（二）单例模式——使用单例模式完成下面描述的类
* Choc-O-Holic公司有一个巧克力锅炉，用来把巧克力和牛奶融合在一起生产巧克力棒。定义这个巧克力锅炉类为ChocolateBoiler
* ChocolateBoiler有两个私有的成员变量，empty和boiled，用来判断锅炉是否为空，以及锅炉内混合物是否已煮沸。注意两个成员变量恰当的初始值。
    *  private boolean empty;
    *  private boolean empty;

* ChocolateBoiler有三个方法来控制锅炉生产巧克力棒。
    *  public void fill() {…} 向锅炉填满巧克力和牛奶的混合物。首先要判断锅炉是否为空，
    只有空的锅炉才能填充巧克力和牛奶（填充过程打印一条语句即可）。填充之后empty为false

    *  public void boil() {…} 将炉内煮沸。首先判断标志位，只有锅炉是满的，并且没有煮过，
    才能进行该操作（煮沸操作打印一条语句即可）。煮沸后boiled标志位设置为true。
    *  public void drain() {…} 排出煮沸的巧克力和牛奶。首先要进行标志位判断，只有锅炉是满的，
    并且锅炉已经煮沸之后，才能排出混合物（排出混合物的动作打印一条语句即可），排出混合物之后设置empty为true。
    *  isEmpty和isBoiled方法来获取empty和boiled标志位的值

* ######源代码：ChocolateBoiler.java


##关于作者
* 姓名：王鸿
* 学号：123012015098
