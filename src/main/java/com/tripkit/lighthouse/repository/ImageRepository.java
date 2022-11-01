package com.tripkit.lighthouse.repository;

import com.tripkit.lighthouse.data.entity.images.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
}
