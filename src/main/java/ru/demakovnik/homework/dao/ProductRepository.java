package ru.demakovnik.homework.dao;

import org.springframework.stereotype.Repository;
import ru.demakovnik.homework.dao.common.CommonRepository;
import ru.demakovnik.homework.entity.Product;

@Repository
public interface ProductRepository extends CommonRepository<Product> {

}
