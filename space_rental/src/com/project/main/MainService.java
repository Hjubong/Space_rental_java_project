package com.project.main;

import com.project.rent.RentData;
import com.project.studio.StudioData;
import com.project.user.UserData;

public class MainService {
	public static void dataLoad() {
		
		UserData.load(); // user 데이터 로드
		StudioData.load(); // studio 데이터 로드
		RentData.load(); // rent 데이터 로드
	}
}
