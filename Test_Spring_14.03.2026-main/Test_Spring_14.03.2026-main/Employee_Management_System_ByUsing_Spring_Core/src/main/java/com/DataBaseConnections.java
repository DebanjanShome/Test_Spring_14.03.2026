package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ComponentScan(basePackages = "com")
@PropertySource("com/application.properties")
public class DataBaseConnections {
	/*root*/

	@Value("${mysqlurl}")
	private String url;
	@Value("${mysqlusername}")
	private String Username;
	@Value("${mysqlpassword}")
	private String Password;
	@Value("${mysqlDriverClass}")
	private String Driverclassname;
	public Connection mysqlDbCoonection() {
		System.out.println("This is for Mysql connection.");
		
		try {
			Class.forName(Driverclassname);
			return DriverManager.getConnection(url, Username, Password);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
			
		public void oracleDbConnection() {
			
			try {
				Class.forName(Driverclassname);
				DriverManager.getConnection(url, Username, Password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		@Override
		public String toString() {
			return "DataBaseConnections [url=" + url + ", Username=" + Username + ", Password=" + Password
					+ ", Driverclassname=" + Driverclassname + "]";
		}
		
	}
