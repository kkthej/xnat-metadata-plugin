/*
 * xnat-template: org.nrg.xnat.plugins.template.entities.Template
 * XNAT http://www.xnat.org
 * Copyright (c) 2017, Washington University School of Medicine
 * All Rights Reserved
 *
 * Released under the Simplified BSD.
 */

package org.nrg.xnat.plugins.template.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.nrg.framework.orm.hibernate.AbstractHibernateEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "templateId"))
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(prefix = "_")
@Slf4j
public class Template extends AbstractHibernateEntity {
    private String _templateId;
}
