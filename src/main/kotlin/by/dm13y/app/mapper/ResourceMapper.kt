package by.dm13y.app.mapper

import by.dm13y.app.model.dto.ResourceDto
import by.dm13y.app.model.entity.Resource
import by.dm13y.app.model.entity.ResourcePrintThrottling
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings


@Mapper(componentModel = "spring")
interface ResourceMapper {
    @Mappings(
        Mapping(target = "description", source = "info")
    )
    fun toResourceDto(resource: Resource): ResourceDto

    @Mappings(
        Mapping(target = "info", source = "description")
    )
    fun toResource(resourceDto: ResourceDto): Resource

    @Mappings
    fun toResourceThrottling(resourceDto: ResourceDto): ResourcePrintThrottling
}
