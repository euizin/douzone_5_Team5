package hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BookManager {
	private HashMap<String, Book> books;

	Scanner sc = new Scanner(System.in);

	public BookManager() {
		this.books = new HashMap<String, Book>();
	}

	// 실행함수
	public void run() {
		boolean run = false;
		while (!run) {
			System.out.println("1:추가 2:삭제 3:검색 4:도서 목록 5:ISBN 목록 0:종료");
			int selectMenu = Integer.parseInt(sc.nextLine());
			switch (selectMenu) {
			case 0:
				System.out.println("종료합니다...");
				run = !run; // !run 이 true가 된 상태로 break 만나서 switch문만 종료
				break; // while 문에서 (!run) 조건식이 false 이기때문에 while문 종료
			case 1:
				// 도서 추가
				addBook();
				break;
			case 2:
				// 도서 삭제
				removeBook();
				break;
			case 3:
				// 도서 검색
				searchBook();
				break;
			case 4:
				// 전체 도서 목록
				bookList();
				break;
			case 5:
				// ISBN 목록
				listISBN();
				break;
			// case 이외의 것이 입력되면 자동으로 default가 걸려있어서 while 계속 돌음
			// default 설정값으로 sysout 설정은 자유

			}
		}
	}

	// 도서 추가
	public void addBook() {
		System.out.print("추가할 도서 ISBN:");
		String bookNum = sc.nextLine();
		if (!books.containsKey(bookNum)) {
			// HashMap으로 만든 books에서 containsKey가 bookNum를 포함하고 있지 않다면 실행
			// bookNum를 포함하고 있으면 실행x (해당 도서 번호는 이미 있는 번호 입니다. 출력)
			System.out.print("도서 제목:");
			String bookName = sc.nextLine();
			System.out.print("가격:");
			int bookPrice = Integer.parseInt(sc.nextLine());
			// nextLine == String으로 받음, 그래서 Integer.parseInt로 int형변환 해줘야함
			// nextInt == int로 받음
			books.put(bookNum, new Book(bookNum, bookName, bookPrice));
			// key값은 bookNum, value 값은 new Book으로 새로운 객체 생성
			// books에 새로운 Book 객체를 생성하여 Num, Name, Price 값을 받음
			System.out.printf("ISBN:%s 이름:%s 가격:%d 생성하였습니다.\n", bookNum, bookName, bookPrice);
		} else {
			System.out.println("해당 도서 번호는 이미 있는 번호 입니다.");
		}
	}

	// 도서 삭제
	public void removeBook() {
		System.out.print("삭제할 도서 ISBN:");
		String bookNum = sc.nextLine();
		if (books.containsKey(bookNum)) { // containsKey bookNum을 포함하는지 검사
			books.remove(bookNum);
			System.out.println("삭제하였습니다.");
		} else {
			System.out.println("해당 도서 번호는 존재하지 않습니다.");
		}
	}

	// 도서 검색
	public void searchBook() {
		System.out.print("검색할 도서 ISBN:");
		String bookNum = sc.nextLine();
		for (Map.Entry m : books.entrySet()) {
			// Map.Entry는 Java에서 맵(Map) 인터페이스를 구현하는 컬렉션(Map Collection)에서 
			// 키(key)와 값(value)의 쌍을 저장하는 데 사용되는 내부 인터페이스이다.
			// Map.Entry 인터페이스는 키-값 쌍을 표현하는데 사용되며, getKey(), getValue()의 두 가지 메서드를 가지고 있음
			// books.entrySet() == 해당 map(books)에 담겨있는 key와 value의 연결들(mappings)을 꺼냄
			if (books.containsKey(bookNum)) {
				System.out.println("검색결과>>ISBN:" + m.getKey() + " 이름:" + ((Book) m.getValue()).getBookName() + " 가격:"
						+ ((Book) m.getValue()).getBookPrice());
			} else {
				System.out.println("해당 도서 번호는 존재하지 않습니다.");
			}
		}
	}

	// 도서 목록
	public void bookList() {
		for (Map.Entry m : books.entrySet()) {
			System.out.println("ISBN:" + m.getKey() + " 이름:" + ((Book) m.getValue()).getBookName() + " 가격:"
					+ ((Book) m.getValue()).getBookPrice());
		}
	}

	// ISBN 목록
	public void listISBN() {
		System.out.println("도서수:" + books.size());
		for (Map.Entry m : books.entrySet()) {
			System.out.println(m.getKey());
		}
	}
}
