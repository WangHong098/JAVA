import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;



public class FCFS extends workTask {
	public FCFS(){
		System.out.println("FCFS");
	}
	
	//��д���෽����ʵ����FCFS
	//�������絽��ķ���
	public Task findTask(List<Task> l) {
    	return l.remove(0);
	}
}