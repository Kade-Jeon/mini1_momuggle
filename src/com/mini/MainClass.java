package com.mini;

import com.mini.db.MySQLconnector;
import com.mini.dto.MenuDataClass;
import com.mini.view.PrintClass;

public class MainClass {

	public static void main(String[] args) {
		PrintClass.intro();

		MySQLconnector mysql = new MySQLconnector(); // DB해제 위해 Main으로 뺌
		mysql.connectMySQL();
		mysql.showAll();
		/** db검증 **/
		int dblength = mysql.DBlength();
		if (dblength != MenuDataClass.menuList.size()) {
			mysql.insertDB(MenuDataClass.menuList);
			mysql.DBlength();
		}

		PrintClass.runSearch();
		
		mysql.close(MySQLconnector.conn); //DB해제
	}// main() END

}// Class END
