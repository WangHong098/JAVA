import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Scanner;
import java.io.Reader;

public class Based_IO {
	public static void write(String f,String s) throws IOException{
		File file=new File(f);
		FileWriter fw=new FileWriter(file);
		BufferedWriter bw=new BufferedWriter(fw);
		bw.write(s);
		bw.flush();
		bw.close();
	}
	public static String read(String f) throws IOException{
		File file=new File(f);
		FileReader fr=new FileReader(file);
		BufferedReader br=new BufferedReader(fr);
		String s="";
		String line="";
		while(line!=null) {
			s=s+line;
			line=br.readLine();
		}
		return s;
	}

	public static void main(String args[]) throws IOException {  
		System.out.println("please input :");
		Scanner scanner=new Scanner(System.in);
		String s=scanner.nextLine();
		s=read("src.txt");
		write("dest.txt",s);
		s=read("dest.txt");
		System.out.println("output :");
		System.out.println(s);
	}
}
