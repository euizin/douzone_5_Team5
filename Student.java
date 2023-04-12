import java.util.List;
import java.util.Scanner;

public class Student {
	
	Scanner sc =new Scanner(System.in);
	private String student;		//학생 정보
	private List<Lecture> LectureList;
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public  Student(String student) {
		this.student= student;
		this.LectureList=LectureList;		
	}
	public void run() { //학생 메뉴 시작
		
	}
	
	public void join() { //관리자 회원가입
		System.out.println("*******KOSA 대학교 학생*******");
		System.out.println("안녕하세요^^");
		System.out.println("회원 가입 할 학생 학번을 입력해주세요^^: ");
		String strNum= sc.nextLine();
		System.out.println("회원 가입하는 학생 이름을 입력해주세요: ");
		String strNum2=sc.nextLine();
		System.out.println("회원 가입 할 PW를 입력해주세요 ");
		String strNum3=sc.nextLine();
	}
	
	public void login() { //학생 로그인
		System.out.println("*******KOSA 대학교 학생*******");
		System.out.println("안녕하세요^^");
		System.out.println("학생 학번을 입력해주세요^^: ");
		String strNum4= sc.nextLine();
		System.out.println("학생 이름을 입력해주세요: ");
		String strNum5=sc.nextLine();
		
		
	}

	public void lectureList() { //학생 수강과목 리스트
		
	}
	public void lectureRegist() { //학생 수강신청하기
		
	}
	public void lectureCencel() { //학생 수강신청 취소하기
		
		
	}
	
}
