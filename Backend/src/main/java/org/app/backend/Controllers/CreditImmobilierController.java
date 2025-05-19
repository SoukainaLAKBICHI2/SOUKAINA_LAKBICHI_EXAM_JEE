package org.app.backend.Controllers;

import lombok.RequiredArgsConstructor;
import org.app.backend.Entities.CreditImmobilier;
import org.app.backend.Services.CreditImmobilierService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/credits/immobiliers")
@RequiredArgsConstructor
public class CreditImmobilierController {
    private final CreditImmobilierService service;

    @GetMapping
    public List<CreditImmobilier> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public CreditImmobilier getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping("/client/{clientId}")
    public CreditImmobilier create(@RequestBody CreditImmobilier credit, @PathVariable Long clientId) {
        return service.save(credit, clientId);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
