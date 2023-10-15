package com.project.view;

import com.project.main.MainService;

//import com.project.main.MainService;

public class MainTest {
	public static void main(String[] args) {
//		System.out.println("MainTest.main - start");

		MainService.dataLoad();

		MainTestService.mainStart();

//		System.out.println("MainTest.main - end");
	}
}
