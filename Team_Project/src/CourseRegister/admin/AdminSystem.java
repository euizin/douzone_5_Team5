package CourseRegister.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import CourseRegister.common.Course;
import CourseRegister.common.FileIO;
import CourseRegister.common.Student;

public class AdminSystem {
	//private List<Student> studentList;	//학생 리스트
	//private List<Course> courseList;	//강의 리스트
	Scanner sc = new Scanner(System.in);
	
	//관리자 생성자
	public AdminSystem() {
		FileIO student = new FileIO("StudentInfo.txt");
		FileIO course = new FileIO("CourseList.txt");
		//this.studentList = new ArrayList<Student>(((HashMap<String, Student>)student.readObject()).values());
		//this.courseList = new ArrayList<Course>(((HashMap<String, Course>)course.readObject()).values());
	}
	
	public void run() {
		System.out.println("관리자 메뉴 입니다.");
		System.out.println("1.신청 내역 조회\t2.강의 관리\t3.돌아가기");
		System.out.print("입력란 : ");
		int choice = 0;
		try {
			choice = Integer.parseInt(sc.nextLine());
		} catch (Exception e) {
			System.out.println("올바르지 않은 입력 형식입니다. 다시 선택해주세요.");
			run();
		}
		switch(choice) {
			case 1:
				viewRegistList();
				break;
			case 2:
				courseManagement();
				break;
			case 3:
				System.out.println("이전 메뉴로 돌아갑니다.");
				return;
		}
	}
	
	//신청 내역 조회
	public void viewRegistList() {
		
	}
	
	//강의 관리
	public void courseManagement() {
		CourseManagement cm = new CourseManagement();
		System.out.println("강의 관리 메뉴");
		System.out.println("1.강의 추가\t2.강의 정보 수정\t3.강의 제거\t 4.돌아가기");
		System.out.print("입력란 : ");
		try {
			int choice = Integer.parseInt(sc.nextLine());
			switch(choice) {
				case 1:
					cm.addCourse();
					break;
				case 2:
					cm.modifyCourse();
					break;
				case 3:
					cm.removeCourse();
					break;
				case 4:
					System.out.println("이전 메뉴로 돌아갑니다.");
					return;
			}
		} catch (Exception e) {
			System.out.println("잘못된 입력 형식입니다. 다시 입력해주세요.");
			courseManagement();
		}
	}
}
