package com.project.user;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Scanner;

import com.project.admin.AdminStudioManageView;
import com.project.rent.Rent;
import com.project.rent.RentData;
import com.project.studio.Studio;
import com.project.studio.StudioData;

public class UserRentService {

	public static void studioSelect() {
		
		StudioData.load();	// 스튜디오 배열 불러오기
		RentData.load();	// 대여내역 배열 불러오기
		
		HashMap<Integer, Studio> studioMap = new HashMap<Integer,Studio>(); // 스튜디오 배열 생성
		HashMap<Integer, Rent> rentMap = new HashMap<Integer, Rent>();		// 대여내역 배열 생성
		
		studioMap = StudioData.getStudioMap();
		rentMap = RentData.getRentMap();
		
		boolean loop = true;
		
		Scanner scan = new Scanner(System.in);
		
		while (loop) {
			
			UserRentView.studioSelectView();
			
			String input = scan.nextLine();
			
			if (input.equals("1")) {
				
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
				
				
			} else if (input.equals("2")) {
				
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
				
			} else if (input.equals("3")) {
				
				System.out.print("최소 가격(원): ");
				int minPrice = scan.nextInt();
				
				scan.nextLine();
				
				System.out.print("최대 가격(원): ");
				int maxPrice = scan.nextInt();
				
				scan.nextLine();
				
				for (int studionNum : studioMap.keySet()) {
					Studio s = studioMap.get(studionNum);
					if (s.getStatus() == 0 && 
						s.getBasicRate() >= minPrice &&		// 입력한 최소 가격 ~ 최대 가격 사이에서 조회
						s.getBasicRate() <= maxPrice) {						
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
				
			} else if (input.equals("4")) {
				
				System.out.print("최소 인원(명): ");
				int minPerson = scan.nextInt();
				
				scan.nextLine();
				
				System.out.print("최대 인원(명): ");
				int maxPerson = scan.nextInt();
				
				scan.nextLine();
				
				for (int studionNum : studioMap.keySet()) {
					Studio s = studioMap.get(studionNum);
					if (s.getStatus() == 0 && 
						s.getMaxNumOfPeople() >= minPerson &&	// 입력한 최소 인원 ~ 최대 인원 사이에서 조회
						s.getMaxNumOfPeople() <= maxPerson) {						
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
				
			} else if (input.equals("5")) {
				
				System.out.print("최소 크기(평): ");
				int minArea = scan.nextInt();
				
				scan.nextLine();
				
				System.out.print("최대 크기(평): ");
				int maxArea = scan.nextInt();
				
				scan.nextLine();
				
				for (int studionNum : studioMap.keySet()) {
					Studio s = studioMap.get(studionNum);
					if (s.getStatus() == 0 && 
							s.getArea() >= minArea &&	// 입력한 최소 크기 ~ 최대 크기 사이에서 검색
							s.getArea() <= maxArea) {						
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
				
			} else if (input.equals("6")) {
				
				System.out.println("지역을 입력하세요. ex)구로, 강남");
				System.out.print("지역: ");
				String address = scan.nextLine();				
				
				for (int studionNum : studioMap.keySet()) {
					Studio s = studioMap.get(studionNum);
					if (s.getStatus() == 0 && 					
						s.getAddress().contains(address)) {		// 입력한 지역이 스튜디오 주소에 포함되는지 조회				
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
				
			} else if (input.equals("0")) {
				
				loop = false;
			
			} else {
				System.out.println("잘못된 번호입니다.");
			}
			
		}
		
		
	}

	public static void studioRent() {
		
		StudioData.load();	// 스튜디오 배열 불러오기
		RentData.load();	// 대여내역 배열 불러오기
		UserData.load();	// 회원 배열 불러오기
		
		HashMap<Integer, Studio> studioMap = new HashMap<Integer,Studio>(); // 스튜디오 배열 생성
		HashMap<Integer, Rent> rentMap = new HashMap<Integer, Rent>();		// 대여내역 배열 생성
		HashMap<String, User> userMap = new HashMap<String, User>();		// 회원 배열 생성
		
		studioMap = StudioData.getStudioMap();
		rentMap = RentData.getRentMap();
		userMap = UserData.getUserMap();
		
		User u = userMap.get("w8znovtv");	// 로그인한 아이디 넣기 
		
		Scanner scan = new Scanner(System.in);

		System.out.println("대여할 스튜디오의 번호를 입력해주세요.");
		System.out.print("스튜디오 번호: ");
		int studioNum = scan.nextInt();		
		scan.nextLine();

		System.out.println("인원을 입력해주세요.(숫자만 기입)");
		System.out.print("인원: ");
		int personNum = scan.nextInt();
		scan.nextLine();

		
		boolean loop = true;

		String rentStartDate = "";	
		
		String rentStartTime = "";
		
		while (loop) {	// 대여할 날짜 및 시각이 현재시간 이후에만 대여가 가능하도록 함

			System.out.println("대여할 날짜를 입력하세요. ex)2023-10-12 또는 20231012");
			System.out.print("대여 날짜: ");
			rentStartDate = scan.nextLine();
			rentStartDate = rentStartDate.replace("-", "");
				
			System.out.println("대여할 시각을 입력하세요. ex)16시 또는 16");
			System.out.print("대여 시각: ");
			rentStartTime = scan.nextLine();
			rentStartTime = rentStartTime.replace("시", "");
			
			Calendar now = Calendar.getInstance();
			
			Calendar compare = Calendar.getInstance();
			
			int year = Integer.parseInt(rentStartDate.substring(0, 4));
			int month = Integer.parseInt(rentStartDate.substring(4, 6));
			int day = Integer.parseInt(rentStartDate.substring(6));
			
			compare.set(year, month - 1, day, Integer.parseInt(rentStartTime), 0, 0);
			
			long nowTick = now.getTimeInMillis();
			long compareTick = compare.getTimeInMillis();

			if (nowTick < compareTick) {
				loop = false;
			} else {
				System.out.println("현재시간 이후로 대여해주세요.");
			}
			
			
		}
		

		System.out.println("대여 시간을 입력해주세요. ex)6시간 또는 6");
		
		loop = true;
		
		String rentTime = "";
		
		while (loop) {	// 대여 시간은 2시간 이상 부터 가능하도록 함
			
			System.out.print("대여 시간: ");
			rentTime = scan.nextLine();
			rentTime = rentTime.replace("시간", "");

			if (Integer.parseInt(rentTime) < 2) {
				System.out.println("대여 시간은 최소 2시간 이상입니다.");
			} else {
				loop = false;
			}
		}
		
		
		int year = Integer.parseInt(rentStartDate.substring(0, 4));
		int month = Integer.parseInt(rentStartDate.substring(4, 6));
		int day = Integer.parseInt(rentStartDate.substring(6));
		
		Calendar start = Calendar.getInstance();
		start.set(year, month - 1, day, Integer.parseInt(rentStartTime), 0, 0);
		
		Calendar end = Calendar.getInstance();
		end.set(year, month - 1, day, Integer.parseInt(rentStartTime), 0, 0);
		end.add(Calendar.HOUR_OF_DAY, Integer.parseInt(rentTime));
		
		long startTick = start.getTimeInMillis();
		long endTick = end.getTimeInMillis();
		
		int length = rentMap.size() + 1;	// 대여 진행시 배열에 새롭게 추가하기 위한 변수	
		
		int num = 0;	// 대여 시간 중복 판별을 위한 변수 > 중복 시 1로 초기화
		
		Studio s = studioMap.get(studioNum);
		for (int rentNum : rentMap.keySet()) {
			Rent r = rentMap.get(rentNum);
			if (r.getStudioNum() == studioNum ) {
				long rStartTick = r.getStartDate().getTimeInMillis(); 
				long rEndTick = r.getEndDate().getTimeInMillis();
				if (rStartTick < startTick && rEndTick > startTick) { // 신청한 대여시작시간이 이미 겹치는 시간이 있을때
					System.out.println("이미 대여중인 스튜디오 입니다.");
					System.out.printf("%tF %tR 이후로 대여 가능합니다.\r\n", r.getEndDate(), r.getEndDate());
					num = 1;
					break;
				} else if (rStartTick < endTick && rEndTick > endTick) { // 신청한 대여종료시간이 이미 겹치는 시간이 있을때
					System.out.println("이미 대여중인 스튜디오 입니다.");
					System.out.printf("%tF %tR 이후로 대여 가능합니다.\r\n", r.getEndDate(), r.getEndDate());
					num = 1;
					break;
				} else if (s.getMaxNumOfPeople() < personNum) { // 신청한 대여 인원이 최대인원 보다 높을때
					System.out.println("최대 인원을 초과했습니다.");
					System.out.printf("%d명 이하만 가능합니다.", s.getMaxNumOfPeople());
					num = 1;
					break;
				}
			}
		}
		
		if (num == 1) {	// num값이 1이면 대여를 하지않음
			
			num = 0;	// 다시 0으로 초기화
			
		} else if (num == 0) { // num값이 0이면 중복되는 시간대가 없으므로 대여 진행
			
			System.out.println("대여가 완료되었습니다.");
			
			int price = s.getBasicRate() * Integer.parseInt(rentTime);
			Rent r = new Rent(length, u.getId(), studioNum,
							  price, personNum, start, end);
			
			rentMap.put(length, r);					
			RentData.save();			
		}
		
		
	}
	
	public static void rentSelect() {
		
		StudioData.load();	// 스튜디오 배열 불러오기
		RentData.load();	// 대여내역 배열 불러오기
		UserData.load();	// 회원 배열 불러오기
		
		HashMap<Integer, Studio> studioMap = new HashMap<Integer,Studio>(); // 스튜디오 배열 생성
		HashMap<Integer, Rent> rentMap = new HashMap<Integer, Rent>();		// 대여내역 배열 생성
		HashMap<String, User> userMap = new HashMap<String, User>();		// 회원 배열 생성
		
		studioMap = StudioData.getStudioMap();
		rentMap = RentData.getRentMap();
		userMap = UserData.getUserMap();
		
		User u = userMap.get("w8znovtv");
		
		for (int rentNum : rentMap.keySet()) {
			Rent r = rentMap.get(rentNum);
			Studio s = studioMap.get(r.getStudioNum());
			if (r.getId().equals(u.getId())) {						
				System.out.println("------------ 대여 내역 -------------");
				System.out.println("대여 번호: " + r.getRentnum());
				System.out.println("스튜디오 번호: " + r.getStudioNum());
				System.out.println("스튜디오 명: " + s.getName());
				System.out.println("총 가격: " + r.getRate());
				System.out.println("인원: " + r.getNumOfPeople());
				System.out.printf("대여 시작 날짜: %tF %tR\r\n", r.getStartDate(), r.getStartDate());
				System.out.printf("대여 종료 날짜: %tF %tR\r\n", r.getEndDate(), r.getEndDate());
			}
		}
		
		AdminStudioManageView.inputEnterView();
		
	}
	
	public static void rentDelete() {
		
		StudioData.load();	// 스튜디오 배열 불러오기
		RentData.load();	// 대여내역 배열 불러오기
		UserData.load();	// 회원 배열 불러오기
		
		HashMap<Integer, Studio> studioMap = new HashMap<Integer,Studio>(); // 스튜디오 배열 생성
		HashMap<Integer, Rent> rentMap = new HashMap<Integer, Rent>();		// 대여내역 배열 생성
		HashMap<String, User> userMap = new HashMap<String, User>();		// 회원 배열 생성
		
		studioMap = StudioData.getStudioMap();
		rentMap = RentData.getRentMap();
		userMap = UserData.getUserMap();
		
		Scanner scan = new Scanner(System.in);
		
		User u = userMap.get("w8znovtv");
		
		Calendar now = Calendar.getInstance();
		long nowTick = now.getTimeInMillis();
		
		//대여 취소는 신청한 대여내역 중 현재 시간이 대여 시작 시간을 지나지 않을 경우에만 가능
		int num = 0;	// 판별하기 위한 변수
		
		int rNum = 0;	// 대여 취소가 가능할 시 취소할 대여번호를 초기화해줄 변수
		
		for (int rentNum : rentMap.keySet()) {	//대여취소는 이미 지난 내역은 취소 불가능
			
			Rent r = rentMap.get(rentNum);
			Studio s = studioMap.get(r.getStudioNum());
			
			long startTick = r.getStartDate().getTimeInMillis();
			long endTick = r.getEndDate().getTimeInMillis();
			
			if (r.getId().equals(u.getId()) && nowTick < startTick) {	
			// 대여내역에 존재하는 아이디와 로그인한 아이디가 같고
			// 그 중에 현재 시간이 신청한 대여시작 시간보다 작은 경우 취소 가능					
				System.out.println("------------ 대여 내역 -------------");
				System.out.println("대여 번호: " + r.getRentnum());
				System.out.println("스튜디오 번호: " + r.getStudioNum());
				System.out.println("스튜디오 명: " + s.getName());
				System.out.println("총 가격: " + r.getRate());
				System.out.println("인원: " + r.getNumOfPeople());
				System.out.printf("대여 시작 날짜: %tF %tR\r\n", r.getStartDate(), r.getStartDate());
				System.out.printf("대여 종료 날짜: %tF %tR\r\n", r.getEndDate(), r.getEndDate());
				
				num = 1;	// 취소할 대여가 있는 경우 1로 변경
				rNum = r.getRentnum(); // 취소할 대여 번호로 초기화
				break;
			}
		}
		
		
		if (num == 0) { // 0이면 취소할 대여가 없음
			System.out.println("취소할 대여가 없습니다.");
		} 
		
		boolean loop = true;
			
		if (num == 1) {		// 1번일 경우 취소할 대여가 있는 경우고 취소 확인을 위한 루프
			System.out.println("-----------------------------------");
			System.out.println("해당 대여를 취소하시겠습니까?");

			while (loop) {

				System.out.print("(Y/N)입력: ");
				String input = scan.nextLine(); 
				
				if (input.equals("y") || input.equals("Y")) { // y 입력시 대여내역에서 삭제 및 저장
					loop = false;
					System.out.println("대여를 취소하였습니다.");
					rentMap.remove(rNum);
					RentData.save();
				} else if (input.equals("n") || input.equals("N")) { // n 입력시 취소하지 않고 돌아감
					loop = false;
					System.out.println("취소하지 않고 돌아갑니다.");
				} else {
					System.out.println("Y 또는 N을 입력해주세요.");
				}
				
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
	
}
