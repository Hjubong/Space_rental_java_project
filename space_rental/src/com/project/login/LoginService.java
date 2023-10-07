package com.project.login;

import java.util.HashMap;
import java.util.Scanner;

import com.project.user.User;
import com.project.user.UserData;

public class LoginService {
	static Scanner scan;

	static {
		scan = new Scanner(System.in);
	}

	/**
	 * 입력한 값이 유효한 값인지 검사하는 메소드입니다. 0, 1, 2, 3이 아닌 값은 null로 바꾸어 반환합니다.
	 * 
	 * @param n
	 * @return 유효한 값(0, 1, 2, 3) 또는 null
	 */
	public static String checkValidNum(String n) {
		// 입력한 값 앞, 뒤의 공백 제거
		n = n.trim();

		if (!(n.equals("0") || n.equals("1") || n.equals("2") || n.equals("3"))) {
			n = null;
		}

		return n;
	}

	/**
	 * 로그인 메소드입니다.
	 */
	public static void login() {
		LoginView.loginTitle();
		System.out.print("아이디: ");
		String id = scan.nextLine();

		System.out.print("비밀번호: ");
		String pw = scan.nextLine();

		System.out.println();
		LoginView.line();

		if (isValidIdPw(id, pw)) {
			// 유효한 로그인인 경우
			System.out.println("로그인이 완료되었습니다.");
			System.out.println("환영합니다!");

			// 로그인 성공했으니 해당 페이지로 이동
		} else {
			// 유효하지 않은 로그인인 경우
			System.out.println("유효하지 않은 아이디 혹은 비밀번호입니다.");
			System.out.println("다시 시도해주세요.");

			// 재입력 받거나 이전 화면으로 돌아간다.
		}
	}

	/**
	 * 아이디와 비밀번호가 유효한지 검사하는 메소드입니다.
	 * 
	 * @param id
	 * @param pw
	 * @return true(로그인 성공 시), false(로그인 실패 시)
	 */
	public static boolean isValidIdPw(String id, String pw) {

		// 입력받은 아이디와 비밀번호를 회원 맵에서 찾기
		HashMap<String, User> uMap = UserData.getUserMap();

		// 1. 아이디가 존재하는지 검색
		// 아이디가 여러개일 수는 없다.

		if (uMap.containsKey(id)) { // 1.1. 존재하는 경우
			// 비밀번호가 일치하는지 검사

//			System.out.println("아이디 존재함.");

			User tempUser = uMap.get(id); // 해당 아이디를 가진 회원 객체

			if (pw.equals(tempUser.getPassword())) { // 1.1.1. 일치하는 경우
				// 로그인 성공
				return true;
			} else { // 1.1.2. 일치하지 않는 경우
//				System.out.println("비밀번호 틀림");
				return false;
			}

		} else { // 1.2. 존재하지 않는 경우
			// 유효하지 않다고 출력
			// 다시 입력받음 또는 뒤로가기
//			System.out.println("아이디 없음.");
			return false;
		}

	}

	public static void findId() {
		LoginView.findIdLabel();

		// 이름과 전화번호 입력하기
		System.out.println("가입하신 정보를 입력해주세요.");
		System.out.print("이름: ");
		String name = scan.nextLine();

		System.out.print("전화번호: ");
		String tel = scan.nextLine();

		System.out.print("생년월일(8자리): ");
		String birth = scan.nextLine();

		LoginView.line();
		
		// 전화번호에 - 넣기
		tel = addDash(tel);

		HashMap<String, User> uMap = UserData.getUserMap();

		String id = getUserId(name, tel, birth, uMap);
		
		if (id != null) {
			// 일치하는 데이터가 있는 경우
			System.out.println("고객님의 아이디는");
			System.out.println(id);
			System.out.println("입니다.");
			System.out.println();
			System.out.println("이전 화면으로 돌아갑니다.");
		} else {
			// 일치하는 데이터가 없을 경우
			System.out.println("일치하는 정보가 없습니다.");
			//이전 화면으로 돌아가거나 다시 입력받는다.
		}

	}

	/**
	 * 입력받은 데이터와 일치하는지 확인 후, 일치하는 정보를 가진 객체의 아이디를 반환하는 메소드입니다.
	 * 
	 * @param name
	 * @param tel
	 * @param birth
	 * @param uMap
	 * @return 회원의 아이디
	 */
	private static String getUserId(String name, String tel, String birth, HashMap<String, User> uMap) {
		String id = null;
		
		for (HashMap.Entry<String, User> entry : uMap.entrySet()) {
			User u = entry.getValue();
			
			if (u.getName().equals(name) && u.getTel().equals(tel) && u.getBirth().equals(birth)) {
				id = entry.getKey();
				break;
			}
		}

		return id;
	}

	/**
	 * 전화번호에 -가 빠졌을 경우 추가하는 메소드입니다.
	 * 
	 * @param tel
	 * @return -가 포함된 전화번호
	 */
	private static String addDash(String tel) {
		if (tel.length() == 11) { // 번호만 입력한 경우
			// - 추가
			StringBuilder sb = new StringBuilder();
			sb.append(tel.substring(0, 3));
			sb.append("-");
			sb.append(tel.substring(3, 7));
			sb.append("-");
			sb.append(tel.substring(7));

			tel = sb.toString();
		}

		return tel;
	}

}
