# 实验二_JAVA的控制语句
## （一）判断闰年
编写Java程序，输出从公元1990年到2007年所有闰年的年号，每输出两个年号换一行。 判断年号是否为闰年的条件是：
- （1）若年号能被4整除，而不能被100整除，则是闰年；
- （2）若年号能被400整除也是闰年。

### I. 工程名 
LeapYear.java
### II. 主要源代码

```
public class LeapYear {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printLeapYear (1990, 2007);
	}
	
	static int num=0;
	
	private static void printLeapYear ( int start, int end) {
        if (start > end) {
            return;
        }
        // 闰年标志：能被400整除，或者能被4整除但不能被100整除
        if (start % 400 == 0 || start % 4 == 0 && start % 100 != 0) {
        	num++;
            System.out.print (start + " ");
            //每输出两个年号换一行
            if(num % 2 == 0) {
            	System.out.println ();
            }
        }
        start++;
        // 递归调用
        printLeapYear (start, end);
    }
}
```

### III. 实验截图
![image](https://note.youdao.com/yws/public/resource/c1eee1ea5aba9bb41e017858f53d2dec/xmlnote/E6CBEA8D314347F19DA479B94AB101A4/338)

## （二）百分制成绩转化为等级成绩
实现方法ToGradeScore，将百分制成绩转化为等级成绩。要求对一组数据，实现批量转化。 
- 等级与百分制对照 
- 优：[90,100] 
- 良：[89,80] 
- 中：[79,70] 
- 及格：[69,60] 
- 不及格：[0,59]

### I. 工程名
Change.java
### II. 主要源代码

```

public class Change {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	    double [] score = {93,44,23,55,-9,60,78,75,93,84,71};
	    ToGradeScore(score);
	}
	public static void ToGradeScore(double[] score) {
		String [] newscore = new String[score.length];
		for(int i=0;i<score.length;i++) {
	        if(score[i]>=90 && score[i]<=100) {
	          newscore[i] = "A";
	        }else if(score[i]>=80 && score[i]<90) {
	            newscore[i] = "B";
	        }else if(score[i]>=70 && score[i]<80) {
	            newscore[i] = "C";
	        }else if(score[i]>=60 && score[i]<70) {
	            newscore[i] = "D";
	        }else if(score[i]>=0 && score[i]<60) {
	        	newscore[i] = "E";
	        }else {
	        	System.out.print(score[i] + "成绩输入错误!" );
	        	System.out.println ();
	        }
	    }

	    //输出转换后成绩
	    for(int i=0;i<newscore.length;i++){
	      System.out.print(newscore[i]+",");
	    }
		
	}
}

```

### III. 实验截图
![image](https://note.youdao.com/yws/public/resource/c1eee1ea5aba9bb41e017858f53d2dec/xmlnote/03FC1FF5ABED453FB1A21874FDCB6B51/393)

## （三）打印图案
利用for循环编写一个程序，将如下图案分别打印输出。
### I. 工程名
Printf.java
### II. 主要源代码

```

public class Printf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int H = 7;
		int W = 7;
		for (int i=0;i<(H+1)/2;i++) {
			for (int j=0;j<W/2-i;j++) {
				System.out.print(" ");
			}
			for (int k=1;k<(i+1)*2;k++) {
				System.out.print('*');
			}
			System.out.println();
		}
		for (int i=1;i<=H/2;i++) {
			for (int j=1;j<=i;j++) {
				System.out.print(" ");
			}
			for (int k=1;k<=W-2*i;k++) {
				System.out.print('*');
			}
			System.out.println();
		}

	}

}

```

### III. 实验截图
![image](https://note.youdao.com/yws/public/resource/c1eee1ea5aba9bb41e017858f53d2dec/xmlnote/1D00A1F59AE14998ABD17C6227525BF5/396)

## （四）水仙花数
编写程序找出所有的水仙花数；水仙花数是三位数，它的各位数字的立方和等于这个三位数本身。
### I. 工程名
Flower.java
### II. 主要源代码

```
public class Flower {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=100;i<1000;i++) {
			ShuiXianHuaShu(i);
		}
	}
	
	public static void ShuiXianHuaShu( int num) {
		if (num<100 || num>999) {
			return;
		}
		int a = num/100;
		int b = num%100/10;
		int c = num%10;
		if (a*a*a + b*b*b + c*c*c ==num) {
			System.out.print(num + "\t");
		}		
	}
}
```

### III. 实验截图
![image](https://note.youdao.com/yws/public/resource/c1eee1ea5aba9bb41e017858f53d2dec/xmlnote/D3D22FDF0AA3436796EEAC67B86EB4FF/387)

# 实验三_JAVA的面向对象基础
## （一）JAVA访问权限修饰符的掌握
编写一个具有public、private、protected、default访问权限的数据成员和成员函数的class。 为它产生一个对象并进行观：当你尝试取用所有class成员时、会产生什么类型的编译消息。
### I. 工程名
Try.java以及Try2.java
### II. 主要源代码

```

public class Try {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Try test = new Try();
		test.test1();
		test.test2();
		test.test3();
		test.test4();
		System.out.print(test.pub);
		System.out.println();
		System.out.print(test.pri);
		System.out.println();
		System.out.print(test.pro);
		System.out.println();
		System.out.print(test.defa);
		System.out.println();
	}
	public int pub=0;
	private int pri=1;
	protected int pro=2;
//	default int def=3;
	int defa=3;
	public void test1() {
		System.out.print("Public。");
		System.out.println();
	}
	private void test2() {
		System.out.print("Private。");
		System.out.println();
	}
	protected void test3() {
		System.out.print("Protected。");
		System.out.println();
	}
	void test4() {
		System.out.print("Default。");
		System.out.println();
	}
}

```

```

public class Try2 extends Try{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Try2 test = new Try2();
		test.test1();
//		test.test2();
		test.test3();
		test.test4();
		System.out.print(test.pub);
		System.out.println();
//		System.out.print(test.pri);
		System.out.println();
		System.out.print(test.pro);
		System.out.println();
		System.out.print(test.defa);
		System.out.println();

	}
}

```

### III. 实验截图
![image](https://note.youdao.com/yws/public/resource/c1eee1ea5aba9bb41e017858f53d2dec/xmlnote/87D1DC256C714C91A96FC9831A7FE19C/401)
![image](https://note.youdao.com/yws/public/resource/c1eee1ea5aba9bb41e017858f53d2dec/xmlnote/19752F6DEBFA4CBD88B985D1507B9C26/406)

## （二）单例模式——使用单例模式完成下面描述的类
Choc-O-Holic公司有一个巧克力锅炉，用来把巧克力和牛奶融合在一起生产巧克力棒。定义这个巧克力锅炉类为ChocolateBoiler

ChocolateBoiler有两个私有的成员变量，empty和boiled，用来判断锅炉是否为空，以及锅炉内混合物是否已煮沸。注意两个成员变量恰当的初始值。

- private boolean empty;
- private boolean empty;

ChocolateBoiler有三个方法来控制锅炉生产巧克力棒。

public void fill() {…} 向锅炉填满巧克力和牛奶的混合物。首先要判断锅炉是否为空， 只有空的锅炉才能填充巧克力和牛奶（填充过程打印一条语句即可）。填充之后empty为false

public void boil() {…} 将炉内煮沸。首先判断标志位，只有锅炉是满的，并且没有煮过， 才能进行该操作（煮沸操作打印一条语句即可）。煮沸后boiled标志位设置为true。

public void drain() {…} 排出煮沸的巧克力和牛奶。首先要进行标志位判断，只有锅炉是满的， 并且锅炉已经煮沸之后，才能排出混合物（排出混合物的动作打印一条语句即可），排出混合物之后设置empty为true。

isEmpty和isBoiled方法来获取empty和boiled标志位的值
### I. 工程名
ChocolateBoiler.java
### II. 主要源代码

```

public class ChocolateBoiler {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChocolateBoiler chocolate = ChocolateBoiler.getInstance();
		chocolate.fill();
		chocolate.boil();
		chocolate.drain();
		
		ChocolateBoiler boiler =  ChocolateBoiler.getInstance();
		boiler.boil();
		
	}
	
	private boolean empty;
	private boolean boiled;
	private static ChocolateBoiler uniqueInstance;
	
	private ChocolateBoiler() {
		empty = true;
		boiled = false;
	}
	
	public static ChocolateBoiler getInstance() {
		if(uniqueInstance == null) {
			uniqueInstance = new ChocolateBoiler();
		}
		return uniqueInstance;
	}
	
	public boolean isEmpty() {
		return empty;
	}
	public boolean isBoiled() {
		return boiled;
	}
	
	public void fill() {
		if (isEmpty()) {
			System.out.print("向锅炉填满巧克力和牛奶的混合物。");
			System.out.println();
			empty = false;
		}
		else {
			System.out.print("!empty。");
			System.out.println();
		}
	}
	public void boil() {
		if (!isEmpty() && !isBoiled()) {
			System.out.print("将炉内煮沸。");
			System.out.println();
			boiled = true;
		}
		else {
			System.out.print("empty or boiled。");
			System.out.println();
		}
	}
	public void drain() {
		if (!isEmpty() && isBoiled()) {
			System.out.print("排出煮沸的巧克力和牛奶。");
			System.out.println();
			empty=true;
			boiled=false;
		}
		else {
			System.out.print("drain false。");
		}
	}
}

```

### III. 实验截图
![image](https://note.youdao.com/yws/public/resource/c1eee1ea5aba9bb41e017858f53d2dec/xmlnote/21114A8FE20A444B96A10921E415EDF2/416)