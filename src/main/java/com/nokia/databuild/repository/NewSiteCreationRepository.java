package com.nokia.databuild.repository;

import com.nokia.databuild.domain.NewSiteCreation;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the NewSiteCreation entity.
 */
@SuppressWarnings("unused")
@Repository
public interface NewSiteCreationRepository extends JpaRepository<NewSiteCreation, Long> {

}
