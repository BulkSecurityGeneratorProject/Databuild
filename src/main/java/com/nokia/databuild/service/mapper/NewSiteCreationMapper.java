package com.nokia.databuild.service.mapper;

import com.nokia.databuild.domain.*;
import com.nokia.databuild.service.dto.NewSiteCreationDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity NewSiteCreation and its DTO NewSiteCreationDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface NewSiteCreationMapper extends EntityMapper<NewSiteCreationDTO, NewSiteCreation> {



    default NewSiteCreation fromId(Long id) {
        if (id == null) {
            return null;
        }
        NewSiteCreation newSiteCreation = new NewSiteCreation();
        newSiteCreation.setId(id);
        return newSiteCreation;
    }
}
