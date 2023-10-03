package com.project.login;

public class LoginView {
	public static void controlLogin() {
		loginTitle();
		System.out.println("0. 뒤로가기");
		System.out.println("1. 로그인");
		System.out.println("2. 아이디 찾기");
		System.out.println("3. 비밀번호 재설정");
		line();
		System.out.print("번호를 입력하세요. : ");
	}

	public static void loginTitle() {
		line();
		System.out.println("         로그인");
		line();
	}

	public static void line() {
		System.out.println("――――――――――――――――――――――");
	}
}
