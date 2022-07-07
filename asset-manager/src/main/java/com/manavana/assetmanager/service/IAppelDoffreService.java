package com.manavana.assetmanager.service;

import com.manavana.assetmanager.entity.acquisition.AppelDOffre;

import java.util.List;
import java.util.Optional;

public interface IAppelDoffreService {
    List<AppelDOffre>getAll();

    AppelDOffre getAppelOffre(String reference);
}
