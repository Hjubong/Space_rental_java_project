package com.project.main;

import java.util.HashMap;

import com.project.rent.Rent;
import com.project.rent.RentData;
import com.project.studio.Studio;
import com.project.studio.StudioData;
import com.project.user.User;
import com.project.user.UserData;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 데이터 로드
		MainService.dataLoad();
		
		
		// 아래는 데이터 테스트
		HashMap<String, User> map = UserData.getUserMap();
		User u = map.get("gzry24b4mrs");
		
		System.out.println(u.toString());
		
		
		// 스튜디오 데이터 
		HashMap<Integer, Studio> sMap = StudioData.getStudioMap();
		Studio s = sMap.get(1);
		System.out.println(s.toString());
		
		
		// 대여 데이터
		HashMap<Integer, Rent> rMap = RentData.getRentMap();
		Rent r = rMap.get(1);
		System.out.printf("%tF %tT\n", r.getStartDate(), r.getStartDate());
		System.out.printf("%tF %tT\n", r.getEndDate(), r.getEndDate());
		System.out.println(r.toString());

		
		// 데이터 수정되었는지는 한번 더 확인해야 함.
		
		// 기능 실행 코드 아래 작성
		
	}

}
