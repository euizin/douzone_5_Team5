
import java.util.Scanner;

public class Student {
	
	Lecture lecture= new Lecture();
	Application_classe app= new Application_classe();
	Scanner sc =new Scanner(System.in);	
	
	String student_number;
	String student_name;
	String student_pw;

	public void join(){//회원가입
		System.out.println("*******KOSA 대학교 회원가입 학생용*******");
		System.out.println("안녕하세요^^");
		System.out.println("회원 가입 할 학생 학번을 입력해주세요^^");
		String sutudent_number=sc.nextLine();
		System.out.println("회원 가입 할 학생 이름을 입력해주세요^^");
		String sutudent_name=sc.nextLine();
		System.out.println("회원 가입 할 학생 PW을 입력해주세요^^");
		String sutudent_pw=sc.nextLine();
		System.out.println("회원 가입 되었습니다.^^");
		System.out.println("로그인하시겠습니까?");
		System.out.println("1.YES 2. NO");
		
		int selec_num=0;
		
		try {
			selec_num = Integer.parseInt(sc.nextLine());	
		} catch (Exception e) {
			System.out.println("잘못된 입력 형식입니다. 다시 입력해주세요.");
		}

			switch (selec_num) {
			case 1:
				System.out.println("안녕하세요^^");
				login();
				break;
			case 2:
				System.out.println("안녕하세요^^");
				System.out.println("이용해 주셔서 감사합니다^^");
				

			}
		
		
	}
	
	public void login(){//로그인
		
		System.out.println("*******KOSA 대학교 로그인 학생용*******");
		System.out.println("안녕하세요^^");
		System.out.println("학생 학번을 입력해주세요^^: ");
		String student_number1=sc.nextLine();
		
		
			System.out.println("학번을 확인했습니다.");
			System.out.println("학생 비번을 입력해주세요^^:");
			String student_pw1=sc.nextLine();
			//비번 입력
			System.out.println("로그인 되셨습니다^^");
			run();
	}
			
			
		
		
	

	public void run() { //학생용 메뉴 시작
		System.out.println("*********KOSA 대학교 수강신청 학생*********");
		System.out.println("1. 학생 수강과목 리스트 목록 확인하기");
		System.out.println("2. 수강신청하기");
		System.out.println("3. 수강 신청 삭제");
		System.out.println("4. 수강 신청 완료 리스트 보기");
		System.out.print("메뉴를 선탁하세요(숫자로 입력해주세요^^):");
		String strNum6=sc.nextLine();
		
		switch(strNum6) {
		case "1":
			lecture.Lecture_list();;
		case "2":
			lecture.ADD_class();
		case "3":
			lecture.Del_class();
		case "4":
			lecture.Completion_Lecture_list();
		}
		
			
		}
		
	}
	
