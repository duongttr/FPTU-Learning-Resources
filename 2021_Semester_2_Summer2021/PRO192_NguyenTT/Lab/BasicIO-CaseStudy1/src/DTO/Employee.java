package DTO;

public class Employee implements Comparable<Employee> {

    private String code;
    private String name;
    private int salary;

    public Employee(String code, String name, int salary) {
        this.code = code;
        this.name = name;
        this.salary = salary;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void print() {
        System.out.format("Code: %s - Name: %s - Salary: %d", code, name, salary);
    }

    @Override
    public int compareTo(Employee o) {
        return getCode().compareTo(o.getCode());
    }

}
