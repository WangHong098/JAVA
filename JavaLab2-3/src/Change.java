
public class Change {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	    double [] score = {93,44,23,55,-9,60,78,75,93,84,71};
	    ToGradeScore(score);
	}
	public static void ToGradeScore(double[] score) {
		String [] newscore = new String[score.length];
		for(int i=0;i<score.length;i++) {
	        if(score[i]>=90 && score[i]<=100) {
	          newscore[i] = "A";
	        }else if(score[i]>=80 && score[i]<90) {
	            newscore[i] = "B";
	        }else if(score[i]>=70 && score[i]<80) {
	            newscore[i] = "C";
	        }else if(score[i]>=60 && score[i]<70) {
	            newscore[i] = "D";
	        }else if(score[i]>=0 && score[i]<60) {
	        	newscore[i] = "E";
	        }else {
	        	System.out.print(score[i] + "成绩输入错误!" );
	        	System.out.println ();
	        }
	    }

	    //输出转换后成绩
	    for(int i=0;i<newscore.length;i++){
	      System.out.print(newscore[i]+",");
	    }
		
	}
}
