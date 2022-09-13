package com.tripkit.lighthouse.repository;

import com.tripkit.lighthouse.data.entity.Line;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineRepository extends JpaRepository<Line, Long> {
}
