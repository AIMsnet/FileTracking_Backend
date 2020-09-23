package com.ex.file.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="desk")
public class Desk implements Serializable{
	public static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="desk_id")
    private Integer deskId;
	
	@Column(name="desk_name")
	private String deskName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="desk_holder")
	private String deskHolder;
	
	@Column(name="created_by")
	private String createdBy;
	
	@Column(name="updated_by")
	private String updatedBy;
	
	@Column(name="created_date")
	private Timestamp createdDate;
	
	@Column(name="updated_date")
	private Timestamp updatedDate;
	
	@ManyToOne
	@JoinColumn(name="department_id")
	private Department department;
	
	@JsonIgnore
	@OneToMany(mappedBy="desk")
    private List<FileEntry> fileEntry;
	
	@JsonIgnore
	@OneToMany(mappedBy="desk")
    private List<NotingEntryForwarded> notingEntryForwarded;
	
	@JsonIgnore
	@OneToMany(mappedBy="desk")
    private List<EmployeeDetails> employeeDetails;

	public Integer getDeskId() {
		return deskId;
	}

	public void setDeskId(Integer deskId) {
		this.deskId = deskId;
	}

	public String getDeskName() {
		return deskName;
	}

	public void setDeskName(String deskName) {
		this.deskName = deskName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDeskHolder() {
		return deskHolder;
	}

	public void setDeskHolder(String deskHolder) {
		this.deskHolder = deskHolder;
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

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<FileEntry> getFileEntry() {
		return fileEntry;
	}

	public void setFileEntry(List<FileEntry> fileEntry) {
		this.fileEntry = fileEntry;
	}

	public List<NotingEntryForwarded> getNotingEntryForwarded() {
		return notingEntryForwarded;
	}

	public void setNotingEntryForwarded(List<NotingEntryForwarded> notingEntryForwarded) {
		this.notingEntryForwarded = notingEntryForwarded;
	}

	public List<EmployeeDetails> getEmployeeDetails() {
		return employeeDetails;
	}

	public void setEmployeeDetails(List<EmployeeDetails> employeeDetails) {
		this.employeeDetails = employeeDetails;
	}
}
