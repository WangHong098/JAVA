import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class Buffered_IO {

	public void withoutBuffer() {
		try{
			int c;
			File inFile=new File("iris.txt");
			File outFile=new File("withoutBuffer.txt");
			Reader finS=new FileReader(inFile);
			Writer foutS=new FileWriter(outFile);
			while((c=finS.read())!=-1) {
				foutS.write(c);
			}
			foutS.close();
			finS.close();
		} catch (IOException e) {
			System.err.println("FileStreamTest:"+e);
		}
	}
	public void withBuffer() {
		try {
			int c;
			File inFile=new File("iris.txt");
			File outFile=new File("withBuffer.txt");
			Reader finS=new FileReader(inFile);
			Writer foutS=new FileWriter(outFile);
			BufferedReader bfinS=new BufferedReader(finS);
			BufferedWriter bfoutS=new BufferedWriter(foutS);
			while((c=bfinS.read())!=-1) {
				bfoutS.write(c);
			}
			bfoutS.close();
			bfinS.close();
		} catch (IOException e) {
			System.err.println("FileStreamTest:"+e);
		}
	}
	public static void main(String [] args)
	{
		Buffered_IO io=new Buffered_IO();
		long startTime = System.currentTimeMillis();
		io.withoutBuffer();
		long endTime = System.currentTimeMillis();
		System.out.println("不带缓冲区的IO: "+(endTime-startTime)+"ms");
		long startTime1 = System.currentTimeMillis();
		io.withBuffer();
		long endTime1 = System.currentTimeMillis();
		System.out.println("带缓冲区的IO: "+(endTime1-startTime1)+"ms");
	}

}
