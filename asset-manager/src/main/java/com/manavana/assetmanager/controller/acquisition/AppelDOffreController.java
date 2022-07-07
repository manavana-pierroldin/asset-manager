package com.manavana.assetmanager.controller.acquisition;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.manavana.assetmanager.entity.acquisition.AppelDOffre;
import com.manavana.assetmanager.service.AppelDOffreService;
import org.hibernate.mapping.Filterable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

@RestController
public class AppelDOffreController {
    @Autowired
    private AppelDOffreService aoService;
    @GetMapping("/appelsoffres")
    List<AppelDOffre> getAllAppelDOffre() throws Exception{
        List<AppelDOffre> appelDOffres= aoService.getAll();

        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.addMixIn(AppelDOffre.class, FilterableAppelDoffre.class);
        SimpleBeanPropertyFilter simpleBeanFilter = SimpleBeanPropertyFilter.filterOutAllExcept("reference", "date", "objet");
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("aoFilter",simpleBeanFilter);
        ObjectWriter writer = mapper.writer(filterProvider);
        String writeValueAsString = writer.writeValueAsString(appelDOffres);
        List<AppelDOffre> result = mapper.readValue(writeValueAsString, List.class);

        return result;
    }

    @GetMapping("/appeloffre/{reference}")
    AppelDOffre getAppelOffre(@PathVariable String reference){
        return aoService.getAppelOffre(reference);
    }
    @JsonFilter("aoFilter")
    private class FilterableAppelDoffre {
        String reference;
        Date date;
        String objet;
    }
}
