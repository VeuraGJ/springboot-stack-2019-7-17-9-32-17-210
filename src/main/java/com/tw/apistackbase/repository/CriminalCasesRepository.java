package com.tw.apistackbase.repository;


import com.tw.apistackbase.entity.CriminalCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;


public interface CriminalCasesRepository extends JpaRepository<CriminalCase,Long> {
    List<CriminalCase> findAllByCaseName(String caseName);
}
