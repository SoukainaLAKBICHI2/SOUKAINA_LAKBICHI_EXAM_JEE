package org.app.backend.Controllers;

import lombok.RequiredArgsConstructor;
import org.app.backend.Entities.CreditPersonnel;
import org.app.backend.Services.CreditPersonnelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/credits/personnels")
@RequiredArgsConstructor
public class CreditPersonnelController {
    private final CreditPersonnelService service;

    @GetMapping
    public List<CreditPersonnel> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public CreditPersonnel getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping("/client/{clientId}")
    public CreditPersonnel create(@RequestBody CreditPersonnel credit, @PathVariable Long clientId) {
        return service.save(credit, clientId);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
