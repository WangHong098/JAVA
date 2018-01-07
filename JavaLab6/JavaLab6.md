# 实验六_JAVA多线程
## 实验一
对实验三中的单例模式进行改造，使其支持多线程，并且是线程安全的。
### I. 工程名
ChocolateBoiler.java
### II. 源代码

```
import java.util.*;

public class ChocolateBoiler implements Runnable{
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
	
	public synchronized boolean isEmpty() {
		return empty;
	}
	public synchronized boolean isBoiled() {
		return boiled;
	}
	
	public synchronized void fill() {
		System.out.print("fill()... ");
		if (isEmpty()) {
			System.out.print("向锅炉填满巧克力和牛奶的混合物。");
			System.out.println();
			empty = false;
		}
		else {
			System.out.print("fill_FALSE。");
			System.out.println();
		}
	}
	public synchronized void boil() {
		System.out.print("boil()... ");
		if (!isEmpty() && !isBoiled()) {
			System.out.print("将炉内煮沸。");
			System.out.println();
			boiled = true;
		}
		else {
			System.out.print("boil_FALSE。");
			System.out.println();
		}
	}
	public synchronized void drain() {
		System.out.print("drain()... ");
		if (!isEmpty() && isBoiled()) {
			System.out.print("排出煮沸的巧克力和牛奶。");
			System.out.println();
			empty=true;
			boiled=false;
		}
		else {
			System.out.print("drain_FALSE。");
			System.out.println();
		}
	}
	public void run() {
		Random rand=new Random();
		int num = 10;
		while(true)
		{	
				try{
					switch(rand.nextInt(3)%3){
						case 0:
							Thread.sleep(1000);
							fill();
							System.out.println(Thread.currentThread().getName());
							Thread.sleep(1000);
							break;
						case 1:
							Thread.sleep(1000);
							boil();
							System.out.println(Thread.currentThread().getName());
							Thread.sleep(1000);
							break;
						case 2:
							Thread.sleep(1000);
							drain();
							System.out.println(Thread.currentThread().getName());
							Thread.sleep(1000);
							break;
	
						default:System.out.println("error");break;
					}		
				}catch(InterruptedException e){
					System.out.println(e);
				}	
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChocolateBoiler chocolate = ChocolateBoiler.getInstance();
		Thread tA=new Thread(chocolate);
		Thread tB=new Thread(chocolate);
		Thread tC=new Thread(chocolate);
		Thread tD=new Thread(chocolate);
		tA.start();
		tB.start();
		tC.start();
		tD.start();

	}

}

```
### III. 实验截图
![image](https://note.youdao.com/yws/public/resource/c1eee1ea5aba9bb41e017858f53d2dec/xmlnote/B72D8A631D8142079AAABB064506FA5F/420)

## 实验二
利用4个线程分段求和1~100
- 线程1计算1~25之和；线程2计算26~50之和；以此类推
- 要求线程1完成之后执行线程2，之后执行线程3，最后执行线程4
- 打印每段求和结果，以及最后的总结果。即分别打印第一段求和结果，第二段求和结果，第三段求和结果，第四段求和结果，最终的求和结果

### 工程名
Sum.java

### 主要源代码

```

public class Sum implements Runnable {
	private static Thread[]sums=new Thread[4];
	private int threadID;
	static int sum=0;
	static int num=0;	
	Sum(int ID) {
		threadID=ID;
	}
	public synchronized void doit() {
		if (num<=100) {
			try {				
				Thread.sleep(200);
			} catch (Exception e) {
				e.printStackTrace();
			}
			num++;
		}
	}
	public void run() {
		// TODO Auto-generated method stub	
		int s=0;
		for(int i=0;i<25;i++) {
			doit();
			sum+=num;
			s+=num;
		}	
		System.out.println("第"+threadID+"段: "+s);
	}
	public static void main(String [] args) {
		try {
			for(int i=0;i<sums.length;i++) {
				sums[i]=new Thread(new Sum(i+1));
				sums[i].start();
				sums[i].join();
			}
		} catch (InterruptedException e) {
			System.out.println(e);
		}
		System.out.println("Total: "+Sum.sum);
	}

}

```

### 实验截图
![image](https://note.youdao.com/yws/public/resource/c1eee1ea5aba9bb41e017858f53d2dec/xmlnote/6951235918F341769ED24DD534221686/437)
