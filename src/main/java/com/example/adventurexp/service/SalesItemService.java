package com.example.adventurexp.service;

import com.example.adventurexp.model.SalesItem;
import com.example.adventurexp.repositories.SalesItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalesItemService {

    @Autowired
    private SalesItemRepo salesItemRepo;

    public SalesItem saveSalesItem(SalesItem salesItem) { return salesItemRepo.save(salesItem); }
}
