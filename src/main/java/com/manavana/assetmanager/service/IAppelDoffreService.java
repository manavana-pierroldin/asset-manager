package com.manavana.assetmanager.service;

import com.manavana.assetmanager.entity.acquisition.AppelDOffre;

import java.util.List;
import java.util.Optional;

public interface IAppelDoffreService {
    List<AppelDOffre>getAll();

    AppelDOffre getAppelOffre(String reference);

    void deleteAppelOffre(String reference);

    void saveAO(AppelDOffre appelDOffre);

    void updateAO(AppelDOffre uappelDOffre);

    List<AppelDOffre> getSortedAppelDOffre(String sortfield);
}
