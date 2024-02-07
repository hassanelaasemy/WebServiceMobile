package com.smart.parking.client.repository;

import com.smart.parking.client.entity.Parking;
import com.smart.parking.client.response.ParkingResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ParkingRepository extends JpaRepository<Parking , Long> {

    @Query("SELECT p from Parking p where p.city.name=:city")
    List<Parking> GetParkingByCity(@Param("city") String city);

    @Query("SELECT p FROM Parking p WHERE p.id = :id")
    Optional<Parking> GetParkingById(@Param("id") Long id);



}