package com.project.admin;

import java.util.Scanner;

public class AdminUserMain {
	
	public static void AdminUser() {
		
		boolean loop = true;
		
		Scanner scan = new Scanner(System.in);	
		
		while (loop) {	
			
			AdminUserView.UserManagementView(); //관리자 회원관리 뷰
				
			int input = scan.nextInt();					//값 입력
			
				if (input == 1) {
					
					boolean innerLoop = true;
					
		                while (innerLoop) {
		                    AdminUserView.UserCheckView(); // 1번일 경우 회원 관리 조회 뷰로
		                    int innerInput = scan.nextInt(); // 하위 메뉴 선택
	
		                    switch (innerInput) {
		                        case 0:
		                            innerLoop = false;
		                            break;
		                        case 1:
		                            AdminUserService.allcheck();// 회원 정보 전체 조회 기능 구현
		                            break;
		                        case 2:
		                        	AdminUserService.check();// 회원 정보 개별 조회 기능 구현
		                            break;
		                        default:
		                            System.out.println("올바른 서비스의 숫자를 입력해주세요.");
		                            break;
		                    }
		                }
				} else if (input == 2) {
					AdminUserService.modify();			// 2번일 경우 회원 정보 수정으로
				} else if (input == 3) {
					AdminUserService.delete();			// 3번일 경우 회원 정보 삭제로
				} else if (input == 0) {
					loop = false;						// 0번일 경우 관리자 회원 마이페이지로 돌아감
				} else {								
					System.out.println("올바른 서비스의 숫자를 입력해주세요.");	// 유효성 검사
				}
				
		}
	}
}
