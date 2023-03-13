package com.demo.demoShop.controllers;

import com.demo.demoShop.models.ItemDTO;
import com.demo.demoShop.services.CartService;
import com.demo.demoShop.services.ItemsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;
    private final ItemsService itemsService;

    @GetMapping("/Cart")
    public List<ItemDTO> getCart() {
        return cartService.getCart();
    }

    @PostMapping("/Cart")
    public List<ItemDTO> addItemToCart(@RequestBody int id) {
        return cartService.addItemToCart(itemsService.getItemById(id));
    }

    @PutMapping("/Cart")
    public List<ItemDTO> clearCart() {
        return cartService.clearCart();
    }
}
