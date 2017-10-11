
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
			System.out.print("empty。");
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
	}

}
