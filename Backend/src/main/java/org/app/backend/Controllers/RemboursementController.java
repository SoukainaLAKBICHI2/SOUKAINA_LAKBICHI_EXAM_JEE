package org.app.backend.Controllers;

import lombok.RequiredArgsConstructor;
import org.app.backend.Entities.Remboursement;
import org.app.backend.Services.RemboursementService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/remboursements")
@RequiredArgsConstructor
public class RemboursementController {
    private final RemboursementService remboursementService;

    @GetMapping("/credit/{creditId}")
    public List<Remboursement> getByCreditId(@PathVariable Long creditId) {
        return remboursementService.getRemboursementsByCreditId(creditId);
    }

    @PostMapping("/credit/{creditId}")
    public Remboursement create(@RequestBody Remboursement remboursement, @PathVariable Long creditId) {
        return remboursementService.saveRemboursement(remboursement, creditId);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        remboursementService.deleteRemboursement(id);
    }
}

