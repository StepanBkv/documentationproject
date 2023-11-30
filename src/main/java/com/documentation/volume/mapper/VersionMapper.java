package com.documentation.volume.mapper;

import com.documentation.volume.DTO.VersionDto;
import com.documentation.volume.model.Version;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VersionMapper {

    VersionDto toDto(Version version);
    Version toModel(VersionDto versionDto);
}
