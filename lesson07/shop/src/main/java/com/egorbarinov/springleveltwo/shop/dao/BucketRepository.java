package com.egorbarinov.springleveltwo.shop.dao;

import com.egorbarinov.springleveltwo.shop.domain.Bucket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BucketRepository extends JpaRepository<Bucket, Long> {
}
