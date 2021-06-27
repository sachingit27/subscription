package com.sac.subscription.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sac.subsscription.entity.Order;
import com.sac.subsscription.entity.Userprofile;

@Repository
public class Subsdao {

	Connection conn = null;
	Statement stat = null;

	public String addUserProfile(Userprofile usr) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/subscriber", "root", "root");
		PreparedStatement psmt = conn
				.prepareStatement("insert into userprofile(firstname,lastname,address,email,pass) values(?,?,?,?,?)");
		psmt.setString(1, usr.getFirstname());
		psmt.setString(2, usr.getLastname());
		psmt.setString(3, usr.getAddress());
		psmt.setString(4, usr.getEmail());
		psmt.setString(5, usr.getPass());
		int i = psmt.executeUpdate();
		if (i > 0) {

			return "Record insert successfully";
		} else {
			return "Record not inserted in table";
		}

	}

	public List<Userprofile> showUsers() {

		List<Userprofile> userProfileList = new ArrayList<>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/subscriber", "root", "root");
			Statement stmt = conn.createStatement();
			String sql = "Select * from userprofile";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {

				Userprofile userprofile = new Userprofile();

				userprofile.setUid(rs.getInt("uid"));
				userprofile.setFirstname(rs.getString("firstname"));
				userprofile.setLastname(rs.getString("lastname"));
				userprofile.setAddress(rs.getString("address"));
				userprofile.setEmail(rs.getString("email"));
				userprofile.setPass(rs.getString("pass"));

				userProfileList.add(userprofile);

			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return userProfileList;
	}

	public String enrollMember(Order order) {

		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/subscriber", "root", "root");
			Connection conn2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/subscriber", "root", "root");
			Statement stmt = conn.createStatement();
			String sql = "Select * from userprofile where email='" + order.getEmailid() + "'";
			String sql2 = "Insert into membership(firstname,lastname,email,startdt,enddt) values(?,?,?,?,?)";
			PreparedStatement psmt = conn2.prepareStatement(sql2);
			System.out.println(1);
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println(2);
			while (rs.next()) {

				String fname = rs.getString("firstname");
				String lname = rs.getString("lastname");

				psmt.setString(1, fname);
				psmt.setString(2, lname);
				psmt.setString(3, order.getEmailid());
				psmt.setString(4, order.getStartDate());
				psmt.setString(5, order.getEndDate());

				psmt.executeUpdate();
				System.out.println(4);
			}

		}

		catch (ClassNotFoundException e) {
			e.printStackTrace();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return "User enrolled in Membership table";

	}

}
