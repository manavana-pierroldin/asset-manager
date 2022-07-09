package com.manavana.assetmanager;

import com.manavana.assetmanager.repository.common.Indexer;
import com.manavana.assetmanager.repository.common.SearchRepository;
import com.manavana.assetmanager.repository.common.SearchRepositoryImpl;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(repositoryBaseClass = SearchRepositoryImpl.class)
@SpringBootApplication
public class AssetManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AssetManagerApplication.class, args);
    }
    @Bean
    public ApplicationRunner buildIndex(Indexer indexer) throws  Exception{
        return (ApplicationArguments args) -> {
            indexer.indexPersistedData("com.manavana.assetmanager.entity.acquisition.AppelDOffre");
        };
    }

}
