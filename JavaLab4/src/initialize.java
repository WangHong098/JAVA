import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

//import JavaLab4.Task;

public class initialize {
	public static File file = new File("task.txt");           //文件名
	
	//生成数据并写入文件
	public static void makeTask() throws IOException {              
		int i;
		int servicetime[]={6,2,1,3,9};
		Random random=new Random();

	    FileWriter fw = new FileWriter(file);
		BufferedWriter writer = new BufferedWriter(fw);

		for(i=0;i<100;i++){                         //生成100条数据
			int index=random.nextInt(5);            //随机生成servicetime
			int id=i+1;
			writer.write(id+" "+i+" "+servicetime[index]);
			writer.newLine();//换行
			writer.flush();
		}
		
	}
	//读取数据，返回一个链表
	public static List<Task> readtask() throws IOException{
		List<Task> alltask=new LinkedList<Task>();
		File file =new File("task.txt");
		FileReader fr =new FileReader(file);
	    BufferedReader reader=new BufferedReader(fr);
	    String line="";
	    int i=0;
	    while(line!=null){
	    	line=reader.readLine();
	    	if(line==null) break;
	    	String st[]=line.split(" ");
	    	int a=Integer.parseInt(st[0]);
	    	int b=Integer.parseInt(st[1]);
	    	int c=Integer.parseInt(st[2]);
	    	Task t=new Task(a,b,c);
            alltask.add(t);	
	    	i++;    	
	    }
	    return alltask;
	}
}
