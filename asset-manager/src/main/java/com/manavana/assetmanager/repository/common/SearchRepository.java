package com.manavana.assetmanager.repository.common;

import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

public interface SearchRepository<T, ID extends Serializable> extends JpaRepository<T,ID> {
    List<T> searchBy(String text, int limit, String ...fields);
}
