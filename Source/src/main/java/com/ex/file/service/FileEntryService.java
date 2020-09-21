package com.ex.file.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.file.dao.DeskRepository;
import com.ex.file.dao.FileEntryRepository;
import com.ex.file.entity.Desk;
import com.ex.file.entity.FileEntry;

@Service
@Transactional
public class FileEntryService {
	
	@Autowired
	private FileEntryRepository fileEntryRepository;
	
	@Autowired
	private DeskRepository deskRepository;
	
    public List<FileEntry> getFileEntryByDeskId(String sessionid){
		Integer deskId=LoginService.LoginSession(sessionid);
		return fileEntryRepository.findByDeskId(deskId);
	}
	
	public FileEntry saveUpdateFileEntry(FileEntry fileEntry, String sessionid) {
		Integer deskId=LoginService.LoginSession(sessionid);
		Desk desk = deskRepository.findByDeskId(deskId);
		FileEntry entry = null;
		if(desk!=null) {
			fileEntry.setDesk(desk);
			FileEntry fileSave=fileEntryRepository.save(fileEntry);
			FileEntry fileEntryData=fileEntryRepository.findByFileId(fileSave.getFileId());
			if(fileEntryData!=null) {
				String fileStringId="File-"+fileEntryData.getFileId();
				fileEntryData.setFileStringId(fileStringId);
				entry = fileEntryRepository.save(fileEntryData);
			}
		}
		return entry;
	}
	
	public FileEntry getFileEntryByFilestringId(String fileStringId){
		return fileEntryRepository.findByFileStringId(fileStringId);
	}
}
