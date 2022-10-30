package com.tripkit.lighthouse.repository;

import com.tripkit.lighthouse.data.entity.SpotDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpotDetailRepository extends JpaRepository<SpotDetail, Long> {
}
