package com.project.view;

import java.util.Scanner;

import com.project.login.LoginMain;

public class MainTestService {
	public static void mainStart() {
//		System.out.println("MainTestService.mainStart - start");
		
		Scanner scan = new Scanner(System.in);

		MainTestView.mainPage();

		while (true) {
//			System.out.println("MainTestService.mainStart.while - start");
			
			String s = scan.nextLine();
			System.out.println();

			if (s.equals("0")) { //뒤로가기			
				MainTestView.mainEndMsg();
				scan.nextLine();
				break;
			} else if (s.equals("1")) { //로그인
				LoginMain.loginMain();
				MainTestView.mainPage();
			} else if (s.equals("2")) { //회원가입
				//회원가입 페이지로 이동
				MainTestView.mainPage();
			} else {
				MainTestView.mainWrongInput();
			}
//			System.out.println("MainTestService.mainStart.while - end");
		}
		
//		System.out.println("MainTestService.mainStart - end");
	}
}
