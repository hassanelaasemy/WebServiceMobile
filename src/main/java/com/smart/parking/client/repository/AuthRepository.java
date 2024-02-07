package com.smart.parking.client.repository;

import com.smart.parking.client.entity.Auth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface AuthRepository extends JpaRepository<Auth, Long> {
    Optional<Auth> findAuthByEmail(String email);

    @Modifying
    @Query("update Auth set firstName = :firstName , lastName = :lastName , email = :email where id=:id")
    void updateUserInfo(@Param("firstName") String firstName , @Param("lastName") String lastName , @Param("email") String email ,@Param("id")  Long id );

    @Modifying
    @Query("update Auth set Avatar= :avatar where id=:id")
    void updateUserAvatar(@Param("avatar") String avatar ,@Param("id")  Long id );


    /*
    @Modifying
    @Query("update Auth set refresh_token = :refreshToken where id=:id")
    void updateUserRefreshToken(@Param("refreshToken") String refreshToken ,@Param("id")  Long id );
    @Modifying
    @Query("update Auth set token =:token where id=:id")
    void updateUserAccessToken(@Param("token")String accessToken ,@Param("id") Long id );
*/

}
