import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Item } from 'src/models/Item';
import { BehaviorSubject, Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class CartService {
  selectedItems: BehaviorSubject<Item[]> = new BehaviorSubject<Item[]>([]);

  constructor(private http: HttpClient) {
    this.http
      .get<Item[]>(`${environment.apiEndpoint}/Cart`)
      .subscribe((data: any) => {
        this.selectedItems.next(data);
      });
  }

  getCart(): Observable<Item[]> {
    return this.selectedItems.asObservable();
  }

  emptyCart(): Observable<Item[]> {
    this.http
      .put(`${environment.apiEndpoint}/Cart`, null)
      .subscribe((data: any) => {
        this.selectedItems.next(data);
      });
    return this.getCart();
  }

  addItemToCart(item: Item): Observable<Item[]> {
    this.http
      .post(`${environment.apiEndpoint}/Cart`, item.id)
      .subscribe((data: any) => {
        this.selectedItems.next(data);
      });
    return this.getCart();
  }
}
