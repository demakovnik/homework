package ru.demakovnik.homework.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.demakovnik.homework.dao.ClientRepository;
import ru.demakovnik.homework.dao.ProductRepository;
import ru.demakovnik.homework.entity.Client;
import ru.demakovnik.homework.entity.Product;
import ru.demakovnik.homework.exception.IncorrectDataItemException;
import ru.demakovnik.homework.exception.NoSuchItemException;
import ru.demakovnik.homework.service.common.AbstractService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Transactional
public class ClientService extends AbstractService<Client, ClientRepository> {

    @Autowired
    private ProductRepository productRepository;
    public ClientService(ClientRepository repository) {
        super(repository);
    }


    @Override
    public Client update(Client client) {
        Client clientFromDb = getById(client.getId());
        productRepository.deleteInBatch(clientFromDb.getProducts());
        List<Product> products = client.getProducts();
        clientFromDb.setProducts(products);
        lengthCheck(clientFromDb);
        return repository.save(clientFromDb);
    }

    @Override
    public Client save(Client client) {
        lengthCheck(client);
        return repository.save(client);
    }

    @Override
    public List<Client> getAll() {
        return repository.findAll();
    }

    @Override
    public Client getById(long id) {
        Optional<Client> byId = repository.findById(id);
        if (!byId.isPresent()) {
            throw new NoSuchItemException("There is no Client with ID = " + id + " in database");
        }
        return byId.get();
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(getById(id).getId());

    }

    private void lengthCheck(Client client) {
        if (client.getSeller().length() != 9
                || client.getCustomer().length() != 9) {
            throw new IncorrectDataItemException("seller or customer length must be 9 characters");
        }
        List<Product> productList = client.getProducts().stream().map(product -> {
            if (product.getCode().length() != 13)
                throw new IncorrectDataItemException("product code length with name = " +
                        product.getName() +
                        " must be 13 characters, but you input " +
                        product.getCode().length() +
                        " characters");
            product.setClient(client);
            return product;
        }).collect(Collectors.toList());
        client.setProducts(productList);
    }
}
