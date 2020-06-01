package com.qst.note.util;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class DBUtil {
static String dbName = "notedemo";
static String name = "root";
static String pass = "225110";

public static void main(String[] args) {
 Connection c =	getConnection();
 try{
	 Statement st = (Statement) c.createStatement();
	 st.execute("insert into user(name,password) value('zhangsan','123')");
	 close(c,st,null);
 }catch(SQLException e){
	 e.printStackTrace();
 }
}

public static  Connection getConnection(){
	Connection c = null;
	try{
		Class.forName("com.mysql.jdbc.Driver");
		 c = (Connection) DriverManager.getConnection
				 ("jdbc:mysql://localhost:3306/"+dbName+"?ssl=true", name, pass);
	}catch(ClassNotFoundException e){
		e.printStackTrace();
	}catch(SQLException e){
		e.printStackTrace();
	}
	return c;
}

public static void close(Connection c,Statement stat,ResultSet rs){
	if (rs != null) {
		try{
			rs.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	if(stat != null){
		try{
			stat.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	if(c != null){
		try{
			c.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}


}
