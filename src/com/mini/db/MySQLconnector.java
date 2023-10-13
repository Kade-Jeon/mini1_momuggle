package com.mini.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mini.dto.MenuClass;
import com.mini.dto.MenuDataClass;


public class MySQLconnector extends Querys{
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/mini_project?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
	private String id_mysql = "root";
	private String pw_mysql = "7276"; // 본인 비밀번호
	
	public static Connection conn = null;

	public MySQLconnector() { // 기본 생성자

	}

	/**MySQL접속**/
	public void connectMySQL() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id_mysql, pw_mysql);
			System.out.println("─────────────────────────────────");
			System.out.println("           DB 접속 성공");
			System.out.println("─────────────────────────────────");
		} catch (ClassNotFoundException e) {
			System.out.println("MySQLconnector ERR: " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("MySQLconnector ERR: " + e.getMessage());
		}
	}// connectMySQL() END
	
	/**전체 조회**/
	public void showAll() {
		Statement stmt = null;
		ResultSet rs = null;
		String SHOW_ALL_QUERY  = "select * from menu";	
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SHOW_ALL_QUERY);
			
			while(rs.next()) {
				String rName = rs.getString("rName");
				String mName = rs.getString("mName");
				String mCat = rs.getString("mCat");
				int wTime = rs.getInt("wTime");
				int mPrice = rs.getInt("mPrice");
				
				MenuDataClass.allMenu.add(new MenuClass(rName, mName, mCat, wTime, mPrice));
				
			}
			
		} catch (SQLException e) {
			System.out.println("showAll ERR : " + e.getMessage());
		}
	}//showALL END
	
	/**메모장에 읽어온 데이터 DB에 저장하기**/
	public void insertDB(ArrayList<MenuClass> menuList) {
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(INSERT_QUERY);
			int result = 0;
			int recordCount = 0;
			for(MenuClass menu : menuList) {
			pstmt.setString(1, menu.getrName());
			pstmt.setString(2, menu.getmName());
			pstmt.setString(3, menu.getmCat());
			pstmt.setInt(4, menu.getwTime());
			pstmt.setInt(5, menu.getmPrice());
			result = pstmt.executeUpdate();
			recordCount++;
			}
			System.out.println("─────────────────────────────────");
			System.out.println(recordCount + " 개의 레코드가 DB에 저장되었습니다.");
			System.out.println("─────────────────────────────────");
			
		} catch (SQLException e) {
			System.out.println("SQLException ERR: " + e.getMessage());
		}finally {
			close(pstmt);
		}
	}//insertDB END

	/**DB 저장된 갯수 반환하기**/
	public int DBlength() {
		int dblength = 0;
		Statement stmt = null;
		ResultSet rs = null;
		
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(DB_LENGTH_QUERY);
			
			if(rs.next()) {
				dblength = rs.getInt("DBlength");
			}
		} catch (SQLException e) {
			System.out.println("SQLException ERR :" +e.getMessage());
		}finally {
			close(stmt, rs);
		}
		return dblength;
	}//DBlength() END

	
}//Class END
