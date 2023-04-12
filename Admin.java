import java.util.List;
import java.util.Scanner;

public class Admin {
	
	Scanner sc= new Scanner(System.in);
	private String admin;		//관리자
	private List<Lecture> lectureList;
	
	public Admin(String admin) {
		super();
		this.admin= admin;
		this.lectureList=lectureList;		
	}
	
	public void join() { //관리자 회원가입
		System.out.println("회원가입 할 ID를 입력 입력해주세요^^: ");
		String strNum= sc.nextLine();
		System.out.println("회원가입 할 PW을 입력해주세요: ");
		String strNum2=sc.nextLine();
		
	}

	public void login() { //관리자 로그인
		System.out.println("ID를 입력 입력해주세요^^: ");
		String strNum3= sc.nextLine();
		System.out.println("PW을 입력해주세요: ");
		String strNum4=sc.nextLine();
	}
	public void run() { //관리자 메뉴 시작
		
	}

	public void lectureList() { //학생 수강과목 리스트
		
	}
	public void Add_lecture() { //수강 과목 추가
		
	}
	public void Del_lecture() { //수강과목 삭제
			
	}
	
}
