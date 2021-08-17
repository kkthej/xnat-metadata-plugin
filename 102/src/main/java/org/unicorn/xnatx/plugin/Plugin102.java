/*
 * xnat-template-plugin: org.nrg.xnat.plugins.template.plugin.XnatTemplatePlugin
 * XNAT https://www.xnat.org
 * Copyright (c) 2005-2021, Washington University School of Medicine
 * All Rights Reserved
 *
 * Released under the Simplified BSD.
 */

package org.unicorn.xnatx.plugin;

import org.unicorn.xnatx.listeners.DefaultEventServiceListener;

import lombok.extern.slf4j.Slf4j;
import org.nrg.config.services.ConfigService;
import org.nrg.framework.annotations.XnatPlugin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@XnatPlugin(value = "Plugin102", name = "XNAT Plugin 102",
	logConfigurationFile = "META-INF/resources/plugin-102-logback.xml")
@Slf4j
public class Plugin102 {
//    static final Logger log = LoggerFactory.getLogger(Plugin102.class);
    DefaultEventServiceListener defaultEventServiceListener = null;

    public Plugin102() {
        log.error("Creating the Plugin102 configuration class (logging as ERROR)");
        log.warn("Creating the Plugin102 configuration class (logging as WARN)");
        log.info("Creating the Plugin102 configuration class (logging as INFO)");

        defaultEventServiceListener = new DefaultEventServiceListener();
        log.error("Created a DefaultEventServiceListener object (logging as ERROR)");
    }

    @Bean
    public String templatePluginMessage() {
        return "This comes from deep within the Plugin 102 example.";
    }
}
