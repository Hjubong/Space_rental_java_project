package com.project.admin;

import com.project.login.LoginMain;
import com.project.auth.Auth;
import com.project.user.User;

import java.util.Scanner;

public class MyPageMain {
    public static void main(String[] args) {
        MyPageService myPageService = new MyPageService();
        LoginMain l= new LoginMain();

        Auth auth = new Auth();
        MyPageView mypage = new MyPageView();
        mypage.myPageMenu();

        while (true) {
            if (mypage.menuNum.equals("0")) {
            	break;
            } else if (mypage.menuNum.equals("1")) {
                User u = myPageService.getUser(auth.authId);

                mypage.userInfoCheck(u); // 관리자 정보 조회 화면
                
                AdminStudioManageView.inputEnterView();
                mypage.myPageMenu();
                
            } else if (mypage.menuNum.equals("2")) {
                mypage.userInfoModify(); // 관리자 정보 수정 화면
                if (mypage.modify.equals("0")) {
                    mypage.myPageMenu(); // 마이페이지 메인 화면으로 이동
                } else if (mypage.modify.equals("1")) {
                    // 비밀번호 수정 메소드
                    myPageService.updateUserPassword(auth.authId);
                } else if (mypage.modify.equals("2")) {
                    // 전화번호 수정 메소드
                    myPageService.updateUserTel(auth.authId);
                }  else if (mypage.modify.equals("3")) {
                    // 생년월일 수정 메소드
                    myPageService.updateUserBirth(auth.authId);
                } else if (mypage.modify.equals("4")) {
                    // 이름 수정 메소드
                    myPageService.updateUserName(auth.authId);
                } else {
                    System.out.print("올바른 숫자를 입력해주세요.: ");
                }
            } else if (mypage.menuNum.equals("3")) {
                mypage.userUnregister(); //회원 탈퇴 화면으로 이동

                if (mypage.unregister.equals("y")) {
                    // 회원 탈퇴 메소드
                    myPageService.deleteUser(auth.authId);

                    // TODO: 로그인 페이지로 이동하는 메소드로 변경하기
                    LoginMain.loginMain();
                } else if (mypage.unregister.equals("n")) {
                    System.out.println("마이페이지 메인 화면으로 돌아갑니다.");
                    mypage.myPageMenu();// n 입력 시 마이페이지 메인으로 이동
                } else {
                    System.out.print("올바른 숫자를 입력해주세요.: ");
                }
            } else {
                System.out.print("올바른 숫자를 입력해주세요.: ");
            }
        }
    }
}
