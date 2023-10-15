package com.project.admin;

public class AdminUserView {
	
	public static void UserManagementView() {
		
		System.out.println("      회원 관리");
		line();
		System.out.println("0. 돌아가기");
		System.out.println("1. 회원 정보 조회");
		System.out.println("2. 회원 정보 수정");
		System.out.println("3. 회원 정보 삭제");
		line();
		System.out.println("번호를 입력해주세요.");
	}
	
	public static void UserCheckView() {
		System.out.println("회원 조회");
		line();
		System.out.println("0. 돌아가기");
		System.out.println("1. 회원 정보 전체 조회");
		System.out.println("2. 회원 정보 개별 조회");
		line();
		System.out.println("번호를 입력해주세요.");
	}
	
	public static void line() {
		System.out.println("――――――――――――――――――――――――――――――――――――――――");
	}
}
