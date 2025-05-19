package org.app.backend.Controllers;

import lombok.RequiredArgsConstructor;
import org.app.backend.Entities.Client;
import org.app.backend.Services.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @GetMapping
    public List<Client> getAll() {
        return clientService.getAllClients();
    }

    @GetMapping("/{id}")
    public Client getById(@PathVariable Long id) {
        return clientService.getClient(id);
    }

    @PostMapping
    public Client create(@RequestBody Client client) {
        return clientService.saveClient(client);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        clientService.deleteClient(id);
    }
}

