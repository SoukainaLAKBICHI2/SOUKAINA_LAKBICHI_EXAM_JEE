package org.app.backend;

import org.app.backend.Entities.*;
import org.app.backend.Repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

import static org.app.backend.Entities.TypeBienImmobilier.MAISON;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }


    @Bean
    CommandLineRunner run(ClientRepository clientRepo,
                          CreditPersonnelRepository creditPersonnelRepo,
                          CreditImmobilierRepository creditImmobilierRepo,
                          CreditProfessionnelRepository creditProfessionnelRepo,
                          RemboursementRepository remboursementRepo) {
        return args -> {
            // Créer un client
            Client client = new Client();
            client.setNom("Ali");
            client.setEmail("ali@example.com");
            client = clientRepo.save(client);

            // Créer un crédit personnel
            CreditPersonnel cp = new CreditPersonnel();
            cp.setDateDemande(LocalDate.now().minusDays(5));
            cp.setMontant(10000.0);
            cp.setDureeRemboursement(24);
            cp.setTauxInteret(5.5);
            cp.setStatut(StatutCredit.EN_COURS);
            cp.setMotif("Achat voiture");
            cp.setClient(client);
            cp = creditPersonnelRepo.save(cp);

            // Créer un crédit immobilier
            CreditImmobilier ci = new CreditImmobilier();
            ci.setDateDemande(LocalDate.now().minusDays(10));
            ci.setMontant(200000.0);
            ci.setDureeRemboursement(120);
            ci.setTauxInteret(3.2);
            ci.setStatut(StatutCredit.ACCEPTE);
            ci.setDateAcception(LocalDate.now().minusDays(7));
            TypeBienImmobilier TypeBien = MAISON;
            ci.setTypeBien(TypeBien);
            ci.setClient(client);
            ci = creditImmobilierRepo.save(ci);

            // Créer un crédit professionnel
            CreditProfessionnel cr = new CreditProfessionnel();
            cr.setDateDemande(LocalDate.now().minusDays(15));
            cr.setMontant(50000.0);
            cr.setDureeRemboursement(36);
            cr.setTauxInteret(4.5);
            cr.setStatut(StatutCredit.REJETE);
            cr.setMotif("Matériel entreprise");
            cr.setRaisonSociale("TechCorp SARL");
            cr.setClient(client);
            cr = creditProfessionnelRepo.save(cr);

            // Créer des remboursements pour le crédit personnel
            Remboursement r1 = new Remboursement();
            r1.setCredit(cp);
            r1.setMontant(500.0);
            r1.setDate(LocalDate.now().minusDays(2));
            r1.setType(TypeRemboursement.MENSUALITE);
            remboursementRepo.save(r1);

            Remboursement r2 = new Remboursement();
            r2.setCredit(cp);
            r2.setMontant(2000.0);
            r2.setDate(LocalDate.now().minusDays(1));
            r2.setType(TypeRemboursement.REMBOURSEMENT_ANTICIPE);
            remboursementRepo.save(r2);

            System.out.println("Données initiales enregistrées avec succès !");
        };
    }
}