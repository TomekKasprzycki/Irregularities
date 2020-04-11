package pl.malopolska.irregularities.dto;

import lombok.Data;

import java.util.List;

@Data
public class InstitutionDto {

    private Long id;
    private String name;
    List<UserDto> userDto;

}
