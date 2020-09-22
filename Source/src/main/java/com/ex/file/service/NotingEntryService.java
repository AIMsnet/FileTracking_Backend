package com.ex.file.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.file.dao.FileEntryRepository;
import com.ex.file.dao.LoginSessionRepository;
import com.ex.file.dao.NotingEntryForwardedRepository;
import com.ex.file.dao.NotingEntryRepository;
import com.ex.file.dto.NotingEntryDto;
import com.ex.file.entity.FileEntry;
import com.ex.file.entity.LoginSession;
import com.ex.file.entity.NotingEntry;
import com.ex.file.entity.NotingEntryForwarded;

@Service
@Transactional
public class NotingEntryService {

	@Autowired
	private NotingEntryRepository notingEntryRepository;

	@Autowired
	private NotingEntryForwardedRepository notingEntryForwardedRepository;
	
	@Autowired
	private LoginSessionRepository loginSessionRepository; 
	
	@Autowired
	private FileEntryRepository fileEntryRepository;
	
	@PersistenceContext
	private EntityManager em;

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

	public List<NotingEntry> getNotingEntryByDeskId(String sessionId) {
		LoginSession loginSession = loginSessionRepository.findBySessionId(sessionId);
		Integer deskId=loginSession.getDeskId();
		List<NotingEntry> notingEntryList = new ArrayList<NotingEntry>();
		Query q = em.createNativeQuery("SELECT n.* FROM file_entry AS f " + 
				"inner join noting_entry AS n " + 
				"ON n.file_id=f.file_id " + 
				"where desk_id = "+deskId+" ");
		List<Object[]> objArrayList = q.getResultList();
		for(Object[] obj : objArrayList) {
			NotingEntry notingEntry = new NotingEntry();
			FileEntry fileEntry = fileEntryRepository.findByFileId(Integer.parseInt(obj[2].toString()));
			notingEntry.setNotingEntryId(Integer.parseInt(obj[0].toString()));
			notingEntry.setTipniId(Integer.parseInt(obj[1].toString()));
			notingEntry.setFileEntry(fileEntry);
			notingEntry.setLetterReference(obj[3].toString());
			notingEntry.setLetterDate((Date) obj[4]);
			notingEntry.setTipniSubject(obj[5].toString());
			notingEntry.setTipniDetails(obj[6].toString());
			notingEntry.setPageNoOfRemarkInTipni(Integer.parseInt(obj[7].toString()));
			notingEntry.setPageNoOfSupportingDocs(Integer.parseInt(obj[8].toString()));
			notingEntry.setTipniStatus(obj[9].toString());
			notingEntry.setCreatedBy(obj[10].toString());
			notingEntry.setCreatedDate((Timestamp) obj[11]);
			notingEntry.setUpdatedBy(obj[12] !=null ? obj[12].toString() : null);
			notingEntry.setUpdaeDate(obj[13]!=null ? (Timestamp) obj[13] : null);
			notingEntryList.add(notingEntry);
		}
		return notingEntryList;
	}
	
	public List<NotingEntryForwarded> getNotingEntryByTipniStatus(String status){
		return notingEntryForwardedRepository.findByTipniStatus(status);
	}
}
