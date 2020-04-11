package pl.malopolska.irregularities.dto;

import lombok.Data;

@Data
public class MessageDto {

    private Long id;
    private String message;
    private Long caseID;
    private UserDto creator;
    private UserDto addressee;

}
