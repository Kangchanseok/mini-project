package address.jdbc;

import java.util.*;

public class PhoneBookApp {

	public static void main(String[] args) {
listPhoneBook();
		insert();
		delete();
	    search();
		
	}
	
	
	private static void search() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("검색어:");
		String keyword = sc.next();
		
		PhoneBookDAOImpl dao = new PhoneBookDAOImpl();
		
		List<PhoneBookVO> list = dao.search(keyword);
		Iterator<PhoneBookVO> it = list.iterator();
		
		while(it.hasNext()) {
			PhoneBookVO vo = it.next();
			System.out.printf("%d\t%s\t%d\t%d%n",
					vo.getPhoneId(),
					vo.getPhoneName(),
					vo.getPhoneHp(),
					vo.getPhoneTel());
		}
		sc.close();
		
	}
	
	
	
	
	
	private static void delete() {
		Scanner sc = new Scanner(System.in);
		System.out.print("넘버:");
		long authorId = sc.nextLong();
		
		PhoneBookDAO dao = new PhoneBookDAOImpl();
		
		boolean success = dao.delete(authorId);
		
		System.out.println("Author DELETE:" + (success ? "성공": "실패"));
		sc.close();
	}
	
	
	
	
	
	private static void insert() {
		Scanner sc = new Scanner(System.in);
		System.out.print("이름:");
		String name = sc.nextLine();
		System.out.print("핸드폰:");
		String hp = sc.nextLine();
		System.out.print("집전화:");
		String tel = sc.nextLine();
		
		PhoneBookVO vo = new PhoneBookVO(name, hp, tel);
		
		PhoneBookDAO dao = new PhoneBookDAOImpl();
		
		boolean success = dao.insert(vo);
		
		System.out.println("Author INSERT:" + 
				(success ? "성공": "실패"));
		sc.close();
	}

	
		private static void listPhoneBook() {
			
			// DAO 생성
			PhoneBookDAO dao = new PhoneBookDAOImpl();
			
			List<PhoneBookVO> list = dao.getList();
			Iterator<PhoneBookVO> it = list.iterator();
			
			System.out.println("**********************************************");	
			System.out.println("*              전화번호 관리 프로그램              *");
			System.out.println("**********************************************");
			System.out.println("1.리스트 | 2.등록 | 3.삭제 | 4.검색 | 5.종료");
			System.out.println("------------------------------------------");
			
			while(it.hasNext()) {
				PhoneBookVO vo = it.next();
				
				System.out.print("메뉴번호 : ");
				
			}


	}

}
