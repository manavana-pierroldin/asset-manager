package com.manavana.assetmanager.security.services;

import com.manavana.assetmanager.entity.affectation.Personnel;
import com.manavana.assetmanager.entity.affectation.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class PersonnelDetails implements UserDetails {
    private Collection<? extends GrantedAuthority> authorities;
    private String password;
    private String username;
    private String fonction;
    private String prenom;

    private List<Role> roles;

    public PersonnelDetails(Collection<? extends GrantedAuthority> authorities, Personnel personnel) {
        this.authorities = authorities;
        this.password = personnel.getMot_de_passe();
        this.username = personnel.getNom();
        this.fonction=personnel.getFonction();
        this.prenom=personnel.getPrenom();
        this.roles=personnel.getRoles();
    }
    public static PersonnelDetails build(Personnel personnel) {
        List<GrantedAuthority> authorities=
                personnel
                        .getRoles()
                        .stream()
                        .map(role-> new SimpleGrantedAuthority(role.getDesignation()))
                        .collect(Collectors.toList());
        return new PersonnelDetails(authorities, personnel);
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getFonction() {
        return fonction;
    }

    public String getPrenom() {
        return prenom;
    }
    public List<Role> getRoles() {
        return roles;
    }
}
