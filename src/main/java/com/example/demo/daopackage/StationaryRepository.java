package com.example.demo.daopackage;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.models.Stationary;
@Repository
public interface StationaryRepository extends CrudRepository<Stationary,Long> {
}