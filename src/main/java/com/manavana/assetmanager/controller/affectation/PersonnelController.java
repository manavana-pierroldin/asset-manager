package com.manavana.assetmanager.controller.affectation;

import com.manavana.assetmanager.dto.JwtDTO;
import com.manavana.assetmanager.dto.LoginOrRegisterDTO;
import com.manavana.assetmanager.dto.PersonnelDTO;
import com.manavana.assetmanager.dto.ProfileDTO;
import com.manavana.assetmanager.dto.auth.AuthDTO;
import com.manavana.assetmanager.entity.affectation.Personnel;
import com.manavana.assetmanager.security.jwt.JwtUtils;
import com.manavana.assetmanager.security.services.PersonnelDetails;
import com.manavana.assetmanager.service.affectation.PersonnelService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PersonnelController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    PersonnelService personnelService;


    @PostMapping("/personnel/login")
    public ResponseEntity<?> authenticateUser(@RequestBody AuthDTO authDTO){
        Authentication auth=authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authDTO.getNom(),authDTO.getMot_de_passe()));
        SecurityContextHolder.getContext().setAuthentication(auth);
        String jwt=jwtUtils.generateJwtToken(auth);
        PersonnelDetails personnelDetails=(PersonnelDetails) auth.getPrincipal();
        LoginOrRegisterDTO personnelPayload=new LoginOrRegisterDTO();
        personnelPayload.setToken(jwt);
        personnelPayload.setNom(personnelDetails.getUsername());
        personnelPayload.setNom(personnelDetails.getPrenom());
        personnelPayload.setFonction(personnelDetails.getFonction());
        personnelPayload.setRoles(personnelDetails.getRoles());
        return  ResponseEntity.ok(personnelPayload);
    }

    @PostMapping("/personnel/register")
    public ResponseEntity<LoginOrRegisterDTO>createPersonnel(@RequestBody PersonnelDTO personnelDTO){

        Personnel personnel=personnelService.createPersonnel(personnelDTO);
        String jwt=jwtUtils.generateJwTokenFromPersonnel(personnel);
        LoginOrRegisterDTO personnelPayload=new LoginOrRegisterDTO();
        personnelPayload.setToken(jwt);
        personnelPayload.setNom(personnel.getNom());
        personnelPayload.setPrenom(personnel.getPrenom());
        personnelPayload.setFonction(personnel.getFonction());
        personnelPayload.setRoles(personnel.getRoles());
        return new ResponseEntity<>(personnelPayload,HttpStatus.CREATED);

    }

    @GetMapping("/personnel/profile")
    public ResponseEntity<ProfileDTO>getProfile(@RequestHeader ("Authorization") String headerAuth){
        String token=headerAuth.substring(7, headerAuth.length());
        String username=jwtUtils.getUserNameFromJwtToken(token);
        Personnel personnel=personnelService.getPersonnelByNom(username);
        ProfileDTO profileDTO=new ProfileDTO();
        profileDTO.setNom(personnel.getNom());
        profileDTO.setPrenom(personnel.getPrenom());
        profileDTO.setFonction(personnel.getFonction());
        profileDTO.setRoles(personnel.getRoles());
        return  new ResponseEntity<>(profileDTO, HttpStatus.OK);
    }
}
