package com.project.user;

public class UserView {
	
	public static void line() {
		System.out.println("――――――――――――――――――――――――――――――――――――――――");
	}
	
	public static void userLogin() {
		line();
		System.out.println("일반 회원 로그인 후 화면");
		System.out.println("1. 마이페이지");
		System.out.println("2. 대여");
		System.out.println("3. 로그아웃");
		line();
		System.out.print("번호를 입력하세요. : ");
	}
}
