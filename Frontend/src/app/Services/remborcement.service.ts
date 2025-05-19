
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Remboursement } from '../Models/remborcement.model';

@Injectable({
  providedIn: 'root'
})
export class RemboursementService {
  private apiUrl = 'http://localhost:8080/api/remboursements'; // Adapt to your backend endpoint

  constructor(private http: HttpClient) {}

  getAll(): Observable<Remboursement[]> {
    return this.http.get<Remboursement[]>(this.apiUrl);
  }

  getById(id: number): Observable<Remboursement> {
    return this.http.get<Remboursement>(`${this.apiUrl}/${id}`);
  }

  create(remboursement: Remboursement): Observable<Remboursement> {
    return this.http.post<Remboursement>(this.apiUrl, remboursement);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }

  update(id: number, remboursement: Remboursement): Observable<Remboursement> {
    return this.http.put<Remboursement>(`${this.apiUrl}/${id}`, remboursement);
  }
}
