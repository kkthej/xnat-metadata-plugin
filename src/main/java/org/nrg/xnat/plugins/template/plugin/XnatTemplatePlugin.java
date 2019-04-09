/*
 * xnat-template: org.nrg.xnat.plugins.template.plugin.XnatTemplatePlugin
 * XNAT http://www.xnat.org
 * Copyright (c) 2017, Washington University School of Medicine
 * All Rights Reserved
 *
 * Released under the Simplified BSD.
 */

package org.nrg.xnat.plugins.template.plugin;

import org.nrg.dcm.id.CompositeDicomObjectIdentifier;
import org.nrg.dcm.id.FixedProjectSubjectDicomObjectIdentifier;
import org.nrg.framework.annotations.XnatDataModel;
import org.nrg.framework.annotations.XnatPlugin;
import org.nrg.xdat.bean.TemplateSampleBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Configuration
@XnatPlugin(value = "templatePlugin", name = "XNAT 1.7 Template Plugin", entityPackages = "org.nrg.xnat.plugins.template.entities",
        dataModels = @XnatDataModel(value = TemplateSampleBean.SCHEMA_ELEMENT_NAME,
                singular = "Template",
                plural = "Templates",
                code = "TM"))
@ComponentScan({"org.nrg.xnat.plugins.template.preferences",
                "org.nrg.xnat.plugins.template.repositories",
                "org.nrg.xnat.plugins.template.rest",
                "org.nrg.xnat.plugins.template.services.impl"})
public class XnatTemplatePlugin {
    public XnatTemplatePlugin() {
        _log.info("Creating the XnatTemplatePlugin configuration class");
    }

    @Bean
    public CompositeDicomObjectIdentifier projectXnat02Identifier(final NamedParameterJdbcTemplate template) {
        return new FixedProjectSubjectDicomObjectIdentifier(template, "XNAT_02", "XNAT_02_01");
    }

    @Bean
    public String templatePluginMessage() {
        return "This comes from deep within the template plugin.";
    }

    private static final Logger _log = LoggerFactory.getLogger(XnatTemplatePlugin.class);
}
