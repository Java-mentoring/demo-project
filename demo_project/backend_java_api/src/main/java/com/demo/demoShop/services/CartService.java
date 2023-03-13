package com.demo.demoShop.services;

import com.demo.demoShop.models.ItemDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {

    private static final List<ItemDTO> Cart = new ArrayList<ItemDTO>(
            List.of(
                    new ItemDTO(99, "Ship", "DHL", 15)
            )
    );

    public List<ItemDTO> getCart() {
        return Cart;
    }

    public List<ItemDTO> addItemToCart(ItemDTO item) {
        Cart.add(item);
        return Cart;
    }

    public List<ItemDTO> clearCart() {
        Cart.clear();
        this.addItemToCart(new ItemDTO(99, "Ship", "DHL", 15));
        return Cart;
    }
}
