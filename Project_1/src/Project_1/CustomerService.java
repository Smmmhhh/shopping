package Project_1;

import java.io.*;
import java.util.*;

public class CustomerService {
	// Customer Main에서 필드값 리스트로 만들기
	ArrayList<CustomerMain> list = new ArrayList<>();
	Scanner sc = new Scanner(System.in);

	// 고객 정보입력
	public void insert() {
		// id입력받기
		System.out.println("id을 입력하세요. ");
		String id = sc.next();

		for (int i = 0; i < list.size(); i++) {
			if (id.equals(list.get(i).getId())) {
				System.out.println("이미 등록된 id입니다.");
				insert();
				break;
			}
		}
		// 이름 입력받기
		System.out.println("이름을 입력하세요. ");
		String name = sc.next();
		// 나이 입력받기
		System.out.println("나이를 입력하세요. ");
		int age = sc.nextInt();
		// 성별 입력받기
		System.out.println("성별를 입력하세요.(남/여)");
		String gender = sc.next();
		while (!(gender.equals("남") || gender.equals("여"))) {
			System.out.println("잘못입력하셨습니다. 다시 입력해주세요.");
			gender = sc.next();
		}
		// 주소 입력받기
		System.out.println("주소를 입력하세요. ");
		String address = sc.nextLine();
		sc.nextLine();
		// 휴대폰 번호 입력받기
		System.out.println("번호를 입력하세요. ");
		String phonenumber = sc.next();
		// 입력받은 값 리스트에 저장
		list.add(new CustomerMain(id, name, age, gender, address, phonenumber));
	}

	// 고객정보 수정
	public void edit() {
		System.out.println("수정할 고객의 ID를 입력하세요.");
		String id = sc.next();

		for (int i = 0; i < list.size(); i++) {
			if (id.equals(list.get(i).getId())) {
				System.out.println("수정하실 항목을 선택하세요.");
				System.out.println("1.이름 2.나이 3.성별 4.주소 5.번호");
				int n = sc.nextInt();

				switch (n) {
				case 1:
					System.out.println("이름을 새로 입력하세요.");
					String name = sc.next();
					list.get(i).setName(name);
					break;
				case 2:
					System.out.println("나이를 새로 입력하세요.");
					int age = sc.nextInt();
					list.get(i).setAge(age);
					break;
				case 3:
					System.out.println("성별을 새로 입력하세요.");
					String gender = sc.next();
					list.get(i).setGender(gender);
					break;
				case 4:
					System.out.println("주소를 새로 입력하세요.");
					String address = sc.next();
					list.get(i).setAddress(address);
					break;
				case 5:
					System.out.println("번호을 새로 입력하세요.");
					String phonenumber = sc.next();
					list.get(i).setPhoneNumber(phonenumber);
					break;
				}
			}

			else {
				System.out.println("잘못된 정보입니다.");
			}
		}
	}

	// 고객 정보 삭제
	public void delete() {
		System.out.println("---회원을 삭제합니다.---");
		System.out.println("삭제할 회원의 아이디를 입력해주세요 : ");
		String name = sc.next();
		Iterator<CustomerMain> customerIterator = list.iterator();
		while (customerIterator.hasNext()) {
			CustomerMain customerMain = customerIterator.next();
			if (customerMain.getId().equals(name)) {
				customerIterator.remove();
				System.out.println(name + " " + "회원님 아이디가 삭제되었습니다.");
				return;
			}
		}

		System.out.println("입력하신 회원님은 없습니다.");
	}
	
	// 개인별 정보 출력
	public void personalView() {
		if (list.size() != 0) {
			for (CustomerMain customer : list) {
				customer.customerList();
			}
		} else if (list.size() == 0) {
			System.out.println("회원 목록이 없습니다.");
		}

	}

	// 전체 고객 정보 출력
	public void view() {
		if (list.size() != 0) {
			for (CustomerMain customer : list) {
				customer.customerList();
			}
		} else if (list.size() == 0) {
			System.out.println("회원 목록이 없습니다.");
		}

	}
}