/*
 * xnat-template-plugin: org.nrg.xnat.plugins.template.services.TemplateService
 * XNAT https://www.xnat.org
 * Copyright (c) 2005-2021, Washington University School of Medicine
 * All Rights Reserved
 *
 * Released under the Simplified BSD.
 */

package org.nrg.xnat.mbc.xmetadata.services;

import org.nrg.framework.orm.hibernate.BaseHibernateService;
import org.nrg.xnat.mbc.xmetadata.entities.Xmetadata;

public interface XmetadataService extends BaseHibernateService<Xmetadata> {
    /**
     * Finds the template with the indicated {@link Template#getTemplateId() template ID}.
     *
     * @param ProjectId The template ID.
     *
     * @return The template with the indicated ID, null if not found.
     */
    Xmetadata findByProjectId(final String projectId);
}
