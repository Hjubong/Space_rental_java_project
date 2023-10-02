package com.project.admin;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Scanner;

import com.project.rent.Rent;
import com.project.rent.RentData;
import com.project.studio.Studio;
import com.project.studio.StudioData;
import com.project.user.User;
import com.project.user.UserData;

public class AdminStudioService {
	
	public static void studioSelect() {
		
		StudioData.load(); 	// 스튜디오 배열 불러오기
		RentData.load();   	// 대여내역 배열 불러오기
		UserData.load();	// 회원 배열 불러오기
		
		HashMap<Integer, Studio> studioMap = new HashMap<Integer,Studio>(); // 스튜디오 배열 생성
		HashMap<Integer, Rent> rentMap = new HashMap<Integer, Rent>();		// 대여내역 배열 생성
		HashMap<String, User> userMap = new HashMap<String, User>();		// 회원 배열 생성
		
		
		Scanner scan = new Scanner(System.in);
		
		boolean loop = true;
		
		while (loop) {
			
			AdminStudioManageView.selectView();	// 스튜디오 조회 뷰
			
			int input = scan.nextInt();
			
			if (input == 1) {	// 1번 입력시 모든 스튜디오 조회
				
				studioMap = StudioData.getStudioMap();
				
				for (int studionNum : studioMap.keySet()) {
					Studio s = studioMap.get(studionNum);
					if (s.getStatus() == 0) {						
						System.out.println("------------ 스튜디오 정보 -------------");
						System.out.println("스튜디오 번호: " + s.getStudioNum());
						System.out.println("스튜디오명: " + s.getName());
						System.out.println("분류: " + s.getType());
						System.out.println("최대 인원: " + s.getMaxNumOfPeople() + "명");
						System.out.println("가격(시간): " + s.getBasicRate() + "원");
						System.out.println("크기: " + s.getArea() + "평");
						System.out.println("주소: " + s.getAddress());
					}
				}
				
				AdminStudioManageView.inputEnterView();
				loop = false;
				
			} else if (input == 2) {	// 2번 입력시 현 시각 기준 대여중인 회원 조회
				
				studioMap = StudioData.getStudioMap();	// 불러온 배열을 현재 배열에 넣어주기
				rentMap = RentData.getRentMap();		
				userMap = UserData.getUserMap();
				
				for (int studionNum : studioMap.keySet()) {	
					Studio s = studioMap.get(studionNum);	
					for (int rentNum : rentMap.keySet()) {
						Rent r = rentMap.get(rentNum);
						if (r.getStudioNum() == s.getStudioNum()) {		// 스튜디오 테이블의 스튜디오 번호 대여내역 테이블의 스튜디오 번호가 같고
							if (s.getStatus() == 0) {
								for (String userNum : userMap.keySet()) {	
									User u = userMap.get(userNum);
									if (u.getId().equals(r.getId())) {		// 대여내역 테이블의 회원 아이디와 회원 테이블의 회원아이디가 같고
										Calendar now = Calendar.getInstance();
										long nowTick = now.getTimeInMillis();
										long startTick = r.getStartDate().getTimeInMillis();
										long endTick = r.getEndDate().getTimeInMillis();
										if (startTick <= nowTick && endTick >= nowTick) {	// 마지막으로 현재시각이 대여내역의 시작시각과 종료시각 사이에 있으면 
											System.out.println("------------ 대여 중인 스튜디오 -------------");	// 현재 대여 중인 스튜디오를 출력
											System.out.println("스튜디오 번호: " + s.getStudioNum());
											System.out.println("스튜디오명: " + s.getName());
											System.out.println("분류: " + s.getType());
											System.out.println("최대 인원: " + s.getMaxNumOfPeople() + "명");
											System.out.println("가격(시간): " + s.getBasicRate() + "원");
											System.out.println("크기: " + s.getArea() + "평");
											System.out.println("주소: " + s.getAddress());
											System.out.println("------------ 대여 중인 회원정보 -------------"); // 대여 중인 회원의 정보도 출력
											System.out.println("회원 아이디: " + u.getId());
											System.out.println("회원 이름: " + u.getName());
											System.out.println("회원 생년월일: " + u.getBirth());
											System.out.println("회원 전화번호: " + u.getTel());
											System.out.println("------------ 대여 정보 ------------");		   // 회원이 대여한 스튜디오의 대여 정보를 출력
											String start = String.format("%tF %tR", r.getStartDate(), r.getStartDate());
											String end = String.format("%tF %tR", r.getEndDate(), r.getEndDate());
											System.out.println("대여 시작시간: " + start);
											System.out.println("대여 종료시간: " + end);
											System.out.println("대여 인원: " + r.getNumOfPeople() + "명");
											System.out.println("대여 가격: " + r.getRate() + "원");
										}
									}
								}								
							}
						}
					}
				}
				AdminStudioManageView.inputEnterView();
				loop = false;
			} else if (input == 3) {
				
				boolean secondLoop = true;
				
				while (secondLoop) {
					
					AdminStudioManageView.typeSelectView();
					
					int secondInput = scan.nextInt();
					String type;
					//촬영관, 스터디룸, 파티룸, 회의실, 공연장, 강의실, 음악실, 체육관

					if (secondInput == 1) {
						type = "촬영관";
						typeSelect(type);
						AdminStudioManageView.inputEnterView();
						secondLoop = false;
						
					} else if (secondInput == 2) {
						type = "스터디룸";
						typeSelect(type);
						AdminStudioManageView.inputEnterView();
						secondLoop = false;
						
					} else if (secondInput == 3) {
						type = "파티룸";
						typeSelect(type);
						AdminStudioManageView.inputEnterView();
						secondLoop = false;
						
					} else if (secondInput == 4) {
						type = "회의실";
						typeSelect(type);
						AdminStudioManageView.inputEnterView();
						secondLoop = false;
						
					} else if (secondInput == 5) {
						type = "공연장";
						typeSelect(type);
						AdminStudioManageView.inputEnterView();
						secondLoop = false;
						
					} else if (secondInput == 6) {
						type = "강의실";
						typeSelect(type);
						AdminStudioManageView.inputEnterView();
						secondLoop = false;
						
					} else if (secondInput == 7) {
						type = "음악실";
						typeSelect(type);
						AdminStudioManageView.inputEnterView();
						secondLoop = false;
						
					} else if (secondInput == 8) {
						type = "체육관";
						typeSelect(type);
						AdminStudioManageView.inputEnterView();
						secondLoop = false;
						
					} else if (secondInput == 0) {
						 loop = false;
					} else {
						System.out.println("올바른 번호를 입력해주세요.");
					}
					
					
				}
				
			} else if (input == 0) {
				
				loop = false;
			
			} else {
				System.out.println("올바른 숫자를 입력해주세요.");
			}
		}
		
	}

