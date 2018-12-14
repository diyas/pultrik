package com.test.pultrik.model.payload;

import lombok.Data;

@Data
public class LoginResponse {
    private long idUser;

    public LoginResponse(long idUser){
        this.idUser = idUser;
    }
}
