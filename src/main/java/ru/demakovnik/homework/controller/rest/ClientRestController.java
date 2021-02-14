package ru.demakovnik.homework.controller.rest;

import org.springframework.web.bind.annotation.*;
import ru.demakovnik.homework.controller.common.AbstractController;
import ru.demakovnik.homework.entity.Client;
import ru.demakovnik.homework.service.ClientService;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class ClientRestController extends AbstractController<Client, ClientService> {

    public ClientRestController(ClientService service) {
        super(service);
    }


    @GetMapping("/clients")
    public List<Client> showAllClients() {
        return service.getAll();
    }

    @GetMapping("/clients/{id}")
    public Client getClient(@PathVariable long id) {
        return service.getById(id);
    }

    @PostMapping("/clients")
    public Client addNewClient(@RequestBody Client client) {
        return service.save(client);
    }

    @PutMapping("/clients")
    public Client updateClient(@RequestBody Client client) {
        return service.update(client);
    }

    @DeleteMapping("/clients/{id}")
    public String deleteClient(@PathVariable long id) {
        Client client = service.getById(id);
        service.deleteById(client.getId());
        return "Client with ID = " + id + " was deleted";
    }
}
