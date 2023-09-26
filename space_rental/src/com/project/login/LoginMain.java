package com.project.login;

import java.util.Scanner;

public class LoginMain {
	public void loginMain() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("――――――――――――――――――――――");
		System.out.println("         로그인");
		System.out.println("――――――――――――――――――――――");
		System.out.println("0. 뒤로가기");
		System.out.println("1. 로그인");
		System.out.println("2. 아이디 찾기");
		System.out.println("3. 비밀번호 재설정");
		System.out.println("――――――――――――――――――――――");
		System.out.print("번호를 입력하세요. : ");
		String n = scan.nextLine();
		
		// n 유효성 검사
		// 0~3까지의 숫자만 허용한다.
		
//		if (n == 0) {
//			
//		} else if (n == 1) {
//			
//		} else if (n == 2) {
//			
//		} else if (n == 3) {
//			
//		}
	}
}
