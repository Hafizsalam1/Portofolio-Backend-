package org.example.Service.Implement;

import org.example.Model.Response.CommonResponse;
import org.example.Model.Response.ErrorResponse;
import org.example.Model.Response.SuccessResponse;
import org.example.Repository.MessageRepository;
import org.example.Service.Interface.MessageServiceInterface;
import org.example.Model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MessageService implements MessageServiceInterface {
    MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public CommonResponse addMessage(Message message) {
        System.out.println(message);
        if(!message.getEmail().isBlank()){
            if(!message.getName().isBlank()){
                if(!message.getPhone().isBlank()){
                    messageRepository.save(message);
                    SuccessResponse<Message> successResponse = new SuccessResponse<>("Message sent", message);
                    return successResponse;

                }else{
                    ErrorResponse errorResponse = new ErrorResponse("Phone Number cannot be blank", "01");
                    return errorResponse;
                }

            }else{
                ErrorResponse errorResponse = new ErrorResponse("Email cannot be blank", "01");
                return errorResponse;

            }
        }
        else{
            ErrorResponse errorResponse = new ErrorResponse("Email cannot be blank", "01");
            return errorResponse;
        }

    }

    @Override
    public CommonResponse deleteMessage(String id) {
        Optional<Message> messageOptional= messageRepository.findById(id);
        if(messageOptional.isPresent()){
            messageRepository.deleteById(id);
            SuccessResponse<Message> successResponse = new SuccessResponse<>("Message delete", messageOptional.get());
            return successResponse;
        }else{
            ErrorResponse errorResponse = new ErrorResponse("Message with this id not found","01");
            return errorResponse;
        }
    }
}
