package com.ex.file.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ex.file.entity.NotingEntry;

@Repository
public interface NotingEntryRepository extends CrudRepository<NotingEntry, Integer>{
	
	public NotingEntry findByNotingEntryId(Integer notingEntryId);
	
	@Query("select m from NotingEntry m where m.fileEntry.fileId=:fileId")
	public List<NotingEntry> findByFileEntry(Integer fileId);
	
	@Query("select max(m.tipniId) from NotingEntry m where m.fileEntry.fileId=:fileId")
	public Integer findMaxTipniIdByFileId(Integer fileId);

}
