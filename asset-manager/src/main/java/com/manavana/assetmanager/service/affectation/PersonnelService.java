package com.manavana.assetmanager.service.affectation;

import com.manavana.assetmanager.dto.PersonnelDTO;
import com.manavana.assetmanager.entity.affectation.Personnel;
import com.manavana.assetmanager.entity.affectation.Role;
import com.manavana.assetmanager.repository.affectation.PersonnelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class PersonnelService {
    @Autowired
    PersonnelRepository personnelRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    public  Personnel createPersonnel(PersonnelDTO personnelDTO) {
        Personnel personnel=new Personnel();
        personnel.setNom(personnelDTO.getNom());
        personnel.setPrenom(personnelDTO.getPrenom());
        personnel.setFonction(personnelDTO.getFonction());
        personnel.setMot_de_passe(passwordEncoder.encode(personnelDTO.getMot_de_passe()));
        personnel.setRoles(personnelDTO
                .getRoles()
                .stream()
                .map(r-> { Role role=new Role(); role.setDesignation(r); return role;})
                .collect(Collectors.toList()));
        return personnelRepository.save(personnel);
    }
}
