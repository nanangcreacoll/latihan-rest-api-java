package com.investree.testRestAPI.view.impl;

import com.investree.testRestAPI.model.Barang;
import com.investree.testRestAPI.model.BarangDetail;
import com.investree.testRestAPI.model.Supplier;
import com.investree.testRestAPI.repository.BarangDetailRepo;
import com.investree.testRestAPI.repository.BarangRepo;
import com.investree.testRestAPI.repository.SupplierRepo;
import com.investree.testRestAPI.view.BarangService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service @Transactional
public class BarangImpl implements BarangService {
    @Autowired
    public BarangRepo repo;
    @Autowired
    public SupplierRepo repoSupp;
    @Autowired
    public BarangDetailRepo repoDetailBarang;

    @Override
    public Map getAll() {
        List<Barang> list = new ArrayList<Barang>();
        Map map = new HashMap();
        try {
            list = repo.getList();
            map.put("data", list);
            map.put("statusCode", 200);
            map.put("statusMessage", "Get Sukses");
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("statusCode", "500");
            map.put("statusMessage", e);
            return map;
        }
    }
    @Override
    public Map findByNama(String nama, Integer page, Integer size) {
        Map map = new HashMap();
        try {
            Pageable show_data = PageRequest.of(page, size);
            Page<Barang> list = repo.findByNama(nama, show_data);

            map.put("data", list);
            map.put("statusCode", 200);
            map.put("statusMessage", "Get Sukses");
            return map;
        } catch(Exception e) {
            e.printStackTrace();
            map.put("statusCode", "500");
            map.put("statusMessage", e);
            return map; //error
        }
    }
    @Override
    public Page<Barang> findByNamaLike(String nama, Pageable pageable) {
        return null;
    }
    @Override
    public Map insert(Barang barang, Long idsupplier) {
        Map map = new HashMap();
        try {
            Supplier supp = repoSupp.getbyID(idsupplier);
            barang.setSupplier(supp);
            BarangDetail detailbarang = repoDetailBarang.save(barang.getDetail());
        } catch () {

        }
    }

}
