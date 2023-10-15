package com.project.admin;

import java.util.HashMap;
import java.util.Scanner;

import com.project.user.User;
import com.project.user.UserData;

public class MyPageService {
    MyPageView mypage = new MyPageView();
    Scanner scan = new Scanner(System.in);
    String path = "/Users/suding/IdeaProjects/space-rental/src/main/resources/file/user.csv";

    /**
     * 개인 관리자 정보 조회
     *
     * @param id
     * @return
     */
    public User getUser(String id) {
//        List<AdminUser> adminUsers = getAdminUsers();
//        for (AdminUser adminUser : adminUsers) {
//            if (id.equals(adminUser.getId())) {
//                return adminUser;
//            }
//        }
//
//        return null;
//    }
        UserData.load();

        HashMap<String, User> userMap = new HashMap<String, User>();

        userMap = UserData.getUserMap();

        User u = userMap.get("25bjvtn30vu2");

        return u;
    }


    /**
     * 관리자 개인 정보 수정 이름
     *
     * @param
     * @return
     */
//
        public void updateUserName(String id) {

            UserData.load();

            HashMap<String, User> userMap = new HashMap<String, User>();

            userMap = UserData.getUserMap();

            User u = userMap.get("25bjvtn30vu2");

            Scanner scanner = new Scanner(System.in);

        System.out.print("새로운 이름 입력(뒤로가기 0번): ");
        String newName = scanner.nextLine();
            if (newName.equals("0")) {
//            mypage.userInfoModify();
        } else {
            // 회원 정보 수정 및 리스트 업데이트
                u.setName(newName);
                UserData.save();
                System.out.println("회원 정보가 수정되었습니다.");
        }
    }

    /**
     * 관리자 정보 수정 비밀번호
     */
//
    public void updateUserPassword(String id) {
        UserData.load();

        HashMap<String, User> userMap = new HashMap<String, User>();

        userMap = UserData.getUserMap();

        User u = userMap.get("25bjvtn30vu2");

        Scanner scanner = new Scanner(System.in);

        System.out.print("새로운 비밀번호 입력(뒤로가기 0번): ");
        String newPassWord = scanner.nextLine();
        if (newPassWord.equals("0")) {
            //mypage.userInfoModify(); 이 코드때문에 0번을 여러번 입력해야함
        } else {
            u.setPassword(newPassWord);
            UserData.save();
            System.out.println("회원 정보가 수정되었습니다.");

        }
    }


    /**
     * 관리자 정보 수정 전화번호
     */

    public void updateUserTel(String id) {
        UserData.load();

        HashMap<String, User> userMap = new HashMap<String, User>();

        userMap = UserData.getUserMap();

        User u = userMap.get("25bjvtn30vu2");

        Scanner scanner = new Scanner(System.in);

        System.out.print("새로운 전화번호 입력(뒤로가기 0번): ");
        String newTel = scanner.nextLine();
        if (newTel.equals("0")) {
            //mypage.userInfoModify();
        } else {
            newTel = addHyphensToPhoneNumber(newTel);
            u.setTel(newTel);
            UserData.save();
            System.out.println("회원 정보가 수정되었습니다.");
        }
    }
    private String addHyphensToPhoneNumber(String phoneNumber) {
        return phoneNumber.substring(0, 3) + "-" + phoneNumber.substring(3, 7) + "-" + phoneNumber.substring(7);

    }

    /**
     * 관리자 정보 수정 생년월일
     *
     * @param id
     */
    public void updateUserBirth(String id) {

        UserData.load();

        HashMap<String, User> userMap = new HashMap<String, User>();

        userMap = UserData.getUserMap();

        User u = userMap.get("25bjvtn30vu2");

        Scanner scanner = new Scanner(System.in);

        System.out.print("\r\n새로운 생년월일 입력\r\nex)19990420 (뒤로가기 0번): ");
        String newBirth = scanner.nextLine();

        if (newBirth.equals("0")) {
            //mypage.userInfoModify();
        } else {
            u.setBirth(newBirth);
            UserData.save();
            System.out.println("회원 정보가 수정되었습니다.");
        }
    }

    /**
     * 관리자 회원 탈퇴 기능
     */

    public void deleteUser(String id) {

        UserData.load();

        HashMap<String, User> userMap = new HashMap<String, User>();

        userMap = UserData.getUserMap();

        User u = userMap.get("25bjvtn30vu2");

            u.setStatus("Y");
            UserData.save();

            System.out.println("회원이 탈퇴 되었습니다.");

            mypage.myPageMenu();


    }
}

