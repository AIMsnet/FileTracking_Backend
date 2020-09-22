package com.ex.file.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ex.file.entity.FileEntry;

@Repository
public interface FileEntryRepository extends CrudRepository<FileEntry, Integer>{
	
	@Query("select m from FileEntry m where m.desk.deskId=:deskId")
	public List<FileEntry> findByDeskId(Integer deskId);
	
	@Query("select m from FileEntry m where m.fileId=:fileId")
	public FileEntry findByFileId(Integer fileId);
	
	@Query("select m from FileEntry m where m.fileStringId=:fileStringId")
	public FileEntry findByFileStringId(String fileStringId);
	
	@Query("select count(m)from FileEntry m where m.fileStatus=:fileStatus")
	public Integer records(String fileStatus);
}
