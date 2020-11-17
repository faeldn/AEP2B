package com.github.faeldn.aep.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class FactoryJDBC {
	
	public static Connection criaConn() {
		Connection conn = null;
		try {
			String path = System.getProperty("user.dir");
			String url = "jdbc:sqlite:" + path + "/database/datab.db";
			conn = DriverManager.getConnection(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

}
