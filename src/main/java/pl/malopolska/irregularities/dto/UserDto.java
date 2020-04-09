package pl.malopolska.irregularities.dto;

import lombok.Data;

@Data
public class UserDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String password2;
    private RoleDto roleDto;
    private boolean active;
    private InstitutionDto institutionDto;

}
