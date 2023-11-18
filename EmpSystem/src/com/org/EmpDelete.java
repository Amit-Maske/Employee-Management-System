package com.org;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class EmpDelete {

public void delete() {
		
		Connection connection = loginPage.getConnection();
		
		try {
			
            if (connection != null) {
                String query = "delete from emp where emp_no = ?";
                
                Scanner sc = new Scanner(System.in);
                
                EmpShow es = new EmpShow();
                es.show();
                
                System.out.println("enter ID");
                int id = sc.nextInt();
                               
                PreparedStatement ps = connection.prepareStatement(query);

                ps.setInt(1, id);
                                
                int result = ps.executeUpdate();

                if (result > 0) {
                    System.out.println("Employee deleted successfully!");
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

	

