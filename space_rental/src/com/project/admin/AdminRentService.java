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

public class AdminRentService {

	public static void rentSelect() {
		
		RentData.load();   	// 대여내역 배열 불러오기
		
		HashMap<Integer, Rent> rentMap = new HashMap<Integer, Rent>();		// 대여내역 배열 생성
		
		
		Scanner scan = new Scanner(System.in);
		
		boolean loop = true;
		
		while (loop) {
			
			AdminRentManageView.selectView();	// 대여내역 조회 뷰
			
			int inputSelect = scan.nextInt();
			scan.nextLine();
			
			if (inputSelect == 1) {	// 1번 입력시 모든 대여내역 조회
				
				rentMap = RentData.getRentMap();
				
				for (int rentNum : rentMap.keySet()) {
					Rent r = rentMap.get(rentNum);
						System.out.println("------------ 대여내역 정보 -------------");
						System.out.println("대여내역 번호: " + r.getRentnum());
						System.out.println("회원 아이디: " + r.getId());
						System.out.println("스튜디오 번호: " + r.getStudioNum());
						System.out.println("대여 인원: " + r.getNumOfPeople());
						System.out.println("총 가격: " + r.getRate());
						String start = String.format("%tF %tR", r.getStartDate(), r.getStartDate());
						String end = String.format("%tF %tR", r.getEndDate(), r.getEndDate());
						System.out.println("대여시작 시간: " + start);
						System.out.println("대여종료 시간: " + end);
				}
				
				AdminStudioManageView.inputEnterView();
				loop = false;
				
			} else if (inputSelect == 2) {	// 2번 입력시 특정 회원 대여내역 조회
				
				rentMap = RentData.getRentMap();		
				
				System.out.println("조회할 회원의 아이디를 입력하세요.");
				System.out.print("아이디: ");
				
				String inputId = scan.nextLine();
				
				for (int rentNum : rentMap.keySet()) {
					Rent r = rentMap.get(rentNum);
					if (inputId.equals(r.getId())) {
						System.out.println("------------ 대여내역 정보 -------------");
						System.out.println("대여내역 번호: " + r.getRentnum());
						System.out.println("회원 아이디: " + r.getId());
						System.out.println("스튜디오 번호: " + r.getStudioNum());
						System.out.println("대여 인원: " + r.getNumOfPeople());
						System.out.println("총 가격: " + r.getRate());
						String start = String.format("%tF %tR", r.getStartDate(), r.getStartDate());
						String end = String.format("%tF %tR", r.getEndDate(), r.getEndDate());
						System.out.println("대여시작 시간: " + start);
						System.out.println("대여종료 시간: " + end);
					}
				}
				
				AdminStudioManageView.inputEnterView();
				loop = false;
			} else if (inputSelect == 3) {	// 3번 입력시 특정 스튜디오 대여내역 조회
				
				rentMap = RentData.getRentMap();		
				
				System.out.println("조회할 스튜디오 번호를 입력하세요.");
				System.out.print("번호: ");
				
				int inputNum = scan.nextInt();
				
				for (int rentNum : rentMap.keySet()) {
					Rent r = rentMap.get(rentNum);
					if (inputNum == r.getStudioNum()) {
						System.out.println("------------ 대여내역 정보 -------------");
						System.out.println("대여내역 번호: " + r.getRentnum());
						System.out.println("회원 아이디: " + r.getId());
						System.out.println("스튜디오 번호: " + r.getStudioNum());
						System.out.println("대여 인원: " + r.getNumOfPeople());
						System.out.println("총 가격: " + r.getRate());
						String start = String.format("%tF %tR", r.getStartDate(), r.getStartDate());
						String end = String.format("%tF %tR", r.getEndDate(), r.getEndDate());
						System.out.println("대여시작 시간: " + start);
						System.out.println("대여종료 시간: " + end);
					}
				}
				
				AdminStudioManageView.inputEnterView();
				loop = false;
				
			} else if (inputSelect == 0) { 	// 0번 입력시 루프 빠져나가고 되돌아감
				
				loop = false;
			
			} else {	// 숫자 이외에 모든 유효성 검사
				System.out.println("올바른 숫자를 입력해주세요.");
			}
		}
		
	}
		
	

