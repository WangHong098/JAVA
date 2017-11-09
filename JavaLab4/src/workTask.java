

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

//import Task.Task;


public abstract class workTask {
	//抽象类，定义不同的方式（FCFS or SJF）
	public abstract  Task findTask(List<Task> l);
	//一个处理队列
	public   void oneList_working() throws IOException{
		System.out.println("one-list ");
		List<Task> alltask=initialize.readtask();
		List<Task> waittask=new LinkedList<Task>();
		int time=0;   //当前时间
		int lasttime=0;   //当前服务还需时间
		//当前处理的任务
		Task t=new Task(); 
        boolean b=true;

		for(;;){
			b=true;
			if(alltask.isEmpty() && waittask.isEmpty() && lasttime==0) break;        //所有作业都执行结束
			System.out.println("Time = "+time+"   ");
			//将到达任务加入等待队列
			if(!alltask.isEmpty()){
     			if(alltask.get(0).getArrivalTime()<=time){
	     			waittask.add(alltask.remove(0));
     			}
			}
			//当前任务结束
			if(lasttime==0){
				if(!waittask.isEmpty()){
					t=findTask(waittask);
					lasttime=t.getServiceTime();					
				}
				else{
					b=false;
				}
			}	
			time++;
			lasttime--;	
			if(b){
    			System.out.println("  ID : "+t.getTaskID()+" ServiceTime : "+t.getServiceTime()+" last : "+lasttime);
			}
			else {
				System.out.println("wait");
			}
		}
	}
    //两个处理队列
    public   void twoList_working() throws IOException{
    	System.out.println("two-list ");
    	List<Task> alltask=initialize.readtask();
    	List<Task> waitlist=new LinkedList<Task>();
    	int time=0;
    	int lasttime1=0;             //第一个处理队列还需时间
    	int lasttime2=0;             //第二个处理队列还需时间
    	//当前处理的任务
        Task t1=new Task();          
        Task t2=new Task();
    	boolean b1=true;
    	boolean b2=true;
    	for(;;){
    		b1=true;
    		b2=true;
    		if(alltask.isEmpty() && waitlist.isEmpty() && lasttime1<=0 && lasttime2<=0 ) break;
    		System.out.println("Time = "+time+"   ");
    		//将到达的服务加入等待队列
    		if(!alltask.isEmpty()){
        		if(alltask.get(0).getArrivalTime()<=time){
        			waitlist.add(alltask.remove(0));
        		}
    		}
    		//第一队列当前任务结束
    		if(lasttime1<=0){
    			if(!waitlist.isEmpty()){
    				t1=findTask(waitlist);
    				lasttime1=t1.getServiceTime();
    				
    			}
    			else{
    				b1=false;
    			}
    		}
    		//第二队列当前任务结束
    		if(lasttime2<=0){
    			if(!waitlist.isEmpty()){
    				t2=findTask(waitlist);
    				lasttime2=t2.getServiceTime();
    			}
    			else{
    				b2=false;
    			}
    		}
    		time++;
    		lasttime1--;
    		lasttime2--;
    		if(b1){
    	    	System.out.print("  LIST1:   ID : "+t1.getTaskID()+" ServiceTime : "+t1.getServiceTime()+" last : "+lasttime1);
    		}
    		else{
    			System.out.print("  LIST1:  wait                             ");
    		}
    		if(b2){
    	    	System.out.println("             LIST2:   ID : "+t2.getTaskID()+" ServiceTime : "+t2.getServiceTime()+" last : "+lasttime2);
    		}
    		else{
    			System.out.println("             LIST2:  wait");
    		}
    		
    	}
    	
    	
    	
    }

}
