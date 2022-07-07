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
    public List<AppelDOffre>getAll(){
        return Optional.ofNullable(aoRepo.findAll()).orElseThrow(()->new RuntimeException("Liste vide"));
    }

    @Override
    public AppelDOffre getAppelOffre(String reference) {
        return Optional.ofNullable(aoRepo.findByReference(reference)).orElseThrow(()->new RuntimeException("AppelOffre Introuvable"));
    }
}
