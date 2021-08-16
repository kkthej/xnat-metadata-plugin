/*
 * xnat-template-plugin: org.nrg.xnat.plugins.template.plugin.XnatTemplatePlugin
 * XNAT https://www.xnat.org
 * Copyright (c) 2005-2021, Washington University School of Medicine
 * All Rights Reserved
 *
 * Released under the Simplified BSD.
 */

package org.unicorn.xnatx.plugin;

import lombok.extern.slf4j.Slf4j;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.nrg.config.services.ConfigService;
import org.nrg.framework.annotations.XnatPlugin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@XnatPlugin(value = "Plugin101", name = "XNAT Plugin 101",
	logConfigurationFile = "META-INF/resources/plugin-101-logback.xml")
@Slf4j
public class Plugin101 {
//    static final Logger log = LoggerFactory.getLogger(Plugin101.class);

    public Plugin101() {
        log.error("Creating the Plugin101 configuration class (logging as ERROR)");
        log.warn("Creating the Plugin101 configuration class (logging as WARN)");
        log.info("Creating the Plugin101 configuration class (logging as INFO)");
    }

    @Bean
    public String templatePluginMessage() {
        return "This comes from deep within the Plugin 101 example.";
    }
}
