package com.projeto_final.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.projeto_final.app.models.Catalogo;
import com.projeto_final.app.models.Item;

public interface ItemRepository extends CrudRepository<Item, Long> {
    List<Item> findByCatalogo(Catalogo catalogo);
    Item findByIdItem(long idItem);
}
