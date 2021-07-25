package com.shady.hidradenitis.suppurutiva.mappers;

import com.shady.hidradenitis.suppurutiva.auth.User;
import com.shady.hidradenitis.suppurutiva.dtos.request.auth.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MapperUsingModelMapper implements DtoMapper {
    @Autowired
    private ModelMapper modelMapper;

    public User map(UserDto userDto) {
        return modelMapper.map(userDto, User.class);
    }
}
