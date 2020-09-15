package com.ex.file.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.file.dao.NotingEntryForwardedRepository;
import com.ex.file.dao.NotingEntryRepository;
import com.ex.file.dto.NotingEntryDto;
import com.ex.file.entity.NotingEntry;
import com.ex.file.entity.NotingEntryForwarded;

@Service
@Transactional
public class NotingEntryService {

	@Autowired
	private NotingEntryRepository notingEntryRepository;

	@Autowired
	private NotingEntryForwardedRepository notingEntryForwardedRepository;

	public NotingEntryForwarded saveNotingEntry(NotingEntryDto dto) {
		List<NotingEntry> list = notingEntryRepository.findByFileEntry(dto.getNotingEntry().getFileEntry().getFileId());
		NotingEntry notingEntry = new NotingEntry();
		if (list.isEmpty()) {
			notingEntry.setTipniId(1);
		} else {
			Integer maxTipniId = notingEntryRepository.findMaxTipniIdByFileId(dto.getNotingEntry().getFileEntry().getFileId());
			notingEntry.setTipniId(maxTipniId + 1);
		}
		notingEntry.setCreatedBy(dto.getNotingEntry().getCreatedBy());
		notingEntry.setCreatedDate(dto.getNotingEntry().getCreatedDate());
		notingEntry.setFileEntry(dto.getNotingEntry().getFileEntry());
		notingEntry.setLetterDate(dto.getNotingEntry().getLetterDate());
		notingEntry.setLetterReference(dto.getNotingEntry().getLetterReference());
		notingEntry.setPageNoOfRemarkInTipni(dto.getNotingEntry().getPageNoOfRemarkInTipni());
		notingEntry.setPageNoOfSupportingDocs(dto.getNotingEntry().getPageNoOfSupportingDocs());
		notingEntry.setTipniDetails(dto.getNotingEntry().getTipniDetails());
		notingEntry.setTipniSubject(dto.getNotingEntry().getTipniSubject());
		notingEntry.setUpdaeDate(dto.getNotingEntry().getUpdaeDate());
		notingEntry.setUpdatedBy(dto.getNotingEntry().getUpdatedBy());
		notingEntry.setTipniStatus("Saved");
		NotingEntry parent = notingEntryRepository.save(notingEntry);
		NotingEntryForwarded notingEntryForwarded = new NotingEntryForwarded();
		notingEntryForwarded.setDepartment(dto.getNotingEntryForwarded().getDepartment());
		notingEntryForwarded.setDesk(dto.getNotingEntryForwarded().getDesk());
		notingEntryForwarded.setNotingEntry(parent);
		notingEntryForwarded.setDeskReason(dto.getNotingEntryForwarded().getDeskReason());
		notingEntryForwarded.setEscapeDesk(dto.getNotingEntryForwarded().getEscapeDesk());
		return notingEntryForwardedRepository.save(notingEntryForwarded);
	}

	public NotingEntry forwardedNotingEntry(NotingEntryDto dto) {
		NotingEntry notingEntry = notingEntryRepository.findByNotingEntryId(dto.getNotingEntry().getNotingEntryId());
		if (notingEntry != null) {
			notingEntry.setCreatedBy(dto.getNotingEntry().getCreatedBy());
			notingEntry.setCreatedDate(dto.getNotingEntry().getCreatedDate());
			notingEntry.setFileEntry(dto.getNotingEntry().getFileEntry());
			notingEntry.setLetterDate(dto.getNotingEntry().getLetterDate());
			notingEntry.setLetterReference(dto.getNotingEntry().getLetterReference());
			notingEntry.setPageNoOfRemarkInTipni(dto.getNotingEntry().getPageNoOfRemarkInTipni());
			notingEntry.setPageNoOfSupportingDocs(dto.getNotingEntry().getPageNoOfSupportingDocs());
			notingEntry.setTipniDetails(dto.getNotingEntry().getTipniDetails());
			notingEntry.setTipniSubject(dto.getNotingEntry().getTipniSubject());
			notingEntry.setUpdaeDate(dto.getNotingEntry().getUpdaeDate());
			notingEntry.setUpdatedBy(dto.getNotingEntry().getUpdatedBy());
			notingEntry.setTipniStatus("Forwarded");
			NotingEntry parent = notingEntryRepository.save(notingEntry);
			NotingEntryForwarded notingEntryForwarded = notingEntryForwardedRepository
					.findByNotingEntryId(notingEntry.getNotingEntryId());
			notingEntryForwarded.setDepartment(dto.getNotingEntryForwarded().getDepartment());
			notingEntryForwarded.setDesk(dto.getNotingEntryForwarded().getDesk());
			notingEntryForwarded.setNotingEntry(parent);
			notingEntryForwarded.setDeskReason(dto.getNotingEntryForwarded().getDeskReason());
			notingEntryForwarded.setEscapeDesk(dto.getNotingEntryForwarded().getEscapeDesk());
			notingEntryForwardedRepository.save(notingEntryForwarded);
		}
		return notingEntry;
	}

	public List<NotingEntryForwarded> getNotingEntryByDeskId(Integer deskId) {
		return notingEntryForwardedRepository.findByDeskId(deskId);
	}
	
	public List<NotingEntryForwarded> getNotingEntryByTipniStatus(String status){
		return notingEntryForwardedRepository.findByTipniStatus(status);
	}
}
