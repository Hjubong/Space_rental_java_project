package com.project.admin;

import java.util.Scanner;

import com.project.user.User;

public class MyPageView {
    Scanner scan = new Scanner(System.in);
    public String menuNum ;
    public String check;
    public String modify;
    public String unregister;
    public void myPageMenu(){

        System.out.println("---------- 마이페이지 ----------");
        System.out.println("0. 돌아가기");
        System.out.println("1. 내 정보 조회");
        System.out.println("2. 내 정보 수정");
        System.out.println("3. 회원탈퇴");
        System.out.println("--------------------------------");
        System.out.print("번호 입력: ");
        menuNum = scan.nextLine();



    }// 마이페이지 선택시 보이는 화면

    public void userInfoCheck(User u){
        System.out.println("---------- 내 정보 조회 ----------");
        System.out.println("아이디: " + u.getId());
        System.out.println("비밀번호: " + u.getPassword());
        System.out.println("전화번호: " + u.getTel());
        System.out.println("생년월일: " + u.getBirth());
        System.out.println("이름: " + u.getName());
        System.out.println("--------------------------------");
        

    }// 내정보 조회 시 보이는 화면

    public void userInfoModify(){
        System.out.println("---------- 내 정보 수정 ----------");
        System.out.println("0. 뒤로가기");
        System.out.println("1. 비밀번호");
        System.out.println("2. 전화번호");
        System.out.println("3. 생년월일");
        System.out.println("4. 이름");
        System.out.println("--------------------------------");
        System.out.print("번호 입력: ");
        modify = scan.nextLine();
    }

    public void userUnregister() {
        System.out.println("---------- 회원 탈퇴 ----------");
        System.out.println("회원 탈퇴 하시겠습니까? ");
        System.out.print("y/n 둘 중 하나 입력: ");
        unregister = scan.nextLine();

    }
}
