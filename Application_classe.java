import java.util.Scanner;

public class Application_classe {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		Student student = new Student(null);
		Admin admin = new Admin(null);
		Lecture lecture = new Lecture();
		
		
		System.out.println("*********KOSA 대학교 수강신청*********");
		System.out.println("1.로그인하기");
		System.out.println("2.회원가입하기");
		System.out.print("메뉴를 선택해주세요(번호로 입력해주세요):");
		
		
	
		String strNum=sc.nextLine();
		
		if(strNum.equals("1")) {
			System.out.println("*********KOSA 대학교 수강신청 로그인*********");
			System.out.println("안녕하세요^^");
			System.out.println("1.수강 신청(학생용) 로그인");
			System.out.println("2.수강 신청(관리자용) 로그인");
			System.out.print("메뉴를 선탁하세요(숫자로 입력해주세요^^):");
			String strNum2=sc.nextLine();
			
		if(strNum2.equals("1")) {
		
			student.login();
			
		}	else if(strNum2.equals("2")){
			admin.login();
		}
		}else if(strNum.equals("2")) {
			System.out.println("*********KOSA 대학교 수강신청 회원가입*********");
			System.out.println("안녕하세요^^");
			System.out.println("1.수강 신청 회원가입(학생용) 로그인");
			System.out.println("2.수강 신청 회원가입(관리자용) 로그인");
			System.out.print("메뉴를 선탁하세요(숫자로 입력해주세요^^):");
			String strNum3=sc.nextLine();
			
			if(strNum3.equals("1")){
				student.join();
			}else if(strNum3.equals("2")){
			admin.join();				
		}
		}
		
		
	}

}
