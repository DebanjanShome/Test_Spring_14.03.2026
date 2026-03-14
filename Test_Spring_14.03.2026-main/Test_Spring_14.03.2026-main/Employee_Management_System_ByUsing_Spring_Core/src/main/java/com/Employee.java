package com;

public class Employee {

    private int id;
    private String name;
    private String deptno;
    private double salary;

    public Employee() {
    }

    public Employee(String name, String deptno, double salary) {
        this.name = name;
        this.deptno = deptno;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public String getDeptno() {
		return deptno;
	}

	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}

	public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}