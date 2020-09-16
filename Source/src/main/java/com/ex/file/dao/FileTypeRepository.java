package com.ex.file.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ex.file.entity.FileType;

@Repository
public interface FileTypeRepository extends CrudRepository<FileType, Integer>{

}
