
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
        // �����־���ܱ�400�����������ܱ�4���������ܱ�100����
        if (start % 400 == 0 || start % 4 == 0 && start % 100 != 0) {
        	num++;
            System.out.print (start + " ");
            //ÿ���������Ż�һ��
            if(num % 2 == 0) {
            	System.out.println ();
            }
        }
        start++;
        // �ݹ����
        printLeapYear (start, end);
    }
}
