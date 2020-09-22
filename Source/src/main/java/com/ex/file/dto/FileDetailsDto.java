package com.ex.file.dto;

public class FileDetailsDto {

	private Integer totalCreatedFiles;
	
	private Integer totalReceivedFiles;
	
	private Integer totalForwordOrSentFiles;
	
	private Integer totalPendingFiles;
	
	private Integer totalClosedFiles;

	public Integer getTotalCreatedFiles() {
		return totalCreatedFiles;
	}

	public void setTotalCreatedFiles(Integer totalCreatedFiles) {
		this.totalCreatedFiles = totalCreatedFiles;
	}

	public Integer getTotalReceivedFiles() {
		return totalReceivedFiles;
	}

	public void setTotalReceivedFiles(Integer totalReceivedFiles) {
		this.totalReceivedFiles = totalReceivedFiles;
	}

	public Integer getTotalForwordOrSentFiles() {
		return totalForwordOrSentFiles;
	}

	public void setTotalForwordOrSentFiles(Integer totalForwordOrSentFiles) {
		this.totalForwordOrSentFiles = totalForwordOrSentFiles;
	}

	public Integer getTotalPendingFiles() {
		return totalPendingFiles;
	}

	public void setTotalPendingFiles(Integer totalPendingFiles) {
		this.totalPendingFiles = totalPendingFiles;
	}

	public Integer getTotalClosedFiles() {
		return totalClosedFiles;
	}

	public void setTotalClosedFiles(Integer totalClosedFiles) {
		this.totalClosedFiles = totalClosedFiles;
	}
}
