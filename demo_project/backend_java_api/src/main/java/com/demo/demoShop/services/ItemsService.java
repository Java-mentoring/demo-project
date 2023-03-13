package com.demo.demoShop.services;

import com.demo.demoShop.models.ItemDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemsService {

    private static final List<ItemDTO> items = new ArrayList<ItemDTO>(
            List.of(
                    new ItemDTO(1, "Phone 10", "128 GB", 1000),
                    new ItemDTO(2, "Phone 11", "256 GB", 2000),
                    new ItemDTO(3, "Phone 11 Pro", "512 GB", 3000),
                    new ItemDTO(4, "Phone 10 Max", "1 TB", 4000),
                    new ItemDTO(5, "Phone 12 Pro Max", "256 GB", 5000),
                    new ItemDTO(6, "Phone 13 Ultra", "128 GB", 6000),
                    new ItemDTO(7, "Phone 12 Minimum", "256 GB", 7000),
                    new ItemDTO(8, "Phone 11 Minimum Max", "512 GB", 8000),
                    new ItemDTO(9, "Phone 14 Pro Minimum", "256 GB", 9000)
            )
    );

    public List<ItemDTO> getItems() {
        return items;
    }

    public ItemDTO getItemById(int id) {
        return items.stream().filter(item -> item.getId() == id).findFirst().orElse(null);
    }

    public ItemDTO addItem(ItemDTO item) {
        item.setId(items.stream().max(Comparator.comparingInt(ItemDTO::getId)).get().getId() + 1);
        System.out.println(item.getId());
        items.add(item);
        return item;
    }

    public ItemDTO updateItem(int id, ItemDTO item) {
        ItemDTO itemToUpdate = items.stream().filter(i -> i.getId() == id).findFirst().orElse(null);
        if (itemToUpdate != null) {
            itemToUpdate.setName(item.getName());
            itemToUpdate.setDescription(item.getDescription());
            itemToUpdate.setPrice(item.getPrice());
        }
        return itemToUpdate;
    }
}
