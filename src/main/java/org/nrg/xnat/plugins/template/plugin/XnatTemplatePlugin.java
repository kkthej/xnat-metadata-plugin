/*
 * xnat-workshop-plugin: org.nrg.xnat.plugins.template.plugin.WorkshopXnatPlugin
 * XNAT http://www.xnat.org
 * Copyright (c) 2016, Washington University School of Medicine
 * All Rights Reserved
 *
 * Released under the Simplified BSD.
 */

package org.nrg.xnat.plugins.template.plugin;

import org.nrg.framework.annotations.XnatDataModel;
import org.nrg.framework.annotations.XnatPlugin;
import org.nrg.xdat.bean.TemplateSampleBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

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
    @Bean
    public String workshopPluginMessage() {
        return "Hello there from the workshop plugin!";
    }
}
