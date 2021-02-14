package ru.demakovnik.homework.controller.common;


import org.springframework.beans.factory.annotation.Autowired;
import ru.demakovnik.homework.entity.AbstractEntity;
import ru.demakovnik.homework.service.common.CommonService;

public abstract class AbstractController<E extends AbstractEntity, S extends CommonService<E>>
        implements CommonController<E> {

    protected final S service;

    @Autowired
    protected AbstractController(S service) {
        this.service = service;
    }
}
