package com.cg.onlineexamination.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.onlineexamination.entity.Exam;
import com.cg.onlineexamination.entity.TestPaper;

public interface TestPaperRepository extends JpaRepository<TestPaper,Integer>{

}
