package com.org;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class EmpAdd {
	
	public void add() {
		
		Connection connection = loginPage.getConnection();
		
		try {
			
            if (connection != null) {
                String query = "insert into emp values(? , ? , ?)";
                
                Scanner sc = new Scanner(System.in);
                
                System.out.println("enter ID");
                int id = sc.nextInt();
                System.out.println("enter name");
                sc.nextLine();
                String name = sc.nextLine();
                System.out.println("enter location");
                String loc = sc.nextLine();
                
                PreparedStatement ps = connection.prepareStatement(query);

                ps.setInt(1, id);
                ps.setString(2, name);
                ps.setString(3, loc);
                
                int result = ps.executeUpdate();

                if (result > 0) {
                    System.out.println("Employee added successfully!");
                } else {
                    System.out.println("Failed to add employee.");
                }
                
            }
		
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
}
