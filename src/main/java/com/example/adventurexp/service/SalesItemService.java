package com.example.adventurexp.service;

import com.example.adventurexp.model.SalesItem;
import com.example.adventurexp.repositories.SalesItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalesItemService {

    @Autowired
    private SalesItemRepo salesItemRepo;

    //Henter alle produkter
    public List<SalesItem> findAll() {
        return salesItemRepo.findAll();
    }

    public SalesItem saveSalesItem(SalesItem salesItem) { return salesItemRepo.save(salesItem); }

    public SalesItem updateSalesItemPrice(int id, int price){
        Optional<SalesItem> existingSalesItemOpt = salesItemRepo.findById(id);

        if (existingSalesItemOpt.isPresent()) {
            SalesItem existingSalesItem = existingSalesItemOpt.get();
            existingSalesItem.setPrice(price);
            return salesItemRepo.save(existingSalesItem);
        }else {
            throw new IllegalArgumentException("Produkt med id " + id + " blev ikke fundet.");
        }
    }
}
