package com.test.pultrik.model.payload;

import lombok.Data;

@Data
public class Response {
    private String status;
    private String message;
    private Object data;

    public Response(String status, String message){
        this.status = status;
        this.message = message;
    }

    public Response(String status, String message, Object data){
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public Response() {

    }
}
