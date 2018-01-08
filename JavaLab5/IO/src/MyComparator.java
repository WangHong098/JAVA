import java.io.File;
import java.util.Comparator;

public class MyComparator implements Comparator {
	public int compare(Object o1,Object o2)
	{
		File f1=(File)o1;
		File f2=(File)o2;
		return f1.getName().compareTo(f2.getName());
	}

}
