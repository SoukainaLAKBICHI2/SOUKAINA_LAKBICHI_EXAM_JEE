package org.app.backend.Controllers;

import lombok.RequiredArgsConstructor;
import org.app.backend.Entities.CreditProfessionnel;
import org.app.backend.Services.CreditProfessionnelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/credits/professionnels")
@RequiredArgsConstructor
public class CreditProfessionnelController {
    private final CreditProfessionnelService service;

    @GetMapping
    public List<CreditProfessionnel> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public CreditProfessionnel getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping("/client/{clientId}")
    public CreditProfessionnel create(@RequestBody CreditProfessionnel credit, @PathVariable Long clientId) {
        return service.save(credit, clientId);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
