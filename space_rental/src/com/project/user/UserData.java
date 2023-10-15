package com.project.user;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;

public class UserData {
	private final static String path = "data/user.csv";

	private static HashMap<String, User> userMap;

	static {
		userMap = new HashMap<>();
	}

	public static HashMap<String, User> getUserMap() {
		return userMap;
	}

	public static void setUserMap(String id, User user) {
		userMap.replace(id, user);

		// 여기서 세이브를 할지, 나중에 할지 결정해야 함.
	}

	/**
	 * 회원 정보가 담긴 csv 파일을 읽어와 User 객체를 만든 후 맵에 저장합니다.
	 */
	public static void load() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));

			String line = null;

			while ((line = reader.readLine()) != null) {
				String[] temp = line.split(",");

				User u = new User(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], Integer.parseInt(temp[6]));

				userMap.put(temp[0], u);
			}

			reader.close();

//			System.out.println("사용자 데이터 로딩 완료");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * 맵에 있는 회원의 정보를 csv 파일에 저장합니다.
	 */
	public static void save() {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(path));

			for (String id : userMap.keySet()) {
				User u = userMap.get(id);

				writer.write(String.format("%s,%s,%s,%s,%s,%s,%d\r\n", u.getId(), u.getName(), u.getPassword(),
						u.getTel(), u.getBirth(), u.getStatus(), u.getLevel()));
			}

			writer.close();

			System.out.println("수정된 회원 파일이 저장되었습니다.");

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
