package dummy;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.security.SecureRandom;

public class user {
	

//	    public static void main(String[] args) {
//	        int numberOfUsernames = 100; // 생성할 더미 아이디 개수
//
//	        for (int i = 0; i < numberOfUsernames; i++) {
//	            String username = generateDummyUsername();
//	            System.out.println(username);
//	        }
//	    }
//
//	    public static String generateDummyUsername() {
//	        SecureRandom random = new SecureRandom();
//	        String characters = "abcdefghijklmnopqrstuvwxyz0123456789";
//	        int minLength = 6;
//	        int maxLength = 16;
//
//	        int usernameLength = random.nextInt(maxLength - minLength + 1) + minLength;
//	        StringBuilder username = new StringBuilder();
//
//	        while (username.length() < usernameLength) {
//	            int index = random.nextInt(characters.length());
//	            char randomChar = characters.charAt(index);
//	            username.append(randomChar);
//	        }
//
//	        return username.toString();
//	    }
	

	

	    

	  
//------------------------------------------------------------------------비밀번호
//	        public static void main(String[] args) {
//	            int numberOfPasswords = 100; // 생성할 더미 비밀번호 개수
//
//	            for (int i = 0; i < numberOfPasswords; i++) {
//	                String password = generateDummyPassword();
//	                System.out.println(password);
//	            }
//	        }
//
//	        public static String generateDummyPassword() {
//	            SecureRandom random = new SecureRandom();
//	            String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*()_+";
//	            int minLength = 8;
//	            int maxLength = 16;
//
//	            int passwordLength = random.nextInt(maxLength - minLength + 1) + minLength;
//	            StringBuilder password = new StringBuilder();
//
//	            boolean hasUpperCase = false;
//	            boolean hasLowerCase = false;
//	            boolean hasDigit = false;
//	            boolean hasSpecialChar = false;
//
//	            while (password.length() < passwordLength) {
//	                int index = random.nextInt(characters.length());
//	                char randomChar = characters.charAt(index);
//
//	                password.append(randomChar);
//
//	                if (Character.isUpperCase(randomChar)) {
//	                    hasUpperCase = true;
//	                } else if (Character.isLowerCase(randomChar)) {
//	                    hasLowerCase = true;
//	                } else if (Character.isDigit(randomChar)) {
//	                    hasDigit = true;
//	                } else {
//	                    hasSpecialChar = true;
//	                }
//	            }
//
//	            // 비밀번호에 최소 2가지 조합을 지키지 않으면 재생성
//	            if (!(hasUpperCase && hasLowerCase) && !(hasUpperCase && hasDigit) && !(hasUpperCase && hasSpecialChar) &&
//	                    !(hasLowerCase && hasDigit) && !(hasLowerCase && hasSpecialChar) && !(hasDigit && hasSpecialChar)) {
//	                return generateDummyPassword();
//	            }
//
//	            return password.toString();
//	        }
	    

//	------------------------------------------------------------------------전화번호

//	    public static void main(String[] args) {
//	        int numberOfPhoneNumbers = 100; // 생성할 더미 전화번호 개수
//
//	        for (int i = 0; i < numberOfPhoneNumbers; i++) {
//	            String phoneNumber = generateDummyPhoneNumber();
//	            System.out.println(phoneNumber);
//	        }
//	    }
//
//	    public static String generateDummyPhoneNumber() {
//	        Random random = new Random();
//
//	        // "010-XXXX-XXXX" 형식의 전화번호 생성
//	        String phoneNumber = "010-";
//
//	        // "XXXX-XXXX" 부분을 무작위로 생성
//	        for (int i = 0; i < 4; i++) {
//	            int digit = random.nextInt(10); // 0부터 9까지의 무작위 숫자
//	            phoneNumber += digit;
//	        }
//
//	        phoneNumber += "-";
//
//	        for (int i = 0; i < 4; i++) {
//	            int digit = random.nextInt(10); // 0부터 9까지의 무작위 숫자
//	            phoneNumber += digit;
//	        }
//
//	        return phoneNumber;
//	    }
	
//		------------------------------------------------------------------------생년월일

//	    public static void main(String[] args) {
//	        int numberOfBirthdates = 100; // 생성할 더미 생년월일 데이터 개수
//
//	        for (int i = 0; i < numberOfBirthdates; i++) {
//	            String birthdate = generateDummyBirthdate();
//	            System.out.println(birthdate);
//	        }
//	    }
//
//	    public static String generateDummyBirthdate() {
//	        Random random = new Random();
//
//	        // 무작위로 1950년부터 2023년 사이의 연도 생성
//	        int year = random.nextInt(74) + 1950;
//
//	        // 무작위로 1월부터 12월 사이의 월 생성
//	        int month = random.nextInt(12) + 1;
//
//	        // 월별로 유효한 일자 생성
//	        int day;
//	        switch (month) {
//	            case 2:
//	                if (isLeapYear(year)) {
//	                    day = random.nextInt(29) + 1; // 윤년인 경우 29일까지
//	                } else {
//	                    day = random.nextInt(28) + 1; // 윤년이 아닌 경우 28일까지
//	                }
//	                break;
//	            case 4:
//	            case 6:
//	            case 9:
//	            case 11:
//	                day = random.nextInt(30) + 1; // 4, 6, 9, 11월은 30일까지
//	                break;
//	            default:
//	                day = random.nextInt(31) + 1; // 나머지 월은 31일까지
//	        }
//
//	        // 날짜를 2자리 문자열로 변환
//	        String yearStr = String.format("%04d", year);
//	        String monthStr = String.format("%02d", month);
//	        String dayStr = String.format("%02d", day);
//
//	        return yearStr + monthStr + dayStr;
//	    }
//
//	    public static boolean isLeapYear(int year) {
//	        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
//	    }
	

//	-----------------------------------------------------------------------이름

	    public static void main(String[] args) {
	    	int numberOfName = 100;
	    	
	    		for (int i = 0; i < numberOfName; i++) {
	    		String birthdate = randName();
	    		System.out.println(birthdate);
	    		        }
	    }

	    public static String randName() {
	        StringBuilder text = new StringBuilder();
	        String first = "김이박최정강임한오서신권황안송류전홍고문양손배조백허유남심노정하곽성차주우구신임나전민유진지엄채방";
	        String last = "가강건달담대덕도동두라래로루리마만명무문미민바박백범별병보사산상새서석선설섭성세소솔수숙순숭슬승시신아안애엄여연영예오옥완요용우원월위유윤율으은의이익인일자잔장재전정제조종주준중지진찬창채천철초춘충치탐태";

	        for (int i = 0; i < 1; i++) {
	            text.append(first.charAt(new Random().nextInt(first.length())));
	        }
	        for (int i = 0; i < 2; i++) {
	            text.append(last.charAt(new Random().nextInt(last.length())));
	        }

	        return text.toString();
	    }
	

	   
	

	

	

}