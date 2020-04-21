package pl.malopolska.irregularities.converters;

import org.springframework.stereotype.Service;
import pl.malopolska.irregularities.dto.UserDto;
import pl.malopolska.irregularities.model.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserConverter {

    private RoleConverter roleConverter;
    private InstitutionConverter institutionConverter;

    private UserConverter(RoleConverter roleConverter, InstitutionConverter institutionConverter){
        this.institutionConverter = institutionConverter;
        this.roleConverter = roleConverter;
    }

    public UserDto convertToDto(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setInstitutionDto(institutionConverter.convertToDto(user.getInstitution()));
        userDto.setRoleDto(roleConverter.convertToDto(user.getRole()));
        userDto.setActive(user.isActive());

        return userDto;
    }

    public User convertFromDto(UserDto userDto){
        User user = new User();

        user.setId(userDto.getId());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setInstitution(institutionConverter.convertFromDto(userDto.getInstitutionDto()));
        user.setRole(roleConverter.convertFromDto(userDto.getRoleDto()));
        user.setActive(false);


        return user;
    }

    public List<User> convertFromDto(List<UserDto> userDtoList){
        List<User> users = new ArrayList<>();
        for (UserDto userDto:userDtoList) {
            users.add(convertFromDto(userDto));
        }
        return users;
    }

    public List<UserDto> convertToDto(List<User> users){
        List<UserDto> userDtoList = new ArrayList<>();
        for (User user:users) {
            userDtoList.add(convertToDto(user));
        }
        return userDtoList;
    }
}
