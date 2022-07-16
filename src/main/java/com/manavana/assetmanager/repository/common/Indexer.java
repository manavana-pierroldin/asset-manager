package com.manavana.assetmanager.repository.common;

import org.hibernate.search.mapper.orm.Search;
import org.hibernate.search.mapper.orm.massindexing.MassIndexer;
import org.hibernate.search.mapper.orm.session.SearchSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Transactional
@Repository
public class Indexer {
    private EntityManager entityManager;
    private static final int THREAD_NUMBER=4;

    public Indexer (EntityManager entityManager){
        this.entityManager=entityManager;
    }

    public void indexPersistedData(String indexedClassName) throws  Exception {
        try{
            SearchSession searchSession= Search.session(entityManager);
            Class<?> ClassToIndex=Class.forName(indexedClassName);
            MassIndexer indexer =
                    searchSession
                            .massIndexer(ClassToIndex)
                            .threadsToLoadObjects(THREAD_NUMBER);

            indexer.startAndWait();
        }
        catch ( ClassNotFoundException e){
            throw new Exception("Invalid class"+indexedClassName+e);
        }
        catch (InterruptedException e){
            throw new Exception("Index interupted "+e);
        }
    }
}
