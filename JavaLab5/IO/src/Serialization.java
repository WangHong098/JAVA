import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Iterator;



public class Serialization {
	public void readFile(SortedSet<Student> ts) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("list.txt"),"UTF-8"));
		String s;
		while((s=br.readLine())!=null) {			
			String [] str=s.split(" ");			
			Student stu=new Student(Long.parseLong(str[0]),str[1],str[2]);			
			ts.add(stu);
		}
		br.close();
	}
	public void ObjectIO(SortedSet<Student> ts) throws Exception {
		Student s=new Student();
		Student t=null;
		String filename = "student.bin";
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		FileInputStream fis = null;
		ObjectInputStream in = null;
		try {
			fos = new FileOutputStream(filename);
			out = new ObjectOutputStream(fos);
			Iterator it=ts.iterator();
			while(it.hasNext()) 
				out.writeObject((Student)it.next());
			out.writeObject(t);
			out.close();
			fis = new FileInputStream(filename);
			in = new ObjectInputStream(fis);
			while((s=(Student)in.readObject())!=null)
				System.out.println(s.toString());
			in.close();
			} catch (IOException ex) {
			   ex.printStackTrace();
			}

	}
	public static void main(String[] args) throws Exception {
		SortedSet<Student> ts=new TreeSet<>();
		Serialization stu=new Serialization();
		stu.readFile(ts);
		stu.ObjectIO(ts);
	}
}
