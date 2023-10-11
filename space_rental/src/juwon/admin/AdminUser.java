package juwon.admin;

import java.util.HashMap;
import java.util.Scanner;

import com.project.user.User;
import com.project.user.UserData;

public class AdminUser {
	
	
	public static void allcheck() { //사용자 전체 조회
		
		// 사용자 데이터 로드하기
        UserData.load();
        
        // 메모리에 저장된 사용자 데이터 가져오기
        HashMap<String, User> userMap = UserData.getUserMap();
        
        // 사용자 데이터 출력
        for (User user : userMap.values()) {
            System.out.println("User ID: " + user.getId());
            System.out.println("Name: " + user.getName());
            System.out.println("Phone: " + user.getTel());
            System.out.println("Birth: " + user.getBirth());
            System.out.println("Status: " + user.getStatus());
            System.out.println("Level: " + user.getLevel());
            System.out.println("----------------------------");
        }
        
	}
	
	
	 public static void check() { // 사용자 개별 조회
	        // 사용자 데이터 로드하기
	        UserData.load();
	        
	        // 메모리에 저장된 사용자 데이터 가져오기
	        HashMap<String, User> userMap = UserData.getUserMap();
	        
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("조회할 사용자의 ID를 입력하세요: ");
	        String targetId = scanner.nextLine();
	        
	        // 사용자 데이터 출력
	        if (userMap.containsKey(targetId)) {
	            User user = userMap.get(targetId);
	            System.out.println("User ID: " + user.getId());
	            System.out.println("Name: " + user.getName());
	            System.out.println("Phone: " + user.getTel());
	            System.out.println("Birth: " + user.getBirth());
	            System.out.println("Status: " + user.getStatus());
	            System.out.println("Level: " + user.getLevel());
	        } else {
	            System.out.println("해당 ID로 사용자를 찾을 수 없습니다.");
	        }
	 }
	 
	 
	 public static void modify() {// 사용자 정보 수정
	        // 먼저 사용자 데이터를 로드합니다.
	        UserData.load();
	        
	        // 메모리에 저장된 사용자 데이터 가져오기
	        HashMap<String, User> userMap = UserData.getUserMap();
	        
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("사용자 정보를 수정할 ID를 입력하세요: ");
	        String targetId = scanner.nextLine();
	        
	        // 사용자 데이터 수정
	        if (userMap.containsKey(targetId)) {
	            User user = userMap.get(targetId);
	            
	            System.out.println("현재 정보:");
	            System.out.println("User ID: " + user.getId());
	            System.out.println("Name: " + user.getName());
	            System.out.println("Phone: " + user.getTel());
	            System.out.println("Birth: " + user.getBirth());
	            System.out.println("Status: " + user.getStatus());
	            System.out.println("Level: " + user.getLevel());
	            
	            System.out.println("새로운 정보를 입력하세요:");
	            System.out.print("Name: ");
	            String newName = scanner.nextLine();
	            System.out.print("Phone: ");
	            String newPhone = scanner.nextLine();
	            System.out.print("Birth: ");
	            String newBirth = scanner.nextLine();
	            System.out.print("Status: ");
	            String newStatus = scanner.nextLine();
	            System.out.print("Level: ");
	            int newLevel = scanner.nextInt();
	            
	            // 사용자 정보 업데이트
	            user.setName(newName);
	            user.setTel(newPhone);
	            user.setBirth(newBirth);
	            user.setStatus(newStatus);
	            user.setLevel(newLevel);
	            
	            // 수정된 정보 저장
	            UserData.save();
	            
	            System.out.println("사용자 정보가 업데이트되었습니다.");
	        } else {
	            System.out.println("해당 ID로 사용자를 찾을 수 없습니다.");
	        }
	 }
	 
	 
	 public static void delete() {// 사용자 정보 삭제
	        // 먼저 사용자 데이터를 로드합니다.
	        UserData.load();
	        
	        // 메모리에 저장된 사용자 데이터 가져오기
	        HashMap<String, User> userMap = UserData.getUserMap();
	        
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("사용자 정보를 삭제할 ID를 입력하세요: ");
	        String targetId = scanner.nextLine();
	        
	        // 사용자 데이터 삭제
	        if (userMap.containsKey(targetId)) {
	            User user = userMap.get(targetId);
	            
	            System.out.println("현재 정보:");
	            System.out.println("User ID: " + user.getId());
	            System.out.println("Name: " + user.getName());
	            System.out.println("Phone: " + user.getTel());
	            System.out.println("Birth: " + user.getBirth());
	            System.out.println("Status: " + user.getStatus());
	            System.out.println("Level: " + user.getLevel());
	            
	            System.out.println("새로운 정보를 입력하세요:");
	            System.out.print("Level: ");
	            int newLevel = scanner.nextInt();
	            
	            // 사용자 정보 업데이트
	            user.setLevel(newLevel);
	            
	            // 수정된 정보 저장
	            UserData.save();
	            
	            System.out.println("사용자 정보가 업데이트되었습니다.");
	        } else {
	            System.out.println("해당 ID로 사용자를 찾을 수 없습니다.");
	        }
	    }
	 
	 
}
