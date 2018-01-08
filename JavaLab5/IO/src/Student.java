import java.io.Serializable;

public class Student implements Serializable , Comparable<Student>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private long studentID;
	private String sex;
	Student() {}
	Student(long studentID,String name,String sex) {
		this.studentID=studentID;
		this.name=name;
		this.sex=sex;
	}
	public String toString() {
		return studentID + " " + name + " " + sex;
	}
	public int compareTo(Student s) {
		return Long.compare(studentID, s.studentID);
	}

}
