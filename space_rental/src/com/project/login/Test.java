package com.project.login;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("전화번호: ");
		String tel = scan.nextLine();

		// 전화번호의 -포함인지, 미포함인지 확인하기
//		StringBuilder sb = new StringBuilder();
//
//		if (tel.length() == 11) {
//			// - 추가
//			sb.append(tel.substring(0, 3));
//			sb.append("-");
//			sb.append(tel.substring(3, 7));
//			sb.append("-");
//			sb.append(tel.substring(7));
//		}
//		System.out.println(sb);
		

		// 유효성 검사
		if (tel.length() == 13) {
			
			// 숫자3 - 숫자4 - 숫자4 유형인가?
			if (tel.matches("^010-[0-9]{4}-[0-9]{4}$")) {
				System.out.println(true);
			} else {
				System.out.println(false);
			}
			
		}		
		
	}

}
