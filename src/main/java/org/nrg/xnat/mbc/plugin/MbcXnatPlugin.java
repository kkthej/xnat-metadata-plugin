package org.nrg.xnat.mbc.plugin;


import org.nrg.framework.annotations.XnatDataModel;
import org.nrg.framework.annotations.XnatPlugin;
import org.nrg.xdat.bean.XnatXmetadataBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@XnatPlugin(value = "mbcPlugin", name = "XNAT 1.8 mbc xmetadata Plugin",
            entityPackages = "org.nrg.xnat.workshop.entities",
            dataModels = {@XnatDataModel(value = XnatXmetadata.SCHEMA_ELEMENT_NAME,
                                         singular = "Biosample Collection",
                                         plural = "Biosample Collections")})
@ComponentScan({"org.nrg.xnat.mbc.xmetadata.services.impl", 
                "org.nrg.xnat.mbc.xmetadata.repositories", 
                "org.nrg.xnat.mbc.xmetadata.rest"})
public class MbcXnatPlugin {
    @Bean
    public String mbcPluginMessage() {
        return "Hello there from the workshop plugin!";
    }
}