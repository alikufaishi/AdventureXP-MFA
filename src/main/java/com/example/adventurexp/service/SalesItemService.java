package com.example.adventurexp.service;

import com.example.adventurexp.model.SalesItem;
import com.example.adventurexp.repositories.SalesItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesItemService {

    @Autowired
    private SalesItemRepo salesItemRepo;

    //Henter alle produkter
    public List<SalesItem> findAll() {
        return salesItemRepo.findAll();
    }

    public SalesItem saveSalesItem(SalesItem salesItem) { return salesItemRepo.save(salesItem); }

    public List<SalesItem> findByType(String type) {
        return salesItemRepo.findByType(type);
    }
}
