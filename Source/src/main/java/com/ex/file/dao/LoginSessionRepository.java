package com.ex.file.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ex.file.entity.LoginSession;

@Repository
public interface LoginSessionRepository extends CrudRepository<LoginSession, Integer>{
	
	public LoginSession findBySessionId(String sessionId);

}
