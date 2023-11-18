package com.org;

import java.util.Scanner;
import java.sql.*;

public class loginPage {
    private static final String url = "jdbc:mysql://localhost:3306/practice";
    private static final String un = "root";
    private static final String pass = "";

    public static Connection getConnection() {
        Connection connection = null;
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, un, pass);
            System.out.println("Connecting.........");
        } catch (Exception e) {
            System.out.println(e);
        }
        return connection;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter UserName: ");
        String username = sc.nextLine();
        System.out.println("Enter Password");
        String password = sc.nextLine();

        Connection connection = getConnection();

        try {
            if (connection != null) {
                String query = "SELECT * FROM admin";
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                boolean found = false;

                while (rs.next()) {
                    String unfromdb = rs.getString("user_name");
                    String passfromdb = rs.getString("PASSWORD");

                    if (unfromdb.equals(username) && passfromdb.equals(password)) {
                        System.out.println("Connected successfully");
                        System.out.println("......................................................");
                        System.out.println("choose your choice");
                        System.out.println("-------->");
                        System.out.println("1. show Details...");
                        System.out.println("2. Add Employee...");
                        System.out.println("3. Delete Employee...");
                        System.out.println("4. Edit Employee...");
                        
                        System.out.println("0. Exit!...");
                        
                        int choice = sc.nextInt();
                        
                        switch(choice) {
                        case 1:
                        	System.out.println("For show details");
                        	EmpShow es = new EmpShow();
                        	es.show();
                        	break;
                        case 2:
                        	System.out.println("Adding emp");
                        	EmpAdd ea = new EmpAdd();
                        	ea.add();
                        	break;
                        case 3:
                        	System.out.println("for delete emp");
                        	EmpDelete ed = new EmpDelete();
                        	ed.delete();
                        	break;
                        case 4:
                        	System.out.println("for edit emp");
                        	EmpEdit ee =new EmpEdit();
                        	ee.edit();
                        	break;
                        case 0:
                        	System.out.println("exit");
                        	break;
                        default:
                        	System.out.println("wrong choice");
                        	break;
                        }
                        
                    
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Invalid credentials");
                }

                stmt.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        sc.close();
    }
}
