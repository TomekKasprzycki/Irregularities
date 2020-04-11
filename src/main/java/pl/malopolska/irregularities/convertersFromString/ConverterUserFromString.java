package pl.malopolska.irregularities.convertersFromString;

import org.springframework.core.convert.converter.Converter;
import pl.malopolska.irregularities.converters.UserConverter;
import pl.malopolska.irregularities.dto.UserDto;
import pl.malopolska.irregularities.services.UserService;

public class ConverterUserFromString implements Converter<String, UserDto> {

    private UserService userService;
    private UserConverter userConverter;

    private ConverterUserFromString(UserService userService, UserConverter userConverter){
        this.userConverter = userConverter;
        this.userService = userService;
    }

    @Override
    public UserDto convert(String s) {
        return userConverter.convertToDto(userService.getUserById(Long.parseLong(s)));
    }

}
