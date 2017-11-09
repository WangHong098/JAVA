import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;


public class main {
	public static void main(String[] args) throws IOException {
		
	//读写文件
		initialize.makeTask();
		initialize.readtask();
		
   //执行不同解决方案
		FCFS fcfs=new FCFS();
		fcfs.oneList_working();
		fcfs.twoList_working();
		SJF sjf=new SJF();
		sjf.oneList_working();
		sjf.twoList_working();
	}
}
