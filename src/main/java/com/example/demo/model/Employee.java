package com.example.demo.model;

import lombok.Data;

import org.springframework.data.annotation.Id;





import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name = "name")
    private String name;

    @Column(name = "position")
    private String position;

    @Column(name = "salary")
    private double salary;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
}