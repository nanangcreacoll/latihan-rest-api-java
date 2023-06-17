package com.investree.testRestAPI.repository;

import com.investree.testRestAPI.model.Pembeli;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PembeliRepo extends PagingAndSortingRepository<Pembeli, Long> {
    @Query("select c from pembeli c")
    public List<Pembeli> getList();

}
