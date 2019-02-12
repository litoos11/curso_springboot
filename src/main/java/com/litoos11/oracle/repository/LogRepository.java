package com.litoos11.oracle.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.litoos11.oracle.entity.Log;

@Repository("logRepository")
public interface LogRepository extends JpaRepository<Log, Serializable> {

}
