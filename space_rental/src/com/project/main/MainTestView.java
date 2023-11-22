package com.project.main;

import java.util.Scanner;

public class MainTestView {
	public static void mainPage() {
		Scanner scan = new Scanner(System.in);

		System.out.println();
		System.out.println("  _  _____  _   _  ____  ____    _    _   _ \r\n"
				+ " | |/ / _ \\| \\ | |/ ___|/ ___|  / \\  | \\ | |\r\n"
				+ " | ' / | | |  \\| | |  _| |  _  / _ \\ |  \\| |\r\n"
				+ " | . \\ |_| | |\\  | |_| | |_| |/ ___ \\| |\\  |\r\n"
				+ " |_|\\_\\___/|_| \\_|\\____|\\____/_/   \\_\\_| \\_|");
		System.out.println("   _  __                                   \r\n"
				+ "  | |/ /___  _ __   __ _  __ _  __ _ _ __  \r\n" 
				+ "  | ' // _ \\| '_ \\ / _` |/ _` |/ _` | '_ \\ \r\n"
				+ "  | . \\ (_) | | | | (_| | (_| | (_| | | | |\r\n"
				+ "  |_|\\_\\___/|_| |_|\\__, |\\__, |\\__,_|_| |_|\r\n" 
				+ "                   |___/ |___/             ");
		System.out.println("  _  _____  _   _  ____  ____    _    _   _ \r\n"
				+ " | |/ / _ \\| \\ | |/ ___|/ ___|  / \\  | \\ | |\r\n"
				+ " | ' / | | |  \\| | |  _| |  _  / _ \\ |  \\| |\r\n"
				+ " | . \\ |_| | |\\  | |_| | |_| |/ ___ \\| |\\  |\r\n"
				+ " |_|\\_\\___/|_| \\_|\\____|\\____/_/   \\_\\_| \\_|\r\n"
				+ "                                            ");
		System.out.println("          =========================");
		System.out.println("            공간 대여 서비스, 공간");
		System.out.println("          =========================");
		System.out.println();
		System.out.println("                 1. 로그인");
		System.out.println("                 2. 회원가입");
		System.out.println("                 0. 뒤로가기");
		System.out.println();
		System.out.print("            번호를 입력하세요: ");
	}
	
	public static void line() {
		System.out.println("――――――――――――――――――――――――――――――――――――――――");
	}
	
	public static void mainEndMsg() {
		System.out.print("  ");
		MainTestView.line();
		System.out.println("          엔터키를 누르면 종료됩니다.");
		System.out.println("             엔터키를 눌러주세요.");
	}
	
	public static void mainWrongInput() {
		System.out.print("  ");
		MainTestView.line();
		System.out.println("     잘못된 입력입니다. 다시 입력해주세요.");
		System.out.print("            번호를 입력하세요: ");
	}
}
