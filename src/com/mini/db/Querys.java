package com.mini.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class Querys {
	public static final String INSERT_QUERY = "Insert into menu(rName,mName,mCat,wTime,mPrice) values(?,?,?,?,?)"; // db에 insret로 데이터 넣어주는 쿼리 문
	public static final String DB_LENGTH_QUERY = "select count(*) as DBlength from menu";
	public Querys() {
		// TODO Auto-generated constructor stub
	}
	/** 자원 해제 메서드들 : Overloading 기법 **/
	public void close(Statement stmt, ResultSet rs) {
		try {
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Statement, ResultSet CLOSE  ERR : " + e.getMessage());
		}
	} // close() END

	public void close(PreparedStatement pstmt, ResultSet rs) {
		try {
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			System.out.println("PreparedStatement, ResultSet  CLOSE  ERR : " + e.getMessage());
		}
	} // close() END

	public void close(PreparedStatement pstmt) {
		try {
			pstmt.close();
		} catch (SQLException e) {
			System.out.println("PreparedStatement  CLOSE  ERR : " + e.getMessage());
		}
	} // close() END

	public void close(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.println("Connection  CLOSE  ERR : " + e.getMessage());
		}
	} // close() END

}
