import {Component, OnInit} from '@angular/core';
import {ClientService} from '../Services/client.service';
import {Client} from '../Models/Client.model';
import {NgForOf, NgIf} from '@angular/common';

@Component({
  selector: 'app-client',
  imports: [
    NgIf,
    NgForOf
  ],
  templateUrl: './client.component.html',
  styleUrl: './client.component.css'
})
export class ClientComponent implements OnInit {
  clients: Client[] = [];
  isLoading = false;
  error: string | null = null;

  constructor(private clientService: ClientService) {}

  ngOnInit(): void {
    this.isLoading = true;
    this.clientService.getClients().subscribe({
      next: (data) => {
        this.clients = data;
        this.isLoading = false;
      },
      error: (err) => {
        this.error = 'Erreur lors du chargement des clients.';
        this.isLoading = false;
      }
    });
  }
}
