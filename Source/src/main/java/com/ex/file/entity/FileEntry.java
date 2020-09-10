package com.ex.file.entity;

import java.io.Serializable;
import java.sql.Date;
import java.time.Year;
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
@Table(name="file_entry")
public class FileEntry implements Serializable{
	public static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="file_id")
    private Integer fileId;
	
	@Column(name="file_created_year")
	private String fileCreatedYear;
	
	@Column(name="file_date")
	private Date fileDate;
	
	@Column(name="file_type")
	private String fileType;
	
	@Column(name="manual_file_no")
	private Integer manualFileNo;
	
	@Column(name="file_subject")
	private String fileSubject;
	
	@Column(name="file_details")
	private String fileDetails;
	
	@Column(name="total_pages_of_tipani")
	private String totalPagesOfTipani;
	
	@Column(name="total_pages_of_attached_docs")
	private String totalPagesOfAttachedDocs;
	
	@Column(name="file_status")
	private String fileStatus;
	
	@Column(name="created_by")
	private String createdBy;
	
	@Column(name="created_date")
	private String createdDate;
	
	@Column(name="updated_by")
	private String updatedBy;
	
	@Column(name="updated_date")
	private String updaeDate;
	
	@ManyToOne
	@JoinColumn(name="desk_id")
	private Desk desk;
	
	@JsonIgnore
	@OneToMany(mappedBy="fileEntry")
    private List<NotingEntry> notingEntry;

	public Integer getFileId() {
		return fileId;
	}

	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}

	public String getFileCreatedYear() {
		return fileCreatedYear;
	}

	public void setFileCreatedYear(String fileCreatedYear) {
		this.fileCreatedYear = fileCreatedYear;
	}

	public Date getFileDate() {
		return fileDate;
	}

	public void setFileDate(Date fileDate) {
		this.fileDate = fileDate;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public Integer getManualFileNo() {
		return manualFileNo;
	}

	public void setManualFileNo(Integer manualFileNo) {
		this.manualFileNo = manualFileNo;
	}

	public String getFileSubject() {
		return fileSubject;
	}

	public void setFileSubject(String fileSubject) {
		this.fileSubject = fileSubject;
	}

	public String getFileDetails() {
		return fileDetails;
	}

	public void setFileDetails(String fileDetails) {
		this.fileDetails = fileDetails;
	}

	public String getTotalPagesOfTipani() {
		return totalPagesOfTipani;
	}

	public void setTotalPagesOfTipani(String totalPagesOfTipani) {
		this.totalPagesOfTipani = totalPagesOfTipani;
	}

	public String getTotalPagesOfAttachedDocs() {
		return totalPagesOfAttachedDocs;
	}

	public void setTotalPagesOfAttachedDocs(String totalPagesOfAttachedDocs) {
		this.totalPagesOfAttachedDocs = totalPagesOfAttachedDocs;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getUpdaeDate() {
		return updaeDate;
	}

	public void setUpdaeDate(String updaeDate) {
		this.updaeDate = updaeDate;
	}

	public Desk getDesk() {
		return desk;
	}

	public void setDesk(Desk desk) {
		this.desk = desk;
	}

	public String getFileStatus() {
		return fileStatus;
	}

	public void setFileStatus(String fileStatus) {
		this.fileStatus = fileStatus;
	}

	public List<NotingEntry> getNotingEntry() {
		return notingEntry;
	}

	public void setNotingEntry(List<NotingEntry> notingEntry) {
		this.notingEntry = notingEntry;
	}
}
