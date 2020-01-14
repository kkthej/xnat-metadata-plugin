/*
 * xnat-template: org.nrg.xnat.plugins.template.plugin.XnatTemplatePlugin
 * XNAT http://www.xnat.org
 * Copyright (c) 2020, Washington University School of Medicine
 * All Rights Reserved
 *
 * Released under the Simplified BSD.
 */

package org.nrg.xnat.plugins.template.plugin;

import lombok.extern.slf4j.Slf4j;
import org.nrg.dcm.id.CompositeDicomObjectIdentifier;
import org.nrg.dcm.id.FixedProjectSubjectDicomObjectIdentifier;
import org.nrg.framework.annotations.XnatDataModel;
import org.nrg.framework.annotations.XnatPlugin;
import org.nrg.xdat.bean.TemplateSampleBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@XnatPlugin(value = "templatePlugin", name = "XNAT 1.7 Template Plugin", entityPackages = "org.nrg.xnat.plugins.template.entities",
        dataModels = @XnatDataModel(value = TemplateSampleBean.SCHEMA_ELEMENT_NAME,
                singular = "Template",
                plural = "Templates",
                code = "TM"))
@ComponentScan({"org.nrg.xnat.plugins.template.preferences",
                "org.nrg.xnat.plugins.template.repositories",
                "org.nrg.xnat.plugins.template.rest",
                "org.nrg.xnat.plugins.template.services.impl"})
@Slf4j
public class XnatTemplatePlugin {
    public XnatTemplatePlugin() {
        log.info("Creating the XnatTemplatePlugin configuration class");
    }

    @Bean
    public String templatePluginMessage() {
        return "This comes from deep within the template plugin.";
    }
}
