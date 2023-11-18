package com.org;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class EmpEdit {

	public void edit()	{

		        Connection connection = loginPage.getConnection();

		        try {
		            if (connection != null) {
		                String query = "UPDATE emp SET emp_name = ?, emp_loc = ? WHERE emp_no= ?";
		                
		                Scanner sc = new Scanner(System.in);
		                
		                System.out.println("Enter the ID of the employee to update:");
		                int id = sc.nextInt();
		                sc.nextLine(); 
		                
		                System.out.println("Enter the new name:");
		                String newName = sc.nextLine();
		                
		                System.out.println("Enter the new location:");
		                String newLocation = sc.nextLine();
		                
		                PreparedStatement ps = connection.prepareStatement(query);
		                ps.setString(1, newName);
		                ps.setString(2, newLocation);
		                ps.setInt(3, id);

		                int result = ps.executeUpdate();

		                if (result > 0) {
		                    System.out.println("Employee with ID " + id + " updated successfully!");
		                } else {
		                    System.out.println("Employee with ID " + id + " not found or update failed.");
		                }
		                
		               sc.close();
		            }

		        } catch (Exception e) {
		            System.out.println(e);
		        }
		    }
		

	}
	

