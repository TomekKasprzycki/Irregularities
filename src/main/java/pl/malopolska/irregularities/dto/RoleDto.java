package pl.malopolska.irregularities.dto;

import lombok.Data;

import java.util.List;

@Data
public class RoleDto {

    private Long id;
    private String name;
    private String description;
    List<UserDto> usersDto;

}
