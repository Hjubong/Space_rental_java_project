package com.project.rent;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Calendar;
import java.util.HashMap;

public class RentData {
	private final static String path = "data/rent.txt";

	private static HashMap<Integer, Rent> rentMap;

	static {
		rentMap = new HashMap<>();
	}

	public static HashMap<Integer, Rent> getRentMap() {
		return rentMap;
	}

	public static void setRentMap(int rentNum, Rent rent) {
		rentMap.replace(rentNum, rent);
	}

	/**
	 * 대여 정보가 담긴 csv 파일을 읽어와 Rent 객체를 만든 후 맵에 저장합니다.
	 */
	public static void load() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));

			String line = null;

			while ((line = reader.readLine()) != null) {
				String[] temp = line.split(",");

				String startDateStr = temp[5];
				String endDateStr = temp[6];

				Calendar startDate = getDate(startDateStr);
				Calendar endDate = getDate(endDateStr);

				Rent r = new Rent(Integer.parseInt(temp[0]), temp[1], Integer.parseInt(temp[2]),
						Integer.parseInt(temp[3]), Integer.parseInt(temp[4]), startDate, endDate);

				rentMap.put(Integer.parseInt(temp[0]), r);
			}

			reader.close();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static Calendar getDate(String dateStr) {
		Calendar result = Calendar.getInstance();
		String[] dateTime = dateStr.split(" ");

		String[] date = dateTime[0].split("-");

		// 년
		int year = Integer.parseInt(date[0]);

		// 월
		int month = Integer.parseInt(date[1]);

		// 일
		int day = Integer.parseInt(date[2]);

		String[] time = dateTime[1].split(":");

		// 시
		int hour = Integer.parseInt(time[0]);

		// 분
		int minute = Integer.parseInt(time[1]);
		
		// 초
		int second = Integer.parseInt(time[2]);

		result.set(year, month - 1, day, hour, minute, second);

		return result;
	}

	/**
	 * 맵에 있는 대여 정보를 csv 파일에 저장합니다.
	 */
	public static void save() {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(path));

			for (int rentNum : rentMap.keySet()) {
				Rent r = rentMap.get(rentNum);

				writer.write(String.format("%d,%s,%d,%d,%d,%tF %tT,%tF %tT\r\n", r.getRentnum(), r.getId(), r.getStudioNum(), r .getRate(), r.getNumOfPeople(), r.getStartDate(), r.getStartDate(), r.getEndDate(), r.getEndDate()));
			}

			writer.close();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
