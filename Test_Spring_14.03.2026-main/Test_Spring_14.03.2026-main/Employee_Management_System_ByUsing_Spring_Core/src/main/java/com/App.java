package com;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    
    {
    	ApplicationContext context = 
    			new AnnotationConfigApplicationContext(DataBaseConnections.class);
    	EmployeeDataBaseOperation emp =
                context.getBean(EmployeeDataBaseOperation.class);

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== EMPLOYEE DATABASE MENU =====");
            System.out.println("1. Insert Employee");
            System.out.println("2. Get All Employees");
            System.out.println("3. Get Employee By ID");
            System.out.println("4. Update Salary By DeptNo");
            System.out.println("5. Delete Employee By ID");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    emp.insertEmployeeDetails();
                    break;

                case 2:
                    emp.getAllEmployees();
                    break;

                case 3:
                    emp.getEmployeeById();
                    break;

                case 4:
                    emp.updateSalaryByDeptNo();
                    break;

                case 5:
                    emp.deleteEmployeeById();
                    break;

                case 6:
                    System.out.println("Exiting Program...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
    }