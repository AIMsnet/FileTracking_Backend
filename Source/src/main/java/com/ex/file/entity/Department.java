package com.ex.file.entity;

import java.io.Serializable;
import java.sql.Timestamp;
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
	
	@Column(name="location")
	private String location;
	
	@Column(name="hod_of_department")
	private String hodOfDepartment;
	
	@Column(name="created_by")
	private String createdBy;
	
	@Column(name="updated_by")
	private String updatedBy;
	
	@Column(name="created_date")
	private Timestamp createdDate;
	
	@Column(name="updated_date")
	private Timestamp updatedDate;
	
	@JsonIgnore
	@OneToMany(mappedBy="department")
    private List<Desk> desk;
	
	@JsonIgnore
	@OneToMany(mappedBy="department")
    private List<NotingEntryForwarded> notingEntryForwarded;
	
	@JsonIgnore
	@OneToMany(mappedBy="department")
    private List<EmployeeDetails> employeeDetails;

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

	public List<NotingEntryForwarded> getNotingEntryForwarded() {
		return notingEntryForwarded;
	}

	public void setNotingEntryForwarded(List<NotingEntryForwarded> notingEntryForwarded) {
		this.notingEntryForwarded = notingEntryForwarded;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getHodOfDepartment() {
		return hodOfDepartment;
	}

	public void setHodOfDepartment(String hodOfDepartment) {
		this.hodOfDepartment = hodOfDepartment;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Timestamp getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}

	public List<EmployeeDetails> getEmployeeDetails() {
		return employeeDetails;
	}

	public void setEmployeeDetails(List<EmployeeDetails> employeeDetails) {
		this.employeeDetails = employeeDetails;
	}	
}
