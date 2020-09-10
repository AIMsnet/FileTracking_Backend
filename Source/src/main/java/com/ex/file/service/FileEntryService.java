package com.ex.file.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.file.dao.FileEntryRepository;
import com.ex.file.entity.FileEntry;

@Service
@Transactional
public class FileEntryService {
	
	@Autowired
	private FileEntryRepository fileEntryRepository;

	public List<FileEntry> getFileEntryByDeskId(Integer deskId){
		System.out.println("desk");
		return fileEntryRepository.findByDeskId(deskId);
	}
	
	public FileEntry saveUpdateFileEntry(FileEntry fileEntry) {
		FileEntry fileSave=fileEntryRepository.save(fileEntry);
		String fileStringId=null;
		FileEntry fileEntryData=fileEntryRepository.findByFileId(fileSave.getFileId());
		if(!fileEntryData.equals(null)) {
			
			fileStringId="File-"+fileEntryData.getFileId();
			fileEntryData.setFileStringId(fileStringId);
			fileEntryRepository.save(fileEntryData);
		}
		return fileEntryData;
	}
	
	public FileEntry getFileEntryByFilestringId(String fileStringId){
		return fileEntryRepository.findByFileStringId(fileStringId);
	}
}
