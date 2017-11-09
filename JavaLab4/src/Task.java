public class Task {
	private  int taskID; //任务ID
	private  int arrivalTime; //到达时间
	private  int serviceTime; //服务时间
	private  int startingTime; //开始时间
	private static int finishingTime; //完成时间=开始时间+服务时间
	private static int turnAroundTime; //周转时间=完成时间-达到时间
	private static int weightTurnAround; //带权周转时间=周转时间/服务时间
	
	public Task(){};
	public Task(int a,int b,int c){
		taskID=a;
		arrivalTime=b;
		serviceTime=c;
	
	}
	
	public void setServiceTime(int a){
		startingTime=a;
		
	}
	public  void setFinishingTime(){
		finishingTime=startingTime+serviceTime;
	}
	public  void setTurnAroundTime(){
		turnAroundTime=finishingTime-arrivalTime;
	}
	public  void setWeightTurnAround(){
		weightTurnAround=turnAroundTime/serviceTime;
	}
	public  int getTaskID(){
		return taskID;
	}
	public  int getArrivalTime() {
		return arrivalTime;
	}
	public  int getServiceTime() {
		return serviceTime;
	}
	public int getStartingTime() {
		return startingTime;
	}
	public  int getFinishingTime() {
		return finishingTime;
	}
	public int getTurnAroundTime() {
		return turnAroundTime;
	}
	public int getWeightTurnAround() {
		return weightTurnAround;
	}
	
}