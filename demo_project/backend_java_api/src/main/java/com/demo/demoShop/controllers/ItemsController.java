package com.demo.demoShop.controllers;

import com.demo.demoShop.models.ItemDTO;
import com.demo.demoShop.services.ItemsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ItemsController {

    private final ItemsService itemsService;

    @GetMapping("/Items")
    public List<ItemDTO> getItems() {
        return itemsService.getItems();
    }

    @GetMapping("/Items/{id}")
    public ItemDTO getItemById(@PathVariable int id) {
        return itemsService.getItemById(id);
    }

    @PostMapping("/Items")
    public ItemDTO addItem(@RequestBody ItemDTO item) {
        return itemsService.addItem(item);
    }

    @PutMapping("/Items/{id}")
    public ItemDTO updateItem(@PathVariable int id, @RequestBody ItemDTO item) {
        return itemsService.updateItem(id, item);
    }
}
