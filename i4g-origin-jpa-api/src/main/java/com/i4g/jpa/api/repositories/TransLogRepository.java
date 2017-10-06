package com.i4g.jpa.api.repositories;

import com.i4g.jpa.api.entities.TransLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransLogRepository extends JpaRepository<TransLog, Long>{
}
