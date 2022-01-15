package org.com.gen;
//JDBC Template
public class Employee {
private int Id;
private String name;
private int salary;
public int getId() {
	return Id;
}
public void setId(int id) {
	Id = id;
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
@Override
public String toString() {
	return "Employee [Id=" + Id + ", name=" + name + ", salary=" + salary + "]";
}

}
