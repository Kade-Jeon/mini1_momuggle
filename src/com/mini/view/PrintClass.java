package com.mini.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.mini.Utility.UtilClass;
import com.mini.db.MySQLconnector;
import com.mini.dto.MenuDataClass;

public class PrintClass {
	public static String keyword = "";
	public static String saveURI = "";
	public static String tags = "";
	
	public PrintClass() {
		// TODO Auto-generated constructor stub
	}
	public static void intro() {

	String uri = "../mini_momeoggle/source/data-RE2.txt";  //DB에 저장하고 검색에 활용할 txt 경로
	
		UtilClass.readTXT(uri);
		UtilClass.splitTXT(MenuDataClass.readTXT);
		UtilClass.putList(MenuDataClass.splitMenu);
		
		
	}//intro() END
	
	
	
	public static void runSearch() {
		Scanner scan = new Scanner(System.in);
		whole :while(true) {
			System.out.println("먹고 싶은 메뉴를 입력해주세요. ");
			System.out.println("전체: 전체메뉴를 조회합니다. 메뉴명: 해당 메뉴를 조회합니다. 종료: 프로그램 종료");
			System.out.print("입력 : ");
			MenuDataClass.searchList = new ArrayList<>();
			
			keyword = scan.next();
			
			part :switch(keyword) {
			case"전체":
				UtilClass.prnConsole(MenuDataClass.allMenu);
				System.out.println("─────────────────────────────────");
				System.out.println("           전체 메뉴 조회");
				System.out.println("─────────────────────────────────");
				tags = ViewClass.createHTML(MenuDataClass.allMenu, keyword);
				saveURI = "./all_result.html"; //저장경로
				ViewClass.saveHTML(saveURI, tags);
				
				break part;
			
			case"종료":
				System.out.println("프로그램을 종료합니다.");
				break whole;
				
			default:
				UtilClass.search(keyword, MenuDataClass.menuList);
				UtilClass.valuation();
				if(MenuDataClass.searchList.size()!=0) {
					UtilClass.prnConsole(MenuDataClass.searchList);
					System.out.println("─────────────────────────────────");
					System.out.println("             검색결과");
					System.out.println("─────────────────────────────────");
					tags = ViewClass.createHTML(MenuDataClass.searchList, keyword);
					saveURI = "./search_result.html"; //저장경로
					ViewClass.saveHTML(saveURI, tags);
					
				}else {					
					System.out.println("─────────────────────────────────");
					System.out.println("검색결과가 없습니다. 다시 입력해주세요.");
					System.out.println("─────────────────────────────────");
				}
				break part;
		}
		}
		scan.close();
	}// printSearch() END

	
}//Class END
