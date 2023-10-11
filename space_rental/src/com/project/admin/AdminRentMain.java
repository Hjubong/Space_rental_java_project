package com.project.admin;

import java.util.Scanner;

public class AdminRentMain {

	public static void main(String[] args) {
		adminRentManage();
	}
	
	public static void adminRentManage() {
		
		
		boolean loop = true;						// 무한루프를 위한 loop
		
		Scanner scan = new Scanner(System.in);		
		
		while (loop) {	
			
		AdminRentManageView.rentManageView();			// 관리자 대여내역관리 부분 뷰
			
		int input = scan.nextInt();					// 값을 받아서
		
			if (input == 1) {
				AdminRentService.rentSelect();	// 1번일 경우 대여내역 조회로
			} else if (input == 2) {
				AdminRentService.rentUpdate();	// 2번일 경우 대여내역 수정으로
			} else if (input == 3) {
				AdminRentService.rentDelete();	// 3번일 경우 대여내역 삭제로
			} else if (input == 0) {
				loop = false;						// 0번일 경우 관리자 회원 마이페이지로 돌아감
			} else {								
				System.out.println("올바른 서비스의 숫자를 입력해주세요.");	// 유효성 검사
			}
			
		}
		
	}
	
}
