package com.project.admin;

public class AdminRentManageView {

	public static void rentManageView() {
		
		// 대여내역 관리 입장시 나오는 뷰
		
		System.out.println("---------- 대여내역 관리 ----------");
		System.out.println("0. 돌아가기");
		System.out.println("1. 대여내역 조회");
		System.out.println("2. 대여내역 수정");
		System.out.println("3. 대여내역 삭제");
		System.out.println("--------------------------------");
		
	}
	
	public static void selectView() {
		
		// 대여내역 관리 > 대여내역 조회 입장시 나오는 뷰 
		
		System.out.println("---------- 대여내역 조회 ----------");
		System.out.println("0. 돌아가기");
		System.out.println("1. 모든 대여내역 조회");
		System.out.println("2. 회원 대여내역 조회");
		System.out.println("3. 스튜디오 대여내역 조회");
		System.out.println("--------------------------------");
		
	}
	
}
