package com.example.cashregister.service;

import com.example.cashregister.model.Item;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CashRegisterService {
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public List<Item> getItems() {
        return items;
    }

    public double getTotalSum() {
        return items.stream().mapToDouble(Item::getTotalPrice).sum();
    }

    public void clearItems() {
        items.clear();
    }
}
