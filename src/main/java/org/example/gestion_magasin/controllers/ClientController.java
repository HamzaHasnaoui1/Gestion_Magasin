package org.example.gestion_magasin.controllers;

import org.example.gestion_magasin.dtos.ClientDto;
import org.example.gestion_magasin.services.Client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
@CrossOrigin("*")
public class ClientController {

@Autowired
private ClientService clientService;

@PostMapping("/addClient")
    public ClientDto addClient(@RequestBody ClientDto clientDto) {
    return clientService.addClient(clientDto);
}

@GetMapping("/clientList")
    public List<ClientDto> getClientList() {
    return clientService.listClient();
}

@GetMapping("/getCltById/{id}")
    public ClientDto getCltById(@PathVariable Long id) {
    return clientService.getClientById(id);
}

@PutMapping("/updateClt/{id}")
    public ClientDto updateClt(@PathVariable Long id ,@RequestBody ClientDto clientDto) {
    return clientService.updateClient(id ,clientDto);
}

@DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Long id) {
    clientService.deleteClient(id);
}

@GetMapping("/searchClt")
    public List<ClientDto> searchClt(@RequestParam(name = "keyword",defaultValue = "") String keyword) {
    return clientService.searchClient("%"+keyword+"%");
}
}
