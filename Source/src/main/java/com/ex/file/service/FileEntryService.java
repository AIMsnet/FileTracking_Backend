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
		return fileEntryRepository.findByDeskId(deskId);
	}
	
	public FileEntry saveFileEntry(FileEntry fileEntry) {
		return fileEntryRepository.save(fileEntry);
	}
}
