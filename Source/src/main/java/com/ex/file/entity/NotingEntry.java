package com.ex.file.entity;

import java.io.Serializable;
import java.sql.Date;
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
@Table(name="noting_entry")
public class NotingEntry implements Serializable{
	public static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="noting_entry_id")
    private Integer notingEntryId;
	
	@Column(name="tipni_id")
    private Integer tipniId;
	
	@Column(name="letter_reference")
	private String letterReference;
	
	@Column(name="letter_date")
	private Date letterDate;
	
	@Column(name="tipni_subject")
	private String tipniSubject;
	
	@Column(name="tipni_details")
	private String tipniDetails;
	
	@Column(name="page_no_of_remark_in_tipni")
	private Integer pageNoOfRemarkInTipni;
	
	@Column(name="page_no_of_supporting_docs")
	private Integer pageNoOfSupportingDocs;
	
	@Column(name="tipni_status")
	private String tipniStatus;
	
	@Column(name="created_by")
	private String createdBy;
	
	@Column(name="created_date")
	private String createdDate;
	
	@Column(name="updated_by")
	private String updatedBy;
	
	@Column(name="updated_date")
	private String updaeDate;
	
	@ManyToOne
	@JoinColumn(name="file_id")
	private FileEntry fileEntry;
	
	@JsonIgnore
	@OneToMany(mappedBy="notingEntry")
    private List<NotingEntryForwarded> notingEntryForwarded;

	public Integer getNotingEntryId() {
		return notingEntryId;
	}

	public void setNotingEntryId(Integer notingEntryId) {
		this.notingEntryId = notingEntryId;
	}

	public Integer getTipniId() {
		return tipniId;
	}

	public void setTipniId(Integer tipniId) {
		this.tipniId = tipniId;
	}

	public String getLetterReference() {
		return letterReference;
	}

	public void setLetterReference(String letterReference) {
		this.letterReference = letterReference;
	}

	public Date getLetterDate() {
		return letterDate;
	}

	public void setLetterDate(Date letterDate) {
		this.letterDate = letterDate;
	}

	public String getTipniSubject() {
		return tipniSubject;
	}

	public void setTipniSubject(String tipniSubject) {
		this.tipniSubject = tipniSubject;
	}

	public String getTipniDetails() {
		return tipniDetails;
	}

	public void setTipniDetails(String tipniDetails) {
		this.tipniDetails = tipniDetails;
	}

	public Integer getPageNoOfRemarkInTipni() {
		return pageNoOfRemarkInTipni;
	}

	public void setPageNoOfRemarkInTipni(Integer pageNoOfRemarkInTipni) {
		this.pageNoOfRemarkInTipni = pageNoOfRemarkInTipni;
	}

	public Integer getPageNoOfSupportingDocs() {
		return pageNoOfSupportingDocs;
	}

	public void setPageNoOfSupportingDocs(Integer pageNoOfSupportingDocs) {
		this.pageNoOfSupportingDocs = pageNoOfSupportingDocs;
	}

	public String getTipniStatus() {
		return tipniStatus;
	}

	public void setTipniStatus(String tipniStatus) {
		this.tipniStatus = tipniStatus;
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

	public FileEntry getFileEntry() {
		return fileEntry;
	}

	public void setFileEntry(FileEntry fileEntry) {
		this.fileEntry = fileEntry;
	}

	public List<NotingEntryForwarded> getNotingEntryForwarded() {
		return notingEntryForwarded;
	}

	public void setNotingEntryForwarded(List<NotingEntryForwarded> notingEntryForwarded) {
		this.notingEntryForwarded = notingEntryForwarded;
	}
}
