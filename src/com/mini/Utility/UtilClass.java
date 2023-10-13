package com.mini.Utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.mini.dto.MenuClass;
import com.mini.dto.MenuDataClass;

public class UtilClass {
	private static final int VALUE = 100;
	
	public UtilClass() {
		// TODO Auto-generated constructor stub
	}
	
	public static void readTXT(String uri) { // txt 파일을 읽어와 ArrayList<String>으로 저장
		FileReader fw = null;
		BufferedReader br = null;

		try {
			fw = new FileReader(uri);
			br = new BufferedReader(fw);

			String temp = "";
			while ((temp = br.readLine()) != null) {
				MenuDataClass.readTXT.add(temp);
			}

		} catch (IOException e) {
			System.out.println("readTXT() ERR: " + e.getMessage());
		}

	}//readDB END

	public static void splitTXT(ArrayList<String> readTXT) {// 저장된 ArrayList를 불러와 split 진행
		for (int idx = 0; idx < readTXT.size(); idx++) {
			String[] temp = null;
			temp = readTXT.get(idx).split(",");
			MenuDataClass.splitMenu.add(temp);
		}
	}//splitDB END
	
	public static void putList (ArrayList<String[]> splitMenu) { // split된 데이터를 ArrayList<menuList>에 저장
		for(int idx = 0; idx < splitMenu.size(); idx++) {
			String[] temp = splitMenu.get(idx);
			String rName = (String) temp[0];
			String mName = (String) temp[1];
			String mCat = (String) temp[2];
			
			String tempForCasting = temp[3];
			int wTime = Integer.parseInt(tempForCasting);
			tempForCasting = temp[4];
			int mPrice = Integer.parseInt(tempForCasting);
			MenuDataClass.menuList.add(new MenuClass(rName, mName, mCat, wTime, mPrice));
		}
	}//putDB END
	
	public static void search(String keyword, ArrayList<MenuClass> menuList ) { //불러온 데이터 중 검색값을 포함하는 데이터 저장
			
			for(int idx = 0; idx < menuList.size(); idx++) {
				if(menuList.get(idx).getmName().contains(keyword)) {
					MenuDataClass.searchList.add(menuList.get(idx));
				}else {
					
				}
			}
	}//search END
	
	public static void valuation() { //검색결과 나온 메뉴에 대해 vPrice 계산 후 set하고 vPrice 내림차순 정렬
		for(int idx = 0; idx < MenuDataClass.searchList.size(); idx++) {
			int price = MenuDataClass.searchList.get(idx).getmPrice();
			int time = MenuDataClass.searchList.get(idx).getwTime();
			int temp = price + (time * VALUE);
			MenuDataClass.searchList.get(idx).setvPrice(temp);
		}
		Collections.sort(MenuDataClass.searchList, new Comparator<MenuClass>() {
		    @Override
		    public int compare(MenuClass o1, MenuClass o2) {
		        return o1.getvPrice() - o2.getvPrice();
		    }
		});   
	} //valuation END
	
	public static void prnConsole(ArrayList<MenuClass> list) { //console에 출력
		for(MenuClass menu : list) {
			System.out.println(menu);
		}
	}//prnConsole() END

}
