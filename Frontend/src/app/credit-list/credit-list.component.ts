import { Component, OnInit } from '@angular/core';
import { Credit } from '../Models/Credit.model';
import { CreditService } from '../Services/credit.service';
import {NgForOf, NgIf} from '@angular/common';

@Component({
  selector: 'app-credit-list',
  imports: [
    NgIf,
    NgForOf
  ],
  templateUrl: './credit-list.component.html'
})
export class CreditListComponent implements OnInit {
  credits: Credit[] = [];
  isLoading = false;
  error = '';

  constructor(private creditService: CreditService) {}

  ngOnInit(): void {
    this.fetchCredits();
  }

  fetchCredits(): void {
    this.isLoading = true;
    this.creditService.getAll().subscribe({
      next: data => {
        this.credits = data;
        this.isLoading = false;
      },
      error: err => {
        this.error = 'Erreur lors du chargement des crédits';
        this.isLoading = false;
      }
    });
  }
}
