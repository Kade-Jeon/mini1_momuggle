package com.mini.dto;

import java.util.ArrayList;


public class MenuDataClass {
	public static final ArrayList<String> readTXT = new ArrayList<>(); //데이터 읽고 String으로 저장
	public static final ArrayList<String[]> splitMenu = new ArrayList<>(); // 데이터 쪼개서 스트링 배열 저장
	public static final ArrayList<MenuClass> menuList = new ArrayList<>(); // 변수 활용 할 수 있도록 각각 대임
	public static ArrayList<MenuClass> searchList = new ArrayList<>(); // 키워드에 따른 검색결과만 저장
	public static final ArrayList<MenuClass> allMenu = new ArrayList<>(); // DB에서 가져온 전체 데이터 저장
	
	public MenuDataClass() {
		
	}
}
