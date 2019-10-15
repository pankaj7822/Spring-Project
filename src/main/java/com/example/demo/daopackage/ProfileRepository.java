package com.example.demo.daopackage;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.models.Profile;
@Repository
public interface ProfileRepository extends CrudRepository<Profile,Long> {
        }