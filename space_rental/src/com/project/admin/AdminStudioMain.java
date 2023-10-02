package com.project.admin;

import java.util.Scanner;

public class AdminStudioMain {

	public static void main(String[] args) {
		adminStudioManage();
	}
	
	public static void adminStudioManage() {
		
		
		boolean loop = true;						// 무한루프를 위한 loop
		
		Scanner scan = new Scanner(System.in);		
		
		while (loop) {	
			
		AdminStudioManageView.manageView();			// 관리자 스튜디오관리 부분 뷰
			
		int input = scan.nextInt();					// 값을 받아서
		
			if (input == 1) {
				AdminStudioService.studioSelect();	// 1번일 경우 스튜디오 조회로
			} else if (input == 2) {
				AdminStudioService.studioInsert();	// 2번일 경우 스튜디오 추가로
			} else if (input == 3) {
				AdminStudioService.studioUpdate();	// 3번일 경우 스튜디오 수정으로
			} else if (input == 4) {
				AdminStudioService.studioDelete();	// 4번일 경우 스튜디오 삭제로
			} else if (input == 0) {
				loop = false;						// 0번일 경우 관리자 회원 마이페이지로 돌아감
			} else {								
				System.out.println("올바른 서비스의 숫자를 입력해주세요.");	// 유효성 검사
			}
			
		}
		
	}
	
}
