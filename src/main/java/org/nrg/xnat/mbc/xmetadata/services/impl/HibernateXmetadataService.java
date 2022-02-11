/*
 * xnat-template-plugin: org.nrg.xnat.plugins.template.services.impl.HibernateTemplateService
 * XNAT https://www.xnat.org
 * Copyright (c) 2005-2021, Washington University School of Medicine
 * All Rights Reserved
 *
 * Released under the Simplified BSD.
 */

package org.nrg.xnat.mbc.xmetadata.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.nrg.framework.orm.hibernate.AbstractHibernateEntityService;
import org.nrg.xnat.mbc.xmetadata.entities.Xmetadata;
import org.nrg.xnat.mbc.xmetadata.repositories.XmetadataRepository;
import org.nrg.xnat.mbc.xmetadata.services.XmetadataService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Manages {@link Template} data objects in Hibernate.
 */
@Service
@Slf4j
public class HibernateXmetadataService 
             extends AbstractHibernateEntityService<Xmetadata, XmetadataRepository> 
             implements XmetadataService {
    /**
     * {@inheritDoc}
     */
    @Transactional
    @Override
    public Xmetadata findByProjectId(final String projectId) {
        //log.trace("Requested template with ID {}", projectId);
        return getDao().findByUniqueProperty("projectId", projectId);
    }
}
