package pl.malopolska.irregularities.converters;

import org.springframework.stereotype.Service;
import pl.malopolska.irregularities.dto.MessageDto;
import pl.malopolska.irregularities.model.Message;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageConverter {

    private UserConverter userConverter;

    private MessageConverter(UserConverter userConverter){
        this.userConverter = userConverter;
    }

    public Message convertFromDto (MessageDto messageDto){
        Message message = new Message();
        message.setId(messageDto.getId());
        message.setAddressee(userConverter.convertFromDto(messageDto.getAddressee()));
        message.setCreator(userConverter.convertFromDto(messageDto.getCreator()));
        message.setCaseID(messageDto.getCaseID());
        message.setMessage(messageDto.getMessage());

        return message;
    }

    public MessageDto convertToDto (Message message){
        MessageDto messageDto = new MessageDto();
        messageDto.setId(message.getId());
        messageDto.setAddressee(userConverter.convertToDto(message.getAddressee()));
        messageDto.setCreator(userConverter.convertToDto(message.getCreator()));
        messageDto.setCaseID(message.getCaseID());
        messageDto.setMessage(message.getMessage());

        return messageDto;
    }

    public List<Message> convertFromDto(List<MessageDto> messagesDto){
        List<Message> messages = new ArrayList<>();
        for (MessageDto messageDto : messagesDto) {
            messages.add(convertFromDto(messageDto));
        }
        return messages;
    }

    public List<MessageDto> convertToDto(List<Message> messages){
        List<MessageDto> messagesDto = new ArrayList<>();
        for (Message message : messages) {
            messagesDto.add(convertToDto(message));
        }
        return messagesDto;
    }

}
