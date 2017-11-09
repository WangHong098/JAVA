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
	
	//重写父类方法，实现先FCFS
	//返回最早到达的服务
	public Task findTask(List<Task> l) {
    	return l.remove(0);
	}
}