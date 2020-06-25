package com.example.demo.service;

import com.example.demo.dao.AppUserRepository;
import com.example.demo.entity.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by A.A.MAMUN on 6/25/2020.
 */
@Service
public class LoginService {

    @Autowired
    private AppUserRepository appUserRepository;

    public boolean isValidUser(AppUser user){
        AppUser appUser = appUserRepository.findAppUserByEmail(user.getEmail());
        return appUser!=null && appUser.getPassword().equals(user.getPassword());
    }
}
