package com.shady.hidradenitis.suppurutiva.mappers;

import com.shady.hidradenitis.suppurutiva.auth.User;
import com.shady.hidradenitis.suppurutiva.dtos.request.auth.UserDto;

public interface DtoMapper {
    User map(UserDto userDto);
}
