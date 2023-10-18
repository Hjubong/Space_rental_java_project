package com.project.admin;

public class AdminView {
	
	public static void line() {
		System.out.println("――――――――――――――――――――――――――――――――――――――――");
	}
	
	public static void adminLogin() {
		line();
		System.out.println("관리자 로그인 후 화면");
		System.out.println("1. 마이페이지");
		System.out.println("2. 회원 관리");
		System.out.println("3. 대여 관리");
		System.out.println("4. 스튜디오 관리");
		System.out.println("5. 로그아웃");
		line();
		System.out.print("번호를 입력하세요. : ");
	}
}
