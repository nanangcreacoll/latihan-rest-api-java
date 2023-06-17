package com.investree.testRestAPI.controller;

import com.investree.testRestAPI.model.Barang;
import com.investree.testRestAPI.repository.BarangRepo;
import com.investree.testRestAPI.repository.SupplierRepo;
import com.investree.testRestAPI.view.BarangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController @RequestMapping("/v1/barang")
public class BarangController {
    @Autowired
    public BarangRepo repo;

    @Autowired
    public SupplierRepo repoSupp;

    @Autowired
    BarangService servis;

    @GetMapping("/listPage") @ResponseBody
    public ResponseEntity<Map> getList() {
        Map c = servis.getAll();
        return new ResponseEntity<Map>(c, HttpStatus.OK);
    }

    @PostMapping("/save/{idsupplier}")
    public ResponseEntity<Map> save(@PathVariable(value = "idsupplier") Long idsupplier, @RequestBody Barang objModel) {
        Map map = new HashMap<>();
        Map obj = servis.insert(objModel, idsupplier);
        return new ResponseEntity<Map>(obj, HttpStatus.OK);
    }

    @PostMapping("/update/{idsupplier}")
    public ResponseEntity<Map> update(@PathVariable(value = "idsupplier") Long idsupplier, @RequestBody Barang objModel) {
        Map map = servis.update(objModel, idsupplier);
        return new ResponseEntity<Map>(map, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map> delete(@PathVariable(value = "id") Long id) {
        Map map = servis.delete(id);
        return new ResponseEntity<Map>(map, HttpStatus.OK);
    }

    @GetMapping("/listByNama")
    public ResponseEntity<Page<Barang>> listByNama(
            @RequestParam() Integer page,
            @RequestParam() Integer size,
            @RequestParam() String nama
    ) {
        Pageable show_data = PageRequest.of(page, size);
        Page<Barang> list = repo.findByNama(nama, show_data);
        return new ResponseEntity<Page<Barang>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/listByNamaLike")
    public ResponseEntity<Page<Barang>> listByNamaLike(
            @RequestParam() Integer page,
            @RequestParam() Integer size,
            @RequestParam() String nama
    ) {
        Pageable show_data = PageRequest.of(page,size);
        Page<Barang> list = repo.findByNamaLike("%" + nama + "%", show_data);
        return new ResponseEntity<Page<Barang>>(list, new HttpHeaders(), HttpStatus.OK);
    }
}