	private static void typeSelect(String type) {	// 입력받은 스튜디오타입의 스튜디오를 출력하기 위한 메서드 
		
		HashMap<Integer,Studio> studioMap = new HashMap<Integer,Studio>();
		
		studioMap = StudioData.getStudioMap();
		
		for (int studionNum : studioMap.keySet()) {
			Studio s = studioMap.get(studionNum);
			if (s.getStatus() == 0 && s.getType().equals(type)) {						
				System.out.println("------------ 스튜디오 정보 -------------");
				System.out.println("스튜디오 번호: " + s.getStudioNum());
				System.out.println("스튜디오명: " + s.getName());
				System.out.println("분류: " + s.getType());
				System.out.println("최대 인원: " + s.getMaxNumOfPeople() + "명");
				System.out.println("가격(시간): " + s.getBasicRate() + "원");
				System.out.println("크기: " + s.getArea() + "평");
				System.out.println("주소: " + s.getAddress());
			}
		}
	}

	public static void studioInsert() {		// 스튜디오 추가 메서드
		
		StudioData.load();
		
		HashMap<Integer, Studio> studioMap = new HashMap<Integer,Studio>();
		
		studioMap = StudioData.getStudioMap();		
				
		Scanner scan = new Scanner(System.in);
		
		System.out.println("------ 추가할 스튜디오 정보 입력 ------");
		System.out.print("스튜디오명: ");
		String studioName = scan.nextLine();
		System.out.print("분류: ");
		String type = scan.nextLine();
		System.out.print("최대 인원: ");
		int maxPerson = scan.nextInt();
		System.out.print("가격(시간): ");
		int price = scan.nextInt();
		System.out.print("크기(평): ");
		int area = scan.nextInt();
		scan.nextLine();
		System.out.print("주소: ");
		String address = scan.nextLine();

		
		Studio s = new Studio(studioMap.size() + 1, studioName, type, maxPerson, price, area, address, 0);
		// 끝 번호 + 1
		
		studioMap.put(studioMap.size() + 1, s);
		// 배열에 넣고
		
		StudioData.save();
		// 데이터에 저장
		
		System.out.println(studioMap.size() + "번으로 추가되었습니다.");
		
	}
	
