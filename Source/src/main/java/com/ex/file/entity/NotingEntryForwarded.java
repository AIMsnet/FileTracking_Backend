package com.ex.file.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="noting_entry_forwarded")
public class NotingEntryForwarded implements Serializable{
	public static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
    private Integer id;
	
	@ManyToOne
	@JoinColumn(name="noting_entry_id")
	private NotingEntry notingEntry;
	
	@ManyToOne
	@JoinColumn(name="department_id")
	private Department department;
	
	@ManyToOne
	@JoinColumn(name="desk_id")
	private Desk desk;
	
	@Column(name="desk_reason")
	private String deskReason;
	
	@Column(name="escape_desk")
    private Integer escapeDesk;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public NotingEntry getNotingEntry() {
		return notingEntry;
	}

	public void setNotingEntry(NotingEntry notingEntry) {
		this.notingEntry = notingEntry;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Desk getDesk() {
		return desk;
	}

	public void setDesk(Desk desk) {
		this.desk = desk;
	}

	public String getDeskReason() {
		return deskReason;
	}

	public void setDeskReason(String deskReason) {
		this.deskReason = deskReason;
	}

	public Integer getEscapeDesk() {
		return escapeDesk;
	}

	public void setEscapeDesk(Integer escapeDesk) {
		this.escapeDesk = escapeDesk;
	}
}
