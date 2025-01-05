package com.jpacourse.persistence.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jpacourse.persistence.entity.AddressEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.entity.VisitEntity;

import java.time.LocalDateTime;

@Repository
public interface PatientDao extends Dao<PatientEntity, Long>{

}
