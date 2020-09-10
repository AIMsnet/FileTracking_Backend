package com.ex.file.dto;

import com.ex.file.entity.NotingEntry;
import com.ex.file.entity.NotingEntryForwarded;

public class NotingEntryDto {
	
	private NotingEntry notingEntry;
	
	private NotingEntryForwarded notingEntryForwarded;

	public NotingEntry getNotingEntry() {
		return notingEntry;
	}

	public void setNotingEntry(NotingEntry notingEntry) {
		this.notingEntry = notingEntry;
	}

	public NotingEntryForwarded getNotingEntryForwarded() {
		return notingEntryForwarded;
	}

	public void setNotingEntryForwarded(NotingEntryForwarded notingEntryForwarded) {
		this.notingEntryForwarded = notingEntryForwarded;
	}
}
