package CourseRegister.common;

import java.util.List;

public class Student {
	private String name;			//학생 이름
	private String studentID;		//학번
	private String pwd;				//비밀번호
	private List<Course> courseList;//수강 신청 목록
	private int availableGrade;		//이수 가능 학점
	
	//학생 생성자 : 생성시 이름, 학번, 비밀번호를 parameter로 갖는다.
	//(신청 목록은 null, 이수 가능 학점은 21로 초기화)
	public Student(String name, String studentID, String pwd) {
		super();
		this.name = name;
		this.studentID = studentID;
		this.pwd = pwd;
		this.courseList = null;
		this.availableGrade = 21;
	}
	
	
}
