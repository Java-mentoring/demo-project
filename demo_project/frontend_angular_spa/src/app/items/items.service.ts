import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Item } from 'src/models/Item';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class ItemsService {
  constructor(private http: HttpClient) {}

  getItems(): Observable<Item[]> {
    return this.http.get<Item[]>(`${environment.apiEndpoint}/Items`);
  }

  getItem(id: number): Observable<Item> {
    return this.http.get<Item>(`${environment.apiEndpoint}/Items/${id}`);
  }
}
