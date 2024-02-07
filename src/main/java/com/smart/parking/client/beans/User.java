package com.smart.parking.client.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private String username;
    private String avatar;
    private String firstName;
    private String lastName;
    private String nickName;
    private String codeNickName;


}
