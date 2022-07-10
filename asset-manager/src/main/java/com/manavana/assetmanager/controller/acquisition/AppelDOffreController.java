package com.manavana.assetmanager.controller.acquisition;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.manavana.assetmanager.dto.acquisition.AppelDOffreDTO;
import com.manavana.assetmanager.dto.acquisition.SearchAppelDOffreDTO;
import com.manavana.assetmanager.entity.acquisition.AppelDOffre;
import com.manavana.assetmanager.service.AppelDOffreService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
public class AppelDOffreController {
    @Autowired
    private AppelDOffreService aoService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/appeloffre")
    List<AppelDOffre> getAllAppelDOffre() throws Exception{
        List<AppelDOffre> appelsoffres = aoService.getAll();
        String[] propertiesToKeep = { "reference", "date", "objet" };
        String filterName = "aoFilter";
        return filter(AppelDOffre.class,FilteredAppelDoffre.class, appelsoffres, propertiesToKeep, filterName);
    }

    @RequestMapping(value={"/appeloffre"}, params = "sortfield")
    List<AppelDOffre>getSortedAppelDOffre(@RequestParam String sortfield) throws Exception{
        List<AppelDOffre> appelDOffres=aoService.getSortedAppelDOffre(sortfield);
        String[] propertiesToKeep = { "reference", "date", "objet" };
        String filterName = "aoFilter";
        return filter(AppelDOffre.class,FilteredAppelDoffre.class, appelDOffres, propertiesToKeep, filterName);
    }

    @GetMapping("/appeloffre/{reference}")
    AppelDOffre getAppelOffre(@PathVariable String reference){
        System.out.println(reference);
        return aoService.getAppelOffre(reference);
    }

    @PostMapping("/appeloffre")
    ResponseEntity<?> createAppelOffre(@RequestBody AppelDOffreDTO appelDOffreDTO){
        AppelDOffre appelDOffre=modelMapper.map(appelDOffreDTO, AppelDOffre.class);
        appelDOffre.setDate(new Date(System.currentTimeMillis()));
        aoService.saveAO(appelDOffre);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @PutMapping("/appeloffre")
    ResponseEntity<?>updateAppelOffre(@RequestBody AppelDOffreDTO appelDOffreDTO){
        AppelDOffre uappelDOffre=modelMapper.map(appelDOffreDTO, AppelDOffre.class);
        aoService.updateAO(uappelDOffre);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/appeloffre/{reference}")
    ResponseEntity<?> deleteAppelOffre(@PathVariable String reference){
        aoService.deleteAppelOffre(reference);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/appeloffre/search")
    List<AppelDOffre>searchAppelDOffre(@RequestBody SearchAppelDOffreDTO searchAppelDOffreDTO) throws JsonProcessingException {

        String text=searchAppelDOffreDTO.getText();
        List<String> fields=searchAppelDOffreDTO.getFields();
        int limit=searchAppelDOffreDTO.getLimit();
        List<AppelDOffre> result = aoService.searchAppelDOffre(text,fields, limit);
        String[] propertiesToKeep = { "reference", "date", "objet" };
        String filterName = "aoFilter";
        return filter(AppelDOffre.class,FilteredAppelDoffre.class, result, propertiesToKeep, filterName);
    }

    @JsonFilter("aoFilter")
    private class FilteredAppelDoffre {
        String reference;
        Date date;
        String objet;
    }
    private <I,F> List<I> filter(Class<I> item, Class<F> result, List<I> toFilter, String[] propertiesToKeep, String filterName) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.addMixIn(item,result);
        SimpleBeanPropertyFilter simpleBeanFilter = SimpleBeanPropertyFilter.filterOutAllExcept(propertiesToKeep);
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter(filterName,simpleBeanFilter);
        ObjectWriter writer = mapper.writer(filterProvider);
        String writeValueAsString = writer.writeValueAsString(toFilter);
        List<I> filtered = mapper.readValue(writeValueAsString, List.class);
        return filtered;
    }
}
