export interface Remboursement {
  id: number;
  date: string; // ou Date
  montant: number;
  type: 'Mensualité' | 'Remboursement anticipé';
}
