package org.example.Model.Response;

import lombok.Data;

@Data
public class CommonResponse {
    private String status;
    private String message;
    private String code;

    public CommonResponse(String message, String code){
        this.message = message;
        this.code = code;
    }
    public CommonResponse(String message){
        this.message = message;
    }
}
