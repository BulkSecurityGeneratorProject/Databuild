package com.nokia.databuild.service;

import com.nokia.databuild.service.dto.NewSiteCreationDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing NewSiteCreation.
 */
public interface NewSiteCreationService {

    /**
     * Save a newSiteCreation.
     *
     * @param newSiteCreationDTO the entity to save
     * @return the persisted entity
     */
    NewSiteCreationDTO save(NewSiteCreationDTO newSiteCreationDTO);

    /**
     * Get all the newSiteCreations.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<NewSiteCreationDTO> findAll(Pageable pageable);


    /**
     * Get the "id" newSiteCreation.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<NewSiteCreationDTO> findOne(Long id);

    /**
     * Delete the "id" newSiteCreation.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
