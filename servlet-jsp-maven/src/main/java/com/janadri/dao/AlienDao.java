package com.janadri.dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.janadri.model.Alien;

public class AlienDao {

	public Alien getAlien(int aid) {
	Alien a = new Alien();
//	a.setAid(1);
//	a.setAname("Veeru");
//	a.setTech("Java");
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itachi","root","itachi");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from alien where aid="+aid);
		if(rs.next()) {
			a.setAid(rs.getInt("aid"));
			a.setAname(rs.getString("aname"));
			a.setTech(rs.getString("tech"));
		}
	} catch (Exception e) {
		System.out.println(e);
	}
	return a;
	
}
}
