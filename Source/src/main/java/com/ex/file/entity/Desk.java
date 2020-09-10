package com.ex.file.entity;

import java.io.Serializable;
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
	
	@Column(name="designation")
	private String designation;
	
	@Column(name="mobile_number")
	private Integer mobileNumber;
	
	@ManyToOne
	@JoinColumn(name="department_id")
	private Department department;
	
	@JsonIgnore
	@OneToMany(mappedBy="desk")
    private List<FileEntry> fileEntry;
	
	@JsonIgnore
	@OneToMany(mappedBy="desk")
    private List<NotingEntryForwarded> notingEntryForwarded;

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

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Integer getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Integer mobileNumber) {
		this.mobileNumber = mobileNumber;
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
}
