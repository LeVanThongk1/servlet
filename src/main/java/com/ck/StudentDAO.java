package com.ck;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class StudentDAO {
	public static Connection getConnection () {
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test5?characterEncoding=utf8", "root","12345" );
		} catch (Exception e) {
			System.out.println(e);
		
		}
		return con;
	}

	public static int save(Student e) {
		int status = 0;
		try {
			Connection con = StudentDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into  user1(name,password,subject) Values (?,?,?)");
			ps.setString(1, e.getName());
			ps.setString(2, e.getPassword());
			ps.setString(3, e.getSubject());
			status = ps.executeUpdate();
			con.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return status;
	}
	public static List<Student> getAllStudents() {
		List<Student> list = new ArrayList<Student>();
		try {
			Connection con = StudentDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from user1");
			ResultSet rs= ps.executeQuery();
			while (rs.next()) {
				Student e = new Student();
			e.setId(rs.getInt(1));
			e.setName(rs.getString(2));
			e.setPassword(rs.getString(3));
			e.setSubject(rs.getString(4));
			list.add(e);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public static int update(Student e) {
		int status = 0;
		try {
			Connection con = StudentDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("update user1 set name=?,password=?,subject=? where id=?");
			ps.setInt(4, e.getId());
			ps.setString(1, e.getName());
			ps.setString(2, e.getPassword());
			ps.setString(3, e.getSubject());
			status = ps.executeUpdate();
			con.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return status;
	}
	public static int delete(int id) {
		int status = 0;
		try {
			Connection con = StudentDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from user1 where id=?");
			ps.setInt(1, id);
			status = ps.executeUpdate();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	public static Student  getStudentById(int id) {
		Student e = new Student();
		try {
			Connection con = StudentDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from user1 where id=?");
			ps.setInt(1, id);
			ResultSet rs= ps.executeQuery();
			if(rs.next()) {
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setPassword(rs.getString(3));
				e.setSubject(rs.getString(4));
			}
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return e;
	}
}
