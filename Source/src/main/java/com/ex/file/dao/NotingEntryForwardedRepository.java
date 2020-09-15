package com.ex.file.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ex.file.entity.NotingEntryForwarded;

@Repository
public interface NotingEntryForwardedRepository extends CrudRepository<NotingEntryForwarded, Integer>{

	@Query("select m from NotingEntryForwarded m where m.desk.deskId=:deskId")
	public List<NotingEntryForwarded> findByDeskId(Integer deskId);
	
	@Query("select m from NotingEntryForwarded m where m.notingEntry.notingEntryId=:notingEntryId")
	public NotingEntryForwarded findByNotingEntryId(Integer notingEntryId);
	
	@Query("select m from NotingEntryForwarded m where m.notingEntry.tipniStatus=:tipniStatus")
	public List<NotingEntryForwarded> findByTipniStatus(String tipniStatus);
}