	public static void studioUpdate() { 	// 스튜디오 수정 메서드
		
		StudioData.load();
		
		HashMap<Integer, Studio> studioMap = new HashMap<Integer,Studio>();
		
		studioMap = StudioData.getStudioMap();		
				
		Scanner scan = new Scanner(System.in);
		
		System.out.println("------ 수정할 스튜디오 정보 입력 ------");
		System.out.print("스튜디오 번호: ");
		int studioNum = scan.nextInt();
		scan.nextLine();
		System.out.print("스튜디오명: ");
		String studioName = scan.nextLine();
		System.out.print("분류: ");
		String type = scan.nextLine();
		System.out.print("최대 인원: ");
		int maxPerson = scan.nextInt();
		System.out.print("가격(시간): ");
		int price = scan.nextInt();
		System.out.print("크기(평): ");
		int area = scan.nextInt();
		scan.nextLine();
		System.out.print("주소: ");
		String address = scan.nextLine();

		
		Studio s = new Studio(studioNum, studioName, type, maxPerson, price, area, address, 0);
				
		StudioData.setStudioMap(studioNum, s);
		
		StudioData.save();
		
	}
	
	public static void studioDelete() {		// 스튜디오 삭제 메서드
		
		StudioData.load();
		
		HashMap<Integer, Studio> studioMap = new HashMap<Integer,Studio>();
		
		studioMap = StudioData.getStudioMap();		
				
		Scanner scan = new Scanner(System.in);
		
		System.out.println("------ 삭제할 스튜디오 정보 입력 ------");
		System.out.println("돌아가시려면 0을 입력해주세요.");
		
		boolean loop = true;
		
		String studioName;
		String type;
		int maxPerson;
		int price;
		int area;
		String address;

		while (loop) {
			
			System.out.print("스튜디오 번호: ");
			String studioNum = scan.nextLine();
			
			
			if (!studioNum.equals("0")) {	// 입력받은 번호가 0이 아닐시
				
				System.out.println("정말로 삭제하시겠습니까? (Y/N)");  // 경고메시지 출력
				System.out.println("-----------------------------");
				String input = scan.nextLine();
				if (input.equals("y") || input.equals("Y")) {		 // y입력시 
					
					for (int studionNum : studioMap.keySet()) {
						Studio s = studioMap.get(studionNum);
						if (Integer.parseInt(studioNum) == s.getStudioNum()) { // 입력받은 번호가 배열에 존재하면
							
							studioName = s.getName();
							type = s.getType();
							maxPerson = s.getMaxNumOfPeople();
							price = s.getBasicRate();
							area = s.getArea();
							address = s.getAddress();
							
							Studio st = new Studio(Integer.parseInt(studioNum), studioName, type, maxPerson, price, area, address, 1);
							// 해당 스튜디오번호의 삭제여부를 1로 바꿈
							
							studioMap.put(Integer.parseInt(studioNum), st);
							
							StudioData.save();
							loop = false;
							break;
						}
					}
					
					System.out.println(studioNum + "번이 삭제되었습니다.");
					
				} else if (input.equals("n") || input.equals("N")) { // n입력시
					
					loop = false;	// 루프를 빠져나감
					AdminStudioManageView.inputEnterView();
				}
			} else if (studioNum.equals("0")) { // 스튜디오번호 입력시 0입력시
				
				loop = false;		// 루프를 빠져나감
				AdminStudioManageView.inputEnterView();
			
			} else {
				System.out.println("올바르지 않은 번호입니다.");
			}	
		}
	}
}
