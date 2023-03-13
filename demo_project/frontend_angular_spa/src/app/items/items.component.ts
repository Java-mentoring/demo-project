import { Component, Input, OnInit } from '@angular/core';
import { Item } from 'src/models/Item';
import { CartService } from '../cart/cart.service';
import { ItemsService } from './items.service';

@Component({
  selector: 'app-items',
  templateUrl: './items.component.html',
  styleUrls: ['./items.component.css'],
})
export class ItemsComponent implements OnInit {
  @Input() item: Item;

  items: Item[] = [];

  constructor(
    private itemsService: ItemsService,
    private cartService: CartService
  ) {}

  ngOnInit(): void {
    this.itemsService.getItems().subscribe((items) => {
      this.items = items;
    });
  }

  addItemToCart(artykul: Item) {
    this.cartService.addItemToCart(artykul);
  }
}
