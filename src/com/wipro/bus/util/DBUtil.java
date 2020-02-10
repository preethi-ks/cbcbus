package com.wipro.bus.util;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.sun.corba.se.pept.transport.Connection;

public class DBUtil {
	private static Connection con;
	public static Connection getDBConnection(){
		if(con==null){
			try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con= (Connection) DriverManager.getConnection("jdbc:oracle:thin:@172.16.100.13:1521:orcl","l17334","pass321");
			}catch(ClassNotFoundException e){
				System.out.println(e);
			}catch(SQLException e){
				System.out.println(e);
			}
		}
		return con;
	}


}
