import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Credit } from '../Models/Credit.model';

@Injectable({
  providedIn: 'root'
})
export class CreditService {
  private apiUrl = 'http://localhost:8084/credits';

  constructor(private http: HttpClient) {}

  getAll(): Observable<Credit[]> {
    return this.http.get<Credit[]>(this.apiUrl);
  }

  getById(id: number): Observable<Credit> {
    return this.http.get<Credit>(`${this.apiUrl}/${id}`);
  }

  create(credit: Credit): Observable<Credit> {
    return this.http.post<Credit>(this.apiUrl, credit);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }

  update(id: number, credit: Credit): Observable<Credit> {
    return this.http.put<Credit>(`${this.apiUrl}/${id}`, credit);
  }
}
