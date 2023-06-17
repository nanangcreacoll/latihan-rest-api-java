package com.investree.testRestAPI.repository;

import com.investree.testRestAPI.model.PembeliDetail;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PembeliDetailRepo extends PagingAndSortingRepository<PembeliDetail, Long> {
}
