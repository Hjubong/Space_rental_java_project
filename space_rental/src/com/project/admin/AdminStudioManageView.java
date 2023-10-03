package com.project.admin;

import java.util.Scanner;

public class AdminStudioManageView {

	public static void manageView() {
		
		// 스튜디오 관리 입장시 나오는 뷰
		
		System.out.println("---------- 스튜디오 관리 ----------");
		System.out.println("0. 돌아가기");
		System.out.println("1. 스튜디오 조회");
		System.out.println("2. 스튜디오 추가");
		System.out.println("3. 스튜디오 수정");
		System.out.println("4. 스튜디오 삭제");
		System.out.println("--------------------------------");
		
	}
	
	public static void selectView() {
		
		// 스튜디오 관리 > 스튜디오 조회 입장시 나오는 뷰 
		
		System.out.println("---------- 스튜디오 조회 ----------");
		System.out.println("0. 돌아가기");
		System.out.println("1. 모든 스튜디오 조회");
		System.out.println("2. 대여 중인 스튜디오 정보 조회");
		System.out.println("3. 분류별 조회");
		System.out.println("--------------------------------");
		
	}

	public static void typeSelectView() {
		
		// 스튜디오 관리 > 스튜디오 조회 > 분류별 조회 입장시 나오는 뷰
		
		//촬영관, 스터디룸, 파티룸, 회의실, 공연장, 강의실, 음악실, 체육관
		
		System.out.println("---------- 분류 별 조회 ----------");
		System.out.println("0. 돌아가기");
		System.out.println("1. 촬영관");
		System.out.println("2. 스터디룸");
		System.out.println("3. 파티룸");
		System.out.println("4. 회의실");
		System.out.println("5. 공연장");
		System.out.println("6. 강의실");
		System.out.println("7. 음악실");
		System.out.println("8. 체육관");
		System.out.println("---------------------------------");
	}
	
	public static void inputEnterView() {
		
		// 엔터 입력 뷰
		System.out.println();
		System.out.println("---------------------------------");
		System.out.println("돌아가려면 엔터를 눌러주세요.");
		Scanner scan = new Scanner(System.in);
		scan.nextLine();
		
	}
	
	
}
