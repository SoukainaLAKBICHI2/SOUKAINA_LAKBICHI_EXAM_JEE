import {Component, OnInit} from '@angular/core';
import {NgForOf, NgIf} from '@angular/common';
import {Remboursement} from '../Models/remborcement.model';
import {RemboursementService} from "../Services/remborcement.service"

@Component({
  selector: 'app-remborsement',
  imports: [
    NgIf,
    NgForOf
  ],
  templateUrl: './remborsement.component.html',
  styleUrl: './remborsement.component.css'
})
export class RemboursementComponent implements OnInit {
  remboursements: Remboursement[] = [];
  isLoading = true;
  error: string | null = null;

  constructor(private remboursementService: RemboursementService) {}

  ngOnInit(): void {
    this.remboursementService.getAll().subscribe({
      next: (data: Remboursement[]) => {
        this.remboursements = data;
        this.isLoading = false;
      },
      error: () => {
        this.error = 'Erreur lors du chargement';
        this.isLoading = false;
      }
    });
  }
}
