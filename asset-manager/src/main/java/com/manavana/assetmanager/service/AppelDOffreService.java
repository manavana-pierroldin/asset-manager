package com.manavana.assetmanager.service;

import com.manavana.assetmanager.entity.acquisition.AppelDOffre;
import com.manavana.assetmanager.repository.acquisition.AppelDOffreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
@Service
public class AppelDOffreService implements IAppelDoffreService{
    @Autowired
    AppelDOffreRepository aoRepo;

    private static final List<String> SEARCHEABLE_FIELDS=Arrays.asList("reference", "description","objet");

    @Override
    public List<AppelDOffre>getAll(){
        return Optional.ofNullable(aoRepo.findAll()).orElseThrow(()->new RuntimeException("Liste vide"));
    }

    @Override
    public AppelDOffre getAppelOffre(String reference) {
        AppelDOffre aoFound = aoRepo.findByReference(reference);
        return Optional.ofNullable(aoFound).orElseThrow(()->new RuntimeException("AppelOffre Introuvable"));
    }

    @Transactional
    @Override
    public void deleteAppelOffre(String reference) {
        aoRepo.deleteByReference(reference);
    }
    @Override
    public void saveAO(AppelDOffre appelDOffre) {
        AppelDOffre  ao=aoRepo.save(appelDOffre);
    }

    @Transactional
    @Override
    public void updateAO(AppelDOffre uappelDOffre) { AppelDOffre ao=aoRepo.save(uappelDOffre); }

    @Override
    public List<AppelDOffre> getSortedAppelDOffre(String sortfield) {
        switch (sortfield){
            case "date":
                return aoRepo.findByOrderByDateDesc();
            case "budget":
                return aoRepo.findByOrderByBudgetAsc();
            default:
                return aoRepo.findByOrderByDateDesc();
        }
    }

    public List<AppelDOffre> searchAppelDOffre(String text, List<String> fields, int limit) {

        List<String> fieldsToSearchBy = fields.isEmpty() ? SEARCHEABLE_FIELDS : fields;

        boolean containsInvalidField = fieldsToSearchBy.stream(). anyMatch(f -> !SEARCHEABLE_FIELDS.contains(f));

        if(containsInvalidField) {
            throw new IllegalArgumentException();
        }

        return aoRepo.searchBy(
                text, limit, fieldsToSearchBy.toArray(new String[0]));
    }
}
