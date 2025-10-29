package Inheritance;



class Course{
	String courseName ;
	int duration;//In days
	Course(String courseName , int duration){
		this.courseName = courseName;
		this.duration = duration;
	}
}

class OnlineCourse extends Course{
	String platform ;
	String isRecorded;//Either yes or no
	OnlineCourse(String courseName , int duration , String platform, String isRecorded){
		super(courseName,duration);
		this.platform = platform;
		this.isRecorded = isRecorded;//Either yes or no
	}
}

class PaidOnlineCourse extends OnlineCourse{
	int fee;
	double discount;
	PaidOnlineCourse(String courseName , int duration , String platform, String isRecorded, int fee , double discount){
		super(courseName,duration,platform,isRecorded);
		this.fee = fee;
		this.discount = discount;
	}
	void displayDetails(){
		System.out.println(courseName + " is a course of duration " + duration + " days and is on a platform name " + platform + " and recorded status : " +isRecorded + " and its fee is "+fee + " with discount of " +discount +" (%)percent");
	}
}


public class EducationCourseHierarchy {
	public static void main(String[] args) {
		PaidOnlineCourse obj = new PaidOnlineCourse("Introduction to Java",30 ,"youtube" ,"yes",1000,10);
		obj.displayDetails();
	}
}