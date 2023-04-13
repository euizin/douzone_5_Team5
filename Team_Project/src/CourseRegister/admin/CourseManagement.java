package CourseRegister.admin;

import java.util.HashMap;
import java.util.Scanner;

import CourseRegister.common.Course;
import CourseRegister.common.FileIO;

public class CourseManagement {
	private HashMap<String, Course> courseList;	//강의 리스트
	Scanner sc = new Scanner(System.in);
	
	//강의 관리 생성잔
	public CourseManagement() {
		this.courseList = null;
	}
	
	//강의 생성
	public void addCourse() {
		try {
			System.out.println("새로운 강의 생성을 위한 정보를 입력해주세요.");
			System.out.print("강의명 : ");
			String courseName = sc.nextLine();
			System.out.print("교수명 : ");
			String professor = sc.nextLine();
			System.out.print("강의시간(ex. 13:00~13:50) : ");
			String time = sc.nextLine();
			System.out.print("최대 수강 인원 : ");
			int maxStudent = Integer.parseInt(sc.nextLine());
			FileIO add = new FileIO("CourseList.txt");
			courseList = (HashMap<String, Course>)add.readObject();
			if(courseList == null) {
				courseList = new HashMap<String, Course>();
			}
			courseList.put(courseName ,new Course(courseName, professor, time, maxStudent));
			add.writeObject(courseList);
			System.out.println("[" + courseName + "]강의를 추가했습니다.");
		} catch (Exception e) {
			System.out.println("잘못된 입력 형식입니다. 형식에 맞춰 다시 작성해주세요.");
			addCourse();
		}
		
	}
	
	//강의 정보 수정
	public void modifyCourse() {
		try {
			System.out.println("수정할 강의명을 입력해주세요.");
			System.out.print("수정할 강의명 : ");
			String courseName = sc.nextLine();
			
			System.out.print("교수명 : ");
			String professor = sc.nextLine();
			System.out.print("강의시간(ex. 13:00~13:50) : ");
			String time = sc.nextLine();
			System.out.print("최대 수강 인원 : ");
			int maxStudent = Integer.parseInt(sc.nextLine());
			FileIO modify = new FileIO("CourseList.txt");
			courseList = (HashMap<String, Course>)modify.readObject();
			if(courseList == null) {
				courseList = new HashMap<String, Course>();
			}
			courseList.put(courseName ,new Course(courseName, professor, time, maxStudent));
			modify.writeObject(courseList);
			System.out.println("[" + courseName + "]강의를 추가했습니다.");
		} catch (Exception e) {
			System.out.println("잘못된 입력 형식입니다. 형식에 맞춰 다시 작성해주세요.");
			addCourse();
		}
	}
	
	//강의 제거
	public void removeCourse() {
		
	}
}
