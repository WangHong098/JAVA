import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;


public class main {
	public static void main(String[] args) throws IOException {
		
	//��д�ļ�
		initialize.makeTask();
		initialize.readtask();
		
   //ִ�в�ͬ�������
		FCFS fcfs=new FCFS();
		fcfs.oneList_working();
		fcfs.twoList_working();
		SJF sjf=new SJF();
		sjf.oneList_working();
		sjf.twoList_working();
	}
}
