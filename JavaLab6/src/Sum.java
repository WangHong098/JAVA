
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
		System.out.println("µÚ"+threadID+"¶Î: "+s);
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
