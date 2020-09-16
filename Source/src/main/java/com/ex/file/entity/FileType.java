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
@Table(name="file_type")
public class FileType implements Serializable{
	public static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="file_type_id")
    private Integer fileTypeId;
	
	@Column(name="file_type")
	private String fileType;
	
	@JsonIgnore
	@OneToMany(mappedBy="fileType")
    private List<FileEntry> fileEntry;

	public Integer getFileTypeId() {
		return fileTypeId;
	}

	public void setFileTypeId(Integer fileTypeId) {
		this.fileTypeId = fileTypeId;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public List<FileEntry> getFileEntry() {
		return fileEntry;
	}

	public void setFileEntry(List<FileEntry> fileEntry) {
		this.fileEntry = fileEntry;
	}
}
