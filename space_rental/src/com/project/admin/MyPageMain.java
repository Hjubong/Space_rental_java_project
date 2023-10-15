package com.project.admin;

import com.project.user.User;

public class MyPageMain {
    public static void main(String[] args) {
        MyPageService myPageService = new MyPageService();

        MyPageView mypage = new MyPageView();
        mypage.myPageMenu();

        while (true) {
            if (mypage.menuNum.equals("0")) {
                // 메인화면 보여주는 메소드 넣을 자리
            	break;
            } else if (mypage.menuNum.equals("1")) {
                User u = myPageService.getUser("25bjvtn30vu2");

                mypage.userInfoCheck(u); // 관리자 정보 조회 화면

                if (mypage.check.equals("0")) {
                    mypage.myPageMenu(); // 마이페이지 메인 화면으로 이동
                }
            } else if (mypage.menuNum.equals("2")) {
                mypage.userInfoModify(); // 관리자 정보 수정 화면
                if (mypage.modify.equals("0")) {
                    mypage.myPageMenu(); // 마이페이지 메인 화면으로 이동
                } else if (mypage.modify.equals("1")) {
                    // 비밀번호 수정 메소드
                    myPageService.updateUserPassword("25bjvtn30vu2");
                } else if (mypage.modify.equals("2")) {
                    // 전화번호 수정 메소드
                    myPageService.updateUserTel("25bjvtn30vu2");
                }  else if (mypage.modify.equals("3")) {
                    // 생년월일 수정 메소드
                    myPageService.updateUserBirth("25bjvtn30vu2");
                } else if (mypage.modify.equals("4")) {
                    // 이름 수정 메소드
                    myPageService.updateUserName("25bjvtn30vu2");
                }
            } else if (mypage.menuNum.equals("3")) {
                mypage.userUnregister(); //회원 탈퇴 화면으로 이동

                if (mypage.unregister.equals("y")) {
                    // 회원 탈퇴 메소드
                    myPageService.deleteUser("25bjvtn30vu2");

                    // TODO: 로그인 페이지로 이동하는 메소드로 변경하기
                    mypage.myPageMenu();
                } else if (mypage.unregister.equals("n")) {
                    System.out.println("마이페이지 메인 화면으로 돌아갑니다.");
                    mypage.myPageMenu();// n 입력 시 마이페이지 메인으로 이동
                }
            }
        }
    }
}
