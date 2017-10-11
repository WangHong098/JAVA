
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
