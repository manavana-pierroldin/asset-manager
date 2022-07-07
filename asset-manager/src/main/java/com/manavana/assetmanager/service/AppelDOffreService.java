package com.manavana.assetmanager.service;

import com.manavana.assetmanager.entity.acquisition.AppelDOffre;
import com.manavana.assetmanager.repository.acquisition.AppelDOffreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
@Service
public class AppelDOffreService implements IAppelDoffreService{
    @Autowired
    AppelDOffreRepository aoRepo;
    @Override
    public List<String>getAll(){
        return Optional.ofNullable(List.of("a","d","d")).orElseThrow(()->new RuntimeException("Liste vide"));
    }
}
