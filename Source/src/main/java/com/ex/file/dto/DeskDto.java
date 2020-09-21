package com.ex.file.dto;

import com.ex.file.entity.Desk;

public class DeskDto {

	private String sessionId;
	
	private Desk desk;

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public Desk getDesk() {
		return desk;
	}

	public void setDesk(Desk desk) {
		this.desk = desk;
	}
	
	
}
