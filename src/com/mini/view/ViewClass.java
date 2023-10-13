package com.mini.view;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.mini.dto.MenuClass;

public class ViewClass {

	public ViewClass() {
		// TODO Auto-generated constructor stub
	}

	public static String createHTML(ArrayList<MenuClass> searchList,String keyword) {
		String tags = "";
		tags = tags + "<html>";
		tags = tags + "<head><title>검색결과</title><style>\r\n"
				+ "           div{width:100%; height:300px; text-align: center; color:#00ebc8; font-weight:bold; font-size: 200px;background-color: rgb(75,154,155);}\r\n"
				+ "           h1{width:70%; height:50px;margin: 80px auto 50px; color: rgb(62,74,96); text-decoration: underline; text-underline-offset : 20px; }\r\n"
				+ "           table{width:70%; border-collapse: collapse;margin: auto; padding: 0 100px; border-top:1px solid #333;}\r\n"
				+ "            \r\n"
				+ "           tr{diplay:block; width:100%; height:40px; border:1px solid #fff;}\r\n"
				+ "           th{diplay:block; border:1px solid #fff; color:#fff; background-color: rgb(62,74,96);}\r\n"
				+ "           tr:hover td{ background-color: #eee;}\r\n"
				+ "           img{ height:100%;}\r\n"
				+ "           td{diplay:block;text-align: center;border-left:1px solid #fff; border-bottom:1px solid rgb(62,74,96);}\r\n"
				+ "           td:first-child{width:50px;}\r\n"
				+ "           td:nth-child(3){width:120px;}\r\n"
				+ "        </style></head>";
		tags = tags + "<body>";
		tags = tags + "<div><img src = '../mini_momeoggle/source/logo.png'></div>";
		tags = tags + "<h1>"+keyword+"에 대한 검색결과</h1>";
		tags = tags + "<table>";
		
		int rank = 1;
		tags = tags + "<tr><th>순위</th><th>가게명</th><th>도보시간(분)</th><th>메뉴</th><th>가격</th><th>분류</th></tr>";
		for (int n = 0; n < searchList.size(); n++) {
			tags = tags + "<tr>";
			tags = tags + "<td>";
			tags = tags + rank;
			tags = tags + "</td>";
				tags = tags + "<td>";
				tags = tags + searchList.get(n).getrName();
				tags = tags + "</td>";
				tags = tags + "<td>";
				tags = tags + searchList.get(n).getwTime()+" 분";
				tags = tags + "</td>";
				tags = tags + "<td>";
				tags = tags + searchList.get(n).getmName();
				tags = tags + "</td>";
				tags = tags + "<td>";
				tags = tags + searchList.get(n).getmPrice()+"원";
				tags = tags + "</td>";
				tags = tags + "<td>";
				tags = tags + searchList.get(n).getmCat();
				tags = tags + "</td>";
				rank++;			

			tags = tags + "</tr>";
		}

		tags = tags + "</table>";
		tags = tags + "</body>";
		tags = tags + "</html>";

		return tags;
	}//createHTML END();

	
	public static void saveHTML(String uri2, String tags){
		FileWriter fw = null;

		try {
			System.out.println("지정한 경로로 HTML 파일을 저장합니다.");
			try {
				for(int i = 0; i < 5; i++) {
					Thread.sleep(1000);
					System.out.println(i*25+"% 다운로드");
				}			
				
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			fw = new FileWriter(uri2);
			fw.write(tags);
		} catch (IOException e) {
			System.out.println("saveHTML() ==> " + e.getMessage());

		} finally {
			
			try {
				fw.close();
				System.out.println("HTML 저장 완료");
			} catch (IOException e) {
				System.out.println("saveHTML() finally ==> " + e.getMessage());
			}
			
		}

	}// saveHTML() Method END
}
