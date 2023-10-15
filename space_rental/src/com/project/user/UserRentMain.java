package com.project.user;

import java.util.Scanner;

public class UserRentMain {

	public static void main(String[] args) {
		rentMain();
	}
	
	public static void rentMain() {
		
		
		boolean loop = true;					// 무한루프를 위한 loop
		
		Scanner scan = new Scanner(System.in);		
		
		while (loop) {	
			
		UserRentView.rentMainView();			// 관리자 대여내역관리 부분 뷰
			
		String input = scan.nextLine();			// 값을 받아서
		
			if (input.equals("1")) {
				UserRentService.studioSelect();	// 1번일 경우 스튜디오 조회로
			} else if (input.equals("2")) {
				UserRentService.studioRent();	// 2번일 경우 스튜디오 대여로
			} else if (input.equals("3")) {
				UserRentService.rentSelect();	// 3번일 경우 대여내역 조회로
			} else if (input.equals("4")) {
				UserRentService.rentDelete();	// 4번일 경우 대여 취소로
			} else if (input.equals("0")) {
				loop = false;					// 0번일 경우 로그인 후 화면으로 돌아감
			} else {								
				System.out.println("올바른 서비스의 숫자를 입력해주세요.");	// 유효성 검사
			}
			
		}
		
	}	
	
}
