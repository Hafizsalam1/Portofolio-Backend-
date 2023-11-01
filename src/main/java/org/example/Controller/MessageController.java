package org.example.Controller;

import org.example.Model.Message;
import org.example.Model.Response.CommonResponse;
import org.example.Service.Implement.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessageController {
    MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/message")
     public ResponseEntity<CommonResponse>addMessage( @RequestBody Message message){
        CommonResponse responseAddMessageService = messageService.addMessage(message);
        if(responseAddMessageService.getCode().equals("01")){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseAddMessageService);
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(responseAddMessageService);
        }
    }

    @DeleteMapping("/message")
    public ResponseEntity<CommonResponse>deleteMessage(String id){
        CommonResponse responseDeleteMessageService = messageService.deleteMessage(id);
        if(responseDeleteMessageService.getCode().equals("01")){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDeleteMessageService);
        }
        else{
            return ResponseEntity.status(HttpStatus.OK).body(responseDeleteMessageService);
        }
    }

    }
