package org.example.Service.Interface;

import org.example.Model.Message;
import org.example.Model.Response.CommonResponse;
import org.springframework.stereotype.Service;

public interface MessageServiceInterface {
    public CommonResponse addMessage(Message message);
    public CommonResponse deleteMessage(String id);


}
