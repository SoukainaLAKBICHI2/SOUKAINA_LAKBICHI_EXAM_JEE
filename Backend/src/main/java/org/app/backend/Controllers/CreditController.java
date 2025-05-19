package org.app.backend.Controllers;

import lombok.RequiredArgsConstructor;
import org.app.backend.Entities.Credit;
import org.app.backend.Entities.StatutCredit;
import org.app.backend.Services.CreditService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/credits")
@RequiredArgsConstructor
public class CreditController {
    private final CreditService creditService;

    @GetMapping
    public List<Credit> getAllCredits() {
        return creditService.getAllCredits();
    }

    @GetMapping("/{id}")
    public Credit getCredit(@PathVariable Long id) {
        return creditService.getCreditById(id);
    }

    @GetMapping("/client/{clientId}")
    public List<Credit> getByClientId(@PathVariable Long clientId) {
        return creditService.getCreditsByClientId(clientId);
    }

    @PatchMapping("/{id}/statut")
    public Credit updateStatut(@PathVariable Long id, @RequestParam StatutCredit statut) {
        return creditService.updateStatus(id, statut);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        creditService.deleteCredit(id);
    }
}

