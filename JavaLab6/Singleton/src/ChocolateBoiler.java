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
