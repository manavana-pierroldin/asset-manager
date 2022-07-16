package com.manavana.assetmanager.security.services;

import com.manavana.assetmanager.entity.affectation.Personnel;
import com.manavana.assetmanager.repository.affectation.PersonnelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PersonnelDetailsService implements UserDetailsService {
    @Autowired
    PersonnelRepository personnelRepository;

    @Override
    public PersonnelDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("trying to load user by username ....");
        Personnel personnel=personnelRepository
                .findByNom(username).
                orElseThrow(()-> new UsernameNotFoundException("Il n'existe aucun personnel ayant le nom "+ username));
        System.out.println("Here is the user ...."+ personnel.getNom()+personnel.getMot_de_passe());

        return PersonnelDetails.build(personnel);

    }
}
