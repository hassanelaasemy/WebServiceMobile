package com.smart.parking.client.repository;

import com.smart.parking.client.entity.Auth;
import com.smart.parking.client.entity.CarUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.Optional;

@Repository

public interface CarRepository extends JpaRepository<CarUser , Long> {

    @Query("SELECT c FROM CarUser c where c.auth.id =:id")
    ArrayList<CarUser> GetCarUserByAuth(@Param("id") Long id);


}
