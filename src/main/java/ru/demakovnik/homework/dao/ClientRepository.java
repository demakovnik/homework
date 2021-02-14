package ru.demakovnik.homework.dao;

import org.springframework.stereotype.Repository;
import ru.demakovnik.homework.dao.common.CommonRepository;
import ru.demakovnik.homework.entity.Client;

@Repository
public interface ClientRepository extends CommonRepository<Client> {

}
