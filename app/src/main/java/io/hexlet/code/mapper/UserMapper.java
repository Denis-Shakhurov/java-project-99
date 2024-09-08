package io.hexlet.code.mapper;

import io.hexlet.code.dto.UserCreateDTO;
import io.hexlet.code.dto.UserDTO;
import io.hexlet.code.dto.UserUpdateDTO;
import io.hexlet.code.model.User;
import org.mapstruct.*;

@Mapper(
        uses = { JsonNullableMapper.class, },
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public abstract class UserMapper {

    public abstract User map(UserCreateDTO dto);
    public abstract UserDTO map(User model);
    public abstract void update(UserUpdateDTO dto, @MappingTarget User model);
}