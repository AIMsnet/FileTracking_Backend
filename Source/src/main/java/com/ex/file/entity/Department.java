package com.ex.file.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="department")
public class Department implements Serializable{
	public static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="department_id")
    private Integer departmentId;
	
	@Column(name="department_name")
	private String departmentName;
	
	@JsonIgnore
	@OneToMany(mappedBy="department")
    private List<Desk> desk;

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public List<Desk> getDesk() {
		return desk;
	}

	public void setDesk(List<Desk> desk) {
		this.desk = desk;
	}	
}
