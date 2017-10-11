
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
