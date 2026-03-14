package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan(basePackages = "com")
public class EmployeeDataBaseOperation {

    @Autowired
    DataBaseConnections dataBaseConnections;

    Scanner sc = new Scanner(System.in);

    // 1️⃣ Insert Employee
    public void insertEmployeeDetails() {

        try {

            Connection con = dataBaseConnections.mysqlDbCoonection();
            System.out.println("Connection Established");

            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Employee Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Employee Salary: ");
            double salary = sc.nextDouble();

            System.out.print("Enter Employee Deptno: ");
            int deptno = sc.nextInt();

            String query = "INSERT INTO employee (Employee_id, Employee_name, Employee_salary, Employee_Deptno) VALUES (?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setDouble(3, salary);
            ps.setInt(4, deptno);

            int result = ps.executeUpdate();

            if (result > 0) {
                System.out.println("Employee inserted successfully");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 2️⃣ Get All Employees
    public void getAllEmployees() {

        try {

            Connection con = dataBaseConnections.mysqlDbCoonection();

            String query = "SELECT * FROM employee";

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println("ID: " + rs.getInt("Employee_id"));
                System.out.println("Name: " + rs.getString("Employee_name"));
                System.out.println("Salary: " + rs.getDouble("Employee_salary"));
                System.out.println("DeptNo: " + rs.getInt("Employee_Deptno"));
                System.out.println("-------------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 3️⃣ Get Employee By ID
    public void getEmployeeById() {

        try {

            Connection con = dataBaseConnections.mysqlDbCoonection();

            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();

            String query = "SELECT * FROM employee WHERE Employee_id=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("ID: " + rs.getInt("Employee_id"));
                System.out.println("Name: " + rs.getString("Employee_name"));
                System.out.println("Salary: " + rs.getDouble("Employee_salary"));
                System.out.println("DeptNo: " + rs.getInt("Employee_Deptno"));

            } else {
                System.out.println("Employee not found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 4️⃣ Update Salary Using DeptNo
    public void updateSalaryByDeptNo() {

        try {

            Connection con = dataBaseConnections.mysqlDbCoonection();

            System.out.print("Enter Department No: ");
            int deptno = sc.nextInt();

            System.out.print("Enter New Salary: ");
            double salary = sc.nextDouble();

            String query = "UPDATE employee SET Employee_salary=? WHERE Employee_Deptno=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setDouble(1, salary);
            ps.setInt(2, deptno);

            int result = ps.executeUpdate();

            if (result > 0) {
                System.out.println("Salary updated successfully");
            } else {
                System.out.println("No employees found in this department");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 5️⃣ Delete Employee By ID
    public void deleteEmployeeById() {

        try {

            Connection con = dataBaseConnections.mysqlDbCoonection();

            System.out.print("Enter Employee ID to delete: ");
            int id = sc.nextInt();

            String query = "DELETE FROM employee WHERE Employee_id=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);

            int result = ps.executeUpdate();

            if (result > 0) {
                System.out.println("Employee deleted successfully");
            } else {
                System.out.println("Employee not found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}