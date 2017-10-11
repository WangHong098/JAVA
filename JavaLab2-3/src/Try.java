
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


