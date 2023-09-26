package com.project.login;

import java.util.HashMap;

import com.project.user.User;
import com.project.user.UserData;

public class LoginService {
	
	public static boolean login(String id, String pw) {
		// 입력받은 아이디와 비밀번호를 회원 맵에서 찾기
		HashMap<String, User> uMap = UserData.getUserMap();

		// 1. 아이디가 존재하는지 검색
		// 아이디가 여러개일 수는 없다.

		if (uMap.containsKey(id)) { // 1.1. 존재하는 경우
			// 비밀번호가 일치하는지 검사

			User tempUser = uMap.get(id); // 해당 아이디를 가진 회원 객체

			if (pw.equals(tempUser.getPassword())) { // 1.1.1. 일치하는 경우
				// 로그인 성공
				return true;
			} else { // 1.1.2. 일치하지 않는 경우
				return false;
			}

		} else { // 1.2. 존재하지 않는 경우
			// 유효하지 않다고 출력
			// 다시 입력받음 또는 뒤로가기
			return false;
		}

	}
}
