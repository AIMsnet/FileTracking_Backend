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
}
