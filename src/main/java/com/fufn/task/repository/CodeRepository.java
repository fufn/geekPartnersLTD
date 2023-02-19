package com.fufn.task.repository;

import com.fufn.task.entity.Code;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface CodeRepository extends JpaRepository<Code, Long> {

    Code findTopByOrderByIdDesc();
}