	public static void rentUpdate() {
		
		RentData.load();   	// 대여내역 배열 불러오기
		
		HashMap<Integer, Rent> rentMap = new HashMap<Integer, Rent>();		// 대여내역 배열 생성
		
		rentMap = RentData.getRentMap();
		
		Scanner scan = new Scanner(System.in);
		
		boolean loop = true;
		
		System.out.println("수정할 대여내역 번호를 입력하세요.");
		System.out.print("대여내역 번호: ");
		
		int updateRentNum = scan.nextInt();
		String id = "";
		scan.nextLine();
		
		while (loop) {
			
			for (int rentNum : rentMap.keySet()) {		// 확인 문구를 위한 for문
				Rent r = rentMap.get(rentNum);
				if (r.getRentnum() == updateRentNum) {	
					System.out.println("-------------------------------------------");
					System.out.printf("아이디 \"%s\" 대여내역을 수정하시겠습니까?\r\n",r.getId());
					System.out.println("-------------------------------------------");
					id = r.getId();
					break;
				}
			}

			System.out.print("(Y/N)입력: ");
			
			String inputUpdate = scan.nextLine();
			
			if (inputUpdate.equals("Y") || inputUpdate.equals("y")) {	// Y 혹은 y 입력시
				System.out.print("스튜디오 번호: ");
				int studioNum = scan.nextInt();		
				scan.nextLine();
				
				System.out.print("대여 인원: ");
				int person = scan.nextInt();
				scan.nextLine();
				
				System.out.print("총 가격: ");
				int price = scan.nextInt();
				scan.nextLine();
				
				System.out.println("ex) 20231225");
				System.out.print("대여시작 년월일: ");
				String startYMD = scan.nextLine();
				String startYear = startYMD.substring(0, 4);
				String startMonth = startYMD.substring(4, 6);
				String startDay = startYMD.substring(6);			// 시작 년월일을 나눠 각각 초기화
				
				System.out.println("ex) 오전 6시 -> 6, 오후 6시 -> 18");
				System.out.print("대여시작 시간: ");
				String startTime = scan.nextLine();					// 시작 시간
				
				System.out.print("대여종료 년월일: ");
				String endYMD = scan.nextLine();
				String endYear = endYMD.substring(0, 4);
				String endMonth = endYMD.substring(4, 6);
				String endDay = endYMD.substring(6);				// 종료도 마찬가지로 초기화
				
				System.out.print("대여종료 시간: ");
				String endTime = scan.nextLine();					// 종료 시간
				
				Calendar start = Calendar.getInstance();
				Calendar end = Calendar.getInstance();
				
				start.set(Integer.parseInt(startYear),
						  Integer.parseInt(startMonth) - 1,
						  Integer.parseInt(startDay),
						  Integer.parseInt(startTime),0,0);			// 입력받은 시작 년월일 및 시간으로 변경

				end.set(Integer.parseInt(endYear),
						Integer.parseInt(endMonth) - 1,
						Integer.parseInt(endDay),
						Integer.parseInt(endTime),0,0);				// 입력받은 종료 년월일 및 시간으로 변경
				
				Rent r = new Rent(updateRentNum, id, studioNum, price, person, start, end);
				
				RentData.setRentMap(updateRentNum, r);
				
				RentData.save();
				
				loop = false;
			} else if (inputUpdate.equals("N") || inputUpdate.equals("n")) { // N 혹은 n 입력시
				System.out.println("대여내역 관리로 돌아갑니다.");
				loop = false;		
			} else {
				System.out.println("Y 혹은 N을 입력해주세요.");
			}
			
		}
		
	}

	public static void rentDelete() {
		
		RentData.load();   	// 대여내역 배열 불러오기
		
		HashMap<Integer, Rent> rentMap = new HashMap<Integer, Rent>();		// 대여내역 배열 생성
		
		rentMap = RentData.getRentMap();
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("삭제할 대여내역 번호를 입력해주세요.");
		System.out.print("대여내역 번호: ");
		
		String inputNum = scan.nextLine();		// 삭제할 대여내역 번호를 입력받고
		
		System.out.println("정말로 삭제하시겠습니까?");	// 경고 문구 출력
		
		
		boolean loop = true;
		
		while (loop) {

			System.out.print("(Y/N)입력: ");				
			String input = scan.nextLine();
			
			if (input.equals("Y") || input.equals("y")) {	// Y 혹은 y 입력시
				rentMap.remove(Integer.parseInt(inputNum));	// 삭제 처리
				System.out.println("삭제하였습니다.");		// 삭제완료 문구
				RentData.save();							// 저장
				loop = false;
			} else if (input.equals("N") || input.equals("n")) { // N 혹은 n 입력시
				System.out.println("대여내역 관리로 돌아갑니다.");
				loop = false;									
			} else {	// 잘못 입력시
				System.out.println("Y 혹은 N을 입력해주세요.");  
			}
		}		
		
	}	
	
}
