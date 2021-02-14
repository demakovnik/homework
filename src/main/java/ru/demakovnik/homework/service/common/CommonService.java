package ru.demakovnik.homework.service.common;


import org.springframework.transaction.annotation.Transactional;
import ru.demakovnik.homework.entity.AbstractEntity;

import java.util.List;

public interface CommonService<E extends AbstractEntity> {

    public E save(E entity);

    public E update(E entity);

    public List<E> getAll();

    public E getById(long id);

    public void deleteById(long id);


}
