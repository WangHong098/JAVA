import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;



public class SJF extends workTask{
	public SJF(){
		System.out.println("SJF");
	}
	//重写父类方法，实现SJF
	//寻找当前最短服务
    public Task findTask(List<Task> l) {
    	int index=0;
    	int serviceTime=l.get(0).getServiceTime();
    	for(int i=0;i<l.size();i++){
    		if(l.get(i).getServiceTime()<serviceTime){
    			index=i;
    		}
    	}
    	return l.remove(index);
	}
	
}
