package com.investree.testRestAPI.controller;

import com.investree.testRestAPI.model.Barang;
import com.investree.testRestAPI.repository.BarangRepo;
import com.investree.testRestAPI.repository.SupplierRepo;
import com.investree.testRestAPI.view.BarangService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<Map> save(@PathVariable(value = "idsupplier") Long idsupplier, @ResponseBody Barang objModel) {
        Map map = new HashMap<>();
        Map obj = servis.insert(objModel, idsupplier);
        return new ResponseEntity<Map>(obj, HttpStatus.OK);
    }

    @PostMapping("")
}
