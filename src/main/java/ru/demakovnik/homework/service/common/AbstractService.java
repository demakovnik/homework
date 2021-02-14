package ru.demakovnik.homework.service.common;


import org.springframework.beans.factory.annotation.Autowired;
import ru.demakovnik.homework.dao.common.CommonRepository;
import ru.demakovnik.homework.entity.AbstractEntity;

public abstract class AbstractService<E extends AbstractEntity, R extends CommonRepository<E>>
        implements CommonService<E> {

    @Autowired
    protected final R repository;

    public AbstractService(R repository) {
        this.repository = repository;
    }



}
