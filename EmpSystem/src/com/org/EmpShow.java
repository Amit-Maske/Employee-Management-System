package com.org;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmpShow {

	public void show() {
		Connection connection = loginPage.getConnection();
		
		try {
			
            if (connection != null) {
                String query = "select * from emp";
            
                Statement stmt = connection.createStatement();
    			
    			ResultSet set = stmt.executeQuery(query);
    			
    			while(set.next()) {
    				int id = set.getInt("emp_no");
    				System.out.print(id +  "    |");
    				
    				String name = set.getString("emp_name"); 
    				System.out.print(name +  "    |");
    			
    				String loc = set.getString("emp_loc");
    				System.out.println(loc);

    			}
            }
	}catch(Exception e) {
		System.out.println(e);
	}
		
	}
}