import java.util.Scanner;

public class Application_classe {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Student student = new Student();
		while (true) {

			System.out.println("*********KOSA 대학교 수강신청*********");
			System.out.println("1.로그인하기");
			System.out.println("2.회원가입하기");
			System.out.print("메뉴를 선택해주세요(번호로 입력해주세요):");

			int selec_num = 0;

			try {
				selec_num = Integer.parseInt(sc.nextLine());

				switch (selec_num) {
				case 1:
					System.out.println("*********KOSA 대학교 수강신청 로그인*********");
					System.out.println("안녕하세요^^");
					student.login();
					break;
				case 2:
					System.out.println("*********KOSA 대학교 수강신청 회원가입*********");
					System.out.println("안녕하세요^^");
					student.join();
					break;
				default :
					System.out.println("잘못된 입력 형식입니다. 다시 입력해주세요.");
				}
			}catch (Exception e) {
				
			}
		}
	}
}
