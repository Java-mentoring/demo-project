import { Component, OnInit } from '@angular/core';
import { Item } from 'src/models/Item';
import { CartService } from './cart.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css'],
})
export class CartComponent implements OnInit {
  cart: Item[] = [];
  counter: number = 0;

  constructor(private cartService: CartService) {}

  ngOnInit(): void {
    this.cartService.getCart().subscribe((items) => {
      this.cart = items;
      this.counter = this.cart.length;
    });
  }

  emptyCart(): void {
    this.cartService.emptyCart();
    this.counter = 0;
  }
}
