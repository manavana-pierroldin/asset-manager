package com.manavana.assetmanager.controller.acquisition;

import com.manavana.assetmanager.entity.acquisition.AppelDOffre;
import com.manavana.assetmanager.service.AppelDOffreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppelDOffreController {
    @Autowired
    private AppelDOffreService aoService;
    List<String> getAllAppelDOffre(){
        return aoService.getAll();
    }
}
