/*
 * xnat-template-plugin: org.nrg.xnat.plugins.template.repositories.TemplateRepository
 * XNAT https://www.xnat.org
 * Copyright (c) 2005-2021, Washington University School of Medicine
 * All Rights Reserved
 *
 * Released under the Simplified BSD.
 */

package org.nrg.xnat.mbc.xmetadata.repositories;

import lombok.extern.slf4j.Slf4j;
import org.nrg.framework.orm.hibernate.AbstractHibernateDAO;
import org.nrg.xnat.mbc.xmetadata.entities.Xmetadata;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class XmetadataRepository extends AbstractHibernateDAO<Xmetadata> {
}
