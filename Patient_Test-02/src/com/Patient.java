package com;

import DBconnection.DB;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


import java.io.IOException; 
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner; 


public class Patient {
	
	DB dbobj1 = new DB();
	
	public String insertPatient(String patfirst, String patlname, String patemail, String patage, String patmobile, String patpassword) {
		
		String output = "";
		
		try {
			Connection con = dbobj1.connect();
			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}
			// create a prepared statement
			
		
			String query = "insert into user (`Uid`,`first`,`lname`,`email`,`age`,`mobile`,`password`)" + " values (?, ?, ?, ?, ?, ?, ?)";
			
		
			
			
			
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			
			
			//run up to here
			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, patfirst);
			preparedStmt.setString(3, patlname);
			preparedStmt.setString(4, patemail);
			preparedStmt.setInt(5, Integer.parseInt(patage));
			preparedStmt.setInt(6, Integer.parseInt(patmobile));
			preparedStmt.setString(7, patpassword);
			
			System.out.println("inide innnsertd");
			
			// execute the statement
			preparedStmt.execute();
			con.close();
			
		
			
			String newPatients = readPatient(); 
			output = "{\"status\":\"success\", \"data\": \"" +   
			newPatients + "\"}"; 
			
			
			//output = "Inserted successfully To Patient";
			System.out.println("Inserted successfully To Patient");
			
		} catch (Exception e) {
			output = "{\"status\":\"error\", \"data\":    "
					+ "     \"Error while inserting the Patient.\"}"; 
			System.err.println(e.getMessage()); 
		}
		return output;
	}

	
	
	public String readPatient() {
		String output = "";
		try {
			
			Connection con = dbobj1.connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			
			
			// Prepare the html table to be displayed
			output = "<table border=\"1\"><th>ID</th><th>First</th><th>lname</th><th>email</th><th>age</th><th>mobile</th><th>password</th><th>Update</th><th>Remove</th>";
			String query = "select * from user";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			// iterate through the rows in the result set
			
			
			while (rs.next()) {
				
				String Uid = Integer.toString(rs.getInt("Uid"));
				String first = rs.getString("first");
				String lname = rs.getString("lname");
				String email = rs.getString("email");
				String age = Integer.toString(rs.getInt("age"));
				String mobile = Integer.toString(rs.getInt("mobile"));
				String password = rs.getString("password");
				
				
				// Add into the html table
				
				output += "<tr><td><input id='hidPatientIDUpdate'"
						+ "       name='hidPatientIDUpdate' type='hidden'  "
						+ "      value='" + Uid + "'>" + Uid + "</td>";
				
				
				output += "<td>" + first + "</td>";
				output += "<td>" + lname + "</td>";
				output += "<td>" + email + "</td>";
				output += "<td>" + age + "</td>";
				output += "<td>" + mobile + "</td>";
				output += "<td>" + password + "</td>";
				
				
				// buttons   
				output += "<td><input name='btnUpdate'"
						+ " type='button'" + "value='Update'  "
						+ "         class='btnUpdate btn btn-secondary'></td>"
						+ "      <td><input name='btnRemove' type='button'      "
						+ " value='Remove'      "
						+ "     class='btnRemove btn btn-danger' data-Uid='" 
						+ Uid + "'>" + "</td></tr>"; 
				
				
			}
			con.close();
			// Complete the html table
			output += "</table>";
			
		} catch (Exception e) {
			output = "Error while reading the patients.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String updatePatient(String patUid, String patfirst, String patlname	, String patemail, String patage, String patmobile, String patpassword) {
		String output = "";
		
		try {
			Connection con = dbobj1.connect();
			if (con == null) {
				return "Error while connecting to the database for updating.";
			}
			
					
			// create a prepared statement
			
			String query = "UPDATE user SET first=?,lname=?,email=?,age=?,mobile=?,password=? WHERE Uid=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			
			
			// binding values
			preparedStmt.setString(1, patfirst);
			preparedStmt.setString(2, patlname);
			preparedStmt.setString(3, patemail);
			preparedStmt.setString(4, patage);
			preparedStmt.setInt(5, Integer.parseInt(patmobile));
			preparedStmt.setString(6, patpassword);
			preparedStmt.setInt(7, Integer.parseInt(patUid));
			
			
			
			// execute the statement
			preparedStmt.execute();
			con.close();
			
			//output = "Updated successfully";
			
			
			String newPatients = readPatient();  
			output = "{\"status\":\"success\", \"data\": \"" +     
			newPatients + "\"}"; 
			
			System.out.println("Update Successfully");
			
		} catch (Exception e) {
			output = "{\"status\":\"error\", \"data\":    "
					+ "     \"Error while updating the patienttt.\"}";  
			System.err.println(e.getMessage()); 
		}
		return output;
	}
			
	
	
	public String deletePatient(String Uid) {
		
		String output = "";
		
		try {
			Connection con = dbobj1.connect();
			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}
			
			// create a prepared statement
			String query ="delete from user where Uid=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			// binding values
			preparedStmt.setInt(1, Integer.parseInt(Uid));
			
			System.out.println("BBBBBB");
			
			// execute the statement
			preparedStmt.execute();
			con.close();
			
			
			
			String newPatients = readPatient();  
			output = "{\"status\":\"success\", \"data\": \"" +    
			newPatients + "\"}"; 
			
			
			//output = "Deleted successfully";
			System.out.println("Deleted successfully");
			
			
			
			
		} catch (Exception e) {
			
			output = "{\"status\":\"error\", \"data\":      "
					+ "   \"Error while deleting the patient.\"}";  
			System.err.println(e.getMessage()); 
		}
		return output;
	}
	
	

}
