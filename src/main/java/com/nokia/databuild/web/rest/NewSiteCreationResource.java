package com.nokia.databuild.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.nokia.databuild.service.NewSiteCreationService;
import com.nokia.databuild.web.rest.errors.BadRequestAlertException;
import com.nokia.databuild.web.rest.util.HeaderUtil;
import com.nokia.databuild.web.rest.util.PaginationUtil;
import com.nokia.databuild.service.dto.NewSiteCreationDTO;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing NewSiteCreation.
 */
@RestController
@RequestMapping("/api")
public class NewSiteCreationResource {

    private final Logger log = LoggerFactory.getLogger(NewSiteCreationResource.class);

    private static final String ENTITY_NAME = "newSiteCreation";

    private final NewSiteCreationService newSiteCreationService;

    public NewSiteCreationResource(NewSiteCreationService newSiteCreationService) {
        this.newSiteCreationService = newSiteCreationService;
    }

    /**
     * POST  /new-site-creations : Create a new newSiteCreation.
     *
     * @param newSiteCreationDTO the newSiteCreationDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new newSiteCreationDTO, or with status 400 (Bad Request) if the newSiteCreation has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/new-site-creations")
    @Timed
    public ResponseEntity<NewSiteCreationDTO> createNewSiteCreation(@Valid @RequestBody NewSiteCreationDTO newSiteCreationDTO) throws URISyntaxException {
        log.debug("REST request to save NewSiteCreation : {}", newSiteCreationDTO);
        if (newSiteCreationDTO.getId() != null) {
            throw new BadRequestAlertException("A new newSiteCreation cannot already have an ID", ENTITY_NAME, "idexists");
        }
        NewSiteCreationDTO result = newSiteCreationService.save(newSiteCreationDTO);
        return ResponseEntity.created(new URI("/api/new-site-creations/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /new-site-creations : Updates an existing newSiteCreation.
     *
     * @param newSiteCreationDTO the newSiteCreationDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated newSiteCreationDTO,
     * or with status 400 (Bad Request) if the newSiteCreationDTO is not valid,
     * or with status 500 (Internal Server Error) if the newSiteCreationDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/new-site-creations")
    @Timed
    public ResponseEntity<NewSiteCreationDTO> updateNewSiteCreation(@Valid @RequestBody NewSiteCreationDTO newSiteCreationDTO) throws URISyntaxException {
        log.debug("REST request to update NewSiteCreation : {}", newSiteCreationDTO);
        if (newSiteCreationDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        NewSiteCreationDTO result = newSiteCreationService.save(newSiteCreationDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, newSiteCreationDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /new-site-creations : get all the newSiteCreations.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of newSiteCreations in body
     */
    @GetMapping("/new-site-creations")
    @Timed
    public ResponseEntity<List<NewSiteCreationDTO>> getAllNewSiteCreations(Pageable pageable) {
        log.debug("REST request to get a page of NewSiteCreations");
        Page<NewSiteCreationDTO> page = newSiteCreationService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/new-site-creations");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /new-site-creations/:id : get the "id" newSiteCreation.
     *
     * @param id the id of the newSiteCreationDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the newSiteCreationDTO, or with status 404 (Not Found)
     */
    @GetMapping("/new-site-creations/{id}")
    @Timed
    public ResponseEntity<NewSiteCreationDTO> getNewSiteCreation(@PathVariable Long id) {
        log.debug("REST request to get NewSiteCreation : {}", id);
        Optional<NewSiteCreationDTO> newSiteCreationDTO = newSiteCreationService.findOne(id);
        return ResponseUtil.wrapOrNotFound(newSiteCreationDTO);
    }

    /**
     * DELETE  /new-site-creations/:id : delete the "id" newSiteCreation.
     *
     * @param id the id of the newSiteCreationDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/new-site-creations/{id}")
    @Timed
    public ResponseEntity<Void> deleteNewSiteCreation(@PathVariable Long id) {
        log.debug("REST request to delete NewSiteCreation : {}", id);
        newSiteCreationService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
