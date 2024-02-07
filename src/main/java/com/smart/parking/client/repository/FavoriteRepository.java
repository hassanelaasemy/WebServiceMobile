package com.smart.parking.client.repository;

import com.smart.parking.client.entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite , Long> {

    @Query("SELECT f FROM Favorite f where f.auth.id=:user and f.parking.id =:parking")
    List<Favorite> getFavoriteParking(@Param("user")Long user , @Param("parking")Long parking);

    @Query("SELECT f FROM Favorite f where f.auth.id=:user")
    List<Favorite> getAuthFavoriteParking(@Param("user")Long user);

}
