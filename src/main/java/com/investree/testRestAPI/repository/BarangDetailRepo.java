package com.investree.testRestAPI.repository;

import com.investree.testRestAPI.model.BarangDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarangDetailRepo extends JpaRepository<BarangDetail, Long> {
}
