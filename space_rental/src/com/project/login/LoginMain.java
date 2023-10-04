package com.project.login;

import java.util.Scanner;

import com.project.main.MainService;

public class LoginMain {
	public static void main(String[] args) {
		MainService.dataLoad();
		
		loginMain();
	}

	public static void loginMain() {
		Scanner scan = new Scanner(System.in);

		// 로그인 메인 화면 출력
		LoginView.controlLogin();

		String n = scan.nextLine();

		// n 유효성 검사
		// 0~3까지의 숫자만 허용한다.
		n = LoginService.checkValid(n);

		System.out.println();
		
		if (n == null) {
			System.out.println("유효하지 않은 입력입니다.");
		} else if (n.equals("0")) {
			// 뒤로가기
			// 메인화면으로 이동
			System.out.println("뒤로가기");
			return;
		} else if (n.equals("1")) {
			// 로그인
			LoginService.login();

		} else if (n.equals("2")) {
			// 아이디 찾기
			LoginService.findId();
			return;
		} else if (n.equals("3")) {
			// 비밀번호 재설정
			System.out.println("비밀번호 재설정");
			return;
		}
	}

}
