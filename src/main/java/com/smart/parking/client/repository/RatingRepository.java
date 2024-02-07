package com.smart.parking.client.repository;

import com.smart.parking.client.entity.Favorite;
import com.smart.parking.client.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RatingRepository extends JpaRepository<Rating , Long> {
    @Query("SELECT r FROM Rating r where r.parking.id =:parking")
    List<Rating> getRatingParking(@Param("parking") Long parking);
    @Query("SELECT r FROM Rating r where r.parking.id =:parking and r.auth.id =:auth")
    Optional<Rating> getRatingParkingAndAuth(@Param("parking") Long parking ,@Param("auth") Long auth);

    @Modifying
    @Query("update Rating set rating =:rating ,description =:description where id=:id")
    void updateRating(@Param("id") Long id , @Param("description") String description ,@Param("rating") double rating);
}
