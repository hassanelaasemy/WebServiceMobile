package com.smart.parking.client.services;

import com.smart.parking.client.beans.User;
import com.smart.parking.client.entity.Auth;
import com.smart.parking.client.repository.AuthRepository;
import com.smart.parking.client.request.GeneralRequest;
import com.smart.parking.client.secuirity.JWTUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final AuthRepository authRepository;
    private final JWTUtil jwtUtil ;

    public UserService(AuthRepository authRepository, JWTUtil jwtUtil) {
        this.authRepository = authRepository;
        this.jwtUtil = jwtUtil;
    }
    public User getUserinfo(HttpServletRequest request){
      String AuthHeader =request.getHeader("Authorization");
      String Token =AuthHeader.substring(7);
      String username = jwtUtil.extractUsername(Token);
      Auth auth = authRepository.findAuthByEmail(username).orElseThrow();

      return User.builder()
              .username(auth.getUsername())
              .firstName(auth.getFirstName())
              .lastName(auth.getLastName())
              .nickName(auth.getNickname())
              .codeNickName(auth.getCodeNickname())
              .avatar(auth.getAvatar())
              .build();
    }

    @Transactional
    public User updateInfo(GeneralRequest generalRequest , HttpServletRequest request){
        String AuthHeader =request.getHeader("Authorization");
        String Token =AuthHeader.substring(7);
        String username = jwtUtil.extractUsername(Token);
        Auth auth = authRepository.findAuthByEmail(username).orElseThrow();

        authRepository.updateUserInfo(generalRequest.getUserUpdateRequest().getFirstName(),
                generalRequest.getUserUpdateRequest().getLastName(),
                generalRequest.getUserUpdateRequest().getEmail(),
                auth.getId());


        return User.builder()
                .username(generalRequest.getUserUpdateRequest().getEmail())
                .firstName(generalRequest.getUserUpdateRequest().getFirstName())
                .lastName(generalRequest.getUserUpdateRequest().getLastName())
                .nickName(auth.getNickname())
                .codeNickName(auth.getCodeNickname())
                .avatar(auth.getAvatar())
                .build();
    }

    @Transactional
    public User updateAvatar(GeneralRequest generalRequest , HttpServletRequest request){
        String AuthHeader =request.getHeader("Authorization");
        String Token =AuthHeader.substring(7);
        String username = jwtUtil.extractUsername(Token);
        Auth auth = authRepository.findAuthByEmail(username).orElseThrow();

        authRepository.updateUserAvatar(generalRequest.getUpdateAvatarRequest().getAvatar(),
                auth.getId());

        return User.builder()
                .avatar(generalRequest.getUpdateAvatarRequest().getAvatar())
                .username(auth.getEmail())
                .firstName(auth.getFirstName())
                .lastName(auth.getLastName())
                .nickName(auth.getNickname())
                .codeNickName(auth.getCodeNickname())
                .avatar(auth.getAvatar())
                .build();
    }
}
