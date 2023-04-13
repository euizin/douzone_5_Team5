package CourseRegister.common;

import java.util.HashMap;
import java.util.Scanner;

import CourseRegister.admin.AdminSystem;
import CourseRegister.student.StudentSystem;

public class CourseRegister {
	private HashMap<String, Student> studentList; // 학생 리스트
	private Student loginStudent;
	Scanner sc = new Scanner(System.in);

	// 생성자
	public CourseRegister() {
		this.loginStudent = null;
		this.studentList = null;
	}


	// 실행
	public void run() {
		boolean run = false;
		System.out.println("수강신청 프로그램");
		while(!run) {
			int result = login();
			switch(result) {
			case 0:
				continue;
			case 1:
				studentMenu();
				break;
			case 2:
				adminMenu();
				break;
			}
		}
	}

	// 로그인
	public int login() {
		int result = 0;
		System.out.println("1.로그인\t2.회원가입");
		System.out.print("입력란 : ");
		int select = 0;
		try {
			select = Integer.parseInt(sc.nextLine());	
		} catch (Exception e) {
			System.out.println("잘못된 입력 형식입니다. 다시 입력해주세요.");
		}
		switch (select) {
		case 1:
			System.out.println("아이디와 비밀번호를 입력해주세요.");
			System.out.print("아이디 : ");
			String inputID = sc.nextLine();
			System.out.print("비밀번호 : ");
			String inputPWD = sc.nextLine();
			if(inputID.equals("admin")) {
				FileIO admin = new FileIO("Admin.txt");
				String[] adminInfo = ((String)admin.readFile()).split(":");
				String adminID = adminInfo[0];
				String adminPWD = adminInfo[1];
				if(inputID.equals(adminID) && inputPWD.equals(adminPWD)) {
					result = 2;
				}
			}else {
				HashMap<String, Student> students = null;
				/*
			try {
				fis = new FileInputStream("StudentInfo.txt");
				bis = new BufferedInputStream(fis);
				ois = new ObjectInputStream(bis);
				students = (HashMap<String, Student>) ois.readObject();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					ois.close();
					bis.close();
					fis.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
				 */
				FileIO get = new FileIO("StudentInfo.txt");
				studentList = (HashMap<String, Student>)get.readObject();
				if(inputPWD.equals(studentList.get(inputID).getPwd())) {
					this.loginStudent = studentList.get(inputID);
					result = 1;
				}else {
					System.out.println("입력하신 정보가 없습니다. 초기 화면으로 돌아갑니다.");
				}				
			}
			break;
		case 2:
			System.out.println("회원가입 정보를 입력해주세요.");
			System.out.print("이름 : ");
			String newName = sc.nextLine();
			System.out.print("아이디 : ");
			String newID = sc.nextLine();
			System.out.print("비밀번호 : ");
			String newPWD = sc.nextLine();
			Student newStudent = new Student(newName, newID, newPWD);
			FileIO get = new FileIO("StudentInfo.txt");
			studentList = (HashMap<String,Student>)get.readObject();
			if(studentList == null) {
				studentList = new HashMap<String, Student>();
			}
			studentList.put(newID, newStudent);
			FileIO add = new FileIO("StudentInfo.txt");
			add.writeObject(studentList);
			System.out.println(newName + "님 회원가입 완료되었습니다. 다시 로그인 해주세요.");
			/*
			try {
				fos = new FileOutputStream("StudentInfo.txt");
				bos = new BufferedOutputStream(fos);
				oos = new ObjectOutputStream(bos);
				
				oos.writeObject(studentList);
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					oos.close();
					bos.close();
					fos.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			*/
			break;
		}
		return result;
	}

	// 학생 메뉴
	public void studentMenu() {
		System.out.println("학생 메뉴 입니다.");
		StudentSystem ss = new StudentSystem(loginStudent);
		ss.run();
	}

	// 관리자 메뉴
	public void adminMenu() {
		AdminSystem as = new AdminSystem();
		as.run();
	}
}
