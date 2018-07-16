package com.example.bringit.models;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemRepository extends CrudRepository<Item,Long>{
    Iterable <Item> findItemsByItemNumBefore(int cutoff);
}
