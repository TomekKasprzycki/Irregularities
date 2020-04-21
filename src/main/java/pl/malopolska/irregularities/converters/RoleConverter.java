package pl.malopolska.irregularities.converters;

import org.springframework.stereotype.Service;
import pl.malopolska.irregularities.dto.RoleDto;
import pl.malopolska.irregularities.model.Role;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleConverter {

//    private UserConverter userConverter;
//
//    private RoleConverter(UserConverter userConverter){
//        this.userConverter = userConverter;
//    }

    public Role convertFromDto(RoleDto roleDto){
        Role role = new Role();
        role.setId(roleDto.getId());
        role.setName(roleDto.getName());
        role.setDescription(roleDto.getDescription());
//        role.setUsers(userConverter.convertFromDto(roleDto.getUsersDto()));
        return role;
    }

    public RoleDto convertToDto(Role role){
        RoleDto roleDto = new RoleDto();
        roleDto.setId(role.getId());
        roleDto.setName(role.getName());
        roleDto.setDescription(role.getDescription());
//        roleDto.setUsersDto(userConverter.convertToDto(role.getUsers()));
        return roleDto;
    }

    public List<RoleDto> convertToDto(List<Role> roles){
        List<RoleDto> roleDtoList = new ArrayList<>();
        for (Role role : roles) {
            roleDtoList.add(convertToDto(role));
        }
        return roleDtoList;
    }

}
