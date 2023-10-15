package com.project.studio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;

import com.project.user.User;

public class StudioData {
	private final static String path = "data/studio.txt";

	private static HashMap<Integer, Studio> studioMap;

	static {
		studioMap = new HashMap<>();
	}

	public static HashMap<Integer, Studio> getStudioMap() {
		return studioMap;
	}

	public static void setStudioMap(int num, Studio studio) {
		studioMap.replace(num, studio);
	}

	/**
	 * 스튜디오 정보가 담긴 csv 파일을 읽어와 Studio 객체를 만든 후 맵에 저장합니다.
	 */
	public static void load() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));

			String line = null;

			while ((line = reader.readLine()) != null) {
				String[] temp = line.split(",");

				Studio s = new Studio(Integer.parseInt(temp[0]), temp[1], temp[2], Integer.parseInt(temp[3]),
						Integer.parseInt(temp[4]), Integer.parseInt(temp[5]), temp[6], Integer.parseInt(temp[7]));

				studioMap.put(Integer.parseInt(temp[0]), s);
			}

			reader.close();
			
//			System.out.println("스튜디오 데이터 로딩 완료");

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * 맵에 있는 스튜디오의 정보를 csv 파일에 저장합니다.
	 */
	public static void save() {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(path));

			for (int studionNum : studioMap.keySet()) {
				Studio s = studioMap.get(studionNum);

				writer.write(String.format("%d,%s,%s,%d,%d,%d,%s,%d\r\n", s.getStudioNum(), s.getName(), s.getType(), s.getMaxNumOfPeople(), s.getBasicRate(), s.getArea(), s.getAddress(), s.getStatus()));
			}

			writer.close();

			System.out.println("수정된 스튜디오 파일이 저장되었습니다.");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
