package com.vn.recruit.dto.respone;

import lombok.Data;

import java.util.Date;

@Data
public class UserResponse {
    Long id;

    String name;

    String email;

    String userName;

    String phoneNumber;

    String homeTown;


    String image;


    String gender;

    Date birthDay;


    private boolean activate;


    boolean isDelete;


}
