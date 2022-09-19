package com.tripkit.lighthouse.repository;

import com.tripkit.lighthouse.data.entity.Spot;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpotRepository extends JpaRepository<Spot, Long> {

    List<Spot> findAllByCategoryIn(String category, Pageable pageable);
}
