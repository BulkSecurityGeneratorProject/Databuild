package com.nokia.databuild.service.impl;

import com.nokia.databuild.service.NewSiteCreationService;
import com.nokia.databuild.domain.NewSiteCreation;
import com.nokia.databuild.repository.NewSiteCreationRepository;
import com.nokia.databuild.service.dto.NewSiteCreationDTO;
import com.nokia.databuild.service.mapper.NewSiteCreationMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing NewSiteCreation.
 */
@Service
@Transactional
public class NewSiteCreationServiceImpl implements NewSiteCreationService {

    private final Logger log = LoggerFactory.getLogger(NewSiteCreationServiceImpl.class);

    private final NewSiteCreationRepository newSiteCreationRepository;

    private final NewSiteCreationMapper newSiteCreationMapper;
    private final NewSiteCreationHelper helper;

    public NewSiteCreationServiceImpl(NewSiteCreationRepository newSiteCreationRepository,
                                      NewSiteCreationMapper newSiteCreationMapper,
                                      NewSiteCreationHelper helper) {
        this.newSiteCreationRepository = newSiteCreationRepository;
        this.newSiteCreationMapper = newSiteCreationMapper;
        this.helper = helper;
    }

    /**
     * Save a newSiteCreation.
     *
     * @param newSiteCreationDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public NewSiteCreationDTO save(NewSiteCreationDTO newSiteCreationDTO) {
        log.debug("Request to save NewSiteCreation : {}", newSiteCreationDTO);

        NewSiteCreation newSiteCreation = newSiteCreationMapper.toEntity(newSiteCreationDTO);
        newSiteCreation = newSiteCreationRepository.save(newSiteCreation);
        return newSiteCreationMapper.toDto(newSiteCreation);
    }

    /**
     * Get all the newSiteCreations.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<NewSiteCreationDTO> findAll(Pageable pageable) {
        log.debug("Request to get all NewSiteCreations");
        return newSiteCreationRepository.findAll(pageable)
            .map(newSiteCreationMapper::toDto);
    }


    /**
     * Get one newSiteCreation by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<NewSiteCreationDTO> findOne(Long id) {
        log.debug("Request to get NewSiteCreation : {}", id);
        return newSiteCreationRepository.findById(id)
            .map(newSiteCreationMapper::toDto);
    }

    /**
     * Delete the newSiteCreation by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete NewSiteCreation : {}", id);
        newSiteCreationRepository.deleteById(id);
    }
}
