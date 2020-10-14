package com.egorbarinov.springleveltwo.shop.service;


import com.egorbarinov.springleveltwo.shop.domain.Bucket;
import com.egorbarinov.springleveltwo.shop.domain.User;
import com.egorbarinov.springleveltwo.shop.dto.BucketDto;

import java.util.List;

public interface BucketService {
    Bucket createBucket(User user, List<Long> productIds);

    void addProducts(Bucket bucket, List<Long> productIds);

    BucketDto getBucketByUser(String name);
}
