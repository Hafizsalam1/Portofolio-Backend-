package org.example.Model.Response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema
public class ErrorResponse extends CommonResponse{
    public ErrorResponse(String message, String code) {
        super(message,code);
        super.setStatus("Failed");
    }
}
