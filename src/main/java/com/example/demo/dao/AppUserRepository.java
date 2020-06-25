package com.example.demo.dao;

import com.example.demo.entity.AppUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by A.A.MAMUN on 6/25/2020.
 */
public interface AppUserRepository extends CrudRepository<AppUser, String> {
    @Query("select u from AppUser u where u.email=?1")
    AppUser findAppUserByEmail(String email);
}
