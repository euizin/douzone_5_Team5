package CourseRegister.common;

import java.util.Date;

public class Course {
	private String courseName;	//강의명
	private String professor;	//교수명
	private Date time;			//강의 시간
	private int maxStudent;		//최대 수강 인원
	private int registNumber;	//현재 신청 인원
	
	//강의 생성자 : 생성시 강의명, 교수명, 강의 시간, 최대 수강 인원을 parameter로 갖는다.
	//(현재 신청 인원은 0으로 초기화)
	public Course(String courseName, String professor, Date time, int maxStudent) {
		super();
		this.courseName = courseName;
		this.professor = professor;
		this.time = time;
		this.maxStudent = maxStudent;
		this.registNumber = 0;
	}
	
	
}
