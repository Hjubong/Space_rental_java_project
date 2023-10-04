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
	 * 입력한 값이 유효한 값인지 검사하는 메소드입니다.
	 * 
	 * @param n
	 * @return 유효한 값 또는 null
	 */
	public static String checkValid(String n) {
		// 입력한 값 앞, 뒤의 공백 제거
		n = n.trim();

		if (!(n.equals("0") || n.equals("1") || n.equals("2") || n.equals("3"))) {
			n = null;
		}

		return n;
	}

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
		} else {
			// 유효하지 않은 로그인인 경우
			System.out.println("유효하지 않은 아이디 혹은 비밀번호입니다.");
			System.out.println("다시 시도해주세요.");
		}
	}

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
		
		// 일치한다면 
		if() {
			
		}
		
		// 아이디 알려주기
		// 일치하지 않는다면
		// 다시 입력받거나 이전으로 돌아가기
	}
}
