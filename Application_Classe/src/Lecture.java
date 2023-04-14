import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lecture {//수강과목 리스트 보여주기
	
	Scanner sc= new Scanner(System.in);
	
		
	public void Lecture_list() {//수강 과목 리스트 가져오기
		System.out.println("=====수강 과목 LIST=====");
		 try {
			// "subjects.txt" 파일을 읽기 위해 BufferedReader를 생성합니다.
	            BufferedReader reader = new BufferedReader(new FileReader("subjects.txt"));
	        // 파일에서 한 줄씩 읽어와서 처리합니다.
	            String line = reader.readLine();
	            while (line != null) {
	            	// 각 줄은 하나의 과목을 나타냅니다.
	                // 따라서 각 줄을 출력합니다.
	                System.out.println(line);
	                line = reader.readLine();
	                // 다음 줄을 읽어옵니다.
	            }
	         // BufferedReader를 닫습니다.
	            reader.close();
	        } catch (IOException e) {
	        	 // 파일을 읽어오는 도중 오류가 발생한 경우 오류 메시지를 출력합니다.
	            System.out.println("Error reading file");
	            e.printStackTrace();
	        }
		
		
	}
		
	public void ADD_class() {//수강 신청하기	
		System.out.println("=====수강 과목 신청=====");
		 List<String> subjects = new ArrayList<>();
	        try {
	            // "subjects.txt" 파일을 읽어서 과목 리스트에 저장합니다.
	            BufferedReader reader = new BufferedReader(new FileReader("subjects.txt"));
	            String line = reader.readLine();
	            while (line != null) {
	                subjects.add(line);
	                line = reader.readLine();
	            }
	            reader.close();
	        } catch (IOException e) {
	            System.out.println("Error reading file");
	            e.printStackTrace();
	        }

	       //수강신청 인덱스 설정하여 출력
	        for (int i = 0; i < subjects.size(); i++) {
	            System.out.println((i + 1) + ". " + subjects.get(i));
	        }
	        // 사용자에게 과목을 선택하도록 안내
	        System.out.println("수강신청하실 강의 인덱스 번호를 입력해주세요^^:");

	        // 사용자가 선택한 과목을 변수에 저장합니다.
	        Scanner scanner = new Scanner(System.in);
	        int subjectIndex = scanner.nextInt();
	        String selectedSubject = subjects.get(subjectIndex - 1);

	        // "registration.txt" 파일에 사용자가 선택한 과목을 추가합니다.
	        try {
	            BufferedWriter writer = new BufferedWriter(new FileWriter("registration.txt", true));
	            writer.write(selectedSubject);
	            writer.newLine();
	            writer.close();
	            System.out.println("수강 신청 되었습니다!!");
	        } catch (IOException e) {
	            System.out.println("Error writing file");
	            e.printStackTrace();
	        } 
	    
		
	}
	public void Del_class() {//수강 신청 취소하기
		System.out.println("=====수강 과목 취소=====");
		
		 // 수강 신청한 과목 리스트를 저장할 리스트를 생성합니다.
        List<String> registrations = new ArrayList<>();
        try {
            // "registration.txt" 파일을 읽어서 수강 신청한 과목 리스트를 생성합니다.
            BufferedReader reader = new BufferedReader(new FileReader("registration.txt"));
            String line = reader.readLine();
            while (line != null) {
                registrations.add(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading file");
            e.printStackTrace();
        }

        // 사용자에게 수강 신청 취소할 과목을 선택하도록 안내합니다.
        
        for (int i = 0; i < registrations.size(); i++) {
            System.out.println((i + 1) + ". " + registrations.get(i));
        }
        System.out.println("수강 취소하실 강의 인덱스 번호를 입력해주세요^^:");

        // 사용자가 선택한 과목을 변수에 저장합니다.
        Scanner scanner = new Scanner(System.in);
        int subjectIndex = scanner.nextInt();
        String selectedSubject = registrations.get(subjectIndex - 1);

        // "registration.txt" 파일에서 사용자가 선택한 과목을 삭제합니다.
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("registration.txt"));
            for (String subject : registrations) {
                if (!subject.equals(selectedSubject)) {
                    writer.write(subject);
                    writer.newLine();
                }
            }
            writer.close();
            System.out.println("수강 신청 취소 완료~~!!!");
        } catch (IOException e) {
            System.out.println("Error writing file");
            e.printStackTrace();
        } 
        
	}


	
	
	public void Completion_Lecture_list() {//수강 신청 완료 리스트
			System.out.println("=====수강 신청 완료 LIST====");
		        // 수강 신청한 과목 리스트를 저장할 리스트를 생성합니다.
		        List<String> registrations = new ArrayList<>();
		        try {
		            // "registration.txt" 파일을 읽어서 수강 신청한 과목 리스트를 생성합니다.
		            BufferedReader reader = new BufferedReader(new FileReader("registration.txt"));
		            String line = reader.readLine();
		            while (line != null) {
		                registrations.add(line);
		                line = reader.readLine();
		            }
		            reader.close();
		        } catch (IOException e) {
		            System.out.println("Error reading file");
		            e.printStackTrace();
		        }

		        // 수강 신청한 과목 리스트를 화면에 출력합니다.
		        System.out.println("수강 신청 완료하신 리스트를 보여드리겠습니다!!^^");
		        for (int i = 0; i < registrations.size(); i++) {
		            System.out.println((i + 1) + ". " + registrations.get(i));
		        }
		
	
}
	}

