package com.project.user;

import java.util.Scanner;

import com.project.admin.MyPageMain;
import com.project.auth.Auth;
import com.project.login.LoginMain;

public class UserMain {
	
	public static void userMain() {
		
		boolean loop = true;					// 무한루프를 위한 loop
		
		Scanner scan = new Scanner(System.in);		
		
		while (loop) {	
			
		UserView.userLogin();					//일반 회원 로그인 후 화면 뷰
			
		String input = scan.nextLine();			// 값을 받아서
		
			if (input.equals("1")) {
					MyPageMain.myPageMain();		// 1번일 경우 일반 회원 마이 페이지
			} else if (input.equals("2")) {
					UserRentMain.rentMain();	// 2번일 경우 스튜디오 대여로
			} else if (input.equals("3")) {
					System.out.println("로그아웃이 완료되었습니다. 로그인화면으로 이동합니다."); // 3번일 경우 로그아웃
					Auth.authId = null;			
					loop = false;
			} else {								
				System.out.println("올바른 서비스의 숫자를 입력해주세요.");	// 유효성 검사
			}
			
		}
	}
}
